package Admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Constructors.Account;
import Constructors.DetoxAndOrderdetail;
import Constructors.Product;
import Constructors.Staff;
import Dao.CRUD_Dao;
import Dao.Other_Dao;
import DetoxProduct.TodaySaleTableModel;
import Order.Manage_Order;
import Order.View_Order;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Staff_Dashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private ArrayList<DetoxAndOrderdetail>data =new ArrayList<DetoxAndOrderdetail>();
    private TodaySaleTableModel todays;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					Staff_Dashboard frame = new Staff_Dashboard( new Staff());
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
	public Staff_Dashboard(Staff s) throws SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Staff_Dashboard.class.getResource("/image/Logo-removebg-preview.png")));
		setTitle("VITALSIP Detox Juice");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1330, 741);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 1316, 50);
		panel.setLayout(null);
		panel.setBackground(new Color(81, 192, 61));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(5, 53, 221, 641);
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(81, 192, 61));
		
		JLabel lblNewLabel_1_1 = new JLabel("Manage Order         >");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					new Manage_Order(s).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		lblNewLabel_1_1.setForeground(SystemColor.inactiveCaptionText);
		lblNewLabel_1_1.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(10, 141, 211, 44);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Manage Customer  >");
		lblNewLabel_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					new Manage_Customer(s).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		lblNewLabel_1_1_1.setForeground(SystemColor.inactiveCaptionText);
		lblNewLabel_1_1_1.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(10, 204, 211, 44);
		panel_1.add(lblNewLabel_1_1_1);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Do you want to Logout", "Logout",JOptionPane.YES_NO_OPTION)==0){
				new Admin_Login().setVisible(true);
				 
				dispose();
			}
			}
		});
		btnLogOut.setIcon(new ImageIcon(Staff_Dashboard.class.getResource("/image/logout-removebg-preview.png")));
		btnLogOut.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnLogOut.setFocusPainted(false);
		btnLogOut.setContentAreaFilled(false);
		btnLogOut.setBorderPainted(false);
		btnLogOut.setBounds(10, 537, 201, 44);
		panel_1.add(btnLogOut);
		contentPane.setLayout(null);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Staff Dashboard");
		lblNewLabel.setBounds(20, 60, 201, 44);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblAdmin_1 = new JLabel("Staff");
		lblAdmin_1.setIcon(new ImageIcon(Staff_Dashboard.class.getResource("/image/people icon.png")));
		lblAdmin_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblAdmin_1.setBounds(1217, 0, 89, 50);
		panel.add(lblAdmin_1);
		
		JLabel lblAdminDashboard = new JLabel("Vitalsip Detox Juice");
		lblAdminDashboard.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblAdminDashboard.setBounds(0, 1, 486, 49);
		panel.add(lblAdminDashboard);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Profile                      >");
		lblNewLabel_1_1_2.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
				//new Staff_Profile(s).setVisible(true);
				setSize(540,680);
				
                 try {
                    
                     Staff staff = new CRUD_Dao().getDataForProfile(s.getName());

                    
                     new Staff_Profile(staff).setVisible(true);

                 } catch (SQLException e1) {
                     JOptionPane.showMessageDialog(null, "Error loading staff data: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                     e1.printStackTrace();
                 }
                 dispose();
			}
		});
		lblNewLabel_1_1_2.setForeground(SystemColor.inactiveCaptionText);
		lblNewLabel_1_1_2.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
		lblNewLabel_1_1_2.setBounds(10, 87, 214, 44);
		panel_1.add(lblNewLabel_1_1_2);
		
		JLabel lblStaffDashboard = new JLabel("Staff Dashboard");
		lblStaffDashboard.setHorizontalAlignment(SwingConstants.CENTER);
		lblStaffDashboard.setForeground(Color.BLACK);
		lblStaffDashboard.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblStaffDashboard.setBackground(Color.LIGHT_GRAY);
		lblStaffDashboard.setBounds(10, 0, 201, 44);
		panel_1.add(lblStaffDashboard);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("View Order             >");
		lblNewLabel_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					new View_Order(s).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		lblNewLabel_1_1_1_1.setForeground(SystemColor.inactiveCaptionText);
		lblNewLabel_1_1_1_1.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
		lblNewLabel_1_1_1_1.setBounds(10, 265, 211, 44);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		JLabel lblListOfSold = new JLabel("List of sold items for today \r\n");
		lblListOfSold.setForeground(new Color(0, 0, 0));
		lblListOfSold.setHorizontalAlignment(SwingConstants.CENTER);
		lblListOfSold.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblListOfSold.setBounds(306, 95, 936, 28);
		contentPane.add(lblListOfSold);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(278, 155, 1028, 492);
		contentPane.add(scrollPane);
		
		
		// Initialize the JTable
        table = new JTable();
        table.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
        scrollPane.setViewportView(table);

        // Fetch data and update the table

        data=new Other_Dao().getProductsForToday();
		todays=new TodaySaleTableModel(data);
		
               
                table.setModel(todays);
//                new DefaultTableModel(
//                	new Object[][] {
//                	},
//                	new String[] {
//                		"No", "Name", "Size", "Quantity", "Ingredients"
//                	}
//                ) {
//                	boolean[] columnEditables = new boolean[] {
//                		false, false, false, false, false
//                	};
//                	public boolean isCellEditable(int row, int column) {
//                		return columnEditables[column];
//                	}
//                });
                table.getColumnModel().getColumn(0).setResizable(false);
                table.getColumnModel().getColumn(1).setResizable(false);
                table.getColumnModel().getColumn(2).setResizable(false);
                table.getColumnModel().getColumn(3).setResizable(false);
                table.getColumnModel().getColumn(4).setResizable(false);
           
		
		JLabel lblAdmin = new JLabel("Staff");
		lblAdmin.setBounds(1240, 5, 126, 62);
		contentPane.add(lblAdmin);
		lblAdmin.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setBounds(1210, 5, 37, 62);
		contentPane.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setIcon(new ImageIcon(Staff_Dashboard.class.getResource("/image/people icon.png")));
	}
	

}
