package DetoxProduct;

import javax.swing.JPanel;


import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTextField;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

import Constructors.OrderTableModel;
import Dao.CRUD_Dao;
import Constructors.Product;
import Constructors.Staff;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class Edit_Product extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtPname;
	private JTextField txtPrice;
	private JTextField txtQuantity;
	private JComboBox cboSize;
	private JTextArea txtDescription, txtIngredients;
	private final ButtonGroup btnStatus = new ButtonGroup();
	private JLabel lblimage;
	private JRadioButton btnOff,btnOn;
	private ArrayList<Product>data =new ArrayList<Product>();
	private OrderTableModel order;
	/**
	 * Create the panel.
	 */
	
	
	
String ImgPath=null;
	private JTextField txtID;
	
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
	
	
	
	
	
	
	public Edit_Product(Staff s) {
		setBounds(0,0,527,738);
		setBackground(UIManager.getColor("Button.light"));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(81, 192, 61));
		panel.setBounds(0, 0, 530, 62);
		add(panel);
		
		JLabel lblAdminDashboard = new JLabel("Vitalsip Detox Juice\r\n ");
		lblAdminDashboard.setFont(new Font("Times New Roman", Font.BOLD, 29));
		lblAdminDashboard.setBounds(10, 0, 263, 62);
		panel.add(lblAdminDashboard);
		
		JLabel lblAdmin = new JLabel("Admin ");
		lblAdmin.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblAdmin.setBounds(1215, 10, 126, 42);
		panel.add(lblAdmin);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(1179, 10, 63, 42);
		panel.add(lblNewLabel_1);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new Product_Manage(s).setVisible(true);
					setVisible(false);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
				
				
			}
		});
		//btnBack.setIcon(new ImageIcon(Edit_Product.class.getResource("/image/image/back.png")));
		//btnBack.setIcon(new ImageIcon(View_ManageStaff.class.getResource("/image/back.png")));
		btnBack.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnBack.setBackground(new Color(50, 205, 50));
		btnBack.setBounds(413, 72, 107, 33);
		add(btnBack);
		
		JButton btnUpdate = new JButton("Update");
