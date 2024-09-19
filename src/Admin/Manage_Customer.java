package Admin;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Toolkit;
import javax.swing.JPasswordField;
import com.toedter.calendar.JDateChooser;

import Constructors.Account;
import Constructors.Customer;
import Constructors.Staff;
import Customer.View_Customer;
import Dao.CRUD_Dao;
import Dao.Other_Dao;
import DetoxProduct.Edit_Product;

import DetoxProduct.ProductTableModel;



import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBox;

public class Manage_Customer extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtAddress;
	private JTextField txtPhno;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtSearch;
	private JTable table;
	private ArrayList<Customer> data = new ArrayList<Customer>();
	private CustomerTableModel cus;
	private final ButtonGroup btngender = new ButtonGroup();
	private JDateChooser dob;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manage_Customer frame = new Manage_Customer(new Staff());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Manage_Customer(Staff s) throws SQLException {
		setTitle("VITALSIP Detox Juice");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Manage_Customer.class.getResource("/image/Logo-removebg-preview.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1330, 741);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.light"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name           :");
		lblName.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblName.setBounds(34, 226, 126, 28);
		contentPane.add(lblName);
		
		JLabel lblGender = new JLabel("Gender        :");
		lblGender.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblGender.setBounds(34, 328, 139, 28);
		contentPane.add(lblGender);
		
		JLabel lblAddress = new JLabel("Address      :");
		lblAddress.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblAddress.setBounds(34, 437, 169, 28);
		contentPane.add(lblAddress);
		
		JLabel lblPhoneNo = new JLabel("Phone No   : ");
		lblPhoneNo.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblPhoneNo.setBounds(34, 377, 169, 28);
		contentPane.add(lblPhoneNo);
		
		JRadioButton rdoMale = new JRadioButton("Male");
		btngender.add(rdoMale);
		rdoMale.setBackground(UIManager.getColor("Button.light"));
		rdoMale.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		rdoMale.setBounds(189, 335, 74, 21);
		contentPane.add(rdoMale);
		
		JRadioButton rdoFemale = new JRadioButton("Female");
		btngender.add(rdoFemale);
		rdoFemale.setBackground(UIManager.getColor("Button.light"));
		rdoFemale.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		rdoFemale.setBounds(275, 335, 103, 21);
		contentPane.add(rdoFemale);
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		txtAddress.setColumns(10);
		txtAddress.setBounds(188, 437, 290, 54);
		contentPane.add(txtAddress);
		
		txtPhno = new JTextField();
		txtPhno.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		txtPhno.setColumns(10);
		txtPhno.setBounds(188, 379, 290, 26);
		contentPane.add(txtPhno);
		
		JLabel lblEmail = new JLabel("Email          :");
		lblEmail.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblEmail.setBounds(34, 530, 126, 28);
		contentPane.add(lblEmail);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		txtName.setColumns(10);
		txtName.setBounds(189, 227, 290, 26);
		contentPane.add(txtName);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		txtEmail.setColumns(10);
		txtEmail.setBounds(188, 533, 290, 26);
		contentPane.add(txtEmail);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(81, 192, 61));
		panel.setBounds(0, 0, 1316, 54);
		contentPane.add(panel);
		
		JLabel lblAdmin = new JLabel("Staff");
		lblAdmin.setIcon(new ImageIcon(Manage_Customer.class.getResource("/image/people icon.png")));
		lblAdmin.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblAdmin.setBounds(1219, 5, 126, 42);
		panel.add(lblAdmin);
		
		JLabel lblAdminDashboard = new JLabel("Vitalsip Detox Juice");
		lblAdminDashboard.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblAdminDashboard.setBounds(0, 0, 486, 49);
		panel.add(lblAdminDashboard);
		
		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				

				try {
						ArrayList<Customer>ur=new CRUD_Dao().AddCustomerIntoTable();
				
				
				String keyword=txtSearch.getText().trim().toLowerCase();
				data.clear();
				data.addAll((ArrayList<Customer>) ur.stream()
						.filter(u ->u.getName().toLowerCase().contains(keyword)||u.getAddress().toLowerCase().contains(keyword)||u.getGender().toLowerCase().contains(keyword))
						.collect(Collectors.toList()));
				cus.fireTableDataChanged();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			
			}
		});
		txtSearch.setFont(new Font("Monospaced", Font.PLAIN, 14));
		txtSearch.setColumns(10);
		txtSearch.setBounds(1001, 150, 280, 26);
		contentPane.add(txtSearch);		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(488, 188, 818, 448);
		contentPane.add(scrollPane);
		
		// Fetch data and update the table
		
		CRUD_Dao b=new CRUD_Dao();
		data=new CRUD_Dao().AddCustomerTable();
		cus=new CustomerTableModel(data);
		
		 table = new JTable();
		 table.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		 table.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		
		 		
		 		int selectedRow = table.getSelectedRow();

		        if (selectedRow != -1) {
		           
		            int productId = (int) table.getValueAt(selectedRow, 0);

		            try {
		               
		                Customer customer = new CRUD_Dao().getCustomerById(productId);

		                if (customer != null) {
		                    // Populate the text fields and combo box with the product data
		                    txtName.setText(customer.getName());
		                    txtEmail.setText(String.valueOf(customer.getEmail()));
		                    dob.setDate(customer.getDob());
		                    txtAddress.setText(String.valueOf(customer.getAddress()));
		                    if (customer.getGender().equalsIgnoreCase("Male")) {
		                    	btngender.setSelected(rdoMale.getModel(), true);
		                    } else if (customer.getGender().equalsIgnoreCase("Female")) {
		                    	btngender.setSelected(rdoFemale.getModel(), true);
		                    } else {
		                    	btngender.clearSelection(); // Clear if gender is not Male/Female
		                    }
					        
		                    txtPhno.setText(String.valueOf(customer.getPhno()));
		                 
		                    
		                    

		                    
		                    
		                } else {
		                    JOptionPane.showMessageDialog(null, "Product not found in the database.");
		                }

		            } catch (SQLException ex) {
		                ex.printStackTrace();
		                JOptionPane.showMessageDialog(null, "An error occurred while fetching product data.");
		            }

		        } else {
		            System.out.println("No row is selected.");
		        }
		    }
				
		 		
		 	
		 });
	        scrollPane.setViewportView(table);


	                table.setModel(cus);
