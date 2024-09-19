package DetoxProduct;

import java.awt.EventQueue;




import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import Constructors.Product;
import Constructors.Staff;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Admin.Admin_Dashboard;
import Dao.CRUD_Dao;

import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Product_Manage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSearch;
	private JTextField txtname;
	private JTextField txtQuantity;
	private JTextField txtPrice;
	private JTable table;
	private JTextField txtIngredients;
	private JTextField txtDescription;
	private JComboBox cboSize;
	private JLabel lblimage;
	private ArrayList<Product>data =new ArrayList<Product>();
	private ProductTableModel p;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Product_Manage frame = new Product_Manage(new Staff());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	
	
String ImgPath=null;
	
	public ImageIcon Resize(String imagePath,byte[]pic) {
		ImageIcon myImage =null;
		if(imagePath !=null) {
			myImage= new ImageIcon(imagePath);
			
		}else {
			myImage=new ImageIcon(pic);
		}
		
		Image im=myImage.getImage();
		Image im2=im.getScaledInstance(lblimage.getWidth(),lblimage.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image=new ImageIcon(im2);
		
		return image;
		
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Product_Manage(Staff s) throws SQLException {
		setTitle("VITALSIP Detox Juice");
	//	setIconImage(Toolkit.getDefaultToolkit().getImage(Product_Manage.class.getResource("/image/Logo-removebg-preview.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1330, 741);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.light"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
	       
	       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Product Manage");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(0, 72, 1189, 54);
		contentPane.add(lblNewLabel);
		
		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				try {
					ArrayList<Product>ur=new CRUD_Dao().getProduct();
					
					
					String keyword=txtSearch.getText().trim().toLowerCase();
					data.clear();
					data.addAll((ArrayList<Product>) ur.stream()
							.filter(u ->u.getName().toLowerCase().contains(keyword)||u.getSize().toLowerCase().contains(keyword))
							.collect(Collectors.toList()));
					p.fireTableDataChanged();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		txtSearch.setFont(new Font("Monospaced", Font.PLAIN, 14));
		txtSearch.setColumns(10);
		txtSearch.setBounds(958, 152, 289, 26);
		contentPane.add(txtSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(480, 197, 803, 426);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int selectedRow = table.getSelectedRow();

		        if (selectedRow != -1) {
		           
		            int productId = (int) table.getValueAt(selectedRow, 0);

		            try {
		               
		                Product product = new CRUD_Dao().getProductById(productId);

		                if (product != null) {
		                    // Populate the text fields and combo box with the product data
		                    txtname.setText(product.getName());
		                    txtPrice.setText(String.valueOf(product.getPrice()));
		                    cboSize.setSelectedItem(product.getSize());
		                    txtQuantity.setText(String.valueOf(product.getQuantity()));
		                    txtIngredients.setText(product.getIngredients());
		                    txtDescription.setText(product.getDescription());
		                 
		                    
		                    

		                    byte[] imageBytes = product.getImage(); // Assuming getImage() returns byte[]
		                    if (imageBytes != null) {
		                        ImageIcon imageIcon = new ImageIcon(imageBytes);
		                        Image image = imageIcon.getImage().getScaledInstance(lblimage.getWidth(), lblimage.getHeight(), Image.SCALE_SMOOTH);
		                        lblimage.setIcon(new ImageIcon(image));
		                    } else {
		                        lblimage.setIcon(null); 
		                    }	
		                    
		                    
		                    
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
		
		
		CRUD_Dao b=new CRUD_Dao();
		data=new CRUD_Dao().AddProductIntoTable();
		p=new ProductTableModel(data);
		table.setModel(p);
		
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(67);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(137);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(102);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(104);
		scrollPane.setViewportView(table);
		
		JButton btnSearch = new JButton("");
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					ArrayList<Product>ur=new CRUD_Dao().getProduct();
					
					
					String keyword=txtSearch.getText().trim().toLowerCase();
					data.clear();
					data.addAll((ArrayList<Product>) ur.stream()
							.filter(u ->u.getName().toLowerCase().contains(keyword)||u.getSize().toLowerCase().contains(keyword))
							.collect(Collectors.toList()));
					p.fireTableDataChanged();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				
			}
		});
		//btnSearch.setIcon(new ImageIcon(Product_Manage.class.getResource("/image/image/search.png")));
		btnSearch.setFont(new Font("Monospaced", Font.PLAIN, 11));
		btnSearch.setBackground(UIManager.getColor("Button.light"));
		btnSearch.setBounds(1248, 152, 35, 25);
		contentPane.add(btnSearch);
		
		JLabel lblProductname = new JLabel("Product Name  :");
		lblProductname.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblProductname.setBounds(10, 292, 129, 28);
		contentPane.add(lblProductname);
		
		txtname = new JTextField();
		txtname.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
		txtname.setColumns(10);
		txtname.setBounds(148, 294, 268, 26);
		contentPane.add(txtname);
		
		txtQuantity = new JTextField();
		txtQuantity.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
		txtQuantity.setColumns(10);
		txtQuantity.setBounds(148, 434, 268, 26);
		contentPane.add(txtQuantity);
		
		JLabel lblQuantity = new JLabel("Quantity            : ");
		lblQuantity.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblQuantity.setBounds(10, 432, 129, 28);
		contentPane.add(lblQuantity);
		
		txtPrice = new JTextField();
		txtPrice.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
		txtPrice.setColumns(10);
		txtPrice.setBounds(148, 387, 268, 26);
		contentPane.add(txtPrice);
		
		JLabel lblPrice = new JLabel("Price                  :");
		lblPrice.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblPrice.setBounds(10, 385, 129, 28);
		contentPane.add(lblPrice);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(81, 192, 61));
		panel.setBounds(-10, 0, 1326, 62);
		contentPane.add(panel);
		
		JLabel lblAdminDashboard = new JLabel("Vitalsip Detox Juice\r\n ");
		lblAdminDashboard.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminDashboard.setFont(new Font("Times New Roman", Font.BOLD, 29));
		lblAdminDashboard.setBounds(23, 0, 263, 62);
		panel.add(lblAdminDashboard);
		
		JLabel lblAdmin = new JLabel("Admin");
		//lblAdmin.setIcon(new ImageIcon(Product_Manage.class.getResource("/image/image/people icon.png")));
		lblAdmin.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblAdmin.setBounds(1217, 13, 126, 42);
		panel.add(lblAdmin);
		
		
		
		JLabel lblSize = new JLabel("Size                   :\r\n");
		lblSize.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblSize.setBounds(10, 330, 129, 28);
		contentPane.add(lblSize);
		
		JLabel lblAddNewProduct = new JLabel("Add New Product");
		lblAddNewProduct.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		lblAddNewProduct.setBounds(10, 132, 169, 28);
		contentPane.add(lblAddNewProduct);
	
		cboSize = new JComboBox();
		cboSize.setModel(new DefaultComboBoxModel(new String[] {"Non", "200ml", " 100ml", "300ml ", "400ml", "500ml", "600ml", "700ml", "800ml", "900ml", "1liter", "2liter", "3liter"}));
		cboSize.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
		cboSize.setBackground(UIManager.getColor("Button.light"));
		cboSize.setBounds(148, 335, 268, 28);
		contentPane.add(cboSize);
		
		JLabel lblIntegredients = new JLabel("Ingredients      :");
		lblIntegredients.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblIntegredients.setBounds(10, 484, 129, 28);
		contentPane.add(lblIntegredients);
		
		JLabel lblDescription = new JLabel("Description      :");
		lblDescription.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblDescription.setBounds(10, 563, 129, 28);
		contentPane.add(lblDescription);
		
		JButton btnEdit = new JButton("Clear");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Clear();
			}
			
		});
		//btnEdit.setIcon(new ImageIcon(Product_Manage.class.getResource("/image/image/clear-format.png")));
		btnEdit.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnEdit.setBackground(new Color(50, 205, 50));
		btnEdit.setBounds(309, 647, 107, 33);
		contentPane.add(btnEdit);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					
				contentPane.removeAll();
				
		        
		        View_Product viewProductPanel = null;
		        viewProductPanel = new View_Product(s);
				contentPane.add(viewProductPanel);
				contentPane.add(viewProductPanel,BorderLayout.CENTER);
		        
				
//				viewProductPanel.setSize(580,620);
				setSize(527,738);
				
				viewProductPanel.setLocation(0,0);
		        contentPane.repaint();
		        contentPane.revalidate();
		       
		        
		        new Product_Manage(s).setVisible(false);
		        
		        int selectedRow = table.getSelectedRow();
				if(selectedRow != -1 ) {
					
					int id = (int) table.getValueAt(selectedRow, 0);
					String name=txtname.getText().trim();
					int price=Integer.parseInt(txtPrice.getText());
					

					ImageIcon imageIcon = (ImageIcon) lblimage.getIcon();
			        byte[] imageData = imageIconToByteArray(imageIcon);
			        
		              
				        panel.add(cboSize);
				        
				        String size = cboSize.getSelectedItem().toString();
		                String ingre = txtIngredients.getText().trim();
		                String desc = txtDescription.getText().trim();
		                int quantity = Integer.parseInt(txtQuantity.getText().trim());

//	              
	                viewProductPanel.populateProductDetails(name, size,imageData, quantity, price, ingre, desc);
		                
	            }
	        } catch (NumberFormatException ex) {
	            JOptionPane.showMessageDialog(null, "Please enter valid numbers for quantity and price.");
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(null, "An error occurred while processing the data.");
	        }
	    }
	
					
				
