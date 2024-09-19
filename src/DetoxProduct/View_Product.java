
package DetoxProduct;

import javax.swing.JPanel;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;

import javax.swing.JComboBox;
import javax.swing.UIManager;

import Constructors.Staff;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class View_Product extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtPname;
	private JTextField txtPrice;
	private JTextField txtQuantity;
	private JTextArea txtDescription,txtIngredients;
	
	private JComboBox cboSize;
	private JLabel lblimage;
	/**
	 * Create the panel.
	 */
	
	
	
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
	
	
	public View_Product(Staff s) {
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
		
		JLabel lblStaffProfile = new JLabel("Product View");
		lblStaffProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblStaffProfile.setForeground(Color.BLACK);
		lblStaffProfile.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		lblStaffProfile.setBackground(Color.LIGHT_GRAY);
		lblStaffProfile.setBounds(0, 118, 530, 44);
		add(lblStaffProfile);
		
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
				
			}
		});
		//btnBack.setIcon(new ImageIcon(View_Product.class.getResource("/image/image/back.png")));
		btnBack.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnBack.setBackground(new Color(50, 205, 50));
		btnBack.setBounds(413, 72, 107, 33);
		add(btnBack);
		
		JLabel lblProductname = new JLabel("Product Name  :");
		lblProductname.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblProductname.setBounds(59, 282, 129, 28);
		add(lblProductname);
		
		txtPname = new JTextField();
		txtPname.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
		txtPname.setColumns(10);
		txtPname.setBounds(197, 284, 268, 26);
		add(txtPname);
		
		JLabel lblSize = new JLabel("Size                   :");
		lblSize.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblSize.setBounds(59, 320, 129, 28);
		add(lblSize);
		
		 cboSize = new JComboBox();
		 cboSize.setModel(new DefaultComboBoxModel(new String[] {"Non", "200ml", " 100ml", "300ml ", "400ml", "500ml", "600ml", "700ml", "800ml", "900ml", "1liter", "2liter", "3liter"}));
		cboSize.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
		cboSize.setBackground(UIManager.getColor("Button.light"));
		cboSize.setBounds(197, 325, 268, 28);
		add(cboSize);
		
		txtPrice = new JTextField();
		txtPrice.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
		txtPrice.setColumns(10);
		txtPrice.setBounds(197, 374, 268, 26);
		add(txtPrice);
		
		JLabel lblPrice = new JLabel("Price                  :");
		lblPrice.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblPrice.setBounds(59, 372, 129, 28);
		add(lblPrice);
		
		JLabel lblImage = new JLabel("Image                :");
		lblImage.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblImage.setBounds(59, 194, 129, 28);
		add(lblImage);
		

 lblimage = new JLabel("");
		//lblimage.setIcon(new ImageIcon(View_Product.class.getResource("/image/Logo-removebg-preview.png")));
		lblimage.setBounds(197, 172, 120, 87);
		add(lblimage);
		
		JLabel lblIntegredients = new JLabel("Ingredients      :");
		lblIntegredients.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblIntegredients.setBounds(59, 464, 129, 28);
		add(lblIntegredients);
		
		JLabel lblDescription = new JLabel("Description      :");
		lblDescription.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblDescription.setBounds(59, 541, 129, 28);
		add(lblDescription);
		
		JLabel lblQuantity = new JLabel("Quantity            : ");
		lblQuantity.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblQuantity.setBounds(59, 410, 129, 28);
		add(lblQuantity);
		
		txtQuantity = new JTextField();
		txtQuantity.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
		txtQuantity.setColumns(10);
		txtQuantity.setBounds(197, 412, 268, 26);
		add(txtQuantity);
		
		 txtIngredients = new JTextArea();
		txtIngredients.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
		txtIngredients.setBounds(197, 467, 268, 55);
		add(txtIngredients);
		
		 txtDescription = new JTextArea();
		txtDescription.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
		txtDescription.setBounds(197, 544, 268, 55);
		add(txtDescription);

	}
	

	public void populateProductDetails( String name, String size,byte[]imageData, int quantity, int price, String ingre, String desc) {
	       
	        txtPname.setText(name);
	        cboSize.setSelectedItem(size);
	        

	        
	        ImageIcon imageIcon = byteArrayToImageIcon(imageData);
	        lblimage.setIcon(imageIcon);
	        
	        txtQuantity.setText(String.valueOf(quantity));
	        txtPrice.setText(String.valueOf(price));

	        
	        txtIngredients.setText(ingre);
	        txtDescription.setText(desc);
	       
	    }
	
	
	
	
	
	protected byte[] imageIconToByteArray(ImageIcon imageIcon) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	

	 private ImageIcon byteArrayToImageIcon(byte[] imageData) {
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
	
	
	
	

		
}