//	                new DefaultTableModel(
//	                	new Object[][] {
//	                	},
//	                	new String[] {
//	                		"No.", "Name", "Gender", "Phone NO", "Email"
//	                	}
//	                ) {
//	                	boolean[] columnEditables = new boolean[] {
//	                		false, false, false, false, false
//	                	};
//	                	public boolean isCellEditable(int row, int column) {
//	                		return columnEditables[column];
//	                	}
//	                });
	                table.getColumnModel().getColumn(0).setResizable(false);
	                table.getColumnModel().getColumn(1).setResizable(false);
	                table.getColumnModel().getColumn(2).setResizable(false);
	                table.getColumnModel().getColumn(3).setResizable(false);
	                table.getColumnModel().getColumn(4).setResizable(false);

		
		JButton btnSearch = new JButton("");
		btnSearch.setIcon(new ImageIcon(Manage_Customer.class.getResource("/Image/refresh-data.png")));
		btnSearch.setFont(new Font("Monospaced", Font.PLAIN, 11));
		btnSearch.setBackground(new Color(50, 205, 50));
		btnSearch.setBounds(1282, 150, 24, 25);
		contentPane.add(btnSearch);
		
		JLabel lblNewLabel = new JLabel("Manage Customer");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(10, 79, 1179, 43);
		contentPane.add(lblNewLabel);
		
		JLabel lblDob = new JLabel("DOB            :");
		lblDob.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblDob.setBounds(34, 278, 126, 28);
		contentPane.add(lblDob);
		
		JLabel lblAddNewStaff = new JLabel("Registration New Customer\r\n");
		lblAddNewStaff.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		lblAddNewStaff.setBounds(34, 186, 238, 28);
		contentPane.add(lblAddNewStaff);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(checkInput()==true) {
					
					String n=txtName.getText();
					String email=txtEmail.getText();
					String ph=txtPhno.getText();
					
					String gender="";
		    		if(rdoMale.isSelected())
		    			gender="Male";
		    		else if(rdoFemale.isSelected())
		    			gender="Female";
		    		
		    		
		    		String a=txtAddress.getText();
		    		Date d=new Date(dob.getDate().getTime());
		    		Customer s=new Customer(n,email,gender,a,ph,d);
		    		
		    		
		    		clear();
		    		
		    		try {
						int id=new CRUD_Dao().addCustomer(s);

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    		
				}
				cus.fireTableDataChanged();
			}
		});
		btnSave.setIcon(new ImageIcon(Manage_Customer.class.getResource("/Image/save.png")));
		btnSave.setBackground(new Color(50, 205, 50));
		btnSave.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnSave.setBounds(357, 650, 107, 33);
		contentPane.add(btnSave);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				 cus = (CustomerTableModel) table.getModel();
			        int selectedRow = table.getSelectedRow();

			        if (selectedRow != -1) {
			            int id = (int) cus.getValueAt(selectedRow, 0); 
			            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
			            
			            if (confirm == JOptionPane.YES_OPTION) {
			                try {
			                    
			                  new CRUD_Dao().deleteCustomerById(id);
			                    
			                    
			                  cus.removeRow(selectedRow);
			                    
			                    JOptionPane.showMessageDialog(null, "Record deleted successfully.");
			                } catch (SQLException ex) {
			                    ex.printStackTrace();
			                    JOptionPane.showMessageDialog(null, "Failed to delete the record. Please try again.");
			                }
			            }
			        } else {
			            if (table.getRowCount() == 0) {
			                JOptionPane.showMessageDialog(null, "Table is empty!");
			            } else {
			                JOptionPane.showMessageDialog(null, "Please select a row for deletion.");
			            }
			        }
			        
			        clear(); 
			}
		});
		btnDelete.setIcon(new ImageIcon(Manage_Customer.class.getResource("/image/delete-two.png")));
		btnDelete.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnDelete.setBackground(new Color(50, 205, 50));
		btnDelete.setBounds(1199, 650, 107, 33);
		contentPane.add(btnDelete);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {

					//contentPane.removeAll();
					
			        
//					 Edit_Customer editProductPanel = 
					//new Edit_Customer(s).setVisible(true);
//				      contentPane.add(editProductPanel);
//			       
//				      setSize(527,738);
//			        contentPane.repaint();
//			        contentPane.revalidate();
					
					int selectedRow = table.getSelectedRow();
					if(selectedRow != -1 ) {
						

						
						int id = (int) table.getValueAt(selectedRow, 0);
						String name=txtName.getText().trim();
						
						
						String email=txtEmail.getText();
						String ph=txtPhno.getText();
						
						String gender="";
			    		if(rdoMale.isSelected())
			    			gender="Male";
			    		else if(rdoFemale.isSelected())
			    			gender="Female";
			    		
			    		
			    		String a=txtAddress.getText();
			    		Date d=new Date(dob.getDate().getTime());
			    		Edit_Customer cust=new Edit_Customer(s);
		                cust.setCustomerData( name, email, gender, a, ph, d);
		                cust.setVisible(true);
			                
		            }
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Please enter valid numbers for quantity and price.");
		        } catch (Exception ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "An error occurred while processing the data.");
		        }
				dispose();
		    }

				
		
					
			
		});
		btnEdit.setIcon(new ImageIcon(Manage_Customer.class.getResource("/image/editor.png")));
		btnEdit.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnEdit.setBackground(new Color(50, 205, 50));
		btnEdit.setBounds(1082, 650, 107, 33);
		contentPane.add(btnEdit);
		
		JButton btnView = new JButton("View");
		btnView.setForeground(new Color(0, 0, 0));
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				new View_Customer(s).setVisible(true);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				dispose();
				
			}
		});
		
		
		btnView.setIcon(new ImageIcon(Manage_Customer.class.getResource("/image/view-grid-detail.png")));
		btnView.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnView.setBackground(new Color(50, 205, 50));
		btnView.setBounds(965, 650, 107, 33);
		contentPane.add(btnView);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					new Staff_Dashboard(s).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		btnBack.setIcon(new ImageIcon(Manage_Customer.class.getResource("/image/back.png")));
		btnBack.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnBack.setBackground(new Color(50, 205, 50));
		btnBack.setBounds(1199, 89, 107, 33);
		contentPane.add(btnBack);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				clear();
			}
		});
		btnClear.setIcon(new ImageIcon(Manage_Customer.class.getResource("/image/clear-format.png")));
		btnClear.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnClear.setBackground(new Color(50, 205, 50));
		btnClear.setBounds(236, 650, 111, 33);
		contentPane.add(btnClear);
		
		 dob = new JDateChooser();
		dob.setBounds(189, 286, 289, 20);
		contentPane.add(dob);
		
		
	}
	
	
	public boolean checkInput(){
		if( checkAddress() & checkEmail() & checkPhno() & checkGender() & checkname() ){  return true;}
		else return false;
	}
	
	public boolean checkAddress(){
		if(txtAddress.getText().isEmpty()){
			//label_9.setForeground(Color.RED);
			txtAddress.setBorder(new LineBorder(Color.RED));
			txtAddress.setText("");
			txtAddress.requestFocus();
			return false;
		}else{
			//label_9.setForeground(Color.BLACK);
			txtAddress.setBorder(new LineBorder(Color.BLACK));
			return true;
		}
	}
	
	public boolean checkEmail(){
		if(txtEmail.getText().isEmpty()){
			//label_8.setForeground(Color.RED);
			txtEmail.setBorder(new LineBorder(Color.RED));
			txtEmail.setText("");
			txtEmail.requestFocus();
			return false;
		}else{
			if(Pattern.matches("[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}", txtEmail.getText().trim()))
			{
			return true;
			}
		
			//label_8.setForeground(Color.BLACK);
			txtEmail.setBorder(new LineBorder(Color.BLACK));
			return true;
		}
	}
	
	
	public boolean checkPhno(){
		if(txtPhno.getText().isEmpty() || !(Pattern.matches("09[2|4|6|7|8|9][0-9]{8}",txtPhno.getText().toString().trim()))){
			//label_7.setForeground(Color.RED);
			txtPhno.setBorder(new LineBorder(Color.RED));
			txtPhno.setText("");
			txtPhno.requestFocus();
			return false;
		}else{
			//label_7.setForeground(Color.BLACK);
			txtPhno.setBorder(new LineBorder(Color.BLACK));
			return true;
		}
	}
	
	
	
	
	public boolean checkGender(){
		if(btngender.isSelected(null)){
			//label_2.setForeground(Color.RED);
			return false;
		}else{
			//label_2.setForeground(Color.BLACK);
			return true;
		}
	}
	
		
	
	
	
	public boolean checkname(){
		if(txtName.getText().isEmpty()){
			
			txtName.setBorder(new LineBorder(Color.RED));
			txtName.setText("");
			txtName.requestFocus();
			return false;
		}else{
			if(Pattern.matches("[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}", txtEmail.getText().trim()))
			{
			return true;
			}
		
			
			
			txtName.setBorder(new LineBorder(Color.BLACK));
			return true;
		}
		
	}
	
	
	
	
	public void clear() {
		txtName.setText("");
		txtEmail.setText("");
		
		txtPhno.setText("");
		btngender.clearSelection();
//		txtuser.setText("");
//		txtpassword.setText("");
//		txtconfirm.setText("");
		txtAddress.setText("");

	}
	
