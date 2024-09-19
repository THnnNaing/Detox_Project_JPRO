package Admin;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JDesktopPane;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Constructors.Account;
import Constructors.DetoxAndOrderdetail;
import Constructors.OrderTableModel;
import Constructors.Product;
import Constructors.Staff;
import Customer.View_Customer;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.awt.Toolkit;

import Dao.CRUD_Dao;
import Dao.Other_Dao;
import DetoxProduct.Product_Manage;
import DetoxProduct.TodaySaleTableModel;
import Order.View_Order;

public class Admin_Dashboard extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtstaff;
    private JTextField txtproduct;
    private JTextField txttotalpermonth;
    private JTable table;
    private JScrollPane scrollPane;
    private ArrayList<DetoxAndOrderdetail>data =new ArrayList<DetoxAndOrderdetail>();
    private TodaySaleTableModel todays;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
            	Account a=new Account();
            	String n=a.getUsername();
            	String p=a.getPassword();
                Admin_Dashboard frame = new Admin_Dashboard(new Staff());
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     * @throws SQLException 
     */
    public Admin_Dashboard(Staff s) throws SQLException {
        setIconImage(Toolkit.getDefaultToolkit().getImage(Admin_Dashboard.class.getResource("/image/Logo-removebg-preview.png")));
        setTitle("VITALSIP Detox Juice");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1330, 741);
        contentPane = new JPanel();
        contentPane.setBackground(UIManager.getColor("Button.light"));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Add the header panel
        JPanel panel = new JPanel();
        panel.setBounds(10, 10, 1296, 49);
        panel.setBackground(new Color(81, 192, 61));
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblAdminDashboard = new JLabel("Vitalsip Detox Juice");
        lblAdminDashboard.setBounds(10, 0, 486, 49);
        panel.add(lblAdminDashboard);
        lblAdminDashboard.setFont(new Font("Times New Roman", Font.BOLD, 25));

        JLabel lblAdmin = new JLabel("Admin ");
        lblAdmin.setIcon(new ImageIcon(Admin_Dashboard.class.getResource("/Image/people icon.png")));
        lblAdmin.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblAdmin.setBounds(1172, 5, 124, 42);
        panel.add(lblAdmin);

        // Add the side panel with menu items
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(10, 45, 221, 649);
        panel_1.setBackground(new Color(81, 192, 61));
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblStaffmanage = new JLabel("Staff Manage          >");
        lblStaffmanage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
					new Staff_Manage(s).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                dispose();
            }
        });
        lblStaffmanage.setForeground(SystemColor.inactiveCaptionText);
        lblStaffmanage.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
        lblStaffmanage.setBounds(5, 118, 201, 44);
        panel_1.add(lblStaffmanage);

        JLabel lblProductmanage = new JLabel("Product Manage     >");
        lblProductmanage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
            }
        	@Override
        	public void mousePressed(MouseEvent e) {
        		try {
					new Product_Manage(s).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        lblProductmanage.setForeground(SystemColor.inactiveCaptionText);
        lblProductmanage.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
        lblProductmanage.setBounds(5, 173, 201, 44);
        panel_1.add(lblProductmanage);

        JLabel lblViewcus = new JLabel("View Customer      >");
        lblViewcus.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
					new View_CustomerForAdmin(s).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                dispose();
            }
        });
        lblViewcus.setForeground(SystemColor.inactiveCaptionText);
        lblViewcus.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
        lblViewcus.setBounds(5, 226, 201, 44);
        panel_1.add(lblViewcus);

        JLabel lblNewLabel = new JLabel("Admin Dashboard");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(10, 10, 201, 44);
        panel_1.add(lblNewLabel);
        lblNewLabel.setForeground(new Color(0, 0, 0));
        lblNewLabel.setBackground(new Color(192, 192, 192));
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));

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
        btnLogOut.setIcon(new ImageIcon(Admin_Dashboard.class.getResource("/image/logout-removebg-preview.png")));
        btnLogOut.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
        btnLogOut.setFocusPainted(false);
        btnLogOut.setContentAreaFilled(false);
        btnLogOut.setBorderPainted(false);
        btnLogOut.setBounds(10, 557, 201, 44);
        panel_1.add(btnLogOut);

        JLabel lblViewOrder = new JLabel("View Order             >");
        lblViewOrder.addMouseListener(new MouseAdapter() {
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
        lblViewOrder.setForeground(SystemColor.inactiveCaptionText);
        lblViewOrder.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
        lblViewOrder.setBounds(5, 280, 211, 44);
        panel_1.add(lblViewOrder);

        JLabel lblProfile = new JLabel("Profile                      >");
        lblProfile.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	String email = s.getName().trim();
            	setSize(540,680);
            	
                         
                            
                             //new Admin_Profile(s).setVisible(true);
                             try {
                                 
                                 Staff staff = new CRUD_Dao().getDataForProfile(s.getName());

                                 new Admin_Profile(staff).setVisible(true);
                                 dispose();

                             } catch (SQLException e1) {
                                 JOptionPane.showMessageDialog(null, "Error loading staff data: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                                 e1.printStackTrace();
                             }
            }
        });
        lblProfile.setForeground(SystemColor.inactiveCaptionText);
        lblProfile.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
        lblProfile.setBounds(5, 64, 201, 44);
        panel_1.add(lblProfile);

        // Add the panel for statistics
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(231, 58, 1075, 133);
        panel_2.setBackground(UIManager.getColor("Button.light"));
        contentPane.add(panel_2);
        panel_2.setLayout(null);

        JLabel lblTotalSale = new JLabel("Total Sales Per Month");
        lblTotalSale.setHorizontalAlignment(SwingConstants.CENTER);
        lblTotalSale.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
        lblTotalSale.setBounds(47, 10, 235, 28);
        panel_2.add(lblTotalSale);

        JLabel lblTotalProduct = new JLabel("Total Product");
        lblTotalProduct.setHorizontalAlignment(SwingConstants.CENTER);
        lblTotalProduct.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
        lblTotalProduct.setBounds(422, 12, 236, 28);
        panel_2.add(lblTotalProduct);

        JLabel lblTotalStaff = new JLabel("Total Staff");
        lblTotalStaff.setHorizontalAlignment(SwingConstants.CENTER);
        lblTotalStaff.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
        lblTotalStaff.setBounds(818, 10, 236, 28);
        panel_2.add(lblTotalStaff);

        txtstaff = new JTextField();
        txtstaff.setHorizontalAlignment(SwingConstants.CENTER);
        txtstaff.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
        txtstaff.setColumns(10);
        txtstaff.setBounds(818, 51, 236, 67);
        panel_2.add(txtstaff);
        
        CRUD_Dao db=new CRUD_Dao();
		try {
	        String staffCount = db.retrieveStaff();
	        txtstaff.setText(("Total Staff NO:  "+staffCount)); 
	    } catch (SQLException e1) {
	        e1.printStackTrace(); 
	        txtstaff.setText("Error"); 
	    }

        txtproduct = new JTextField();
        txtproduct.setHorizontalAlignment(SwingConstants.CENTER);
        txtproduct.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
        txtproduct.setColumns(10);
        txtproduct.setBounds(411, 51, 247, 67);
        panel_2.add(txtproduct);
        try {
	        String staffCount = db.retrieveProduct();
	        txtproduct.setText(("Total Staff NO:  "+staffCount)); 
	    } catch (SQLException e1) {
	        e1.printStackTrace(); 
	        txtproduct.setText("Error"); 
	    }
        
        

        txttotalpermonth = new JTextField();
        txttotalpermonth.setHorizontalAlignment(SwingConstants.CENTER);
        txttotalpermonth.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
        txttotalpermonth.setColumns(10);
        txttotalpermonth.setBounds(47, 51, 236, 67);
        panel_2.add(txttotalpermonth);
        try {
	        String staffCount = db.retrieveMonthlySale();
	        txttotalpermonth.setText((" Monthy sale:  "+staffCount)); 
	    } catch (SQLException e1) {
	        e1.printStackTrace(); 
	        txttotalpermonth.setText("Error"); 
	    }

        JLabel lblListOfSold = new JLabel("List of sold items for today");
        lblListOfSold.setHorizontalAlignment(SwingConstants.CENTER);
        lblListOfSold.setBounds(241, 208, 1065, 28);
        lblListOfSold.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
        contentPane.add(lblListOfSold);

        // Initialize the JScrollPane and JTable
        scrollPane = new JScrollPane();
        scrollPane.setBounds(241, 246, 1065, 448);
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

    }

   
}
