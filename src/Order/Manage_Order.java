package Order;

import java.awt.EventQueue;

import java.io.ByteArrayInputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Admin.Staff_Dashboard;
import Constructors.OrderTableModel;
import Constructors.Product;
import Constructors.Staff;
import Constructors.Customer;
import Constructors.Invoice;
import Dao.CRUD_Dao;
import DetoxProduct.ProductTableModel;
import DetoxProduct.View_Product;
import Constructors.OrderDetail;
import Constructors.Order;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.stream.Collectors;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class Manage_Order extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable orderTable;
	private JTextField txtsearchP;
	private ArrayList<Product>data =new ArrayList<Product>();
	private OrderTableModel order;//ordering page(image,price,size)
	private ProductTableModel product;
	private JTable   productTable;
	//private   DefaultTableModel productModel;
	private JTextField txtQty;
	private JLabel lblTotalprice,lbltaxamount;
	private DefaultTableModel tableModel;
	private JTable table_1;
	private ArrayList<Invoice> v=new ArrayList<Invoice>();//for slip frame
	private InvoiceTableModel view;
	private JTextField txtSearch;
	private ArrayList<Customer> customerList = new ArrayList<>();
	private JComboBox<String> comboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manage_Order frame = new Manage_Order(new Staff());
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
	 * @throws IOException 
	 */
	public Manage_Order(Staff s) throws SQLException, IOException {
//		setIconImage(Toolkit.getDefaultToolkit().getImage(Manage_Order.class.getResource("/image/Logo-removebg-preview.png")));
		setTitle("VITALSIP Detox Juice");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1330, 741);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1316, 51);
		panel.setLayout(null);
		panel.setBackground(new Color(81, 192, 61));
		contentPane.add(panel);
		
		JLabel lblAdmin_1 = new JLabel("Staff");
//		lblAdmin_1.setIcon(new ImageIcon(Manage_Order.class.getResource("/image/people icon.png")));
		lblAdmin_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblAdmin_1.setBounds(1227, 0, 89, 49);
		panel.add(lblAdmin_1);
		
		JLabel lblAdminDashboard = new JLabel("Vitalsip Detox Juice");
		lblAdminDashboard.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblAdminDashboard.setBounds(0, 0, 486, 49);
		panel.add(lblAdminDashboard);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(945, 224, 334, 281);
		contentPane.add(scrollPane_1);
		
		orderTable = new JTable();
		orderTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		orderTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"No", "Name", "Quantity"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		orderTable.getColumnModel().getColumn(1).setPreferredWidth(113);
		orderTable.getColumnModel().getColumn(2).setPreferredWidth(113);
		scrollPane_1.setViewportView(orderTable);
		
		txtsearchP = new JTextField();
		txtsearchP.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				try {
					ArrayList<Constructors.Product>ur=new CRUD_Dao().getProductForOrder();
					
					
					String keyword=txtsearchP.getText().trim().toLowerCase();
					data.clear();
					data.addAll((ArrayList<Product>) ur.stream()
							.filter(u ->u.getName().toLowerCase().contains(keyword)||u.getSize().toLowerCase().contains(keyword)||String.valueOf(u.getPrice()).toLowerCase().contains(keyword))
							.collect(Collectors.toList()));
					order.fireTableDataChanged();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
			
		});
		txtsearchP.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		txtsearchP.setColumns(10);
		txtsearchP.setBounds(437, 108, 289, 26);
		contentPane.add(txtsearchP);
		
		JButton btnSearch = new JButton("S");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					ArrayList<Product>ur=new CRUD_Dao().getProductForOrder();
					
					
					String keyword=txtsearchP.getText().trim().toLowerCase();
					data.clear();
					data.addAll((ArrayList<Product>) ur.stream()
							.filter(u ->u.getName().toLowerCase().contains(keyword)||u.getSize().toLowerCase().contains(keyword))
							.collect(Collectors.toList()));
					order.fireTableDataChanged();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
			
			
		});
		btnSearch.setForeground(new Color(0, 0, 0));
	//	btnSearch.setIcon(new ImageIcon(Manage_Order.class.getResource("/image/search.png")));
		btnSearch.setFont(new Font("Monospaced", Font.PLAIN, 11));
		btnSearch.setBackground(new Color(50, 205, 50));
		btnSearch.setBounds(727, 108, 35, 25);
		contentPane.add(btnSearch);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(250, 250, 210));
		panel_1.setBounds(20, 182, 742, 506);
		contentPane.add(panel_1);
		
		table_1 = new JTable();
		data=new CRUD_Dao().getProductForOrder();
		order=new OrderTableModel(data);
		table_1.setModel(order);
