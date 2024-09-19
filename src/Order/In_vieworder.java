package Order;

import javax.swing.JPanel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Customer.Customer;
import Dao.CRUD_Dao;
import Constructors.Order;
import Constructors.Staff;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Constructors.Invoice;
public class In_vieworder extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private ArrayList<Invoice> v=new ArrayList<Invoice>();
	private InvoiceTableModel view;
	private JLabel lblStaff ,lblCustomer,lbldate, lblTotalp,lblnetpayment,lblTaxamount;
	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public In_vieworder(Staff s) throws SQLException {
		setLayout(null);
		setBounds(0,0,543,738);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(81, 192, 61));
		panel.setBounds(0, 0, 539, 51);
		add(panel);
		
		JLabel lblAdminDashboard = new JLabel("Vitalsip Detox Juice");
		lblAdminDashboard.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblAdminDashboard.setBounds(0, 0, 486, 49);
		panel.add(lblAdminDashboard);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 241, 509, 290);
		add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
//				 int selectedRow = table.getSelectedRow();
//	                if (selectedRow != -1) {
//	                    
//	                    int quantity = (int) table.getValueAt(selectedRow, 3);
//	                    int price = (int) table.getValueAt(selectedRow, 4);
//
//	                    double totalPrice = quantity * price;
//	                    double taxAmount = totalPrice * 0.10; //  10% tax
//	                    double netPayment = totalPrice + taxAmount;
//
//	                    
//	                    lblTotalp.setText(String.format("%.2f", totalPrice));
//	                    lblTaxamount.setText(String.format("%.2f", taxAmount));
//	                    lblnetpayment.setText(String.format("%.2f", netPayment));
//	                }
            
			}
		});
		

		Invoice o=new Invoice();
		int i=o.getOrderID();
		
		v=new CRUD_Dao().getInvoices(i);
		try {
			view=new InvoiceTableModel(v);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		table.setModel(view);
//		new DefaultTableModel(
//			new Object[][] {
//			},
//			new String[] {
//				"No", "Name", "Size", "Quantity", "Price"
//			}
//		) {
//			boolean[] columnEditables = new boolean[] {
//				false, false, false, false, false
//			};
//			public boolean isCellEditable(int row, int column) {
//				return columnEditables[column];
//			}
	//	});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(54);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(89);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(106);
		scrollPane.setViewportView(table);
		
		JLabel lblTotalprice = new JLabel("Total Price     :");
		lblTotalprice.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		lblTotalprice.setBounds(239, 541, 127, 30);
		add(lblTotalprice);
		
		 lblTotalp = new JLabel("");
		lblTotalp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalp.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		lblTotalp.setBounds(376, 541, 143, 30);
		add(lblTotalp);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new View_Order(s).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
//				dispose();
			}
			
		});
		btnBack.setIcon(new ImageIcon(In_vieworder.class.getResource("/image/image/back.png")));
		btnBack.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnBack.setBackground(new Color(50, 205, 50));
		btnBack.setBounds(426, 57, 107, 33);
		add(btnBack);
		
		JLabel lblTaxamont = new JLabel("TaxAmount    :");
		lblTaxamont.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		lblTaxamont.setBounds(238, 581, 143, 30);
		add(lblTaxamont);
		
		 lblTaxamount = new JLabel("");
		lblTaxamount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTaxamount.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		lblTaxamount.setBounds(376, 581, 143, 30);
		add(lblTaxamount);
		
		JLabel lblNetPayment = new JLabel("Net Payment  :");
		lblNetPayment.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		lblNetPayment.setBounds(238, 621, 127, 30);
		add(lblNetPayment);
		
		 lblnetpayment = new JLabel("");
		lblnetpayment.setHorizontalAlignment(SwingConstants.RIGHT);
		lblnetpayment.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		lblnetpayment.setBounds(376, 621, 143, 30);
		add(lblnetpayment);
		
		JLabel lblDate = new JLabel("Date            :");
		lblDate.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblDate.setBounds(10, 147, 92, 28);
		add(lblDate);
		
		 lbldate = new JLabel("");
		lbldate.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lbldate.setBounds(137, 147, 118, 28);
		add(lbldate);
		
		 lblCustomer = new JLabel("");
		lblCustomer.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblCustomer.setBounds(142, 192, 128, 28);
		add(lblCustomer);
		
		JLabel lblCustomerName = new JLabel("Customer Name :");
		lblCustomerName.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblCustomerName.setBounds(10, 192, 127, 28);
		add(lblCustomerName);
		
		 lblStaff = new JLabel("");
		lblStaff.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblStaff.setBounds(401, 192, 118, 28);
		add(lblStaff);
		
		JLabel lblStaffName = new JLabel("Staff Name :");
		lblStaffName.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblStaffName.setBounds(284, 192, 107, 28);
		add(lblStaffName);
		
		JLabel lblOrderView = new JLabel("Order View");
		lblOrderView.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrderView.setForeground(Color.BLACK);
		lblOrderView.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		lblOrderView.setBackground(Color.LIGHT_GRAY);
		lblOrderView.setBounds(0, 85, 539, 44);
		add(lblOrderView);
		
		Order order=new Order();
		int r=order.getOrderID();
		updateOrderDetails(r);
		
	}
		 public void updateOrderDetails(int orderId) throws SQLException {
		        // Assuming you are fetching a single order's data for display
		        Order order = new CRUD_Dao().getOrderForView(orderId); // Modify this method as needed

		        if (order != null) {
		            lblStaff.setText(order.getSname());
		            lblCustomer.setText(order.getCname());
		            lbldate.setText(order.getOrderDate().toString());
		        } else {
		            lblStaff.setText("N/A");
		            lblCustomer.setText("N/A");
		            lbldate.setText("N/A");
		        }
		
		 }
	
}
