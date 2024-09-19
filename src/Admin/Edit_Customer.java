package Admin;

import javax.swing.JPanel;


import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTextField;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;

import Constructors.Customer;
import Constructors.Staff;
import Customer.Password_ChangeForAdmin;
import Dao.CRUD_Dao;
import DetoxProduct.Edit_Product;

import DetoxProduct.Product_Manage;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class Edit_Customer extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtName;
	private JTextField txtPhno;
	private JTextField txtAddress;
	private JTextField txtEmail;
	private final ButtonGroup btngender = new ButtonGroup();
	private JTextField txtid;
	private JRadioButton rdoFemale,rdoMale;
	private JDateChooser dob;
	/**
	 * Create the panel.
	 */
	public Edit_Customer(Staff s) {
		setBounds(0,0,527,738);
		setBackground(UIManager.getColor("Button.light"));
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(81, 192, 61));
		panel.setBounds(0, 0, 530, 62);
		getContentPane().add(panel);
		
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
		
		JLabel lblName = new JLabel("Name          :");
		lblName.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblName.setBounds(33, 200, 126, 28);
		getContentPane().add(lblName);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
		txtName.setColumns(10);
		txtName.setBounds(169, 203, 290, 26);
		getContentPane().add(txtName);
		
		JLabel lblDob = new JLabel("DOB           :");
		lblDob.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblDob.setBounds(33, 239, 126, 28);
		getContentPane().add(lblDob);
		
		JLabel lblGender = new JLabel("Gender        :");
		lblGender.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblGender.setBounds(33, 291, 169, 28);
		getContentPane().add(lblGender);
		
		rdoMale = new JRadioButton("Male");
		btngender.add(rdoMale);
		rdoMale.setFont(new Font("Mongolian Baiti", Font.PLAIN, 16));
		rdoMale.setBackground(UIManager.getColor("Button.light"));
		rdoMale.setBounds(187, 296, 74, 21);
		getContentPane().add(rdoMale);
		
		 rdoFemale = new JRadioButton("Female");
		btngender.add(rdoFemale);
		rdoFemale.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		rdoFemale.setBackground(UIManager.getColor("Button.light"));
		rdoFemale.setBounds(263, 295, 103, 21);
		getContentPane().add(rdoFemale);
		
		JLabel lblPhoneNo = new JLabel("Phone No   : ");
		lblPhoneNo.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblPhoneNo.setBounds(33, 342, 169, 28);
		getContentPane().add(lblPhoneNo);
		
		txtPhno = new JTextField();
		txtPhno.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
		txtPhno.setColumns(10);
		txtPhno.setBounds(187, 344, 290, 26);
		getContentPane().add(txtPhno);
		
		JLabel lblAddress = new JLabel("Address      :");
		lblAddress.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblAddress.setBounds(33, 397, 169, 28);
		getContentPane().add(lblAddress);
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
		txtAddress.setColumns(10);
		txtAddress.setBounds(187, 397, 290, 54);
		getContentPane().add(txtAddress);
		
		JLabel lblEmail = new JLabel("Email          :");
		lblEmail.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblEmail.setBounds(33, 486, 126, 28);
		getContentPane().add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(187, 489, 290, 26);
		getContentPane().add(txtEmail);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					new Manage_Customer(s).setVisible(true);
					setVisible(false);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		btnBack.setIcon(new ImageIcon(Edit_Customer.class.getResource("/image/back.png")));
		btnBack.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnBack.setBackground(new Color(50, 205, 50));
		btnBack.setBounds(413, 72, 107, 33);
		getContentPane().add(btnBack);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String status = "";
                if (rdoFemale.isSelected()) {
                    status = "on";
                } else if (rdoMale.isSelected()) {
                    status = "off";
                }
			
			try {
				
				int cid=Integer.parseInt(txtid.getText());
			String name = txtName.getText().trim();
			
			String email=txtEmail.getText();
			String ph=txtPhno.getText();
			
			String gender="";
    		if(rdoMale.isSelected())
    			gender="Male";
    		else if(rdoFemale.isSelected())
    			gender="Female";
    		
    		
    		String a=txtAddress.getText();
    		Date d=new Date(dob.getDate().getTime());
		        
		        
		       
                
		        
		        Customer cust = new Customer(name, email, gender,a, ph,d);
		        cust.setId(cid);
		        
		       
		        try {
		            
		            int id = new CRUD_Dao().updateCustomer(cust);
		            if (id > 0) {
		                JOptionPane.showMessageDialog(null, "Update Successful");
		                //Clear();
		                
		                
		                JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(Edit_Customer.this);
		                
		                parentFrame.dispose();  // This will close the current window

		               
		                Product_Manage productManageFrame = new Product_Manage(s);
		                productManageFrame.setVisible(true);
		                
		                
		            } else {
		                JOptionPane.showMessageDialog(null, "Update failed. Please try again.");
		            }
		        } catch (NumberFormatException ex) {
		            // Handle the case where input is not a valid number
		            JOptionPane.showMessageDialog(null, "Please enter valid numbers for ID, quantity, and price.");
		        }
		        
			}catch (SQLException e1) {
		            e1.printStackTrace();
		            JOptionPane.showMessageDialog(null, "An error occurred while updating the record.");
		        }
			
			}	
			
		});
		btnUpdate.setIcon(new ImageIcon(Edit_Customer.class.getResource("/image/folder-upload.png")));
		btnUpdate.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnUpdate.setBackground(new Color(50, 205, 50));
		btnUpdate.setBounds(411, 650, 109, 33);
		getContentPane().add(btnUpdate);
		
		JLabel lblEditStaffProfile = new JLabel("Customer  Profile");
		lblEditStaffProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditStaffProfile.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		lblEditStaffProfile.setBounds(33, 127, 444, 28);
		getContentPane().add(lblEditStaffProfile);
		
		JLabel lblChangeYourPassword = new JLabel("If you want to change your password   --->\r\n");
		lblChangeYourPassword.setForeground(Color.BLACK);
		lblChangeYourPassword.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblChangeYourPassword.setBounds(33, 548, 310, 28);
		getContentPane().add(lblChangeYourPassword);
		
		JButton btnClickHere = new JButton("Click Here");
		btnClickHere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Password_ChangeForAdmin(s).setVisible(true);
				setVisible(false);
			}
		});
		btnClickHere.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnClickHere.setBackground(new Color(50, 205, 50));
		btnClickHere.setBounds(355, 546, 111, 33);
		getContentPane().add(btnClickHere);
		
		dob = new JDateChooser();
		dob.setBounds(179, 250, 281, 20);
		getContentPane().add(dob);
		
		txtid = new JTextField();
		txtid.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
		txtid.setColumns(10);
		txtid.setBounds(169, 166, 290, 26);
		getContentPane().add(txtid);
		
		JLabel ID = new JLabel("ID          :");
		ID.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		ID.setBounds(33, 166, 126, 28);
		getContentPane().add(ID);

	}
	

	public void setCustomerData( String name, String email, String gender, String address, String phno, Date d) {
       
        txtName.setText(name);
       
        txtEmail.setText(email);
    
        txtAddress.setText(String.valueOf(address));
        txtPhno.setText(String.valueOf(phno));
        
        dob.setDate(d);
        
       
        if (gender.equals("on")) {
        	rdoFemale.setSelected(true);
        	rdoMale.setSelected(false);
        } else if (gender.equals("off")) {
        	rdoFemale.setSelected(false);
            rdoMale.setSelected(true);
        } else {
            //  handle unexpected status values
        	rdoFemale.setSelected(false);
        	rdoMale.setSelected(false);
        }
       
    }
}

