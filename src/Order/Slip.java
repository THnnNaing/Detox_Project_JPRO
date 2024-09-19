package Order;

import javax.swing.JPanel;


import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Constructors.OrderTableModel;
import Constructors.Product;
import Constructors.Staff;
import Constructors.Customer;
import Constructors.Invoice;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Slip extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private ArrayList<Invoice> v=new ArrayList<Invoice>();
	public JLabel lblStaff,lblCustomer,lbldate;
	
	public  JLabel lblTotalp,lblTaxamount,lblnetpayment;
	public InvoiceTableModel tableModel;
	public JTable table_1;
	
	private ArrayList<Product>data =new ArrayList<Product>();
	private OrderTableModel order;//ordering page(image,price,size)
	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public Slip(Staff s,String cusName,java.sql.Date currentDate) throws SQLException {
		
		
		
		
		setLayout(null);
		setBounds(0,0,550,690);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(81, 192, 61));
		panel.setBounds(0, 0, 550, 52);
		add(panel);
		
		JLabel lblAdminDashboard = new JLabel("Vitalsip Detox Juice");
		lblAdminDashboard.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblAdminDashboard.setBounds(0, 0, 486, 49);
		panel.add(lblAdminDashboard);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 226, 519, 249);
		add(scrollPane);
		
		
		tableModel = new InvoiceTableModel(new ArrayList<Invoice>());
		 
		table_1 = new JTable();
		table_1.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		table_1.setModel(tableModel);
