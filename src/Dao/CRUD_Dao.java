package Dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JComboBox;

import Constructors.Account;
import Constructors.Customer;
import Constructors.Invoice;
import Constructors.Staff;

import Constructors.Order;
import Constructors.OrderDetail;
import Constructors.Product;

public class CRUD_Dao {

	private Connection con;

	public CRUD_Dao() throws SQLException {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/detoxdb", "root", "");
	}

	// ----------- ACCOUNT CRUD CODES-------------//
	// Add account query
	public int addAccount(Account a) throws SQLException {
		PreparedStatement pst = con
				.prepareStatement("INSERT INTO account (accountID, username, password, staffID) VALUES (?, ?, ?, ?)");
		pst.setInt(1, a.getAccountID());
		pst.setString(2, a.getUsername());
		pst.setString(3, a.getPassword());
		pst.setInt(4, a.getStaffID());
		int i = pst.executeUpdate();
		int id = 0;
		if (i > 0) {
			pst = con.prepareStatement("SELECT LAST_INSERT_ID()");
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			rs.close();
		}
		pst.close();
		return id;
	}

	// Update account query
	public int updateAccount(Account a) throws SQLException {
		PreparedStatement pst = con
				.prepareStatement("UPDATE account SET username = ?, password = ?, staffID = ? WHERE accountID = ?");
		pst.setString(1, a.getUsername());
		pst.setString(2, a.getPassword());
		pst.setInt(3, a.getStaffID());
		pst.setInt(4, a.getAccountID());
		int rowsUpdated = pst.executeUpdate();
		pst.close();
		return rowsUpdated;
	}

	// Delete account query
	public void deleteAccount(int id) throws SQLException {
		PreparedStatement pst = con.prepareStatement("DELETE FROM account WHERE accountID = ?");
		pst.setInt(1, id);
		pst.executeUpdate();
		pst.close();
	}

	// ----------- STAFF CRUD CODES-------------//
	// Add staff query
	public int addStaff(Staff s) throws SQLException {
		PreparedStatement pst = con.prepareStatement(
				"insert into staff (staffID,name,email,gender,phone_number,NRC,position,address,DateOfBirth) values(?,?,?,?,?,?,?,?,?)");
		pst.setInt(1, s.getId());
		pst.setString(2, s.getName());
		pst.setString(3, s.getEmail());
		pst.setString(4, s.getGender());
		pst.setString(5, s.getPhno());
		pst.setString(6, s.getNRC());
		pst.setString(7, s.getPosition());
		pst.setString(8, s.getAddress());
		pst.setDate(9, s.getDob());
		int i = pst.executeUpdate();
		int id = 0;
		if (i > 0) {
			pst = con.prepareStatement("select last_insert_id()");
			ResultSet rs = pst.executeQuery();
			while (rs.next())
				id = rs.getInt(1);
			rs.close();

		}
		return id;
	}

	// Update staff query
	public int updateStaff(Staff staff) throws SQLException {
		String sql = "UPDATE staff SET name=?, email=?, gender=?, phone_number=?, NRC=?, position=?, address=?, dob=? WHERE staffID=?";

		try (PreparedStatement pst = con.prepareStatement(sql)) {
			// Set parameters
			pst.setString(1, staff.getName());
			pst.setString(2, staff.getEmail());
			pst.setString(3, staff.getGender());
			pst.setString(4, staff.getPhno());
			pst.setString(5, staff.getNRC());
			pst.setString(6, staff.getPosition());
			pst.setString(7, staff.getAddress());
			pst.setInt(8, staff.getId());
			pst.setDate(9, staff.getDob());

			// Execute the update and return the number of affected rows
			return pst.executeUpdate();
		} catch (SQLException e) {
			// Log and rethrow exception
			System.err.println("SQL Error: " + e.getMessage());
			throw e;
		}
	}

	// Method to update references in the account table
	public void updateAccountBeforeDelete(int staffId) throws SQLException {
		String updateAccountQuery = "UPDATE account SET staffID = NULL WHERE staffID = ?";

		try (PreparedStatement pst = con.prepareStatement(updateAccountQuery)) {
			pst.setInt(1, staffId); // Set the staff ID parameter
			pst.executeUpdate(); // Execute the update
		} catch (SQLException ex) {
			System.out.println("Error updating account references: " + ex.getMessage());
			throw ex; // Re-throw the exception if you want the calling method to handle it
		}
	}

