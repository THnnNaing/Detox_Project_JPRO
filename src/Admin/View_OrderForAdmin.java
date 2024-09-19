package Admin;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Admin.Admin_Dashboard;
import Admin.Staff_Dashboard;
import Dao.CRUD_Dao;
import DetoxProduct.ProductTableModel;
import DetoxProduct.View_Product;
import Order.In_vieworder;
import Order.OrderListTableModel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Constructors.Order;
import Constructors.Staff;
public class View_OrderForAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSearch;
	private JTable table;
	private ArrayList<Order> order=new ArrayList<Order>();
	private OrderListTableModel otb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_OrderForAdmin frame = new View_OrderForAdmin(new Staff());
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
	public View_OrderForAdmin(Staff s) throws SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(View_OrderForAdmin.class.getResource("/Image/Logo-removebg-preview.png")));
		//setIconImage(Toolkit.getDefaultToolkit().getImage(View_Order.class.getResource("/image/Logo-removebg-preview.png")));
		setTitle("VITALSIP Detox Juice");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 983, 741);
		contentPane = new JPanel();
		contentPane.setForeground(UIManager.getColor("Button.light"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOrderList = new JLabel("Order List");
		lblOrderList.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrderList.setForeground(Color.BLACK);
		lblOrderList.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblOrderList.setBackground(Color.BLACK);
		lblOrderList.setBounds(28, 98, 915, 33);
		contentPane.add(lblOrderList);
		
		JButton btnBack = new JButton("Back");
		btnBack.setIcon(new ImageIcon(View_OrderForAdmin.class.getResource("/Image/back.png")));
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
	//	btnBack.setIcon(new ImageIcon(View_Order.class.getResource("/image/image/back.png")));
		btnBack.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnBack.setBackground(new Color(50, 205, 50));
		btnBack.setBounds(836, 78, 107, 33);
		contentPane.add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 189, 915, 444);
		contentPane.add(scrollPane);
		
		
		order=new CRUD_Dao().getOrder();
		otb=new OrderListTableModel(order);
		
		
		
		
		table = new JTable();
		table.setModel(otb);
//		new DefaultTableModel(
//			new Object[][] {
//				{new Integer(1), "Myo Myo", "Aung Aung", null},
//				{new Integer(2), "Soe Soe", "Mya Mya", null},
//				{new Integer(3), "Myo Myo", "Mya Mya", null},
//				{new Integer(4), "Ei Zin Htun", "Mya Mya", null},
//				{new Integer(5), "Myo Myo", "Mya Mya", null},
//				{new Integer(6), "Htun Htun", "Ko Ko", null},
//				{new Integer(7), "Myo Myo", "Ko Ko", null},
//				{new Integer(8), "Myo Myo", "Ko Ko", null},
//				{new Integer(9), "Myo Myo", "Ko Ko", null},
//				{new Integer(10), "Lwin Mar Aung", "Ko Ko", null},
//				{new Integer(11), "Myo Myo", "Ko Ko", null},
//				{new Integer(12), "Ei Sandar Kyaw", "Ko Ko", null},
//				{new Integer(13), "Lwin Mar Aung", "Ko Ko", null},
//				{new Integer(14), "Lwin Mar Aung", "Ko Ko", null},
//				{new Integer(15), "Myo Myo", "Ko Ko", null},
//				{new Integer(16), "Myo Myo", "Ko Ko", null},
//				{new Integer(17), "Myo Myo", "Ko Ko", null},
//				{new Integer(18), "Myo Myo", "Ko Ko", null},
//				{new Integer(19), "Myo Myo", "Ko Ko", null},
//				{new Integer(20), "Myo Myo", "Ko Ko", null},
//				{new Integer(21), "Myo Myo", "Ko Ko", null},
//				{new Integer(22), "Myo Myo", "Ko Ko", null},
//				{new Integer(23), "Myo Myo", "Ko Ko", null},
//				{new Integer(24), "Myo Myo", "Ko Ko", null},
//				{new Integer(25), "Myo Myo", "Ko Ko", null},
//				{new Integer(26), "Myo Myo", "Ko Ko", null},
//				{new Integer(27), "Myo Myo", "Ko Ko", null},
//				{new Integer(28), "Myo Myo", "Ko Ko", null},
//				{new Integer(29), "Myo Myo", "Ko Ko", null},
//				{new Integer(30), "Myo Myo", "Ko Ko", null},
//				{new Integer(31), "Myo Myo", "Ko Ko", null},
//				{new Integer(32), "Myo Myo", "Ko Ko", null},
//				{new Integer(33), "Myo Myo", "Ko Ko", null},
//				{new Integer(34), "Myo Myo", "Ko Ko", null},
//				{new Integer(35), "Ei Sandar Kyaw", "Ko Ko", null},
//				{new Integer(36), "Myo Myo", "Ko Ko", null},
//				{new Integer(37), "Myo Myo", "Hla Hla", null},
//				{new Integer(38), "Htun Htun", "Hla Hla", null},
//				{new Integer(39), "Aung Cham Myae", "Aung Ko Htet", null},
//				{new Integer(40), "Ei Sandar Kyaw", "Kyaw Soe Moe", null},
//				{new Integer(41), "Ei Sandar Kyaw", "Kyaw Soe Moe", null},
//				{new Integer(42), "Ei Sandar Kyaw", "Kyaw Soe Moe", null},
//				{new Integer(43), "Ei Sandar Kyaw", "Kyaw Soe Moe", null},
//				{new Integer(44), "Ei Sandar Kyaw", "Kyaw Soe Moe", null},
//			},
//			new String[] {
//				"No", "Customers", "Staff", "Date"
//			}
//		) {
//			boolean[] columnEditables = new boolean[] {
//				false, false, false, false
//			};
//			public boolean isCellEditable(int row, int column) {
//				return columnEditables[column];
//			}
//		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(112);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.setFont(new Font("Mongolian Baiti", Font.PLAIN, 21));
		scrollPane.setViewportView(table);
		
		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				try {
					ArrayList<Order>ur=new CRUD_Dao().getOrder();
					
					
					String keyword=txtSearch.getText().trim().toLowerCase();
					order.clear();
					order.addAll((ArrayList<Order>) ur.stream()
							.filter(u ->u.getSname().toLowerCase().contains(keyword)||u.getCname().toLowerCase().contains(keyword)||u.getOrderDate().toString().contains(keyword))
							.collect(Collectors.toList()));
					otb.fireTableDataChanged();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				
			}
		});
		txtSearch.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		txtSearch.setColumns(10);
		txtSearch.setBounds(573, 151, 345, 26);
		contentPane.add(txtSearch);
		
		JButton btnSearch = new JButton("");
		btnSearch.setIcon(new ImageIcon(View_OrderForAdmin.class.getResource("/Image/refresh-data.png")));
		//btnSearch.setIcon(new ImageIcon(View_Order.class.getResource("/image/image/search.png")));
		btnSearch.setFont(new Font("Monospaced", Font.PLAIN, 11));
		btnSearch.setBackground(new Color(34, 139, 34));
		btnSearch.setBounds(919, 151, 24, 25);
		contentPane.add(btnSearch);
		
		JButton btnView = new JButton("View");
		btnView.setIcon(new ImageIcon(View_OrderForAdmin.class.getResource("/Image/view-grid-detail.png")));
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				
		        
		        In_vieworder viewProductPanel = null;
		        try {
					viewProductPanel = new In_vieworder(s);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				contentPane.add(viewProductPanel);
				contentPane.add(viewProductPanel,BorderLayout.CENTER);
		        
				
				viewProductPanel.setSize(580,620);
				viewProductPanel.setLocation(0,0);
		        contentPane.repaint();
		        contentPane.revalidate();
		        
		        int selectedRow = table.getSelectedRow();
				if(selectedRow != -1 ) {
					
					int id = (int) table.getValueAt(selectedRow, 0);
					Order o=new Order();
					int i=o.getOrderID();
					try {
						viewProductPanel.updateOrderDetails(id);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				}
				
			}
		});
		//btnView.setIcon(new ImageIcon(View_Order.class.getResource("/image/image/view-grid-detail.png")));
		btnView.setForeground(Color.BLACK);
		btnView.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnView.setBackground(new Color(50, 205, 50));
		btnView.setBounds(836, 649, 107, 33);
		contentPane.add(btnView);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(81, 192, 61));
		panel.setBounds(0, 0, 969, 49);
		contentPane.add(panel);
		
		JLabel lblAdminDashboard = new JLabel("Vitalsip Detox Juice");
		lblAdminDashboard.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblAdminDashboard.setBounds(10, 0, 486, 49);
		panel.add(lblAdminDashboard);
		
		JLabel lblAdmin = new JLabel("Admin ");
		lblAdmin.setIcon(new ImageIcon(View_OrderForAdmin.class.getResource("/Image/people icon.png")));
		lblAdmin.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblAdmin.setBounds(864, 5, 101, 42);
		panel.add(lblAdmin);
		
		JLabel lblSearchHere = new JLabel("Search Here :");
		lblSearchHere.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchHere.setForeground(Color.BLACK);
		lblSearchHere.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblSearchHere.setBackground(Color.BLACK);
		lblSearchHere.setBounds(458, 146, 115, 33);
		contentPane.add(lblSearchHere);
	}
}