//		        try {
//		            ArrayList<Product> products = new CRUD_Dao().getProduct();
//
//		           
//		            if (!products.isEmpty()) {
//		                Product product = products.get(0); //  display the first product
//		                viewProductPanel.populateProductDetails(product);
//		            }
//		        } catch (SQLException e1) {
//		            e1.printStackTrace();
//		            
//		            
//		        }
//		
//				}
//			}
				
			
		});
		//btnView.setIcon(new ImageIcon(Product_Manage.class.getResource("/image/image/view-grid-detail.png")));
		btnView.setForeground(Color.BLACK);
		btnView.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnView.setBackground(new Color(50, 205, 50));
		btnView.setBounds(942, 647, 107, 33);
		contentPane.add(btnView);
		
		JButton btnEdit_1 = new JButton("Edit");
		btnEdit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				try {

				contentPane.removeAll();
				
		        
				 Edit_Product editProductPanel = new Edit_Product(s);
			      contentPane.add(editProductPanel);
		       
			      setSize(527,738);
		        contentPane.repaint();
		        contentPane.revalidate();
				
				int selectedRow = table.getSelectedRow();
				if(selectedRow != -1 ) {
					

					
					int id = (int) table.getValueAt(selectedRow, 0);
					String name=txtname.getText().trim();
					int price=Integer.parseInt(txtPrice.getText());
					 String desc = txtDescription.getText().trim();
					
					 ImageIcon imageIcon = (ImageIcon) lblimage.getIcon();
				        byte[] imageData = imageIconToByteArray(imageIcon);
					
	                    
	                    
	                
	                String size = cboSize.getSelectedItem().toString();
				       
	                String ingre = txtIngredients.getText().trim();
	               
	                int quantity = Integer.parseInt(txtQuantity.getText().trim());
	                //String ed = txtEnableDisble.getText().trim();

	                // Set product data in the edit panel
	                editProductPanel.setProductData( name, price, desc, imageData, size, ingre, quantity);
		                
	            }
	        } catch (NumberFormatException ex) {
	            JOptionPane.showMessageDialog(null, "Please enter valid numbers for quantity and price.");
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(null, "An error occurred while processing the data.");
	        }
	    }

			
	
				
				
				
			
		});
		//btnEdit_1.setIcon(new ImageIcon(Product_Manage.class.getResource("/image/image/editor.png")));
		btnEdit_1.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnEdit_1.setBackground(new Color(50, 205, 50));
		btnEdit_1.setBounds(1059, 647, 107, 33);
		contentPane.add(btnEdit_1);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				 ProductTableModel model = (ProductTableModel) table.getModel();
			        int selectedRow = table.getSelectedRow();

			        if (selectedRow != -1) {
			            int id = (int) model.getValueAt(selectedRow, 0); 
			            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
			            
			            if (confirm == JOptionPane.YES_OPTION) {
			                try {
			                    
			                  new CRUD_Dao().deleteProducts(id);
			                    
			                    
			                    model.removeRow(selectedRow);
			                    
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
			        
			        Clear(); 
				
				
			}
		});
	//	btnDelete.setIcon(new ImageIcon(Product_Manage.class.getResource("/image/delete-two.png")));
		btnDelete.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnDelete.setBackground(new Color(50, 205, 50));
		btnDelete.setBounds(1176, 647, 107, 33);
		contentPane.add(btnDelete);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new Admin_Dashboard(s).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 dispose();
			}
		});
		//btnBack.setIcon(new ImageIcon(Product_Manage.class.getResource("/image/image/back.png")));
		btnBack.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnBack.setBackground(new Color(50, 205, 50));
		btnBack.setBounds(1176, 88, 107, 33);
		contentPane.add(btnBack);
		
		JLabel lblImage = new JLabel("Image                :");
		lblImage.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblImage.setBounds(10, 210, 129, 28);
		contentPane.add(lblImage);
		
		 lblimage = new JLabel("");
	//	lblimage.setIcon(new ImageIcon(Product_Manage.class.getResource("/image/Logo-removebg-preview.png")));
		lblimage.setBounds(148, 188, 120, 87);
		contentPane.add(lblimage);
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				JFileChooser file = new JFileChooser();
				file.setCurrentDirectory(new File("C:\\Users\\DELL\\eclipse-workspace\\VitalsipProject\\src\\image\\image"));
				
				FileNameExtensionFilter filter=new FileNameExtensionFilter("images","png","jpg");
				file.addChoosableFileFilter(filter);
				int res=file.showSaveDialog(null);
				int result = file.showOpenDialog(null);
				if(result==JFileChooser.APPROVE_OPTION)
		{
			File selectFile=file.getSelectedFile();
			String path=selectFile.getAbsolutePath();
			lblimage.setIcon(Resize(path,null));
			ImgPath=path;
			
		}else {
			System.out.println("file not selected");
		}
				
			
				
			}
		});
		btnBrowse.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		btnBrowse.setBounds(312, 215, 104, 28);
		contentPane.add(btnBrowse);
		
		txtIngredients = new JTextField();
		txtIngredients.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
		txtIngredients.setColumns(10);
		txtIngredients.setBounds(148, 484, 268, 54);
		contentPane.add(txtIngredients);
		
		txtDescription = new JTextField();
		txtDescription.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
		txtDescription.setColumns(10);
		txtDescription.setBounds(148, 569, 268, 54);
		contentPane.add(txtDescription);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
	               
	                String name = txtname.getText().trim();
	                int price = Integer.parseInt(txtPrice.getText().trim());


	                	
	                if (ImgPath == null || ImgPath.isEmpty()) {
	                    JOptionPane.showMessageDialog(null, "Please select an image file.");
	                    return;
	                }

	                // Read image file
	                byte[] imageBytes = null;
	                File imageFile = new File(ImgPath);
	                if (imageFile.exists()) {
	                    try (FileInputStream fis = new FileInputStream(imageFile)) {
	                        imageBytes = new byte[(int) imageFile.length()];
	                        fis.read(imageBytes);
	                    }
	                } else {
	                    JOptionPane.showMessageDialog(null, "Selected image file does not exist.");
	                    return;
	                }
	                
	                String size = cboSize.getSelectedItem() != null ? cboSize.getSelectedItem().toString() : "";
	                //String size = cboSize.getSelectedItem().toString();
	                String ingredient = txtIngredients.getText().toString();
	                String description = txtDescription.getText().trim();
	                int quantity = Integer.parseInt(txtQuantity.getText().trim());
	               
	                
	                
	                Product product = new Product( name, price, description, imageBytes, size, ingredient, quantity);
	                
						try {
							int id=new CRUD_Dao().addProduct(product);
							 JOptionPane.showMessageDialog(null, "Product saved successfully.");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							JOptionPane.showMessageDialog(null, "Error saving product: " + e1.getMessage());
						}
					
	                Clear();
	            } catch (NumberFormatException | IOException ex) {
	                ex.printStackTrace();
	                JOptionPane.showMessageDialog(null, "Error saving product: " + ex.getMessage());
	            }
	        

				
			
			
				
			}
		});
		//btnSave.setIcon(new ImageIcon(Product_Manage.class.getResource("/image/image/Savee.png")));
		btnSave.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnSave.setBackground(new Color(50, 205, 50));
		btnSave.setBounds(192, 647, 107, 33);
		contentPane.add(btnSave);
		
		
	}
	
	
	private byte[] imageIconToByteArray(ImageIcon imageIcon) {
	    if (imageIcon == null) {
	        return null;
	    }
	    Image image = imageIcon.getImage();
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    try {
	        BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
	        Graphics2D g2d = bufferedImage.createGraphics();
	        g2d.drawImage(image, 0, 0, null);
	        g2d.dispose();
	        ImageIO.write(bufferedImage, "png", baos);
	        baos.flush();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return baos.toByteArray();
	}
	 
	
	public void Clear() {
		txtSearch.setText("");
		txtname.setText("");
		txtQuantity.setText("");
		 txtPrice.setText("");
		 cboSize.setSelectedIndex(0);
		 txtIngredients.setText("");
		 txtDescription.setText("");
		// txtEnableDisble.setText("");
	}
}