	// Method to delete staff by ID
	public void deleteStaffById(int staffId) throws SQLException {
		PreparedStatement pst = null;
		try {

			con.setAutoCommit(false); // Start transaction

			// Delete from `orderdetail` first
			String deleteOrderDetailSQL = "DELETE FROM orderdetail WHERE orderID IN (SELECT orderID FROM `order` WHERE staffID = ?)";
			pst = con.prepareStatement(deleteOrderDetailSQL);
			pst.setInt(1, staffId);
			pst.executeUpdate();

			// Delete from `order` next
			String deleteOrderSQL = "DELETE FROM `order` WHERE staffID = ?";
			pst = con.prepareStatement(deleteOrderSQL);
			pst.setInt(1, staffId);
			pst.executeUpdate();

			// Optionally, delete from `account` if applicable
			String deleteAccountSQL = "DELETE FROM `account` WHERE staffID = ?";
			pst = con.prepareStatement(deleteAccountSQL);
			pst.setInt(1, staffId);
			pst.executeUpdate();

			// Finally, delete from `staff`
			String deleteStaffSQL = "DELETE FROM staff WHERE staffID = ?";
			pst = con.prepareStatement(deleteStaffSQL);
			pst.setInt(1, staffId);
			pst.executeUpdate();

			con.commit(); // Commit transaction

		} catch (SQLException ex) {
			if (con != null) {
				con.rollback(); // Rollback transaction on error
			}
			ex.printStackTrace();

		} finally {
			if (pst != null) {
				pst.close();
			}
			if (con != null) {
				con.setAutoCommit(true); // Reset auto-commit mode
				con.close();
			}
		}

	}

	// ----------- PRODUCT CRUD CODES-------------//
	// Add product query
	public int addProduct(Product p) throws SQLException {
		PreparedStatement pst = con.prepareStatement(
				"insert into detox (name,price,description,image,size,ingredients,quantity) values (?,?,?,?,?,?,?); ");

		pst.setString(1, p.getName());
		pst.setInt(2, p.getPrice());
		pst.setString(3, p.getDescription());
		pst.setBytes(4, p.getImage());
		pst.setString(5, p.getSize());
		pst.setString(6, p.getIngredients());

		pst.setInt(7, p.getQuantity());

		int i = pst.executeUpdate();
		int id = 0;
		if (i > 0) {
			pst = con.prepareStatement("select last_insert_id()");
			ResultSet rs = pst.executeQuery();
			while (rs.next())
				id = rs.getInt(1);
			rs.close();

		}
		return id;
	}

	// Delete product query
	public void deleteProduct(int id) throws SQLException {
		PreparedStatement pst = con.prepareStatement("DELETE FROM detox WHERE detoxID=?;");
		pst.setInt(1, id);
		pst.executeUpdate();
	}

	// ----------- ORDER CRUD CODES-------------//
	// Add order query
	public int addOrder(Order o) throws SQLException {
		String insertQuery = "INSERT INTO order (orderID, orderDate, order_note, customerID, staffID) VALUES (?, ?, ?, ?, ?)";
		try (PreparedStatement pst = con.prepareStatement(insertQuery)) {
			pst.setInt(1, o.getOrderID());
			pst.setDate(2, o.getOrderDate());
			pst.setString(3, o.getOrder_note());
			pst.setInt(4, o.getCustomerID());
			pst.setInt(5, o.getStaffID());

			int rowsAffected = pst.executeUpdate();
			if (rowsAffected > 0) {
				try (PreparedStatement pstLastId = con.prepareStatement("SELECT LAST_INSERT_ID()")) {
					ResultSet rs = pstLastId.executeQuery();
					if (rs.next()) {
						return rs.getInt(1);
					}
				}
			}
			return 0;
		}
	}

	// Update order query
	public int updateOrder(Order o) throws SQLException {
		PreparedStatement pst = con.prepareStatement(
				"update order set orderID=?,orderDate=?,order_note=?,customerID=?,staffID=? where orderID=?;");
		pst.setInt(1, o.getOrderID());
		pst.setDate(2, o.getOrderDate());
		pst.setString(3, o.getOrder_note());
		pst.setInt(4, o.getCustomerID());
		pst.setInt(5, o.getStaffID());

		int i = pst.executeUpdate();
		return i;
	}

	// Delete order query
	public void deleteOrder(int id) throws SQLException {
		PreparedStatement pst = con.prepareStatement("DELETE FROM order WHERE orderID = ?");
		pst.setInt(1, id);
		pst.executeUpdate();
		pst.close();
	}