//		new DefaultTableModel(
//			new Object[][] {
//			},
//			new String[] {
//				"Image", "Name", "Size", "Price", "Ingredients"
//			}
//		));
		
		table_1.setBounds(0, 0, 742, 506);
		panel_1.add(table_1);
		table_1.setRowHeight(100);

		   
		table_1.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer()); // Image column
		table_1.getColumnModel().getColumn(1).setPreferredWidth(60); // Name column

		   
		 
		
		JLabel lblCustomername = new JLabel("Customer Name :");
		lblCustomername.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblCustomername.setBounds(927, 169, 137, 26);
		contentPane.add(lblCustomername);
		
		JLabel lblTotalPrice = new JLabel("Total Price    :");
		lblTotalPrice.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		lblTotalPrice.setBounds(1002, 515, 128, 26);
		contentPane.add(lblTotalPrice);
		
		 lblTotalprice = new JLabel("");
		lblTotalprice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalprice.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		lblTotalprice.setBounds(1136, 515, 143, 26);
		contentPane.add(lblTotalprice);
		
		JLabel lblTaxAmount = new JLabel("TaxAmount :");
		lblTaxAmount.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		lblTaxAmount.setBounds(1002, 562, 128, 26);
		contentPane.add(lblTaxAmount);
		
		 lbltaxamount = new JLabel("");
		lbltaxamount.setHorizontalAlignment(SwingConstants.RIGHT);
		lbltaxamount.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		lbltaxamount.setBounds(1136, 562, 143, 26);
		contentPane.add(lbltaxamount);
		
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
//		btnBack.setIcon(new ImageIcon(Manage_Order.class.getResource("/image/back.png")));
		btnBack.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnBack.setBackground(new Color(50, 205, 50));
		btnBack.setBounds(1199, 72, 107, 33);
		contentPane.add(btnBack);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

           
				        ArrayList<OrderDetail> orderDetails = new ArrayList<>();
				        String customerName = comboBox.getSelectedItem().toString();
				        int customerID = 0;

				        try {
				            customerID = new CRUD_Dao().getCustomerIDByName(customerName);
				        } catch (SQLException e1) {
				            e1.printStackTrace();
				            JOptionPane.showMessageDialog(null, "Error retrieving customer ID.");
				            return;
				        }

				        if (customerID == 0) {
				            JOptionPane.showMessageDialog(null, "Customer not found.");
				            return;
				        }

				        int staffID = s.getId(); 
				        java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());

				        int orderID = 0;
				        try {
				            // Insert order and retrieve orderID
				            orderID = new CRUD_Dao().insertOrder(customerID, staffID);

				            // Collect order details from the table
				            int rowCount = tableModel.getRowCount();

				            for (int i = 0; i < rowCount; i++) {
				               // String name = (String) order.getValueAt(i, 1);
				                String detoxIDStr = tableModel.getValueAt(i, 0).toString().trim(); 
				                int detoxID = Integer.parseInt(detoxIDStr);
				                Object quantityValue = tableModel.getValueAt(i, 2); 
				                int quantity = (quantityValue instanceof Integer) ? (Integer) quantityValue : 0;

				                // Get product and check stock
				                Product p = new CRUD_Dao().getProductById(detoxID);
				                if (p != null) {
				                    int currentStock = p.getQuantity();

				                    if (quantity > currentStock) {
				                        JOptionPane.showMessageDialog(null, "Not enough stock available for " + p.getName(), "Error", JOptionPane.ERROR_MESSAGE);
				                        return;
				                    }

				                    // Reduce stock by quantity
				                    new CRUD_Dao().updateQuantity(detoxID, currentStock - quantity); // Correctly decrease stock

				                    // Add to order details
				                    OrderDetail detail = new OrderDetail();
				                    detail.setDetoxid(detoxID);
				                    detail.setQuantity(quantity);
				                    orderDetails.add(detail);
				                }
				            }

				            // Insert order details
				            new CRUD_Dao().insertOrderDetails(orderID, orderDetails);

				            JOptionPane.showMessageDialog(null, "Order placed successfully.");
				        } catch (SQLException e1) {
				            e1.printStackTrace();
				            JOptionPane.showMessageDialog(null, "Error processing the order: " + e1.getMessage());
				        }

				       
				
				
				
		        Slip viewProductPanel = null;
		        try {
		        	setSize(550,1400);
		            viewProductPanel = new Slip(s,customerName,currentDate); // Create the Slip panel
		            contentPane.removeAll();
		            contentPane.add(viewProductPanel, BorderLayout.CENTER);
		            viewProductPanel.setSize(580, 620);
		            viewProductPanel.setLocation(0, 0);
		            contentPane.repaint();
		            contentPane.revalidate();
		        } catch (SQLException e1) {
		            e1.printStackTrace();
		        }
		        
		        
		        view = viewProductPanel.getInvoiceTableModel();
		        order = (OrderTableModel) table_1.getModel(); // Extract OrderTableModel
		        tableModel = (DefaultTableModel) orderTable.getModel(); // Extract DefaultTableModel

		        int productRowCount = order.getRowCount();
		        int orderRowCount = tableModel.getRowCount();


		         //for slip frame
		       
		        ArrayList<Invoice> invoices = new ArrayList<>();
		        for (int i = 0; i < productRowCount; i++) {
		            if (i < orderRowCount) {
		                String name = (String) order.getValueAt(i, 1); 
		                String size = (String) order.getValueAt(i, 2);  
		                int price = (Integer) order.getValueAt(i, 3);  
		                int quantity = (Integer) tableModel.getValueAt(i, 2);  
		                invoices.add(new Invoice(name, size, price, quantity));
		            }
		        }
		        viewProductPanel.updateTable(invoices);
		    
		       
				
			        
			        double totalAmount = 0.0;
			        for (int i = 0; i < view.getRowCount(); i++) {
			            int quantity = Integer.parseInt(view.getValueAt(i, 3).toString());
			            int price = Integer.parseInt(view.getValueAt(i, 4).toString());
			            totalAmount += quantity * price;
			        }
			        double taxAmount = totalAmount * 0.10; 
			        double netPayment = totalAmount + taxAmount;

			       
			        viewProductPanel.lblTotalp.setText(String.format("%.2f", totalAmount));
			        viewProductPanel.lblTaxamount.setText(String.format("%.2f", taxAmount));
			        viewProductPanel.lblnetpayment.setText(String.format("%.2f", netPayment));
			        
				contentPane.add(viewProductPanel);
				contentPane.add(viewProductPanel,BorderLayout.CENTER);
		        
				
				viewProductPanel.setSize(580,620);
				viewProductPanel.setLocation(0,0);
		        contentPane.repaint();
		        contentPane.revalidate();
	        
				
		}
		});