//		new DefaultTableModel(
//			new Object[][] {
//			},
//			new String[] {
//				"No", "Name", "Size", "Quantity", "Price"
//			}
//		) {
//			boolean[] columnEditables = new boolean[] {
//				false, true, true, false, false
//			};
//			public boolean isCellEditable(int row, int column) {
//				return columnEditables[column];
//			}
//		});
		table_1.getColumnModel().getColumn(0).setResizable(false);
		table_1.getColumnModel().getColumn(3).setResizable(false);
		table_1.getColumnModel().getColumn(4).setResizable(false);
		scrollPane.setViewportView(table_1);
		
		
		
		
		JLabel lblTotalprice = new JLabel("Total Price     :");
		lblTotalprice.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		lblTotalprice.setBounds(20, 488, 127, 30);
		add(lblTotalprice);
		
		 lblTotalp = new JLabel("");
		lblTotalp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalp.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		lblTotalp.setBounds(157, 486, 107, 30);
		add(lblTotalp);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//					new Slip().setVisible(false);
				
				try {
					new Manage_Order(s).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		//btnBack.setIcon(new ImageIcon(Slip.class.getResource("/image/back.png")));
		btnBack.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnBack.setBackground(new Color(50, 205, 50));
		btnBack.setBounds(433, 62, 107, 33);
		add(btnBack);
		
		JLabel lblTaxamont = new JLabel("TaxAmount    :");
		lblTaxamont.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		lblTaxamont.setBounds(20, 528, 143, 30);
		add(lblTaxamont);
		
		 lblTaxamount = new JLabel("");
		lblTaxamount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTaxamount.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		lblTaxamount.setBounds(157, 527, 107, 30);
		add(lblTaxamount);
		
		JLabel lblNetPayment = new JLabel("Net Payment  :");
		lblNetPayment.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		lblNetPayment.setBounds(272, 488, 127, 30);
		add(lblNetPayment);
		
		 lblnetpayment = new JLabel("");
		lblnetpayment.setHorizontalAlignment(SwingConstants.RIGHT);
		lblnetpayment.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		lblnetpayment.setBounds(386, 486, 143, 30);
		add(lblnetpayment);
		
		JLabel lblDate = new JLabel("Date            :");
		lblDate.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblDate.setBounds(10, 150, 92, 28);
		add(lblDate);
		
		 lbldate = new JLabel("");
		lbldate.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lbldate.setBounds(137, 150, 118, 28);
		add(lbldate);
		
	 lblCustomer = new JLabel("");
		lblCustomer.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblCustomer.setBounds(142, 195, 128, 28);
		add(lblCustomer);
		
		JLabel lblCustomerName = new JLabel("Customer Name :");
		lblCustomerName.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblCustomerName.setBounds(10, 195, 127, 28);
		add(lblCustomerName);
		
		 lblStaff = new JLabel("");
		lblStaff.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblStaff.setBounds(401, 195, 128, 28);
		add(lblStaff);
		
		JLabel lblStaffName = new JLabel("Staff Name :");
		lblStaffName.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblStaffName.setBounds(284, 195, 107, 28);
		add(lblStaffName);
		
		JLabel lblOrderView = new JLabel("");
		lblOrderView.setHorizontalAlignment(SwingConstants.CENTER);
		//lblOrderView.setIcon(new ImageIcon(Slip.class.getResource("/image/Vital.png")));
		lblOrderView.setForeground(Color.BLACK);
		lblOrderView.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		lblOrderView.setBackground(Color.LIGHT_GRAY);
		lblOrderView.setBounds(0, 46, 539, 94);
		add(lblOrderView);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		//btnExit.setIcon(new ImageIcon(Slip.class.getResource("/image/exit.png")));
		btnExit.setForeground(Color.BLACK);
		btnExit.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnExit.setBackground(new Color(50, 205, 50));
		btnExit.setBounds(410, 565, 107, 33);
		add(btnExit);
		
		
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Invoice> invoices = new ArrayList<>();
				
				try {
			        
			      
					
			        
//			        tableModel = (InvoiceTableModel) table_1.getModel();
//			        
//			        
//		            int invoiceRowCount = tableModel.getRowCount();
//			        
//			        
//			        for (int i = 0; i < invoiceRowCount; i++) {
//			            
//			        	String orid = order.getValueAt(i, 0).toString().trim();
//		                int orderid = Integer.parseInt(orid);
//
//		                // Get detoxID and quantity from InvoiceTableModel
//		                String detoxIDStr = tableModel.getValueAt(i, 0).toString().trim();
//		                String quantityStr = tableModel.getValueAt(i, 4).toString().trim();
//		                int detoxID = Integer.parseInt(detoxIDStr);
//		                int quantity = Integer.parseInt(quantityStr);
//			            
//			            DetailOrder invoice = new DetailOrder();
//			            invoice.setDetoxid(detoxID);
//			            invoice.setQuantity(quantity);
//			            invoice.setOrderid(orderid); // Set the foreign key
//			            
//		                
//		                int orderDetailID = new CRUD_Dao().insertOrderDetail(invoice);
//
//		                if (orderDetailID > 0) {
//		                    System.out.println("Inserted successfully for row " + i);

		   				 PrinterJob printerJob = PrinterJob.getPrinterJob();
		   	                printerJob.setPrintable(new Printpanel(Slip.this));
		   	                try {
		   	                    if (printerJob.printDialog()) {
		   	                        printerJob.print();
		   	                    }
		   	                } catch (PrinterException ex) {
		   	                    ex.printStackTrace();
		   	                }
		   				
		                
		                
		            }
		         catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Invalid number format: " + ex.getMessage());
		        } catch (ClassCastException ex) {
		            JOptionPane.showMessageDialog(null, "Data type mismatch: " + ex.getMessage());
		        }
		    
			
			}
		});
		//btnPrint.setIcon(new ImageIcon(Slip.class.getResource("/image/printer.png")));
		btnPrint.setForeground(Color.BLACK);
		btnPrint.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnPrint.setBackground(new Color(50, 205, 50));
		btnPrint.setBounds(292, 565, 107, 33);
		add(btnPrint);
		
		
		//lbldate.setDate(currentDate);
		String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(currentDate);
	    
	    
	    lbldate.setText(formattedDate);
	    
	    lblCustomer.setText(cusName);
	    
	   
	    lblStaff.setText(s.getName());
		
		

       
	}
	
	 
	
	 
	 public void updateTable(ArrayList<Invoice> invoices) {
	        tableModel.setInvoices(invoices); // Update the table model with new data
	    }
	    
	    public InvoiceTableModel getInvoiceTableModel() {
	        return tableModel;
	    }
	    private boolean isValidNumber(String str) {
	        if (str == null || str.isEmpty()) {
	            return false;
	        }
	        try {
	            Integer.parseInt(str);
	            return true;
	        } catch (NumberFormatException e) {
	            return false;
	        }
	    }
}