//	private void viewSelectedCustomer() {
//        int selectedRow = table.getSelectedRow();
//        if (selectedRow >= 0) {
//            // Retrieve data from the selected row
//            int id = (Integer) table.getValueAt(selectedRow, 0);
//            String name = (String) table.getValueAt(selectedRow, 1);
//            String gender = (String) table.getValueAt(selectedRow, 2);
//            String phoneNumber = (String) table.getValueAt(selectedRow, 3);
//            String email = (String) table.getValueAt(selectedRow, 4);
//
//            // Display the data in a dialog
//            JOptionPane.showMessageDialog(this, 
//                "ID: " + id + "\n" +
//                "Name: " + name + "\n" +
//                "Gender: " + gender + "\n" +
//                "Phone Number: " + phoneNumber + "\n" +
//                "Email: " + email,
//                "Customer Details",
//                JOptionPane.INFORMATION_MESSAGE);
//        } else {
//            JOptionPane.showMessageDialog(this, "No row selected", "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }
	
//	private static void configureTable(JTable table) {
//        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//
////         "No", "Name", "Gender", "Phone Number", "Email"
//        
//        // Safely configure table columns
//        if (table.getColumnModel().getColumnCount() > 0) {
//            table.getColumnModel().getColumn(0).setPreferredWidth(50); // ID
//        }
//        if (table.getColumnModel().getColumnCount() > 1) {
//            table.getColumnModel().getColumn(1).setPreferredWidth(100); // Name
//        }
//        if (table.getColumnModel().getColumnCount() > 2) {
//            table.getColumnModel().getColumn(2).setPreferredWidth(100); // Gender
//        }
//        if (table.getColumnModel().getColumnCount() > 3) {
//            table.getColumnModel().getColumn(3).setPreferredWidth(100); // Phone Number 
//        }
//        if (table.getColumnModel().getColumnCount() > 4) {
//            table.getColumnModel().getColumn(4).setPreferredWidth(150); // Email 
//        }
  //  }
}
