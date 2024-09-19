package Admin;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Date;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import javax.swing.ButtonGroup;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;

public class View_ManageStaff extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtName;
	private JTextField txtNRC4;
	private JTextField txtPhno;
	private JTextField txtAddress;
	private JTextField txtEmail;
	private JComboBox<String> comboBox2, comboBox1;
	private JDateChooser dateChooser;
	private JComboBox cboPosition;
	private final ButtonGroup btnGender = new ButtonGroup();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdoFemale, rdoMale;

	/**
	 * Create the panel.
	 */
	public View_ManageStaff(Staff s) {
		getContentPane().setBackground(UIManager.getColor("Button.light"));
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(View_ManageStaff.class.getResource("/Image/Logo-removebg-preview.png")));
		setTitle("VITALSIP Detox Juice");
		setBounds(0, 0, 543, 738);
		setBackground(UIManager.getColor("Button.light"));
		getContentPane().setLayout(null);

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
		lblAdminDashboard.setBounds(0, 0, 486, 49);
		panel.add(lblAdminDashboard);

		JLabel lblStaffProfile = new JLabel("Staff Profile");
		lblStaffProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblStaffProfile.setForeground(Color.BLACK);
		lblStaffProfile.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblStaffProfile.setBackground(Color.LIGHT_GRAY);
		lblStaffProfile.setBounds(0, 115, 530, 36);
		getContentPane().add(lblStaffProfile);

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

		txtNRC4 = new JTextField();
		txtNRC4.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		txtNRC4.setColumns(10);
		txtNRC4.setBounds(187, 266, 290, 26);
		getContentPane().add(txtNRC4);

		JLabel lblGender = new JLabel("Gender        :");
		lblGender.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblGender.setBounds(33, 311, 169, 28);
		getContentPane().add(lblGender);

		rdoMale = new JRadioButton("Male");
		btnGender.add(rdoMale);
		rdoMale.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		rdoMale.setBackground(UIManager.getColor("Button.light"));
		rdoMale.setBounds(187, 316, 74, 21);
		getContentPane().add(rdoMale);

		rdoFemale = new JRadioButton("Female");
		btnGender.add(rdoFemale);
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
		lblAddress.setBounds(33, 428, 169, 28);
		getContentPane().add(lblAddress);

		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		txtAddress.setColumns(10);
		txtAddress.setBounds(187, 428, 290, 54);
		getContentPane().add(txtAddress);

		JLabel lblEmail = new JLabel("Email          :");
		lblEmail.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblEmail.setBounds(33, 508, 126, 28);
		getContentPane().add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		txtEmail.setColumns(10);
		txtEmail.setBounds(187, 511, 290, 26);
		getContentPane().add(txtEmail);

		JLabel lblPosition = new JLabel("Position     :");
		lblPosition.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblPosition.setBounds(33, 565, 126, 28);
		getContentPane().add(lblPosition);

		cboPosition = new JComboBox();
		cboPosition.setModel(new DefaultComboBoxModel(new String[] { "None", "Admin", "Staff", "Customer" }));
		cboPosition.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		cboPosition.setBackground(UIManager.getColor("Button.light"));
		cboPosition.setBounds(187, 567, 290, 28);
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
				dispose();
			}
		});
		btnBack.setIcon(new ImageIcon(View_ManageStaff.class.getResource("/image/back.png")));
		btnBack.setFont(new Font("Mongolian Baiti", Font.BOLD, 15));
		btnBack.setBackground(new Color(50, 205, 50));
		btnBack.setBounds(413, 72, 107, 33);
		getContentPane().add(btnBack);

	}

	public void populateStaffDetails(String name, java.util.Date dob, String email, String gender, String phno,
			String nrc, String position, String address) {

		txtName.setText(name);
		cboPosition.setSelectedItem(position);

		dateChooser.setDate(dob);

		txtEmail.setText(String.valueOf(email));
		txtPhno.setText(String.valueOf(phno));

		txtNRC4.setText(nrc);

		txtAddress.setText(address);
		if (gender.equals("on")) {
			rdoFemale.setSelected(true);
			rdoMale.setSelected(false);
		} else if (gender.equals("off")) {
			rdoFemale.setSelected(false);
			rdoMale.setSelected(true);
		} else {
			// handle unexpected status values
			rdoFemale.setSelected(false);
			rdoMale.setSelected(false);
		}

	}

}
