package Customer;

import javax.swing.JPanel;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class View_ManageCustomer extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtName;
	private JTextField txtPhno;
	private JTextField txtAddress;
	private JTextField txtEmail;

	/**
	 * Create the panel.
	 */
	public View_ManageCustomer() {
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
		
		JLabel lblStaffProfile = new JLabel("Customer Profile");
		lblStaffProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblStaffProfile.setForeground(Color.BLACK);
		lblStaffProfile.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
		lblStaffProfile.setBackground(Color.LIGHT_GRAY);
		lblStaffProfile.setBounds(0, 116, 530, 44);
		add(lblStaffProfile);
		
		JButton btnBack = new JButton("Back");
		btnBack.setIcon(new ImageIcon(View_ManageCustomer.class.getResource("/image/back.png")));
		btnBack.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnBack.setBackground(new Color(50, 205, 50));
		btnBack.setBounds(413, 72, 107, 33);
		add(btnBack);
		
		JLabel lblName = new JLabel("Name          :");
		lblName.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblName.setBounds(38, 191, 126, 28);
		add(lblName);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
		txtName.setColumns(10);
		txtName.setBounds(192, 194, 290, 26);
		add(txtName);
		
		JLabel lblDob = new JLabel("DOB           :");
		lblDob.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblDob.setBounds(38, 243, 126, 28);
		add(lblDob);
		
		JLabel lblGender = new JLabel("Gender        :");
		lblGender.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblGender.setBounds(38, 295, 169, 28);
		add(lblGender);
		
		JRadioButton rdoMale = new JRadioButton("Male");
		rdoMale.setFont(new Font("Mongolian Baiti", Font.PLAIN, 16));
		rdoMale.setBackground(UIManager.getColor("Button.light"));
		rdoMale.setBounds(192, 300, 74, 21);
		add(rdoMale);
		
		JRadioButton rdoFemale = new JRadioButton("Female");
		rdoFemale.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		rdoFemale.setBackground(UIManager.getColor("Button.light"));
		rdoFemale.setBounds(268, 299, 103, 21);
		add(rdoFemale);
		
		JLabel lblPhoneNo = new JLabel("Phone No   : ");
		lblPhoneNo.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblPhoneNo.setBounds(38, 346, 169, 28);
		add(lblPhoneNo);
		
		txtPhno = new JTextField();
		txtPhno.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
		txtPhno.setColumns(10);
		txtPhno.setBounds(192, 348, 290, 26);
		add(txtPhno);
		
		JLabel lblAddress = new JLabel("Address      :");
		lblAddress.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblAddress.setBounds(38, 401, 169, 28);
		add(lblAddress);
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
		txtAddress.setColumns(10);
		txtAddress.setBounds(192, 401, 290, 54);
		add(txtAddress);
		
		JLabel lblEmail = new JLabel("Email          :");
		lblEmail.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblEmail.setBounds(38, 490, 126, 28);
		add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(192, 493, 290, 26);
		add(txtEmail);

	}
}
