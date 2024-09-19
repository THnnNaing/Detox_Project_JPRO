package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Constructors.Account;
import Constructors.Customer;
import Constructors.DetoxAndOrderdetail;
import Constructors.Order;
import Constructors.Staff;
import Constructors.Product;

public class Other_Dao {
	
private Connection con;
	
	public Other_Dao() throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/detoxdb", "root", "");
    }
	
	//----------- START OF ACCOUNT OTHER CODES-------------//	
	// Method to get staff position based on email
    public String getPositionByEmail(String email) throws SQLException {
        String sql = "SELECT s.position FROM staff s JOIN account a ON s.id = a.staffID WHERE s.email = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, email);
        ResultSet rs = pst.executeQuery();
        String position = null;
        if (rs.next()) {
            position = rs.getString("position");
        }
        rs.close();
        pst.close();
        return position;
    }

 // Authentication
    public Staff authenticateUser(String email, String password) throws SQLException {
		Staff s = new Staff();
		String sql = "SELECT staff.* from staff ,account where account.staffID = staff.staffID AND account.username = ? AND account.password = ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, email);
		pst.setString(2, password);
		ResultSet rs = pst.executeQuery();
//		String position = null;
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
    
	//account list query
	public ArrayList<Account> getAccount() throws SQLException{
		ArrayList<Account> p=new ArrayList<Account>();
		PreparedStatement pst=con.prepareStatement("select * from staff");
		 ResultSet rs = pst.executeQuery();
		    
		    while (rs.next()) {
		    	Account account = new Account(rs.getInt("accountID"), rs.getString("username"), rs.getString("password"), rs.getInt("staffID"));
		    	p.add(account);
		    }
	return p;
	}
	//----------- END OF ACCOUNT OTHER CODES-------------//	
	
	//----------- START OF ORDER OTHER CODES-------------//	
	// List Order query
    public ArrayList<Order> getOrders() throws SQLException {
        ArrayList<Order> orders = new ArrayList<>();
        String selectQuery = "SELECT * FROM order";
        try (PreparedStatement pst = con.prepareStatement(selectQuery);
             ResultSet rs = pst.executeQuery()) {
            
            while (rs.next()) {
                Order order = new Order(rs.getInt("orderID"), rs.getDate("orderDate"), rs.getString("order_note"), rs.getInt("customerID"), rs.getInt("staffID"));
                orders.add(order);
            }
        }
        return orders;
    }

    // Get Order Totals query
    public Map<Integer, Double> getOrderTotals() throws SQLException {
        Map<Integer, Double> orderTotals = new HashMap<>();
        String query = "SELECT od.orderID, SUM(od.quantity * d.price) AS totalOrderPrice " +
                       "FROM orderdetail od " +
                       "JOIN detox d ON od.detoxID = d.detoxID " +
                       "GROUP BY od.orderID";
        try (PreparedStatement pst = con.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {
            
            while (rs.next()) {
                int orderID = rs.getInt("orderID");
                double totalOrderPrice = rs.getDouble("totalOrderPrice");
                orderTotals.put(orderID, totalOrderPrice);
            }
        }
        return orderTotals;
    }
    //----------- END OF ORDER OTHER CODES-------------//	
    
   //----------- START OF STAFF OTHER CODES-------------//	
   //staff list query
  		public ArrayList<Staff> getAllStaff() throws SQLException{
  			ArrayList<Staff> p=new ArrayList<Staff>();
  			PreparedStatement pst=con.prepareStatement("select * from staff");
  			 ResultSet rs = pst.executeQuery();
  			    
  			    while (rs.next()) {
  			    	Staff staff = new Staff(rs.getInt("staffID"), rs.getString("name"), rs.getString("email"), rs.getString("gender"),
  			    								rs.getString("phone_number"), rs.getString("NRC"), rs.getString("position"), 
  			    								rs.getString("address"), rs.getDate("dob"));
  			    	p.add(staff);
  			    }
  		return p;
  		}
  		
  	// Method to get staffID by name
	    public int getStaffIdByName(String staffName) throws SQLException {
	        String query = "SELECT staffID FROM staff WHERE name = ?"; // Use the actual column name for the name
	
	        try (PreparedStatement pst = con.prepareStatement(query)) {
	            pst.setString(1, staffName); // Set the staff name parameter
	            ResultSet rs = pst.executeQuery();
	            
	            if (rs.next()) {
	                return rs.getInt("staffID"); // Retrieve and return the ID
	            } else {
	                throw new SQLException("No staff found with the name: " + staffName);
	            }
	        }
	    }
	    
	    public Staff getStaffById(int staffId) throws SQLException {
	        Staff staff = null;
	        String query = "SELECT * FROM staff WHERE staffID = ?"; // Adjust the query to match the table and column names

	        try (PreparedStatement stmt = con.prepareStatement(query)) {
	            stmt.setInt(1, staffId); // Set the staff ID parameter
	            
	            try (ResultSet rs = stmt.executeQuery()) {
	                if (rs.next()) {
	                    staff = new Staff();
	                    staff.setId(rs.getInt("staffID")); // Assuming there's a method to set the staff ID
	                    staff.setName(rs.getString("name"));
	                    // Set other fields as needed
	                } else {
	                    throw new SQLException("No staff found with ID: " + staffId);
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	                throw e;
	            }
	        }

	        return staff;
	    }

	    
	    public ArrayList<Staff> ManageStaff() throws SQLException {
			ArrayList<Staff> staffs = new ArrayList<>();
	        String query = "select StaffID, name, gender, phone_number, position from staff where position = 'Sale'";
	        
	        try (PreparedStatement pst = con.prepareStatement(query);
	             ResultSet rs = pst.executeQuery()) {

	            while (rs.next()) {
	                Staff staff = new Staff(
	                		rs.getInt("StaffID"),
	                    rs.getString("name"),
	                    rs.getString("gender"),
	                    rs.getString("phone_number"),
	                    rs.getString("position") // Fetching quantity from orderdetail
	                );
	                staffs.add(staff);
	            }
	        }
	        return staffs;
	    }
	    
	 
	 //----------- END OF STAFF OTHER CODES-------------//
	    
	 //----------- START OF PRODUCT OTHER CODES-------------//	
	  //product list query
//		public ArrayList<Product> getProduct() throws SQLException {
//	        ArrayList<Product> p = new ArrayList<>();
//	        PreparedStatement pst = con.prepareStatement("SELECT * FROM detox");
//	        ResultSet rs = pst.executeQuery();
//
//	        while (rs.next()) {
//	            Product product = new Product(
//	                rs.getInt("detoxID"),
//	                rs.getString("name"),
//	                rs.getInt("price"),
//	                rs.getString("description"),
//	                rs.getBlob("image"),
//	                rs.getString("size"),
//	                rs.getString("ingredients"),
//	                rs.getString("status"),
//	                rs.getInt("quantity")
//	            );
//	            p.add(product);
//	        }
//	        rs.close();
//	        pst.close();
//	        return p;
//	    }
//		
//		public ArrayList<Product> getProductById() throws SQLException {
//	        ArrayList<Product> p = new ArrayList<>();
//	        PreparedStatement pst = con.prepareStatement("SELECT * FROM detox where detoxID=?");
//	        ResultSet rs = pst.executeQuery();
//
//	        while (rs.next()) {
//	            Product product = new Product(
//	                rs.getInt("detoxID"),
//	                rs.getString("name"),
//	                rs.getInt("price"),
//	                rs.getString("description"),
//	                rs.getBlob("image"),
//	                rs.getString("size"),
//	                rs.getString("ingredients"),
//	                rs.getString("status"),
//	                rs.getInt("quantity")
//	            );
//	            p.add(product);
//	        }
//	        rs.close();
//	        pst.close();
//	        return p;
//	    }
		
//		public Product getProductById(int productId) throws SQLException {
//	        Product product = null;
//	        String query = "SELECT * FROM detox WHERE detoxID = ?";
//
//	        
//	             PreparedStatement stmt = con.prepareStatement(query);
//	            
//	            
//	            stmt.setInt(1, productId);
//	            
//	            
//	            try (ResultSet rs = stmt.executeQuery()) {
//	                if (rs.next()) {
//	                	product = new Product(productId, query, productId, query, null, query, query, query, productId);
//	           
//	                   // product.setDetoxID(rs.getInt("detoxID"));
//	                    product.setName(rs.getString("name"));
//	                    product.setPrice(rs.getInt("price"));
//	                    product.setDescription(rs.getString("description")); 
//	                    product.setSize(rs.getString("size"));
//	                    product.setImage(rs.getBlob("image"));
//	                    product.setIngredients(rs.getString("ingredients"));
//	                   //product.setStatus(rs.getString("status")); 
//	                    product.setQuantity(rs.getInt("quantity"));
//	                }
//	            
//	        } catch (SQLException e) {
//	        	e.printStackTrace();
//	            throw e;
//	        }
//	        return product;
//	    }
		
		//product list query
		public ArrayList<DetoxAndOrderdetail> getProductsForToday() throws SQLException {
			ArrayList<DetoxAndOrderdetail> products = new ArrayList<>();
	        String query = "SELECT d.name, d.size, d.price, od.quantity\r\n"
	        		+ "FROM detox d\r\n"
	        		+ "JOIN orderdetail od ON d.detoxID = od.detoxID\r\n"
	        		+ "JOIN `order` o ON o.orderID = od.orderID\r\n"
	        		+ "WHERE o.orderDate = CURDATE()";
	        
	         PreparedStatement pst = con.prepareStatement(query);
	              {
	        	ResultSet rs = pst.executeQuery();
	            while (rs.next()) {
	            	DetoxAndOrderdetail product = new DetoxAndOrderdetail(
	                		//rs.getInt("detoxID"),
	                    rs.getString("name"),
	                    rs.getString("size"),
	                    
	                    rs.getInt("quantity"),
	                    rs.getInt("price")// Fetching quantity from orderdetail
	                );
	            	
	                products.add(product);
	            }
	        }
	        return products;
	    }
	 //----------- END OF PRODUCT OTHER CODES-------------//   
		
//		
//		public int updatePassword(String accountId, String oldPassword, String newPassword) {
//	        String selectQuery = "SELECT password FROM account WHERE accountID = ?";
//	        String updateQuery = "UPDATE account SET password = ? WHERE accountID = ?";
//
//	        try {
//	            // Check if the old password is correct
//	            try (PreparedStatement selectStmt = con.prepareStatement(selectQuery)) {
//	                selectStmt.setString(1, accountId);
//	                ResultSet rs = selectStmt.executeQuery();
//	                
//	                if (rs.next()) {
//	                    String dbPassword = rs.getString("password");
//	                    
//	                    if (!dbPassword.equals(oldPassword)) {
//	                        // Old password does not match
//	                        return -1; // Indicate password mismatch
//	                    }
//	                } else {
//	                    // Account not found
//	                    return -2; // Indicate account not found
//	                }
//	            }
//	         // Update the password
//	            try (PreparedStatement updateStmt = con.prepareStatement(updateQuery)) {
//	                updateStmt.setString(1, newPassword);
//	                updateStmt.setString(2, accountId);
//	                return updateStmt.executeUpdate(); // Returns the number of rows updated
//	            }
//
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	            return 0; // Indicate failure
//	        }
//		}
		
		
		
		 //----------- Start OF CUSTOMER OTHER CODES-------------//  

//		public Customer(int id,String n,String e,String g,String a,int phno,Date d) {
		
		
		
//		getManageCustomer
		
		public ArrayList<Customer> getManageCustomer() throws SQLException {
	        ArrayList<Customer> p = new ArrayList<>();
	        PreparedStatement pst = con.prepareStatement("SELECT * FROM customer");
	        ResultSet rs = pst.executeQuery();

	        while (rs.next()) {
	        	Customer customer = new Customer(
	                rs.getInt("customerID"),
	                rs.getString("name"),
	                rs.getString("email"),
	                rs.getString("gender"),
	                rs.getString("phoneNumber")
	            );
	            p.add(customer);
	        }
	        rs.close();
	        pst.close();
	        return p;
	    }
		//----------- End OF Customer OTHER CODES-------------//   

		public ArrayList<Staff> authenticateUser(Staff s) {
			// TODO Auto-generated method stub
			return null;
		}
}
