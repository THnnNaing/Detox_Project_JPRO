package Admin;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
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
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import javax.swing.ButtonGroup;

public class Admin_Profile extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtnrc3;
	private JTextField txtPhno;
	private JTextField txtAddress;
	private JTextField txtEmail;
	private JDateChooser dob;
	private JComboBox cboPosition;
	private JRadioButton rdoMale, rdoFemale;
	private final ButtonGroup btnGender = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public Admin_Profile(Staff s) {
		getContentPane().setBackground(UIManager.getColor("Button.light"));
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Admin_Profile.class.getResource("/Image/Logo-removebg-preview.png")));
		setTitle("VITALSIP Detox Juice");

		setBackground(UIManager.getColor("Button.light"));
		getContentPane().setLayout(null);
		setBounds(0, 0, 540, 680);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(81, 192, 61));
		panel.setBounds(0, 0, 530, 44);
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
		lblAdminDashboard.setBounds(0, 0, 520, 52);
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

		dob = new JDateChooser();
		dob.setBounds(188, 217, 289, 23);
		getContentPane().add(dob);

		JLabel lblNrc = new JLabel("NRC            : ");
		lblNrc.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblNrc.setBounds(33, 263, 126, 28);
		getContentPane().add(lblNrc);

		txtnrc3 = new JTextField();
		txtnrc3.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		txtnrc3.setColumns(10);
		txtnrc3.setBounds(187, 266, 290, 26);
		getContentPane().add(txtnrc3);

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

		JLabel lblPosition = new JLabel("Position     :");
		lblPosition.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblPosition.setBounds(33, 549, 126, 28);
		getContentPane().add(lblPosition);

		cboPosition = new JComboBox();
		cboPosition.setModel(new DefaultComboBoxModel(new String[] { "None", "Admin", "Staff", "Customer" }));
		cboPosition.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		cboPosition.setBackground(UIManager.getColor("Button.light"));
		cboPosition.setBounds(187, 551, 290, 28);
		getContentPane().add(cboPosition);

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
		btnBack.setIcon(new ImageIcon(View_ManageStaff.class.getResource("/image/back.png")));
		btnBack.setFont(new Font("Mongolian Baiti", Font.BOLD, 15));
		btnBack.setBackground(new Color(50, 205, 50));
		btnBack.setBounds(413, 72, 107, 33);
		getContentPane().add(btnBack);

		JLabel lblAdminProfile = new JLabel("Admin Profile");
		lblAdminProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminProfile.setForeground(Color.BLACK);
		lblAdminProfile.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
		lblAdminProfile.setBackground(Color.LIGHT_GRAY);
		lblAdminProfile.setBounds(10, 97, 510, 44);
		getContentPane().add(lblAdminProfile);

		JLabel lblChangeYourPassword_1 = new JLabel("If you want to change your password   >\r\n");
		lblChangeYourPassword_1.setForeground(Color.BLACK);
		lblChangeYourPassword_1.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblChangeYourPassword_1.setBounds(33, 597, 310, 28);
		getContentPane().add(lblChangeYourPassword_1);

		JButton btnClickHere = new JButton("Click Here");
		btnClickHere.setIcon(new ImageIcon(Admin_Profile.class.getResource("/Image/cursors.png")));
		btnClickHere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Password_ChangeForAdmin(s).setVisible(true);
				dispose();
			}
		});
		btnClickHere.setFont(new Font("Mongolian Baiti", Font.BOLD, 15));
		btnClickHere.setBackground(new Color(50, 205, 50));
		btnClickHere.setBounds(347, 595, 130, 33);
		getContentPane().add(btnClickHere);

		if (s != null) {

			String nrc = s.getNRC();


				txtName.setText(s.getName());
				dob.setDate(s.getDob());
				txtnrc3.setText(nrc);
				rdoMale.setSelected(s.getGender().equals("Male"));
				rdoFemale.setSelected(s.getGender().equals("Female"));
				txtPhno.setText(s.getPhno());
				txtAddress.setText(s.getAddress());
				txtEmail.setText(s.getEmail());
				cboPosition.setSelectedItem(s.getPosition());
			}
	}

	private boolean containsItem(JComboBox<String> comboBox, String item) {
		for (int i = 0; i < comboBox.getItemCount(); i++) {
			if (comboBox.getItemAt(i).equals(item)) {
				return true;
			}
		}
		return false;
	}

//	private void switchToPanel(JPanel newPanel) {
//        if (contentPane != null) {
//        	 contentPane.removeAll();
//            // contentPane.add(new Change_Password(s));
//             contentPane.revalidate();
//             contentPane.repaint();
//        } else {
//            System.err.println("Parent panel is null");
//        }
//    }
}
