package Customer;

import java.awt.EventQueue;




import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Admin.Admin_Dashboard;
import Admin.Staff_Dashboard;
import Dao.CRUD_Dao;
import Constructors.Customer;
import Constructors.CustomerTableModel;
import Constructors.Staff;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View_Customer extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSearch;
	private JTable table;
	private ArrayList<Customer>data =new ArrayList<Customer>();
	private CustomerTableModel cus;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Customer frame = new View_Customer(new Staff());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public View_Customer(Staff s) throws SQLException {
		//setIconImage(Toolkit.getDefaultToolkit().getImage(View_Customer.class.getResource("/image/Logo-removebg-preview.png")));
		setTitle("VITALSIP Detox Juice\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 983, 741);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(81, 192, 61));
		panel.setBounds(0, 0, 979, 62);
		contentPane.add(panel);
		
		JLabel lblAdminDashboard = new JLabel("Vitalsip Detox Juice\r\n ");
		lblAdminDashboard.setFont(new Font("Times New Roman", Font.BOLD, 29));
		lblAdminDashboard.setBounds(10, 0, 263, 62);
		panel.add(lblAdminDashboard);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(1179, 10, 63, 42);
		panel.add(lblNewLabel_1);
		
		JLabel lblAdmin = new JLabel("Admin ");
		//lblAdmin.setIcon(new ImageIcon(View_Customer.class.getResource("/image/image/people icon.png")));
		lblAdmin.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblAdmin.setBounds(856, 13, 102, 42);
		panel.add(lblAdmin);
		
		JLabel lblCustomerList = new JLabel("Customer List");
		lblCustomerList.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerList.setForeground(Color.BLACK);
		lblCustomerList.setFont(new Font("Mongolian Baiti", Font.BOLD, 23));
		lblCustomerList.setBackground(Color.BLACK);
		lblCustomerList.setBounds(0, 114, 959, 43);
		contentPane.add(lblCustomerList);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 200, 947, 463);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		data=new CRUD_Dao().AddCustomerIntoTable();
		cus=new CustomerTableModel(data);
		table.setModel(cus);
		
		
		
		
		table.setForeground(new Color(0, 0, 0));
		table.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		
		
		
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(6).setResizable(false);
		scrollPane.setViewportView(table);
		
		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				try {
				
				ArrayList<Customer>ur=new CRUD_Dao().AddCustomerIntoTable();
				
				
				String keyword=txtSearch.getText().trim().toLowerCase();
				data.clear();
				data.addAll((ArrayList<Customer>) ur.stream()
						.filter(u ->u.getName().toLowerCase().contains(keyword)||u.getAddress().toLowerCase().contains(keyword)||u.getGender().toLowerCase().contains(keyword))
						.collect(Collectors.toList()));
				cus.fireTableDataChanged();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			}	
				
			
		});
		txtSearch.setFont(new Font("Monospaced", Font.PLAIN, 14));
		txtSearch.setColumns(10);
		txtSearch.setBounds(589, 153, 345, 26);
		contentPane.add(txtSearch);
		
		JButton btnSearch = new JButton("");
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
						ArrayList<Customer>ur=new CRUD_Dao().AddCustomerIntoTable();
				
				
				String keyword=txtSearch.getText().trim().toLowerCase();
				data.clear();
				data.addAll((ArrayList<Customer>) ur.stream()
						.filter(u ->u.getName().toLowerCase().contains(keyword)||u.getAddress().toLowerCase().contains(keyword)||u.getGender().toLowerCase().contains(keyword))
						.collect(Collectors.toList()));
				cus.fireTableDataChanged();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			}	
				
				
				
			
		});
		//btnSearch.setIcon(new ImageIcon(View_Customer.class.getResource("/image/image/search.png")));
		btnSearch.setFont(new Font("Monospaced", Font.PLAIN, 11));
		btnSearch.setBackground(new Color(34, 139, 34));
		btnSearch.setBounds(935, 153, 24, 25);
		contentPane.add(btnSearch);
		
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
		//btnBack.setIcon(new ImageIcon(View_Customer.class.getResource("/image/image/back.png")));
		btnBack.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnBack.setBackground(new Color(50, 205, 50));
		btnBack.setBounds(852, 85, 107, 33);
		contentPane.add(btnBack);
	}
}