	public ArrayList<Product> AddProductIntoTable() throws SQLException {
		ArrayList<Product> p = new ArrayList<Product>();
		PreparedStatement pst = con.prepareStatement("select * from detox");
		ResultSet rs = pst.executeQuery();

		while (rs.next()) {

			Product product = new Product(rs.getInt("detoxID"), rs.getString("name"), rs.getInt("price"),
					rs.getString("size"));
			p.add(product);
		}
		return p;

	}

	public ArrayList<Product> getProduct() throws SQLException {
		ArrayList<Product> p = new ArrayList<>();
		PreparedStatement pst = con.prepareStatement("SELECT * FROM detox");
		ResultSet rs = pst.executeQuery();

		while (rs.next()) {
			Product product = new Product(

					rs.getString("name"), rs.getInt("price"), rs.getString("description"), rs.getBytes("image"),
					rs.getString("size"), rs.getString("ingredients"),

					rs.getInt("quantity"));
			p.add(product);
		}
		rs.close();
		pst.close();
		return p;
	}

	public void deleteProducts(int detoxID) throws SQLException {

		String deleteOrderDetailSql = "DELETE FROM orderdetail WHERE detoxID = ?";
		try (PreparedStatement ps = con.prepareStatement(deleteOrderDetailSql)) {
			ps.setInt(1, detoxID);
			ps.executeUpdate();
		}

		// Then, delete the row from the parent table (detox)
		String deleteDetoxSql = "DELETE FROM detox WHERE detoxID = ?";
		try (PreparedStatement ps = con.prepareStatement(deleteDetoxSql)) {
			ps.setInt(1, detoxID);
			ps.executeUpdate();
		}
	}

	public ArrayList<Invoice> AddProduct() throws SQLException {
		ArrayList<Invoice> p = new ArrayList<Invoice>();
		PreparedStatement pst = con.prepareStatement("select * from detox");
		ResultSet rs = pst.executeQuery();

		while (rs.next()) {

			Invoice product = new Invoice(rs.getInt("detoxID"), rs.getString("name"), rs.getString("size"),
					rs.getInt("price"), rs.getInt("quantity"));
			p.add(product);
		}

		return p;

	}

	public ArrayList<Customer> AddCustomerTable() throws SQLException {
		ArrayList<Customer> p = new ArrayList<Customer>();
		PreparedStatement pst = con.prepareStatement("select * from customer");
		ResultSet rs = pst.executeQuery();

		while (rs.next()) {

			Customer cus = new Customer(rs.getInt("customerID"), rs.getString("name"), rs.getString("gender"),
					rs.getString("phoneNumber"), rs.getString("email"));
			p.add(cus);
		}
		return p;

	}

	public int addCustomer(Customer p) throws SQLException {
		PreparedStatement pst = con.prepareStatement(
				"insert into customer (name,email,gender,address,phoneNumber,date_of_birth) values (?,?,?,?,?,?); ");

		pst.setString(1, p.getName());
		pst.setString(2, p.getEmail());
		pst.setString(3, p.getGender());
		pst.setString(4, p.getAddress());
		pst.setString(5, p.getPhno());
		pst.setDate(6, p.getDob());

		int i = pst.executeUpdate();
		int id = 0;
		if (i > 0) {
			pst = con.prepareStatement("select last_insert_id()");
			ResultSet rs = pst.executeQuery();
			while (rs.next())
				id = rs.getInt(1);
			rs.close();

		}
		return id;
	}

	public void deleteCustomer(int cid) throws SQLException {

		String deleteOrderDetailSql = "DELETE FROM customer WHERE customerID = ?";
		try (PreparedStatement ps = con.prepareStatement(deleteOrderDetailSql)) {
			ps.setInt(1, cid);
			ps.executeUpdate();
		}

	}

	public int updateCustomer(Customer c) throws SQLException {
		int i = 0;
		PreparedStatement pst = con.prepareStatement(
				"update customer set name=?,email=?,gender=?,address=?,phoneNumber=?,date_of_birth=? where customerID=?;");
		pst.setString(1, c.getName());
		pst.setString(2, c.getEmail());
		pst.setString(3, c.getGender());
		pst.setString(4, c.getAddress());
		pst.setString(5, c.getPhno());
		pst.setDate(6, c.getDob());
		pst.setInt(7, c.getId());
		i = pst.executeUpdate();

		return i;
	}