//		btnUpdate.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				 String status = "";
//	                if (btnOn.isSelected()) {
//	                    status = "on";
//	                } else if (btnOff.isSelected()) {
//	                    status = "off";
//	                }
//				
//				try {
//					
//					int pid=Integer.parseInt(txtID.getText());
//				String name = txtPname.getText().trim();
//			        
//			        JComboBox<String> comboBox = new JComboBox<>();
//			        String size = cboSize.getSelectedItem().toString();
//			        comboBox.addItem(size);
//			        
//			        ImageIcon imageIcon = (ImageIcon) lblimage.getIcon();
//			        byte[] imageData = imageIconToByteArray(imageIcon);
//	                
//			        int qty = Integer.parseInt(txtQuantity.getText().trim());
//			        int price = Integer.parseInt(txtPrice.getText().trim());
//			        String ingre = txtIngredients.getText().trim();
//			        String desc = txtDescription.getText().trim();
//			       
//
//			        Product product = new Product(name, price, desc, imageData, size, ingre, qty,status);
//			        product.setDetoxID(pid);
//			        
//			        if (btnOn.isEnabled()||btnOff.isEnabled()) {
//			        try {
//			            
//			            int id = new CRUD_Dao().updateProduct(product);
//			            if (id > 0) {
//			                JOptionPane.showMessageDialog(null, "Update Successful");
//			                Clear();
//			                
//			                
//			                JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(Edit_Product.this);
//			                
//			                parentFrame.dispose();  // This will close the current window
//
//			               
//			                Product_Manage productManageFrame = new Product_Manage(s);
//			                productManageFrame.setVisible(true);
//			                
//			                
//			            } else {
//			                JOptionPane.showMessageDialog(null, "Update failed. Please try again.");
//			            }
//			        } catch (NumberFormatException ex) {
//			            // Handle the case where input is not a valid number
//			            JOptionPane.showMessageDialog(null, "Please enter valid numbers for ID, quantity, and price.");
//			        }
//			        } 
//				}catch (SQLException e1) {
//			            e1.printStackTrace();
//			            JOptionPane.showMessageDialog(null, "An error occurred while updating the record.");
//			        }
//					
//				 try {
//					 
//					updateUIBasedOnStatus(status);
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				
//				
//			
	btnUpdate.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	        String status = "";
	        if (btnOn.isSelected()) {
	            status = "on";
	        } else if (btnOff.isSelected()) {
	            status = "off";
	        } else {
	            JOptionPane.showMessageDialog(null, "Please select a status (on/off).");
	            return; // Exit the method if no button is selected
	        }

	        try {
	            int pid = Integer.parseInt(txtID.getText());
	            
	            // Check current product status before allowing updates
	            String currentStatus = new CRUD_Dao().getProductStatus(pid);
	            if ("off".equals(currentStatus) && "on".equals(status)) {
	                // Allow updates if turning on, but notify the user
	                JOptionPane.showMessageDialog(null, "You are reactivating this product.");
	            } else if ("off".equals(currentStatus) && "off".equals(status)) {
	                // Prevent updates if the product is already inactive
	                JOptionPane.showMessageDialog(null, "This product is already inactive.");
	                return; // Exit if the product is inactive
	            }

	            String name = txtPname.getText().trim();
	            String size = cboSize.getSelectedItem().toString();
	            ImageIcon imageIcon = (ImageIcon) lblimage.getIcon();
	            byte[] imageData = imageIconToByteArray(imageIcon);
	            int qty = Integer.parseInt(txtQuantity.getText().trim());
	            int price = Integer.parseInt(txtPrice.getText().trim());
	            String ingre = txtIngredients.getText().trim();
	            String desc = txtDescription.getText().trim();

	            // Create Product object
	            Product product = new Product(name, price, desc, imageData, size, ingre, qty, status);
	            product.setDetoxID(pid);

	            // Update the product information
	            int id = new CRUD_Dao().updateProduct(product);
	            if (id > 0) {
	                // Update the product status
	                int statusUpdate = new CRUD_Dao().updateProductStatus(pid, status);
	                if (statusUpdate > 0) {
	                    JOptionPane.showMessageDialog(null, "Update Successful");
	                    Clear();

	                    // Close current window and open product management
	                    JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(Edit_Product.this);
	                    parentFrame.dispose();

	                    Product_Manage productManageFrame = new Product_Manage(s);
	                    productManageFrame.setVisible(true);
	                } else {
	                    JOptionPane.showMessageDialog(null, "Status update failed. Please try again.");
	                }
	            } else {
	                JOptionPane.showMessageDialog(null, "Product update failed. Please try again.");
	            }
	        } catch (NumberFormatException ex) {
	            JOptionPane.showMessageDialog(null, "Please enter valid numbers for ID, quantity, and price.");
	        } catch (SQLException e1) {
	            e1.printStackTrace();
	            JOptionPane.showMessageDialog(null, "An error occurred while updating the record.");
	        }
	    }
	});

		//btnUpdate.setIcon(new ImageIcon(Edit_Product.class.getResource("/image/image/editor.png")));
		btnUpdate.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnUpdate.setBackground(new Color(50, 205, 50));
		btnUpdate.setBounds(409, 651, 109, 33);
		add(btnUpdate);
		
		JLabel lblImage = new JLabel("Image                :");
		lblImage.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblImage.setBounds(59, 191, 129, 28);
		add(lblImage);
		
		 lblimage = new JLabel("");
		//lblimage.setIcon(new ImageIcon(Edit_Product.class.getResource("/image/Logo-removebg-preview.png")));
		lblimage.setBounds(197, 169, 120, 87);
		add(lblimage);
		
		JLabel lblStaffProfile = new JLabel("Edit Product");
		lblStaffProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblStaffProfile.setForeground(Color.BLACK);
		lblStaffProfile.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		lblStaffProfile.setBackground(Color.LIGHT_GRAY);
		lblStaffProfile.setBounds(0, 115, 530, 44);
		add(lblStaffProfile);
		
		JLabel lblProductname = new JLabel("Product Name  :");
		lblProductname.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblProductname.setBounds(59, 279, 129, 28);
		add(lblProductname);
		
		txtPname = new JTextField();
		txtPname.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
		txtPname.setColumns(10);
		txtPname.setBounds(197, 281, 268, 26);
		add(txtPname);
		
		JLabel lblSize = new JLabel("Size                   ;");
		lblSize.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblSize.setBounds(59, 317, 129, 28);
		add(lblSize);
		
		 cboSize = new JComboBox();
		 cboSize.setModel(new DefaultComboBoxModel(new String[] {"Non", "200ml", " 100ml", "300ml ", "400ml", "500ml", "600ml", "700ml", "800ml", "900ml", "1liter", "2liter", "3liter"}));
		cboSize.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
		cboSize.setBackground(UIManager.getColor("Button.light"));
		cboSize.setBounds(197, 322, 268, 28);
		add(cboSize);
		
		JLabel lblPrice = new JLabel("Price                  :");
		lblPrice.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblPrice.setBounds(59, 369, 129, 28);
		add(lblPrice);
		
		JLabel lblQuantity = new JLabel("Quantity            : ");
		lblQuantity.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblQuantity.setBounds(59, 407, 129, 28);
		add(lblQuantity);
		
		txtPrice = new JTextField();
		txtPrice.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
		txtPrice.setColumns(10);
		txtPrice.setBounds(197, 371, 268, 26);
		add(txtPrice);
		
		txtQuantity = new JTextField();
		txtQuantity.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
		txtQuantity.setColumns(10);
		txtQuantity.setBounds(197, 409, 268, 26);
		add(txtQuantity);
		
		JLabel lblIntegredients = new JLabel("Ingredients      :");
		lblIntegredients.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblIntegredients.setBounds(59, 461, 129, 28);
		add(lblIntegredients);
		
		JLabel lblDescription = new JLabel("Description      :");
		lblDescription.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblDescription.setBounds(59, 538, 129, 28);
		add(lblDescription);
		
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
		btnBrowse.setBounds(361, 196, 104, 28);
		add(btnBrowse);
		
		 btnOn = new JRadioButton("On");
		 btnOn.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		 enableDataFields(true);
		 	}
		 });
		btnStatus.add(btnOn);
		btnOn.setBackground(UIManager.getColor("Button.light"));
		btnOn.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		btnOn.setBounds(197, 614, 71, 21);
		add(btnOn);
		
		JLabel lblStatus = new JLabel("Status                : ");
		lblStatus.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblStatus.setBounds(59, 614, 129, 28);
		add(lblStatus);
		

 btnOff = new JRadioButton("Off");
 btnOff.addActionListener(new ActionListener() {
 	public void actionPerformed(ActionEvent e) {
 		 enableDataFields(false);
 	}
 });
		btnStatus.add(btnOff);
		btnOff.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		btnOff.setBackground(UIManager.getColor("Button.light"));
		btnOff.setBounds(270, 615, 104, 21);
		add(btnOff);
		
		 txtIngredients = new JTextArea();
		txtIngredients.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
		txtIngredients.setBounds(197, 464, 268, 55);
		add(txtIngredients);
		
		 txtDescription = new JTextArea();
		txtDescription.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
		txtDescription.setBounds(197, 541, 268, 55);
		add(txtDescription);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
		txtID.setColumns(10);
		txtID.setBounds(197, 252, 268, 26);
		add(txtID);
		
		JLabel lblId = new JLabel("ID  :");
		lblId.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblId.setBounds(59, 250, 129, 28);
		add(lblId);

	}
	
	
	public byte[] imageIconToByteArray(ImageIcon icon) {
	    if (icon == null) return null;
	    Image image = icon.getImage();
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    try {
	        ImageIO.write(toBufferedImage(image), "png", baos);
	        baos.flush();
	        return baos.toByteArray();
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }
	}




	public void setProductData( String name, int price, String desc,byte[]imageData, String size, String ingre, int quantity) {
       
        txtPname.setText(name);
        cboSize.setSelectedItem(size);
        
        ImageIcon imageIcon = byteArrayToImageIcon(imageData);
        lblimage.setIcon(imageIcon);
        

    
        txtQuantity.setText(String.valueOf(quantity));
        txtPrice.setText(String.valueOf(price));
        txtIngredients.setText(ingre);
        txtDescription.setText(desc);
        
        String status="";
        if (status.equals("on")) {
            btnOn.setSelected(true);
            btnOff.setSelected(false);
        } else if (status.equals("off")) {
            btnOn.setSelected(false);
            btnOff.setSelected(true);
        } else {
            //  handle unexpected status values
            btnOn.setSelected(false);
            btnOff.setSelected(false);
        }
       
    }
	
	

	
	 private ImageIcon byteArrayToImageIcon(byte[] imageData) {//this image for insert into label
	        if (imageData != null) {
	            try (ByteArrayInputStream bais = new ByteArrayInputStream(imageData)) {
	                BufferedImage bufferedImage = ImageIO.read(bais);
	                if (bufferedImage != null) {
	                    return new ImageIcon(bufferedImage);
	                }
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	        return null;
	}
	 
	 private BufferedImage toBufferedImage(Image img) {//this for database
		    if (img instanceof BufferedImage) {
		        return (BufferedImage) img;
		    }
		    BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		    Graphics2D bGr = bimage.createGraphics();
		    bGr.drawImage(img, 0, 0, null);
		    bGr.dispose();
		    return bimage;
		}
		

	 
	 
//	 public void updateTableRowStatus(int productId, String newStatus) {
//		    for (int i = 0; i < table.getRowCount(); i++) {
//		        int tableProductId = (int) table.getValueAt(i, 0);  // Assuming product ID is in the first column
//		        if (tableProductId == productId) {
//		        	table.setValueAt(newStatus, i,0);  // Update the status in the correct column
//		            break;
//		        }
//		    }
//		}
	 private void updateUIBasedOnStatus(String status) throws SQLException {
		 
		 if (status.equals("on")) {
			new CRUD_Dao().getStatusAction();
		        // Update UI for 'on' status
		    } else if (status.equals("off")) {
		    	new CRUD_Dao().getStatusAction();
		        // Update UI for 'off' status
		    }
//		    if (status.equals(btnOff)) {
//		        // Set the UI to reflect inactive status
//		        // For example, change the background color of components to a "blurred" color
//		        txtID.setBackground(Color.LIGHT_GRAY);
//		        txtPname.setBackground(Color.LIGHT_GRAY);
//		        cboSize.setBackground(Color.LIGHT_GRAY);
//		        txtQuantity.setBackground(Color.LIGHT_GRAY);
//		        txtPrice.setBackground(Color.LIGHT_GRAY);
//		        txtIngredients.setBackground(Color.LIGHT_GRAY);
//		        txtDescription.setBackground(Color.LIGHT_GRAY);
//		        lblimage.setEnabled(false); // or set a different icon to reflect inactive status
//		    } else {
//		        // Reset UI to active status
//		        txtID.setBackground(Color.WHITE);
//		        txtPname.setBackground(Color.WHITE);
//		        cboSize.setBackground(Color.WHITE);
//		        txtQuantity.setBackground(Color.WHITE);
//		        txtPrice.setBackground(Color.WHITE);
//		        txtIngredients.setBackground(Color.WHITE);
//		        txtDescription.setBackground(Color.WHITE);
//		        lblimage.setEnabled(true); // or reset the image icon
//		    }
		}
		
	 private void enableDataFields(boolean enable) {
		    txtID.setEnabled(enable);
		    txtPname.setEnabled(enable);
		    cboSize.setEnabled(enable);
		    txtQuantity.setEnabled(enable);
		    txtPrice.setEnabled(enable);
		    txtIngredients.setEnabled(enable);
		    txtDescription.setEnabled(enable);
		    lblimage.setEnabled(enable); // Assuming lblimage is a label showing the image
		}


	public void Clear() {
		//txtPid.setText("");
		txtPname.setText("");
		txtQuantity.setText("");
		 txtPrice.setText("");
		 cboSize.setSelectedIndex(0);
		 txtIngredients.setText("");
		 txtDescription.setText("");
		// txtenableDisble.setText("");
	}
}