//		btnConfirm.setIcon(new ImageIcon(Manage_Order.class.getResource("/image/confirmm.png")));
		btnConfirm.setForeground(Color.BLACK);
		btnConfirm.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnConfirm.setBackground(new Color(50, 205, 50));
		btnConfirm.setBounds(1160, 657, 119, 31);
		contentPane.add(btnConfirm);
		
		JLabel lblQuantity_1 = new JLabel("Quantity ");
		lblQuantity_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity_1.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblQuantity_1.setBounds(773, 503, 119, 28);
		contentPane.add(lblQuantity_1);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				 int selectedRow = table_1.getSelectedRow();
//
//			        if (selectedRow != -1) {
//			            order = (OrderTableModel) table_1.getModel();
//			            String name = (String) order.getValueAt(selectedRow, 1); // Name column
//
//			            int quantity;
//			            try {
//			                quantity = Integer.parseInt(txtQty.getText());
//			                
//			                // Fetch the product
//			                Product p = new CRUD_Dao().getProductByName(name);
//			                
//			                if (p == null) {
//			                    JOptionPane.showMessageDialog(null, "Product not found", "Error", JOptionPane.ERROR_MESSAGE);
//			                    return;
//			                }
//			                
//			                int currentQty = p.getQuantity(); // Ensure p is not null before accessing its methods
//			                
//			                if (quantity > currentQty) {
//			                    JOptionPane.showMessageDialog(null, "Not enough stock available", "Error", JOptionPane.ERROR_MESSAGE);
//			                    return;
//			                }
//
//			               
//			                int newQty = currentQty - quantity;
//			                new CRUD_Dao().updateQuantity(name, newQty);
//			                
//			               
//			                DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
//			                tableModel.addRow(new Object[] {
//			                    tableModel.getRowCount() + 1, // Row number
//			                    name,
//			                    quantity
//			                });
//
//			                
//			                TotalAndTax();
//			                txtQty.setText("");
//
//			            } catch (NumberFormatException ex) {
//			                JOptionPane.showMessageDialog(null, "Please enter a valid quantity", "Invalid Input", JOptionPane.ERROR_MESSAGE);
//			            } catch (SQLException ex) {
//			                JOptionPane.showMessageDialog(null, "Error updating the product quantity", "Error", JOptionPane.ERROR_MESSAGE);
//			                ex.printStackTrace();
//			            }
//			        }
				
				 
			        ArrayList<Product> customerOrder = new ArrayList<Product>(); // by teacher

			        if (selectedRow > -1) {
			            order = (OrderTableModel) table_1.getModel();
			            String name = (String) order.getValueAt(selectedRow, 1); // Name column

			            int quantity;
			            try {
			                quantity = Integer.parseInt(txtQty.getText());

			                // Fetch the latest product from the database instead of using cached data
			                Product p=null;
							try {
								p = new CRUD_Dao().getProductByName(name);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

			                if (p == null) {
			                    JOptionPane.showMessageDialog(null, "Product not found", "Error", JOptionPane.ERROR_MESSAGE);
			                    return;
			                } else {
			                    int currentQty = p.getQuantity(); // Get latest quantity from database

			                    if (quantity > currentQty) {
			                        JOptionPane.showMessageDialog(null, "Not enough stock available", "Error", JOptionPane.ERROR_MESSAGE);
			                        return;
			                    } else {
			                        tableModel = (DefaultTableModel) orderTable.getModel();
			                        boolean found = false;

			                        
			                        for (int i = 0; i < tableModel.getRowCount(); i++) {
			                            String existingProductName = (String) tableModel.getValueAt(i, 1); // Name column
			                            if (existingProductName.equals(name)) {
			                     
			                                int existingQuantity = (int) tableModel.getValueAt(i, 2); // Quantity column
			                                tableModel.setValueAt(existingQuantity + quantity, i, 2); // Update with new quantity
			                                found = true;
			                                break;
			                            }
			                        }
			                        

			                        if (!found) {
			                            // Add new row if the product was not found
			                            tableModel.addRow(new Object[] {
			                                tableModel.getRowCount() + 1, // Row number
			                                name,
			                                quantity
			                            });
			                        }

			                        // Update the customerOrder list as well
			                        for (int i = 0; i < customerOrder.size(); i++) {
			                            if (customerOrder.get(i).getName().equals(name)) {
			                                customerOrder.get(i).setQuantity(quantity + customerOrder.get(i).getQuantity());
			                                found = true;
			                                break;
			                            }
			                        }

			                        if (!found) {
			                            p.setQuantity(quantity);
			                            customerOrder.add(p);
			                        }

			                        TotalAndTax(); // Update totals and tax
			                        txtQty.setText(""); // Clear the quantity input
			                    }
			                }

			            } catch (NumberFormatException ex) {
			                JOptionPane.showMessageDialog(null, "Please enter a valid quantity", "Error", JOptionPane.ERROR_MESSAGE);
			            }
			        }
			    }
		
			    
			
			
		});
		//btnAdd.setIcon(new ImageIcon(Manage_Order.class.getResource("/image/add-to-cart.png")));
		btnAdd.setForeground(Color.BLACK);
		btnAdd.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnAdd.setBackground(new Color(50, 205, 50));
		btnAdd.setBounds(773, 572, 119, 33);
		contentPane.add(btnAdd);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				
			}
			
			
		});
		//btnClear.setIcon(new ImageIcon(Manage_Order.class.getResource("/image/clear-format.png")));
		btnClear.setForeground(Color.BLACK);
		btnClear.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnClear.setBackground(new Color(50, 205, 50));
		btnClear.setBounds(1031, 657, 119, 31);
		contentPane.add(btnClear);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectedRow = orderTable.getSelectedRow();
	              if (selectedRow != -1) {
					
	            	  tableModel = (DefaultTableModel) orderTable.getModel();
	                  tableModel.removeRow(selectedRow);  // Remove the selected row
	              } else {
	                  JOptionPane.showMessageDialog(null, "Please select a row to remove.");
	              }
				
			}
		});
		//btnRemove.setIcon(new ImageIcon(Manage_Order.class.getResource("/image/remove.png")));
		btnRemove.setHorizontalAlignment(SwingConstants.LEADING);
		btnRemove.setForeground(Color.BLACK);
		btnRemove.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnRemove.setBackground(new Color(50, 205, 50));
		btnRemove.setBounds(772, 655, 119, 33);
		contentPane.add(btnRemove);
		
		JLabel lblDetoxingNever = new JLabel("Drink your juice.It's like liquid sunshine for your body.");
		lblDetoxingNever.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetoxingNever.setFont(new Font("Times New Roman", Font.ITALIC, 17));
		lblDetoxingNever.setBounds(20, 109, 417, 23);
		contentPane.add(lblDetoxingNever);
		
       
	  // loadProductsIntoPanel(panel_1);
	   
	   
	    
	    JPanel panel_2 = new JPanel();
	    panel_2.setBounds(20, 145, 742, 37);
	    contentPane.add(panel_2);
	    panel_2.setLayout(null);
	    panel_2.setBackground(new Color(211, 211, 211));
	    
	    JLabel lblImage = new JLabel("Image");
	    lblImage.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
	    lblImage.setBounds(20, 0, 59, 39);
	    panel_2.add(lblImage);
	    
	    JLabel lblName = new JLabel("Name");
	    lblName.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
	    lblName.setBounds(145, 0, 59, 39);
	    panel_2.add(lblName);
	    
	    JLabel lblIngredients = new JLabel("Ingredients");
	    lblIngredients.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
	    lblIngredients.setBounds(595, 0, 100, 39);
	    panel_2.add(lblIngredients);
	    
	    JLabel lblSize = new JLabel("Size");
	    lblSize.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
	    lblSize.setBounds(275, 0, 59, 39);
	    panel_2.add(lblSize);
	    
	    JLabel lblPrice = new JLabel("Price");
	    lblPrice.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
	    lblPrice.setBounds(411, 0, 59, 39);
	    panel_2.add(lblPrice);
	    
	    txtQty = new JTextField();
	    txtQty.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
	    txtQty.setBounds(772, 536, 120, 26);
	    contentPane.add(txtQty);
	    txtQty.setColumns(10);
	    
	    
	    
	     comboBox = new JComboBox<>();
	     comboBox.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
	    comboBox.setBounds(1094, 132, 185, 25);
	    contentPane.add(comboBox);

	    
	    
	    try {
	        // add customers into the combo box
	        customerList = new CRUD_Dao().retrievecustomer(); 
	        for (Customer customer : customerList) {
	            comboBox.addItem(customer.getName()); 
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    
	    txtSearch = new JTextField();
	    txtSearch.addKeyListener(new KeyAdapter() {
	    	@Override
	    	public void keyPressed(KeyEvent e) {
	    		
	    		String keyword = txtSearch.getText().trim().toLowerCase(); // Get the search keyword
	            
	            comboBox.removeAllItems();

	            customerList.stream()
	                .filter(c -> c.getName().toLowerCase().contains(keyword))
	                             
	                .forEach(c -> comboBox.addItem(c.getName()));
	    	}
	    	
	    });
	    txtSearch.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
	    txtSearch.setColumns(10);
	    txtSearch.setBounds(1094, 171, 185, 26);
	    contentPane.add(txtSearch);
	    
	    JButton btnSub = new JButton("ReduceQty");
	    btnSub.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		ArrayList<Product> customerOrder = new ArrayList<Product>(); // by teacher
	    		int selectedRow = table_1.getSelectedRow();
		        if (selectedRow > -1) {
		            order = (OrderTableModel) table_1.getModel();
		            String name = (String) order.getValueAt(selectedRow, 1); // Name column

		            int quantity;
		            try {
		                quantity = Integer.parseInt(txtQty.getText());

		                // Fetch the latest product from the database instead of using cached data
		                Product p=null;
						try {
							p = new CRUD_Dao().getProductByName(name);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

		                if (p == null) {
		                    JOptionPane.showMessageDialog(null, "Product not found", "Error", JOptionPane.ERROR_MESSAGE);
		                    return;
		                } else {
		                    int currentQty = p.getQuantity(); // Get latest quantity from database

		                    if (quantity > currentQty) {
		                        JOptionPane.showMessageDialog(null, "Not enough stock available", "Error", JOptionPane.ERROR_MESSAGE);
		                        return;
		                    } else {
		                        tableModel = (DefaultTableModel) orderTable.getModel();
		                        boolean found = false;

		                        
		                        for (int i = 0; i < tableModel.getRowCount(); i++) {
		                            String existingProductName = (String) tableModel.getValueAt(i, 1); // Name column
		                            if (existingProductName.equals(name)) {
		                     
		                                int existingQuantity = (int) tableModel.getValueAt(i, 2); // Quantity column
		                                tableModel.setValueAt(existingQuantity -quantity, i, 2); // Update with new quantity
		                                found = true;
		                                break;
		                            }
		                        }
		                        

		                        if (!found) {
		                            // Add new row if the product was not found
		                            tableModel.addRow(new Object[] {
		                                tableModel.getRowCount() + 1, // Row number
		                                name,
		                                quantity
		                            });
		                        }

		                        // Update the customerOrder list as well
		                        for (int i = 0; i < customerOrder.size(); i++) {
		                            if (customerOrder.get(i).getName().equals(name)) {
		                                customerOrder.get(i).setQuantity(quantity - customerOrder.get(i).getQuantity());
		                                found = true;
		                                break;
		                            }
		                        }

		                        if (!found) {
		                            p.setQuantity(quantity);
		                            customerOrder.add(p);
		                        }

		                        TotalAndTax(); // Update totals and tax
		                        txtQty.setText(""); // Clear the quantity input
		                    }
		                }

		            } catch (NumberFormatException ex) {
		                JOptionPane.showMessageDialog(null, "Please enter a valid quantity", "Error", JOptionPane.ERROR_MESSAGE);
		            }
		        }
		    }
	
		    
	    		
	    		
	    	
	    });
	    btnSub.setForeground(Color.BLACK);
	    btnSub.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
	    btnSub.setBackground(new Color(50, 205, 50));
	    btnSub.setBounds(772, 614, 119, 31);
	    contentPane.add(btnSub);
	    
	    JLabel lblSearchName = new JLabel("Search Name     :");
	    lblSearchName.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
	    lblSearchName.setBounds(927, 133, 137, 26);
	    contentPane.add(lblSearchName);
	    
	    JLabel lblManageOrder = new JLabel("Manage Order");
	    lblManageOrder.setHorizontalAlignment(SwingConstants.CENTER);
	    lblManageOrder.setFont(new Font("Times New Roman", Font.BOLD, 30));
	    lblManageOrder.setBounds(0, 61, 1316, 37);
	    contentPane.add(lblManageOrder);


	}
	
	private void TotalAndTax() {
	     tableModel = (DefaultTableModel) orderTable.getModel();
	    int rowCount = tableModel.getRowCount();
	    
	    int totalAmount = 0;
	    double totalTax = 0.0;
	    
	    for (int i = 0; i < rowCount; i++) {
	        
	        int quantity = (Integer) tableModel.getValueAt(i, 2); // Quantity column
	        int price = (Integer) order.getValueAt(i, 3); // Assuming price is from the productTable

	        // Calculate amount and tax for the row
	        int amount = quantity * price;
	        double taxAmount = amount * 0.10; // 10% tax
	        
	        // Accumulate totals
	        totalAmount += amount;
	        totalTax += taxAmount;
	    }
	    
	    double netPayment = totalAmount + totalTax;
	    
	  
	    lblTotalprice.setText(String.format("%.2f", (double) totalAmount));
	    lbltaxamount.setText(String.format("%.2f", totalTax));
	}
	
	public void clear() {
		 tableModel = (DefaultTableModel) orderTable.getModel(); 
	    tableModel.setRowCount(0);
		 txtQty.setText("");
		 lblTotalprice.setText("");
		 lbltaxamount.setText("");
	}
}
