package Admin;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import Constructors.Staff;
import Customer.Password_ChangeForAdmin;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

import Dao.CRUD_Dao;
import Dao.Other_Dao;
import DetoxProduct.Product_Manage;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class Edit_Staff extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtName;
	private JTextField txtNrc;
	private JTextField txtPhno;
	private JTextField txtAddress;
	private JTextField txtEmail;
	private JDateChooser chooserDob;
	private final ButtonGroup btnGender = new ButtonGroup();
	private JComboBox cboPosition ;
	private JRadioButton rdoMale, rdoFemale;

	/**
	 * Create the panel.
	 */
	public Edit_Staff(Staff s) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Edit_Staff.class.getResource("/Image/Logo-removebg-preview.png")));
		getContentPane().setBackground(UIManager.getColor("Button.light"));
        setTitle("VITALSIP Detox Juice");
        setBounds(0, 0, 540, 738);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        
        initializeNrcOptions();

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(81, 192, 61));
        panel.setBounds(0, 0, 530, 54);
        getContentPane().add(panel);

		JLabel lblAdmin = new JLabel("Admin ");
		lblAdmin.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblAdmin.setBounds(1215, 10, 126, 42);
		panel.add(lblAdmin);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(1179, 10, 63, 42);
		panel.add(lblNewLabel_1);
		
		JLabel lblAdminDashboard = new JLabel("Vitalsip Detox Juice");
		lblAdminDashboard.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblAdminDashboard.setBounds(0, 3, 486, 49);
		panel.add(lblAdminDashboard);

		JLabel lblName = new JLabel("Name          :");
		lblName.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblName.setBounds(33, 151, 126, 28);
		getContentPane().add(lblName);

		txtName = new JTextField();
		txtName.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		txtName.setColumns(10);
		txtName.setBounds(187, 154, 290, 26);
		getContentPane().add(txtName);

		JLabel lblDob = new JLabel("DOB           :");
		lblDob.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblDob.setBounds(33, 203, 126, 28);
		getContentPane().add(lblDob);

		chooserDob = new JDateChooser();
		chooserDob.setBounds(187, 203, 289, 23);
		getContentPane().add(chooserDob);

		JLabel lblNrc = new JLabel("NRC            : ");
		lblNrc.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblNrc.setBounds(33, 253, 126, 28);
		getContentPane().add(lblNrc);

		txtNrc = new JTextField();
		txtNrc.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		txtNrc.setColumns(10);
		txtNrc.setBounds(187, 256, 290, 26);
		getContentPane().add(txtNrc);

		JLabel lblGender = new JLabel("Gender        :");
		lblGender.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblGender.setBounds(33, 301, 169, 28);
		getContentPane().add(lblGender);

		rdoMale = new JRadioButton("Male");
		btnGender.add(rdoMale);
		rdoMale.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		rdoMale.setBackground(UIManager.getColor("Button.light"));
		rdoMale.setBounds(187, 306, 74, 21);
		getContentPane().add(rdoMale);

		rdoFemale = new JRadioButton("Female");
		btnGender.add(rdoFemale);
		rdoFemale.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		rdoFemale.setBackground(UIManager.getColor("Button.light"));
		rdoFemale.setBounds(273, 305, 103, 21);
		getContentPane().add(rdoFemale);

		JLabel lblPhoneNo = new JLabel("Phone No   : ");
		lblPhoneNo.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblPhoneNo.setBounds(33, 350, 169, 28);
		getContentPane().add(lblPhoneNo);

		txtPhno = new JTextField();
		txtPhno.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		txtPhno.setColumns(10);
		txtPhno.setBounds(187, 352, 290, 26);
		getContentPane().add(txtPhno);

		JLabel lblAddress = new JLabel("Address      :");
		lblAddress.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblAddress.setBounds(33, 409, 169, 28);
		getContentPane().add(lblAddress);

		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		txtAddress.setColumns(10);
		txtAddress.setBounds(187, 409, 290, 54);
		getContentPane().add(txtAddress);

		JLabel lblEmail = new JLabel("Email          :");
		lblEmail.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblEmail.setBounds(33, 489, 126, 28);
		getContentPane().add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		txtEmail.setColumns(10);
		txtEmail.setBounds(187, 492, 290, 26);
		getContentPane().add(txtEmail);

		JLabel lblPosition = new JLabel("Position     :");
		lblPosition.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblPosition.setBounds(33, 546, 126, 28);
		getContentPane().add(lblPosition);

		cboPosition = new JComboBox();
		cboPosition.setModel(new DefaultComboBoxModel(new String[] {"None", "Admin", "Staff", "Customer"}));
		cboPosition.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		cboPosition.setBackground(UIManager.getColor("Button.light"));
		cboPosition.setBounds(187, 548, 290, 28);
		getContentPane().add(cboPosition);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new Staff_Manage(s).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
				dispose();
			}
		});
		btnBack.setIcon(new ImageIcon(View_ManageStaff.class.getResource("/image/back.png")));
		btnBack.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnBack.setBackground(new Color(50, 205, 50));
		btnBack.setBounds(413, 72, 107, 33);
		getContentPane().add(btnBack);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

