package Dao;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Slip extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public Slip() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(81, 192, 61));
		panel.setBounds(0, 0, 539, 36);
		add(panel);
		
		JLabel lblAdminDashboard = new JLabel("Vitalsip Detox Juice\r\n ");
		lblAdminDashboard.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblAdminDashboard.setBounds(10, 0, 263, 36);
		panel.add(lblAdminDashboard);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 211, 519, 253);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"No", "Name", "Size", "Quantity", "Price"
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
		lblTotalprice.setBounds(248, 474, 127, 30);
		add(lblTotalprice);
		
		JLabel lblTotalp = new JLabel("");
		lblTotalp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalp.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		lblTotalp.setBounds(385, 474, 143, 30);
		add(lblTotalp);
		
		JButton btnBack = new JButton("Back");
		btnBack.setIcon(new ImageIcon(Slip.class.getResource("/image/back.png")));
		btnBack.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnBack.setBackground(new Color(50, 205, 50));
		btnBack.setBounds(422, 46, 107, 33);
		add(btnBack);
		
		JLabel lblTaxamont = new JLabel("TaxAmount    :");
		lblTaxamont.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		lblTaxamont.setBounds(248, 514, 143, 30);
		add(lblTaxamont);
		
		JLabel lblTaxamount = new JLabel("");
		lblTaxamount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTaxamount.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		lblTaxamount.setBounds(386, 514, 143, 30);
		add(lblTaxamount);
		
		JLabel lblNetPayment = new JLabel("Net Payment  :");
		lblNetPayment.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		lblNetPayment.setBounds(247, 554, 127, 30);
		add(lblNetPayment);
		
		JLabel lblnetpayment = new JLabel("");
		lblnetpayment.setHorizontalAlignment(SwingConstants.RIGHT);
		lblnetpayment.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		lblnetpayment.setBounds(385, 554, 143, 30);
		add(lblnetpayment);
		
		JLabel lblDate = new JLabel("Date            :");
		lblDate.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblDate.setBounds(10, 128, 92, 28);
		add(lblDate);
		
		JLabel lbldate = new JLabel("");
		lbldate.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lbldate.setBounds(137, 128, 118, 28);
		add(lbldate);
		
		JLabel lbldate_1 = new JLabel("");
		lbldate_1.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lbldate_1.setBounds(142, 173, 128, 28);
		add(lbldate_1);
		
		JLabel lblCustomerName = new JLabel("Customer Name :");
		lblCustomerName.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblCustomerName.setBounds(10, 173, 127, 28);
		add(lblCustomerName);
		
		JLabel lbldate_1_1 = new JLabel("");
		lbldate_1_1.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lbldate_1_1.setBounds(401, 173, 128, 28);
		add(lbldate_1_1);
		
		JLabel lblStaffName = new JLabel("Staff Name :");
		lblStaffName.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblStaffName.setBounds(284, 173, 107, 28);
		add(lblStaffName);
		
		JLabel lblOrderView = new JLabel("");
		lblOrderView.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrderView.setIcon(new ImageIcon(Slip.class.getResource("/image/Vital.png")));
		lblOrderView.setForeground(Color.BLACK);
		lblOrderView.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		lblOrderView.setBackground(Color.LIGHT_GRAY);
		lblOrderView.setBounds(0, 33, 539, 107);
		add(lblOrderView);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setIcon(new ImageIcon(Slip.class.getResource("/image/exit.png")));
		btnExit.setForeground(Color.BLACK);
		btnExit.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnExit.setBackground(new Color(50, 205, 50));
		btnExit.setBounds(411, 613, 107, 33);
		add(btnExit);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.setIcon(new ImageIcon(Slip.class.getResource("/image/printer.png")));
		btnPrint.setForeground(Color.BLACK);
		btnPrint.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnPrint.setBackground(new Color(50, 205, 50));
		btnPrint.setBounds(284, 613, 107, 33);
		add(btnPrint);

	}
}
