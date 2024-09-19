package Admin;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import Constructors.Staff;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class Staff_Profile extends JFrame {

	private static final long serialVersionUID = 1L;
	 private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtn;
	private JTextField txtnrc;
	private JTextField txtPhno;
	private JTextField txtAddress;
	private JTextField txtEmail;
	private JComboBox cboNrc,cboNrcR;
	private JDateChooser dateChooser;
	private JRadioButton rdoMale,rdoFemale;
	/**
	 * Create the panel.
	 */
	public Staff_Profile(Staff s) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Staff_Profile.class.getResource("/Image/Logo-removebg-preview.png")));
		setTitle("VITALSIP Detox Juice");
		getContentPane().setBackground(UIManager.getColor("Button.light"));
		
//		setBackground(UIManager.getColor("Button.light"));
//		setLayout(null);
//		setBounds(0,0,550,680);
//		JPanel panel = new JPanel();
//		panel.setLayout(null);
//		panel.setBackground(new Color(81, 192, 61));
//		panel.setBounds(0, 0, 530, 62);
//		add(panel);
		
		
		setBackground(UIManager.getColor("Button.light"));
		getContentPane().setLayout(null);
		setBounds(0,0,540,680);
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
		lblName.setBounds(33, 161, 126, 28);
		getContentPane().add(lblName);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		txtName.setColumns(10);
		txtName.setBounds(187, 164, 290, 26);
		getContentPane().add(txtName);
		
		JLabel lblDob = new JLabel("DOB           :");
		lblDob.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblDob.setBounds(33, 213, 126, 28);
		getContentPane().add(lblDob);
		
		 dateChooser = new JDateChooser();
		dateChooser.setBounds(188, 217, 289, 23);
		getContentPane().add(dateChooser);
		
		JLabel lblNrc = new JLabel("NRC            : ");
		lblNrc.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblNrc.setBounds(33, 263, 126, 28);
		getContentPane().add(lblNrc);
		
		 cboNrc = new JComboBox();
		cboNrc.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		cboNrc.setBackground(UIManager.getColor("Button.light"));
		cboNrc.setBounds(187, 265, 58, 28);
		getContentPane().add(cboNrc);
		
		 cboNrcR = new JComboBox();
		cboNrcR.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		cboNrcR.setBackground(UIManager.getColor("Button.light"));
		cboNrcR.setBounds(246, 265, 97, 28);
		getContentPane().add(cboNrcR);
		
		txtn = new JTextField();
		txtn.setText(" (N)");
		txtn.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		txtn.setColumns(10);
		txtn.setBounds(347, 266, 35, 28);
		getContentPane().add(txtn);
		
		txtnrc = new JTextField();
		txtnrc.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		txtnrc.setColumns(10);
		txtnrc.setBounds(386, 266, 91, 26);
		getContentPane().add(txtnrc);
		
		JLabel lblGender = new JLabel("Gender        :");
		lblGender.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblGender.setBounds(33, 311, 169, 28);
		getContentPane().add(lblGender);
		
		 rdoMale = new JRadioButton("Male");
		rdoMale.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		rdoMale.setBackground(UIManager.getColor("Button.light"));
		rdoMale.setBounds(187, 316, 74, 21);
		getContentPane().add(rdoMale);
		
		 rdoFemale = new JRadioButton("Female");
		rdoFemale.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		rdoFemale.setBackground(UIManager.getColor("Button.light"));
		rdoFemale.setBounds(273, 315, 103, 21);
		getContentPane().add(rdoFemale);
		
		JLabel lblPhoneNo = new JLabel("Phone No   : ");
		lblPhoneNo.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblPhoneNo.setBounds(33, 360, 169, 28);
		getContentPane().add(lblPhoneNo);
		
		txtPhno = new JTextField();
		txtPhno.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		txtPhno.setColumns(10);
		txtPhno.setBounds(187, 362, 290, 26);
		getContentPane().add(txtPhno);
		
		JLabel lblAddress = new JLabel("Address      :");
		lblAddress.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblAddress.setBounds(33, 419, 169, 28);
		getContentPane().add(lblAddress);
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		txtAddress.setColumns(10);
		txtAddress.setBounds(187, 419, 290, 54);
		getContentPane().add(txtAddress);
		
		JLabel lblEmail = new JLabel("Email          :");
		lblEmail.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblEmail.setBounds(33, 499, 126, 28);
		getContentPane().add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		txtEmail.setColumns(10);
		txtEmail.setBounds(187, 502, 290, 26);
		getContentPane().add(txtEmail);
		
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
		btnBack.setIcon(new ImageIcon(View_ManageStaff.class.getResource("/image/back.png")));
		btnBack.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnBack.setBackground(new Color(50, 205, 50));
		btnBack.setBounds(413, 72, 107, 33);
		getContentPane().add(btnBack);
		
		JLabel lblAdminProfile = new JLabel("Staff Profile");
		lblAdminProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminProfile.setForeground(Color.BLACK);
		lblAdminProfile.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblAdminProfile.setBackground(Color.LIGHT_GRAY);
		lblAdminProfile.setBounds(0, 99, 520, 44);
		getContentPane().add(lblAdminProfile);
		
		JButton btnClickHere = new JButton("Click Here");
		btnClickHere.setIcon(new ImageIcon(Staff_Profile.class.getResource("/Image/cursors.png")));
		btnClickHere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Password_ChangeForStaff(s).setVisible(true);		
				dispose();
			}
		});
		btnClickHere.setFont(new Font("Mongolian Baiti", Font.BOLD, 15));
		btnClickHere.setBackground(new Color(50, 205, 50));
		btnClickHere.setBounds(347, 552, 130, 33);
		getContentPane().add(btnClickHere);
		
		JLabel lblChangeYourPassword_1 = new JLabel("If you want to change your password   >\r\n");
		lblChangeYourPassword_1.setForeground(Color.BLACK);
		lblChangeYourPassword_1.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblChangeYourPassword_1.setBounds(33, 554, 310, 28);
		getContentPane().add(lblChangeYourPassword_1);
		if (s != null) {
			
	        txtName.setText(s.getName());
	        dateChooser.setDate(s.getDob()); 
	        cboNrc.setSelectedItem(s.getNRC()); 
	        cboNrcR.setSelectedItem(s.getNRC()); 
	        txtnrc.setText(s.getNRC()); 
	        rdoMale.setSelected(s.getGender().equals("Male")); 
	        rdoFemale.setSelected(s.getGender().equals("Female")); 
	        txtPhno.setText(s.getPhno()); 
	        txtAddress.setText(s.getAddress()); 
	        txtEmail.setText(s.getEmail()); 
	      //  cboPosition.setSelectedItem(s.getPosition());
	 }
	
	}
}