	public Customer getCustomerById(int cusid) throws SQLException {
		Customer customer = null;
		String query = "SELECT * FROM customer WHERE customerID = ?";

		PreparedStatement stmt = con.prepareStatement(query);

		stmt.setInt(1, cusid);

		try (ResultSet rs = stmt.executeQuery()) {
			if (rs.next()) {
				customer = new Customer();

				// product.setDetoxID(rs.getInt("detoxID"));
				customer.setName(rs.getString("name"));
				customer.setEmail(rs.getString("email"));
				customer.setGender(rs.getString("gender"));

				customer.setAddress(rs.getString("address"));

				customer.setPhno(rs.getString("phoneNumber"));

				customer.setDob(rs.getDate("date_of_birth"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}

		return customer;
	}

	public Staff getStaffrById(int cusid) throws SQLException {
		Staff staff = null;
		String query = "SELECT * FROM staff WHERE staffID = ?";

		PreparedStatement stmt = con.prepareStatement(query);

		stmt.setInt(1, cusid);

		try (ResultSet rs = stmt.executeQuery()) {
			if (rs.next()) {
				staff = new Staff();

				// product.setDetoxID(rs.getInt("detoxID"));
				staff.setName(rs.getString("name"));
				staff.setEmail(rs.getString("email"));
				staff.setGender(rs.getString("gender"));

				staff.setPhno(rs.getString("phone_number"));

				staff.setNRC(rs.getString("NRC"));

				staff.setPosition(rs.getString("position"));
				staff.setAddress(rs.getString("address"));
				staff.setDob(rs.getDate("DateOfBirth"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}

		return staff;
	}

	public ArrayList<Customer> AddCustomerIntoTable() throws SQLException {
		ArrayList<Customer> c = new ArrayList<Customer>();
		PreparedStatement pst = con.prepareStatement("select * from customer");
		ResultSet rs = pst.executeQuery();

		while (rs.next()) {

			Customer cus = new Customer(rs.getInt("CustomerID"), rs.getString("name"), rs.getString("email"),
					rs.getString("gender"), rs.getString("address"), rs.getString("PhoneNumber"),
					rs.getDate("date_of_birth"));
			c.add(cus);
		}

		return c;

	}

	public void deleteCustomerById(int cusId) throws SQLException {
		PreparedStatement pst = null;
		try {

			con.setAutoCommit(false); // Start transaction

			// Delete from `orderdetail` first
			String deleteOrderDetailSQL = "DELETE FROM orderdetail WHERE orderID IN (SELECT orderID FROM `order` WHERE customerID = ?)";
			pst = con.prepareStatement(deleteOrderDetailSQL);
			pst.setInt(1, cusId);
			pst.executeUpdate();

			// Delete from `order` next
			String deleteOrderSQL = "DELETE FROM `order` WHERE customerID = ?";
			pst = con.prepareStatement(deleteOrderSQL);
			pst.setInt(1, cusId);
			pst.executeUpdate();

			// Finally, delete from `staff`
			String deleteStaffSQL = "DELETE FROM customer WHERE customerID = ?";
			pst = con.prepareStatement(deleteStaffSQL);
			pst.setInt(1, cusId);
			pst.executeUpdate();

			con.commit(); // Commit transaction

		} catch (SQLException ex) {
			if (con != null) {
				con.rollback(); // Rollback transaction on error
			}
			ex.printStackTrace();

		} finally {
			if (pst != null) {
				pst.close();
			}
			if (con != null) {
				con.setAutoCommit(true); // Reset auto-commit mode
				con.close();
			}
		}

	}

	public ArrayList<Order> getOrder() throws SQLException {
		ArrayList<Order> orders = new ArrayList<>();

		// Updated SQL query with JOINs to fetch required data
		String Query = "SELECT o.orderID, c.name, s.name, o.orderDate, o.order_note " + "FROM `order` o "
				+ "INNER JOIN customer c ON o.customerID = c.customerID "
				+ "INNER JOIN staff s ON o.staffID = s.staffID";

		try (PreparedStatement pst = con.prepareStatement(Query); ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				orders.add(new Order(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4)));
			}
		}

		return orders;
	}

	public ArrayList<Product> getProductForOrder() throws SQLException {
		ArrayList<Product> p = new ArrayList<>();
		PreparedStatement pst = con.prepareStatement("SELECT * FROM detox");
		ResultSet rs = pst.executeQuery();

		while (rs.next()) {
			Product product = new Product(rs.getBytes("image"), rs.getString("name"), rs.getString("size"),
					rs.getInt("price"),

					rs.getString("ingredients")

			);
			p.add(product);
		}
		rs.close();
		pst.close();
		return p;
	}

	public int insertOrderDetail(OrderDetail invoice) throws SQLException {

		String s = "INSERT INTO order ( customerID, staffID,orderDate) VALUES (?, ?, ?)";
		PreparedStatement pst = con.prepareStatement(s, Statement.RETURN_GENERATED_KEYS);

		Order o = new Order();
		Customer c = new Customer();
		Staff staff = new Staff();

		pst.setDate(3, o.getOrderDate());
		pst.setInt(1, c.getId());
		pst.setInt(2, staff.getId());

		pst.executeUpdate();
		ResultSet rs = pst.getGeneratedKeys();
		int orderID = 0;
		if (rs.next()) {
			orderID = rs.getInt(1);
		}

//	        
//	        String sql = "INSERT INTO orderdetail (detoxID, orderID, quantity) VALUES (?, ?, ?)";
//
//	        PreparedStatement pst1 = con.prepareStatement(sql);
//	        pst1.setInt(1, invoice.getDetoxid());
//	        pst1.setInt(2, orderID);  // Use the generated orderID here
//	        pst1.setInt(3, invoice.getQuantity());
//
//	        int i = pst1.executeUpdate();
//	        int orderDetailID = 0;
//	        if (i > 0) {
//	           
//	            pst1 = con.prepareStatement("SELECT last_insert_id()");
//	            ResultSet rs1 = pst1.executeQuery();
//	            if (rs1.next()) {
//	                orderDetailID = rs1.getInt(1);
//	            }
//	            rs1.close();
//	        }

		rs.close();
		// return orderDetailID;
		return orderID;
	}

	public int getAccID(String uname, String pass) throws SQLException {
		int id = 0;
		PreparedStatement pst = con.prepareStatement("select id from account where username=? and password=?");
		pst.setString(1, uname);
		pst.setString(2, pass);

		ResultSet rs = pst.executeQuery();
		while (rs.next())
			id = rs.getInt(1);
		rs.close();
		pst.close();
		return id;
	}

	public Product getProductByName(String name) throws SQLException {// for quantity update
		Product product = null;
		PreparedStatement pst = con.prepareStatement("select * from detox where name = ?");

		pst.setString(1, name);

		ResultSet rs = pst.executeQuery();

		while (rs.next()) {
			product = new Product(rs.getInt("detoxID"), rs.getString("name"), rs.getInt("price"),
					rs.getInt("quantity"));
		}

		return product;
	}

	public void updateQuantity(int name, int newQuantity) throws SQLException {// insert new quantity into product
		PreparedStatement pst = con.prepareStatement("update detox set quantity=? where detoxID=?;");
		pst.setInt(1, newQuantity);
		pst.setInt(2, name);
		pst.executeUpdate();

	}

	public Order getOrderForView(int orderId) throws SQLException {
		String query = "SELECT c.name, s.name, o.orderDate " + "FROM `order` o "
				+ "INNER JOIN customer c ON o.customerID = c.customerID "
				+ "INNER JOIN staff s ON o.staffID = s.staffID " + "WHERE o.orderID = ?";

		Order order = null;

		try (PreparedStatement pst = con.prepareStatement(query)) {
			pst.setInt(1, orderId); // Set the orderId parameter in the query

			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {

					String staffName = rs.getString(1);
					String customerName = rs.getString(2);
					Date orderDate = rs.getDate(3);
					order = new Order(staffName, customerName, orderDate);
				}
			}

		}
		return order;
	}

	public ArrayList<Staff> AddStaffTable() throws SQLException {
		ArrayList<Staff> p = new ArrayList<Staff>();
		PreparedStatement pst = con.prepareStatement("select * from staff");
		ResultSet rs = pst.executeQuery();

		while (rs.next()) {

			Staff cus = new Staff(rs.getInt("staffID"), rs.getString("name"), rs.getString("gender"),
					rs.getString("phone_number"), rs.getString("position"));
			p.add(cus);
		}
		return p;

	}

	public ArrayList<Invoice> getInvoices(int orderDetailId) throws SQLException {
		ArrayList<Invoice> invoices = new ArrayList<>();
		String sql = "SELECT " + "`order`.orderID, " + "detox.name AS detoxName, " + "detox.size, " + "detox.price, "
				+ "orderdetail.quantity " + "FROM `order` "
				+ "JOIN orderdetail ON orderdetail.orderDetail_ID = `order`.orderID "
				+ "JOIN detox ON detox.detoxID = orderdetail.detoxID " + "WHERE orderdetail.orderDetail_ID = ?";

		try (PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setInt(1, orderDetailId);
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					Invoice invoice = new Invoice(rs.getInt("orderID"), rs.getString("detoxName"), rs.getString("size"),
							rs.getInt("price"), rs.getInt("quantity"));
					invoices.add(invoice);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Handle exceptions or rethrow if necessary
		}

		return invoices;
	}

	public Product getProductById(int productId) throws SQLException {
		Product product = null;
		String query = "SELECT * FROM detox WHERE detoxID = ?";

		PreparedStatement stmt = con.prepareStatement(query);

		stmt.setInt(1, productId);

		try (ResultSet rs = stmt.executeQuery()) {
			if (rs.next()) {
				product = new Product();

				// product.setDetoxID(rs.getInt("detoxID"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getInt("price"));
				product.setDescription(rs.getString("description"));

				product.setSize(rs.getString("size"));

				product.setImage(rs.getBytes("image"));
				product.setIngredients(rs.getString("ingredients"));

				// product.setStatus(rs.getString("status"));
				product.setQuantity(rs.getInt("quantity"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}

		return product;
	}

	public Product getStatusAction() throws SQLException {
		Product product = null;
		String query = "SELECT * FROM detox WHERE status = 'on'";

		PreparedStatement stmt = con.prepareStatement(query);

		stmt.setInt(1, 1);

		try (ResultSet rs = stmt.executeQuery()) {
			if (rs.next()) {
				product = new Product();

				product.setDetoxID(rs.getInt("detoxID"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getInt("price"));
				product.setDescription(rs.getString("description"));

				product.setSize(rs.getString("size"));

				product.setImage(rs.getBytes("image"));
				product.setIngredients(rs.getString("ingredients"));

				// product.setStatus(rs.getString("status"));
				product.setQuantity(rs.getInt("quantity"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}

		return product;
	}

	public int updateProduct(Product p) throws SQLException {
		int i = 0;
		PreparedStatement pst = con.prepareStatement(
				"update detox set name=?,price=?,description=?,image=?,size=?,ingredients=?,quantity=?,status=? where detoxID=?;");
		pst.setString(1, p.getName());
		pst.setInt(2, p.getPrice());
		pst.setBytes(4, p.getImage());
		pst.setString(3, p.getDescription());
		pst.setString(5, p.getSize());
		pst.setString(6, p.getIngredients());

		pst.setString(8, p.getStatus());
		pst.setInt(7, p.getQuantity());

		pst.setInt(9, p.getDetoxID());
		i = pst.executeUpdate();

		return i;
	}

	public String retrieveStaff() throws SQLException {
		String staffCount = "0";
		PreparedStatement pst = con.prepareStatement("SELECT count(*) FROM staff;");
		ResultSet rs = pst.executeQuery();

		while (rs.next()) {
			staffCount = rs.getString(1);

//		        staffList.add(new Staff(name));
		}

		rs.close();

		pst.close();
		return staffCount;
	}

	public String retrieveProduct() throws SQLException {
		String staffCount = "0";
		PreparedStatement pst = con.prepareStatement("SELECT count(*)FROM detox;");
		ResultSet rs = pst.executeQuery();

		while (rs.next()) {
			staffCount = rs.getString(1);

//		        staffList.add(new Staff(name));
		}

		rs.close();

		pst.close();
		return staffCount;
	}

	public String retrieveMonthlySale() throws SQLException {
		String totalSales = "0";
		String query = "SELECT SUM(d.price * od.quantity) AS total_sales " + "FROM detox d "
				+ "JOIN orderdetail od ON d.detoxID = od.detoxID " + "JOIN `order` o ON o.orderID = od.orderID "
				+ "WHERE (MONTH(o.orderDate) = IF(MONTH(CURDATE()) = 1, 12, MONTH(CURDATE()) - 1)) "
				+ "AND (YEAR(o.orderDate) = IF(MONTH(CURDATE()) = 1, YEAR(CURDATE()) - 1, YEAR(CURDATE())));";

		PreparedStatement pst = con.prepareStatement(query);
		ResultSet rs = pst.executeQuery();

		if (rs.next()) {
			totalSales = rs.getString("total_sales");
		}

		rs.close();
		pst.close();

		return totalSales != null ? totalSales : "0";
	}

	public void retrievecustomer(JComboBox<String> comboBox) throws SQLException {
		PreparedStatement pst = con.prepareStatement("SELECT name FROM customer;");
		ResultSet rs = pst.executeQuery();

		// Clear the combo box before adding new items
		comboBox.removeAllItems();

		while (rs.next()) {
			String customerName = rs.getString("name");
			// Add each customer name to the combo box
			comboBox.addItem(customerName);
		}

		// Clean up
		rs.close();
		pst.close();
	}

	// Modify the method to return an ArrayList of Customer objects
	public ArrayList<Customer> retrievecustomer() throws SQLException {
		ArrayList<Customer> customerList = new ArrayList<>();

		PreparedStatement pst = con.prepareStatement("SELECT name FROM customer;");
		ResultSet rs = pst.executeQuery();

		while (rs.next()) {
			String name = rs.getString("name");

			Customer customer = new Customer(name);
			customerList.add(customer);
		}

		// Clean up
		rs.close();
		pst.close();

		return customerList;
	}

	public void CreateAccount(Account c) throws SQLException {
		String sql = "INSERT INTO account(username, password, staffID) VALUES (?, ?, ?)";
		try (PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setString(1, c.getUsername());
			pst.setString(2, c.getPassword());
			pst.setInt(3, c.getStaffID());
			pst.executeUpdate();
			pst.close();
		}
	}

	public int getCustomerIDByName(String customerName) throws SQLException {
		// TODO Auto-generated method stub
		String query = "SELECT customerID FROM customer WHERE name = ?";
		try (PreparedStatement pst = con.prepareStatement(query)) {
			pst.setString(1, customerName);
			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					return rs.getInt("customerID");
				} else {
					// Return 0 or handle the case where customer is not found
					return 0;
				}
			}

		}
	}

	public Staff getProfile(String loginName, String password) throws SQLException {
		// Example implementation; adjust SQL query and logic based on your actual
		// database schema
		String sql = "SELECT * FROM staff WHERE name = ? AND password = ?";

		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, loginName);
		pst.setString(2, password);

		try (ResultSet rs = pst.executeQuery()) {
			if (rs.next()) {
				// Populate and return a Staff object
				Staff staff = new Staff();
				staff.setName(rs.getString("name"));
				staff.setEmail(rs.getString("email"));
				staff.setGender(rs.getString("gender"));
				staff.setPhno(rs.getString("phone_number"));
				staff.setNRC(rs.getString("NRC"));
				staff.setPosition(rs.getString("position"));
				staff.setAddress(rs.getString("address"));
				staff.setDob(rs.getDate("DateOfBirth"));

				return staff;

			}
		}
		return null;

	}

	public Staff authenticateUser(String email, String password) throws SQLException {
		Staff s = new Staff();
		String sql = "SELECT staff.* from staff ,account where account.staffID = staff.staffID AND account.username = ? AND account.password = ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, email);
		pst.setString(2, password);
		ResultSet rs = pst.executeQuery();
//			String position = null;
		if (rs.next()) {
			s.setId(rs.getInt(1));
			s.setName(rs.getString(2));
			s.setEmail(rs.getString(3));
			s.setGender(rs.getString(4));
			s.setPhno(rs.getString(5));
			s.setNRC(rs.getString(6));
			s.setPosition(rs.getString(7));
			s.setAddress(rs.getString(8));
			s.setDob(rs.getDate(9));
		}
		rs.close();
		pst.close();
		return s;
	}

	public Staff getStaffById(int staffId) throws SQLException {
		Staff s = new Staff();
		String sql = "SELECT * FROM staff WHERE staffID = ?";
		try (PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setInt(1, staffId);
			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					s.setId(rs.getInt("staffID"));
					s.setName(rs.getString("name"));
					s.setEmail(rs.getString("email"));
					s.setGender(rs.getString("gender"));
					s.setPhno(rs.getString("phone_number"));
					s.setNRC(rs.getString("NRC"));
					s.setPosition(rs.getString("position"));
					s.setAddress(rs.getString("address"));
					s.setDob(rs.getDate("DateOfBirth"));
				}
			}
		}
		return s;
	}

	public void insertOrderDetails(int orderID, ArrayList<OrderDetail> orderDetails) throws SQLException {
		String sql = "INSERT INTO orderdetail (detoxID, orderID, quantity) VALUES (?,?, ?)";
		try (PreparedStatement pst = con.prepareStatement(sql)) {
			for (OrderDetail detail : orderDetails) {
				pst.setInt(1, detail.getDetoxid());
				pst.setInt(2, orderID);
				pst.setInt(3, detail.getQuantity());
				pst.addBatch();
			}
			pst.executeBatch();
		}
	}

	public int insertOrder(int customerID, int staffID) throws SQLException {
		String sql = "INSERT INTO `order` (orderDate, customerID, staffID) VALUES (?, ?, ?)";
		PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
		pst.setDate(1, currentDate);
		pst.setInt(2, customerID);
		pst.setInt(3, staffID);

		int affectedRows = pst.executeUpdate();

		if (affectedRows == 0) {
			throw new SQLException("Creating order failed, no rows affected.");
		}

		ResultSet generatedKeys = pst.getGeneratedKeys();
		if (generatedKeys.next()) {
			return generatedKeys.getInt(1);
		} else {
			throw new SQLException("Creating order failed, no ID obtained.");
		}
	}

	public Staff getDataForProfile(String name) throws SQLException {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM staff WHERE name = ?";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, name);

		ResultSet rs = pst.executeQuery();
		Staff staff = null;

		if (rs.next()) {
			staff = new Staff();
			staff.setName(rs.getString("name"));
			staff.setEmail(rs.getString("email"));
			staff.setGender(rs.getString("gender"));
			staff.setPhno(rs.getString("phone_number"));

			staff.setNRC(rs.getString("NRC"));
			staff.setPosition(rs.getString("position"));

			staff.setAddress(rs.getString("address"));

			staff.setDob(rs.getDate("DateOfBirth"));
		}

		rs.close();
		pst.close();

		return staff;

	}

	public Account getAccountByID(int staffID) throws SQLException {
		Account account = null;

		String query = "SELECT * FROM account WHERE accountID = ?"; // SQL query to retrieve account by ID

		PreparedStatement pstmt = con.prepareStatement(query);

		pstmt.setInt(1, staffID); // Set the staff ID in the query

		try (ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {

				int id = rs.getInt("accountID");
				String email = rs.getString("username");
				String password = rs.getString("password");

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Error retrieving account by ID: " + e.getMessage());
		}
		return account;
	}

	public void getRecord(String old, String n) throws SQLException {
		PreparedStatement pst = con.prepareStatement("SELECT password FROM account WHERE password = ?");
		pst.setString(1, old);
		ResultSet rs = pst.executeQuery();

		// Check if the old password matches
		if (rs.next()) {
			String currentPassword = rs.getString("password");

		}
	}

	public String hashPassword(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256"); // Example using SHA-256
			byte[] hash = md.digest(password.getBytes());
			StringBuilder hexString = new StringBuilder();
			for (byte b : hash) {
				String hex = Integer.toHexString(0xff & b);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean verifyPassword(String accountId, String oldPassword) throws SQLException {
		String query = "SELECT password FROM account WHERE username = ?";
		try (PreparedStatement stmt = con.prepareStatement(query)) {
			stmt.setString(1, accountId);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				String dbPassword = rs.getString("password");
				return dbPassword.equals(oldPassword); // Check if passwords match
			}
		}
		return false; // If no result, the password is incorrect
	}

//public boolean verifyPassword(String accountId, String oldPassword) throws SQLException {
//    String hashedPassword = hashPassword(oldPassword); // Hash the password before checking
//    String query = "SELECT password FROM account WHERE username = ?";
//    try (PreparedStatement stmt = con.prepareStatement(query)) {
//        stmt.setString(1, accountId);
//        ResultSet rs = stmt.executeQuery();
//        
//        if (rs.next()) {
//            String dbPassword = rs.getString("password");
//            return dbPassword.equals(hashedPassword); // Compare with the hashed password
//        }
//    }
//    return false; // If no result, the password is incorrect
//}

	public boolean updatePassword(String accountId, String newPassword) throws SQLException {
		String query = "UPDATE account SET password = ? WHERE username = ?";
		try (PreparedStatement stmt = con.prepareStatement(query)) {
			stmt.setString(1, newPassword);
			stmt.setString(2, accountId);
			int rowsAffected = stmt.executeUpdate();
			return rowsAffected > 0; // Returns true if the update was successful
		}
	}

}