//					int sid=Integer.parseInt(txtID.getText());
					String name = txtName.getText().trim();

//			        JComboBox<String> comboBox = new JComboBox<>();
					String gender = rdoMale.isSelected() ? "Male" : rdoFemale.isSelected() ? "Female" : "";
					String nrc = txtNrc.getText().trim();
					Date dob = (Date) chooserDob.getDate();
					String phoneNumber = txtPhno.getText().trim();
					String address = txtAddress.getText().trim();
					String email = txtEmail.getText().trim();
//					String password = passwordField.getText().trim();
					String position = cboPosition.getSelectedItem().toString().trim();
//			        comboBox.addItem(positon);

//					public Staff (int id, String name, String email, String gender, String phno, String NRC, String position, String address, Date dob) {

					Staff staff = new Staff(name, email, gender, nrc, position, address, dob);
					staff.setName(name);

					try {

						int id = new CRUD_Dao().updateStaff(staff);
						if (id > 0) {
							JOptionPane.showMessageDialog(null, "Update Successful");
							Clear();

							JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(Edit_Staff.this);

							parentFrame.dispose(); // This will close the current window

							Product_Manage productManageFrame = new Product_Manage(s);
							productManageFrame.setVisible(true);

						} else {
							JOptionPane.showMessageDialog(null, "Update failed. Please try again.");
						}
					} catch (NumberFormatException ex) {
						// Handle the case where input is not a valid number
						JOptionPane.showMessageDialog(null, "Please enter valid numbers for ID, quantity, and price.");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "An error occurred while updating the record.");
				}
				dispose();
			}
		});

		btnUpdate.setIcon(new ImageIcon(Edit_Staff.class.getResource("/image/folder-upload.png")));
		btnUpdate.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnUpdate.setBackground(new Color(50, 205, 50));
		btnUpdate.setBounds(411, 650, 109, 33);
		getContentPane().add(btnUpdate);
		
		JLabel lblEditStaff = new JLabel("Edit Staff Informatin");
		lblEditStaff.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditStaff.setForeground(Color.BLACK);
		lblEditStaff.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblEditStaff.setBackground(Color.LIGHT_GRAY);
		lblEditStaff.setBounds(0, 105, 530, 36);
		getContentPane().add(lblEditStaff);

	}
	
	private void initializeNrcOptions() {
		// TODO Auto-generated method stub
		
	}

	public void Clear() {
		txtName.setText("");
		chooserDob.setDate(null);
		txtNrc.setText("");
		btnGender.clearSelection();
		txtPhno.setText("");
		txtAddress.setText("");
		txtEmail.setText("");
		cboPosition.setSelectedItem("");
	}
	
	public void populateStaffDetails(String name, java.util.Date dob, String nrc, String gender, String phno, String address, String email, String position) {

	    // Pattern to match the NRC format: 1/XX(N)123456
	    Pattern pattern = Pattern.compile("(\\d{1,2})/(\\w+)\\((N)\\)(\\d{6})");
	    Matcher matcher = pattern.matcher(nrc);

	    
	    txtName.setText(name);
	    chooserDob.setDate(dob); // Set the date of birth
	    txtPhno.setText(phno);
	    txtAddress.setText(address);
	    txtNrc.setText(nrc);
	    txtEmail.setText(email);
	    cboPosition.setSelectedItem(position); // Set the position

	    // Set the gender based on the provided value
	    if ("Male".equalsIgnoreCase(gender)) {
	        rdoMale.setSelected(true);
	    } else if ("Female".equalsIgnoreCase(gender)) {
	        rdoFemale.setSelected(true);
	    } else {
	        btnGender.clearSelection(); // Clear if invalid gender
	    }
	}

}