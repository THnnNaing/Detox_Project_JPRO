package Customer;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.JPasswordField;




import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import Admin.Staff_Dashboard;
import Constructors.Staff;
import javax.swing.ButtonGroup;

public class Manage_Customer extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtAddress;
	private JTextField txtPhno;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtSearch;
	private JTable table;
	private final ButtonGroup btnGender = new ButtonGroup();
	private JRadioButton rdoFemale, rdoMale;
	private JDateChooser dateChooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manage_Customer frame = new Manage_Customer(new Staff());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Manage_Customer(Staff s) {
		setTitle("VITALSIP Detox Juice");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Manage_Customer.class.getResource("/image/Logo-removebg-preview.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1330, 741);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.light"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name           :");
		lblName.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblName.setBounds(20, 188, 126, 28);
		contentPane.add(lblName);
		
		JLabel lblGender = new JLabel("Gender        :");
		lblGender.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblGender.setBounds(20, 274, 139, 28);
		contentPane.add(lblGender);
		
		JLabel lblAddress = new JLabel("Address      :");
		lblAddress.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblAddress.setBounds(20, 376, 169, 28);
		contentPane.add(lblAddress);
		
		JLabel lblPhoneNo = new JLabel("Phone No   : ");
		lblPhoneNo.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblPhoneNo.setBounds(20, 328, 169, 28);
		contentPane.add(lblPhoneNo);
		
		rdoMale = new JRadioButton("Male");
		btnGender.add(rdoMale);
		rdoMale.setBackground(UIManager.getColor("Button.light"));
		rdoMale.setFont(new Font("Mongolian Baiti", Font.PLAIN, 16));
		rdoMale.setBounds(175, 281, 74, 21);
		contentPane.add(rdoMale);
		
		rdoFemale = new JRadioButton("Female");
		btnGender.add(rdoFemale);
		rdoFemale.setBackground(UIManager.getColor("Button.light"));
		rdoFemale.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		rdoFemale.setBounds(261, 281, 103, 21);
		contentPane.add(rdoFemale);
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
		txtAddress.setColumns(10);
		txtAddress.setBounds(174, 376, 290, 54);
		contentPane.add(txtAddress);
		
		txtPhno = new JTextField();
		txtPhno.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
		txtPhno.setColumns(10);
		txtPhno.setBounds(174, 330, 290, 26);
		contentPane.add(txtPhno);
		
		JLabel lblEmail = new JLabel("Email          :");
		lblEmail.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblEmail.setBounds(20, 453, 126, 28);
		contentPane.add(lblEmail);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
		txtName.setColumns(10);
		txtName.setBounds(174, 191, 290, 26);
		contentPane.add(txtName);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(174, 456, 290, 26);
		contentPane.add(txtEmail);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(81, 192, 61));
		panel.setBounds(0, 0, 1316, 62);
		contentPane.add(panel);
		
		JLabel lblAdminDashboard = new JLabel("Vitalsip Detox Juice\r\n ");
		lblAdminDashboard.setFont(new Font("Times New Roman", Font.BOLD, 29));
		lblAdminDashboard.setBounds(10, 10, 263, 52);
		panel.add(lblAdminDashboard);
		
		JLabel lblAdmin = new JLabel("Staff");
		lblAdmin.setIcon(new ImageIcon(Manage_Customer.class.getResource("/image/people icon.png")));
		lblAdmin.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblAdmin.setBounds(1215, 10, 126, 42);
		panel.add(lblAdmin);
		
		txtSearch = new JTextField();
		txtSearch.setFont(new Font("Monospaced", Font.PLAIN, 14));
		txtSearch.setColumns(10);
		txtSearch.setBounds(1001, 150, 280, 26);
		contentPane.add(txtSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(488, 188, 818, 448);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"  No", "         Name", "      Gender", "       Phone No", "          Email"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(45);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(110);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(85);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(112);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(107);
		scrollPane.setViewportView(table);
		
		JButton btnSearch = new JButton("");
		btnSearch.setIcon(new ImageIcon(Manage_Customer.class.getResource("/image/search.png")));
		btnSearch.setFont(new Font("Monospaced", Font.PLAIN, 11));
		btnSearch.setBackground(new Color(34, 139, 34));
		btnSearch.setBounds(1282, 150, 24, 25);
		contentPane.add(btnSearch);
		
		JLabel lblNewLabel = new JLabel("Manage Customer");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(39, 79, 1137, 43);
		contentPane.add(lblNewLabel);
		
		JLabel lblDob = new JLabel("DOB            :");
		lblDob.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblDob.setBounds(20, 236, 126, 28);
		contentPane.add(lblDob);
		
		JLabel lblAddNewStaff = new JLabel("Registration New Customer\r\n");
		lblAddNewStaff.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		lblAddNewStaff.setBounds(10, 150, 238, 28);
		contentPane.add(lblAddNewStaff);
		
		JButton btnSave = new JButton("Save");
		btnSave.setIcon(new ImageIcon(Manage_Customer.class.getResource("/image/Savee.png")));
		btnSave.setBackground(new Color(50, 205, 50));
		btnSave.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnSave.setBounds(233, 650, 107, 33);
		contentPane.add(btnSave);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setIcon(new ImageIcon(Manage_Customer.class.getResource("/image/delete-two.png")));
		btnDelete.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnDelete.setBackground(new Color(50, 205, 50));
		btnDelete.setBounds(1199, 650, 107, 33);
		contentPane.add(btnDelete);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setIcon(new ImageIcon(Manage_Customer.class.getResource("/image/editor.png")));
		btnEdit.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnEdit.setBackground(new Color(50, 205, 50));
		btnEdit.setBounds(1082, 650, 107, 33);
		contentPane.add(btnEdit);
		
		JButton btnView = new JButton("View");
		btnView.setForeground(new Color(0, 0, 0));
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new View_Customer(s).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
				setVisible(false);
			}
		});
		
		
		btnView.setIcon(new ImageIcon(Manage_Customer.class.getResource("/image/view-grid-detail.png")));
		btnView.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnView.setBackground(new Color(50, 205, 50));
		btnView.setBounds(965, 650, 107, 33);
		contentPane.add(btnView);
		
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
		btnBack.setIcon(new ImageIcon(Manage_Customer.class.getResource("/image/back.png")));
		btnBack.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnBack.setBackground(new Color(50, 205, 50));
		btnBack.setBounds(1199, 89, 107, 33);
		contentPane.add(btnBack);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clear();
			}
		});
		btnClear.setIcon(new ImageIcon(Manage_Customer.class.getResource("/image/clear-format.png")));
		btnClear.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnClear.setBackground(new Color(50, 205, 50));
		btnClear.setBounds(353, 650, 111, 33);
		contentPane.add(btnClear);
		
		 dateChooser = new JDateChooser();
		dateChooser.setBounds(175, 241, 289, 23);
		contentPane.add(dateChooser);
		
		
	}
	public void Clear() {
		txtName.setText("");
		btnGender.clearSelection();
		txtPhno.setText("");
		txtAddress.setText("");
		txtEmail.setText("");
		dateChooser.setDate(null);
		
	}
}
