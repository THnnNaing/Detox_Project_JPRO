package Admin;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
import javax.swing.SwingUtilities;

import java.awt.Toolkit;
import javax.swing.JPasswordField;
import com.toedter.calendar.JDateChooser;

import Admin.populateTownships;
import Constructors.Account;
import Constructors.Customer;
import Constructors.Product;
import Dao.CRUD_Dao;
import Constructors.Staff;
import Customer.View_Customer;
import Dao.Other_Dao;
import DetoxProduct.ProductTableModel;
import DetoxProduct.Product_Manage;
import DetoxProduct.View_Product;
import Admin.Edit_Staff;
import Admin.View_ManageStaff;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.swing.ButtonGroup;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JCheckBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Staff_Manage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtAddress;
	private JTextField txtPhno;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtNrc;
	private JTextField txtn;
	private JTextField txtSearch;
	private JPasswordField txtpassword;
	private JPasswordField txtconfirm;
	private JTable table;
	private final ButtonGroup btnGender = new ButtonGroup();
	private JTextField txtUsername;
	private JComboBox<String> comboBox2, comboBox1;
	private JDateChooser Dob;
	private JComboBox cboPosition;
	private JRadioButton rdoMale, rdoFemale;
	private ArrayList<Staff> data = new ArrayList<Staff>();
	private StaffTableModel staff;
	private JLabel lblPassword,lblConfirmpsw, lblName, lblGender, lblNrc, lblAddress, lblPhoneNo, lblEmail, lblPosition;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Staff_Manage frame = new Staff_Manage(new Staff());
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
	public Staff_Manage(Staff s) throws SQLException {
		setTitle("VITALSIP Detox Juice");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Staff_Manage.class.getResource("/image/Logo-removebg-preview.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1330, 741);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.light"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Initialize the JRadioButtons
		rdoMale = new JRadioButton("Male");
		rdoFemale = new JRadioButton("Female");

		// Add JRadioButtons to ButtonGroup
		btnGender.add(rdoMale);
		btnGender.add(rdoFemale);

		lblName = new JLabel("Name          :");
		lblName.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblName.setBounds(20, 158, 126, 28);
		contentPane.add(lblName);

		lblGender = new JLabel("Gender        :");
		lblGender.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblGender.setBounds(20, 260, 169, 28);
		contentPane.add(lblGender);

		lblNrc = new JLabel("NRC            : ");
		lblNrc.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblNrc.setBounds(20, 227, 126, 28);
		contentPane.add(lblNrc);

		lblAddress = new JLabel("Address      :");
		lblAddress.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblAddress.setBounds(20, 336, 169, 28);
		contentPane.add(lblAddress);

		lblPhoneNo = new JLabel("Phone No   : ");
		lblPhoneNo.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblPhoneNo.setBounds(20, 298, 169, 28);
		contentPane.add(lblPhoneNo);

		rdoMale = new JRadioButton("Male");
		btnGender.add(rdoMale);
		rdoMale.setBackground(UIManager.getColor("Button.light"));
		rdoMale.setFont(new Font("Mongolian Baiti", Font.PLAIN, 16));
		rdoMale.setBounds(174, 265, 74, 21);
		contentPane.add(rdoMale);

		rdoFemale = new JRadioButton("Female");
		btnGender.add(rdoFemale);
		rdoFemale.setBackground(UIManager.getColor("Button.light"));
		rdoFemale.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		rdoFemale.setBounds(260, 264, 103, 21);
		contentPane.add(rdoFemale);

		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		txtAddress.setColumns(10);
		txtAddress.setBounds(174, 336, 290, 54);
		contentPane.add(txtAddress);

		txtPhno = new JTextField();
		txtPhno.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		txtPhno.setColumns(10);
		txtPhno.setBounds(174, 300, 290, 26);
		contentPane.add(txtPhno);

		lblEmail = new JLabel("Email          :");
		lblEmail.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblEmail.setBounds(20, 400, 126, 28);
		contentPane.add(lblEmail);

		txtName = new JTextField();
		txtName.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		txtName.setColumns(10);
		txtName.setBounds(174, 161, 290, 26);
		contentPane.add(txtName);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		txtEmail.setColumns(10);
		txtEmail.setBounds(174, 403, 290, 26);
		contentPane.add(txtEmail);

		txtNrc = new JTextField();
		txtNrc.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		txtNrc.setColumns(10);
		txtNrc.setBounds(373, 229, 91, 28);
		contentPane.add(txtNrc);

		lblPosition = new JLabel("Position     :");
		lblPosition.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblPosition.setBounds(20, 438, 126, 28);
		contentPane.add(lblPosition);

		cboPosition = new JComboBox();
		cboPosition.setBackground(UIManager.getColor("Button.light"));
		cboPosition.setModel(new DefaultComboBoxModel(new String[] {"None", "Admin", "Staff", "Customer", "Sale"}));
		cboPosition.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		cboPosition.setBounds(174, 440, 290, 28);
		contentPane.add(cboPosition);

	 comboBox2 = new JComboBox<>();
		comboBox2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				String d1[] = { "BaMaNa", "KhaHpaNa", "DaHpaYa", "HaPaNa", "HpaKaNa", "AhGaYa", "KaMaNa", "KaMaTa",
						"KaPaTa", "MaKhaBa", "MaSaNa", "MaKaTa", "MaNyaNa", "KhaLaHpa", "LaGaNa", "MaMaNa", "MaKaNa",
						"MaLaNa", "NaMaNa", "PaWaNa", "PaNaDa", "PaTaAh", "PaTaAh", "SaDaNa", "YaBaYa", "YaKaNa",
						"SaBaNa", "SaPaYa", "TaNaNa", "SaLaNa", "TaSaLa", "WaMaNa" };
				String d2[] = { "BaLaKha", "DaMaSa", "HpaSaNa", "HpaYaSa", "LaKaNa", "MaSaNa", "YaTaNa", "aThaNa" };
				String d3[] = { "BaGaLa", "LaBaNa", "BaAhNa", "HpaPaNa", "BaThaSa", "KaMaMa", "KaKaYa", "KaDaNa",
						"KaSaKa", "KaDaTa", "LaThaNa", "MaWaTa", "PaKaNa", "YaYaTha", "SaKaLa", "ThaTaNa", "ThaTaKa",
						"WaLaMa" };
				String d4[] = { "KaKhaNa", "HpaLaNa", "HaKhaNa", "KaPaLa", "MaTaPa", "MaTaNa", "PaLaWa", "YaZaNa",
						"YaKhaDa", "SaMaNa", "TaTaNa", "HtaTaLa", "TaZaNa" };
				String d5[] = { "AhYaTa", "BaMaNa", "BaTaLa", "KhaTaNa", "KhaOuTa", "HaMaLa", "AhTaNa", "KaLaHta",
						"KaLaWa", "KaBaLa", "KaNaNa", "KaThaNa", "KaLaTa", "KhaOuNa", "KaLaNa", "LaHaNa", "LaYaNa",
						"MaLaNa", "MaKaNa", "MaYaNa", "MaMaNa", "MaMaTa", "NaYaNa", "NgaZaNa", "PaLaNa", "HpaPaNa",
						"PaLaBa", "SaKaNa", "SaLaKa", "YaBaNa", "DaPaYa", "TaMaNa", "TaSaNa", "HtaKhaNa", "WaLaNa",
						"WaThaNa", "YaOuNa", "YaMaPa", "KaMaNa", "KhaPaNa" };
				String d6[] = { "BaPaNa", "HtaWaNa", "KaLaAh", "KaThaNa", "KaSaNa", "LaLaNa", "MaMaNa", "PaLaNa",
						"TaThaYa", "ThuYaKha", "YaHpaNa", "KhaMaNa", "MaTaNa", "PaLaTa", "MaAhYa", "MaAhYa", "KaYaYa" };
				String d7[] = { "DaOuNa", "KaPaKa", "KaWaNa", "KaKaNa", "KaTaKha", "LaPaTa", "MaLaNa", "MaNyaNa",
						"NaTaLa", "NyaLaPa", "AhHpaNa", "AhTaNa", "PaTaNa", "PaKhaTa", "PaKhaNa", "PaTaTa", "PaNaKa",
						"HpaMaNa", "PaMaNa", "YaTaNa", "YaKaNa", "HtaTaPa", "TaNgaNa", "ThaNaPa", "ThaWaTa", "ThaKaNa",
						"ThaSaNa", "WaMaNa", "YaTaYa", "ZaKaNa", "PaTaSa" };
				String d8[] = { "AhLaNa", "KhaMaNa", "GaGaNa", "KaMaNa", "MaKaNa", "MaBaNa", "MaTaNa", "MaLaNa",
						"MaMaNa", "MaHtaNa", "MaThaNa", "NaMaNa", "NgaHpaNa", "PaKhaKa", "PaMaNa", "PaHpaNa", "SaLaNa",
						"SaMaNa", "SaHpaNa", "SaTaYa", "SaPaWa", "TaTaKa", "ThaYaNa", "HtaLaNa", "YaNaKha", "YaSaKa",
						"MaHtaNa", "KaHtaNa", "MaTaNa" };
				String d9[] = { "AhMaYa", "AhMaZa", "KhaAhZa", "KhaMaSa", "KaPaTa", "KaSaNa", "MaTaYa", "MaHaMa",
						"MaLaNa", "MaYaMa", "MaYaTa", "MaNaMa", "MaNaTa", "MaHtaLa", "MaKaNa", "MaKhaNa", "MaThaNa",
						"NaHtaNa", "NaHtaKa", "NgaThaYa", "NgaZaNa", "NyaOuNa", "PaThaKa", "PaBaNa", "PaKaKha",
						"PaOuLa", "SaKaNa", "SaKaTa", "ThaPaKa", "TaTaOu", "TaThaNa", "ThaSaNa", "WaTaNa", "YaMaTha",
						"NgaThaYa", "TaKaNa", "TaKaTa", "MaMaNa", "DaKhaTha", "LaWaNa", "OuTaTha", "PaBaTha", "PaMaNa",
						"TaKaNa", "ZaBaTha", "ZaYaTha" };
				String d10[] = { "BaLaNa", "KhaSaNa", "KhaZaNa", "KaMaYa", "KaHtaNa", "LaMaNa", "MaLaMa", "MaDaNa",
						"PaMaNa", "ThaHpaYa", "ThaHtaNa", "YaMaNa" };
				String d11[] = { "AaMaNa", "BaThaTa", "GaMaNa", "KaHpaNa", "KaTaNa", "MaAhNa", "MaAhTa", "MaTaNa",
						"MaPaNa", "MaAhNa", "MaOuNa", "MaPaTa", "PaTaNa", "PaNaKa", "PaNaTa", "YaBaNa", "YaThaTa",
						"SaTaNa", "ThaTaNa", "TaKaNa", "KaTaLa", "TaPaWa" };
				String d12[] = { "AhLaNa", "BaHaNa", "BaTaHta", "KaKaKa", "DaGaYa", "DaGaMa", "DaGaSa", "DaGaTa",
						"DaGaNa", "DaLaNa", "DaPaNa", "LaThaYa", "LaMaNa", "LaKaNa", "MaBaNa", "HtaTaPa", "AhSaNa",
						"KaMaYa", "KaMaNa", "KhaYaNa", "KaKhaKa", "KaTaTa", "KaTaNa", "KaMaTa", "LaMaTa", "LaThaYa",
						"MaYaKa", "MaGaDa", "MaGaTa", "OuKaMa", "PaBaTa", "PaZaTa", "SaKhaNa", "SaKaKha", "SaKaNa",
						"YaPaTha", "OuKaTa", "TaTaHta", "TaKaNa", "TaMaNa", "ThaKaTa", "ThaLaNa", "ThaGaKa", "ThaKhaNa",
						"TaTaNa", "YaKaNa", "OuKaNa" };

				String d13[] = { "AhKhaNa", "KhaYaHa", "KhaMaNa", "HaTaNa", "HaPaNa", "HaPaTa", "SaHpaNa", "ThaNaNa",
						"SaSaNa", "ThaPaNa", "KaLaHpa", "KaLaNa", "KaLaDa", "KaMaSa", "KaTaNa", "KaYaNa", "KaTaTa",
						"KaHaNa", "KaLaNa", "KaLaTa", "KaKhaNa", "KaMaNa", "KaTaLa", "KaThaNa", "LaKhaNa", "LaKhaTa",
						"LaYaNa", "LaKaNa", "LaKaTa", "LaKhaNa", "LaHaNa", "LaLaNa", "LaHtaNa", "MaBaNa", "MaMaSa",
						"MaTaNa", "MaTaTa", "MaMaNa", "MaHpaNa", "MaKaNa", "MaPaNa", "MaHpaNa", "MaSaNa", "MaYaNa",
						"MaKhaNa", "MaLaNa", "MaMaNa", "MaMaTa", "MaMaNa", "MaMaTa", "MaNaNa", "MaPaNa", "MaPaNa",
						"MaTaNa", "MaYaTa", "MaYaNa", "MaYaNa", "MaSaTa", "NaKhaWa", "NaTaNa", "NaKhaTa", "NaKhaNa",
						"NaMaTa", "NaHpaNa", "NaSaNa", "NaSaNa", "NaKaNa", "NaWaNa", "NaPhaNa", "NaKhaNa", "NakhaTa",
						"NyaYaNa", "PaKhaNa", "PaYaNa", "PaSaNa", "PaWaNa", "HpaKhaNa", "PaTaYa", "PaLaNa", "TaKhaLa",
						"TaYaNa", "TaKhaNa", "YaLaNa", "YaSaNa", "YaHpaNa", "YaNgaNa", "NaTaYa", "PaLaTa", "KhaLaNa",
						"PaPaKa", "MaHaYa", "TaMaNya", "MaBaNa", "MaNgaNa", "AhTaNa", "TaLaNa" };
				String d14[] = { "AhMaTa", "BaKaLa", "DaNaHpa", "DaDaYa", "AhMaNa", "HaKaKa", "HaThaTa", "AhGaPa",
						"KaKaHta", "KaLaNa", "KaKhaNa", "KaKaNa", "KaPaNa", "LaPaTa", "LaMaNa", "MaAhNa", "MaMaNa",
						"NgaPaTa", "NgaThaKha", "NgaYaKa", "NgaSaNa", "NgaThaYa", "NyaTaNa", "PaTaNa", "PaThaNa",
						"HpaPaNa", "PaSaLa", "YaThaYa", "ThaPaNa", "WaKhaMa", "YaKaNa", "ZaLaNa", "PaThaYa" };
				 comboBox1.removeAllItems();
				if (comboBox2.getSelectedIndex() == 1) {
					for (int i = 0; i < d1.length; i++)
						 comboBox1.addItem(d1[i]);
				} else {
					if (comboBox2.getSelectedIndex() == 2) {
						for (int i = 0; i < d2.length; i++)
							comboBox1.addItem(d2[i]);
					} else {
						if (comboBox2.getSelectedIndex() == 3) {
							for (int i = 0; i < d3.length; i++)
								comboBox1.addItem(d3[i]);
						} else {
							if (comboBox2.getSelectedIndex() == 4) {
								for (int i = 0; i < d4.length; i++)
									comboBox1.addItem(d4[i]);
							} else {
								if (comboBox2.getSelectedIndex() == 5) {
									for (int i = 0; i < d5.length; i++)
										comboBox1.addItem(d5[i]);
								} else {
									if (comboBox2.getSelectedIndex() == 6) {
										for (int i = 0; i < d6.length; i++)
											comboBox1.addItem(d6[i]);
									} else {
										if (comboBox2.getSelectedIndex() == 7) {
											for (int i = 0; i < d7.length; i++)
												comboBox1.addItem(d7[i]);
										} else {
											if (comboBox2.getSelectedIndex() == 8) {
												for (int i = 0; i < d8.length; i++)
													comboBox1.addItem(d8[i]);
											} else {
												if (comboBox2.getSelectedIndex() == 9) {
													for (int i = 0; i < d9.length; i++)
														comboBox1.addItem(d9[i]);
												} else {
													if (comboBox2.getSelectedIndex() == 10) {
														for (int i = 0; i < d10.length; i++)
															comboBox1.addItem(d10[i]);
													} else {
														if (comboBox2.getSelectedIndex() == 11) {
															for (int i = 0; i < d11.length; i++)
																comboBox1.addItem(d11[i]);
														} else {
															if (comboBox2.getSelectedIndex() == 12) {
																for (int i = 0; i < d12.length; i++)
																	comboBox1.addItem(d12[i]);
															} else {
																if (comboBox2.getSelectedIndex() == 13) {
																	for (int i = 0; i < d13.length; i++)
																		comboBox1.addItem(d13[i]);
																} else {
																	if (comboBox2.getSelectedIndex() == 14) {
																		for (int i = 0; i < d14.length; i++)
																			comboBox1.addItem(d14[i]);
																	}
																}
															}
														}
													}

												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
				
			
			
			
			
		});
		comboBox2.setModel(new DefaultComboBoxModel(new String[] { "", "1/", "2/", "3/", "4/", "5/", "6/", "7/", "8/",
				"9/", "10/", "11/", "12/", "13/", "14/" }));
		comboBox2.setBackground(UIManager.getColor("Button.light"));
		comboBox2.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		comboBox2.setBounds(174, 229, 58, 28);
		contentPane.add(comboBox2);

		txtn = new JTextField();
		txtn.setText(" (N)");
		txtn.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		txtn.setColumns(10);
		txtn.setBounds(334, 230, 35, 28);
		contentPane.add(txtn);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(81, 192, 61));
		panel.setBounds(0, 0, 1316, 48);
		contentPane.add(panel);

		JLabel lblAdmin = new JLabel("Admin ");
		lblAdmin.setIcon(new ImageIcon(Staff_Manage.class.getResource("/image/people icon.png")));
		lblAdmin.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblAdmin.setBounds(1211, 5, 95, 42);
		panel.add(lblAdmin);
		
		JLabel lblAdminDashboard = new JLabel("Vitalsip Detox Juice");
		lblAdminDashboard.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblAdminDashboard.setBounds(0, 0, 486, 49);
		panel.add(lblAdminDashboard);

		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				try {
					ArrayList<Staff>ur=new CRUD_Dao().AddStaffTable();
					
					
					String keyword=txtSearch.getText().trim().toLowerCase();
					data.clear();
					data.addAll((ArrayList<Staff>) ur.stream()
							.filter(u ->u.getName().toLowerCase().contains(keyword)||u.getGender().toLowerCase().contains(keyword))
							.collect(Collectors.toList()));
					staff.fireTableDataChanged();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		txtSearch.setFont(new Font("Monospaced", Font.PLAIN, 14));
		txtSearch.setColumns(10);
		txtSearch.setBounds(1001, 150, 280, 26);
		contentPane.add(txtSearch);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(488, 188, 818, 457);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		scrollPane.setViewportView(table);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {


		 		int selectedRow = table.getSelectedRow();

		        if (selectedRow != -1) {
		           
		            int productId = (int) table.getValueAt(selectedRow, 0);

		            try {
		               
		               Staff customer = new CRUD_Dao().getStaffrById(productId);

		                if (customer != null) {
		                    // Populate the text fields and combo box with the product data
		                    txtName.setText(customer.getName());
		                    txtEmail.setText(String.valueOf(customer.getEmail()));
		                   // Dob.setDate(customer.getDob());
		                    
		                    Date dob = customer.getDob();
		                    if (dob != null) {
		                        Dob.setDate(dob); 
		                    } else {
		                        Dob.setDate(null); 
		                    }
			        
		                    if (customer.getGender().equalsIgnoreCase("Male")) {
		                    	btnGender.setSelected(rdoMale.getModel(), true);
		                    } else if (customer.getGender().equalsIgnoreCase("Female")) {
		                    	btnGender.setSelected(rdoFemale.getModel(), true);
		                    } else {
		                    	btnGender.clearSelection(); // Clear if gender is not Male/Female
		                    }
		                    
		                   
		                    String position = customer.getPosition();
		                    if (position != null) {
		                        cboPosition.setSelectedItem(position); 
		                    } else {
		                        cboPosition.setSelectedItem("");
		                    }
					       // cboPosition.setSelectedItem(customer.getPosition());
		                    txtAddress.setText(String.valueOf(customer.getAddress()));
					        
		                    txtPhno.setText(String.valueOf(customer.getPhno()));
		                 
		                    
		                    JComboBox comboBox = comboBox2  ;  // Your JComboBox instance
		                    Object selectedItem = comboBox.getSelectedItem();

		                    if (selectedItem != null) {
		                        String selectedValue = selectedItem.toString();
		                        // Proceed with using selectedValue
		                    } else {
		                        JOptionPane.showMessageDialog(null, "Please select an item from the dropdown.");
		                    }

		                    
		                    
		                } else {
		                    JOptionPane.showMessageDialog(null, "Product not found in the database.");
		                }

		            } catch (SQLException ex) {
		                ex.printStackTrace();
		                JOptionPane.showMessageDialog(null, "An error occurred while fetching product data.");
		            }

		        } else {
		            System.out.println("No row is selected.");
		        }
		    }
		});

		// Fetch data and update the table
		CRUD_Dao b=new CRUD_Dao();
		data=new CRUD_Dao().AddStaffTable();
		staff=new StaffTableModel(data);
		
				table.setModel(staff);
//				new DefaultTableModel(
//					new Object[][] {
//					},
//					new String[] {
//						"NO", "Name", "Gender", "Phone NO", "Position"
//					}
//				) {
//					boolean[] columnEditables = new boolean[] {
//						false, true, false, false, false
//					};
//					public boolean isCellEditable(int row, int column) {
//						return columnEditables[column];
//					}
//				});
				table.getColumnModel().getColumn(0).setResizable(false);
				table.getColumnModel().getColumn(2).setResizable(false);
				table.getColumnModel().getColumn(4).setResizable(false);
				//configureTable(table);

			
		 comboBox1 = new JComboBox<>();
		comboBox1.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		comboBox1.setBackground(UIManager.getColor("Button.light"));
		comboBox1.setBounds(233, 229, 97, 28);
		contentPane.add(comboBox1);

		comboBox2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new populateTownships(comboBox1, comboBox2);
			}
		});

		JButton btnSearch = new JButton("");
		btnSearch.setIcon(new ImageIcon(Staff_Manage.class.getResource("/Image/refresh-data.png")));
		btnSearch.setFont(new Font("Monospaced", Font.PLAIN, 11));
		btnSearch.setBackground(new Color(34, 139, 34));
		btnSearch.setBounds(1282, 150, 24, 25);
		contentPane.add(btnSearch);

		JLabel lblNewLabel = new JLabel("Manage Staff");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(10, 79, 1139, 43);
		contentPane.add(lblNewLabel);

		JLabel lblDob = new JLabel("DOB           :");
		lblDob.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblDob.setBounds(20, 193, 126, 28);
		contentPane.add(lblDob);

		JLabel lblAddNewStaff = new JLabel("Registration New Staff");
		lblAddNewStaff.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		lblAddNewStaff.setBounds(10, 120, 238, 28);
		contentPane.add(lblAddNewStaff);

		JLabel lblCreateNewAccount = new JLabel("Create New Account");
		lblCreateNewAccount.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		lblCreateNewAccount.setBounds(10, 477, 186, 28);
		contentPane.add(lblCreateNewAccount);

		 lblPassword = new JLabel("Create password    :");
		lblPassword.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblPassword.setBounds(10, 548, 169, 28);
		contentPane.add(lblPassword);

		 lblConfirmpsw = new JLabel("Confirm password :");
		lblConfirmpsw.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblConfirmpsw.setBounds(10, 587, 144, 28);
		contentPane.add(lblConfirmpsw);

		txtpassword = new JPasswordField();
		txtpassword.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		txtpassword.setBounds(174, 548, 290, 26);
		contentPane.add(txtpassword);

		txtconfirm = new JPasswordField();
		txtconfirm.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		txtconfirm.setBounds(174, 587, 290, 26);
		contentPane.add(txtconfirm);

		Dob = new JDateChooser();
		Dob.setBounds(174, 198, 289, 23);
		contentPane.add(Dob);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkInput()) {
					
				String name = txtName.getText().trim();
				String gender = rdoMale.isSelected() ? "Male" : rdoFemale.isSelected() ? "Female" : "";
				String nrc = comboBox2.getSelectedItem().toString() + comboBox1.getSelectedItem().toString() +txtn.getText().trim()
						+ txtNrc.getText().trim();
				String phoneNumber = txtPhno.getText().trim();
				String address = txtAddress.getText().trim();
				String email = txtEmail.getText().trim();
				String password = txtpassword.getText().trim();
				String confirmPassword = txtconfirm.getText().trim();
				String username = txtUsername.getText().trim();
				Date d=new Date(Dob.getDate().getTime());
				 String position = cboPosition.getSelectedItem() != null ? cboPosition.getSelectedItem().toString() : "";

				// Perform validations
				if (!checkName(name)) {
					showMessage(
							"Invalid Name. Name must start with a letter and can only contain letters, numbers, and spaces.");
					return;
				}

				if (!validatePhoneNumber(phoneNumber)) {
					showMessage("Invalid Phone Number. Please enter a valid Myanmar phone number.");
					return;
				}

				if (!validateEmail(email)) {
					showMessage("Invalid Email. Please enter a valid email address.");
					return;
				}

				if (!checkAddress()) {
					showMessage("Address cannot be empty.");
					return;
				}

				// If all validations pass, save the data to the database
				Staff staff = new Staff(); // Assuming you have a Staff class
				staff.setName(name);
				staff.setGender(gender);
				staff.setNRC(nrc);
				staff.setPhno(phoneNumber);
				staff.setAddress(address);
				staff.setEmail(email);
				staff.setDob(d);
				staff.setPosition(position);
				

				try {
					CRUD_Dao dao = new CRUD_Dao(); // Assuming you have a StaffDAO class for database operations
					int id=dao.addStaff(staff); // Save the staff to the database
					Account account = new Account();
					account.setPassword(password);
					account.setUsername(username);
					account.setStaffID(id);
					

					
					new CRUD_Dao().CreateAccount(account);
					showMessage("Staff saved successfully.");
				} catch (Exception ex) {
					showMessage("Error saving staff: " + ex.getMessage());
				}
			}
			}	
			
		});
		
		btnSave.setIcon(new ImageIcon(Staff_Manage.class.getResource("/Image/save.png")));
		btnSave.setBackground(new Color(50, 205, 50));
		btnSave.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnSave.setBounds(354, 660, 107, 33);
		contentPane.add(btnSave);

		JButton btnClear = new JButton("Clear");
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Clear();
			}
		});
		btnClear.setIcon(new ImageIcon(Staff_Manage.class.getResource("/image/clear-format.png")));
		btnClear.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnClear.setBackground(new Color(50, 205, 50));
		btnClear.setBounds(233, 660, 111, 33);
		contentPane.add(btnClear);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				 staff = (StaffTableModel) table.getModel();
			        int selectedRow = table.getSelectedRow();

			        if (selectedRow != -1) {
			            int id = (int) staff.getValueAt(selectedRow, 0); 
			            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
			            
			            if (confirm == JOptionPane.YES_OPTION) {
			                try {
			                    
			                  new CRUD_Dao().deleteStaffById(id);
			                    
			                    
			                  staff.removeRow(selectedRow);
			                    
			                    JOptionPane.showMessageDialog(null, "Record deleted successfully.");
			                } catch (SQLException ex) {
			                    ex.printStackTrace();
			                    JOptionPane.showMessageDialog(null, "Failed to delete the record. Please try again.");
			                }
			            }
			        } else {
			            if (table.getRowCount() == 0) {
			                JOptionPane.showMessageDialog(null, "Table is empty!");
			            } else {
			                JOptionPane.showMessageDialog(null, "Please select a row for deletion.");
			            }
			        }
			        
			        Clear(); 
				
			
			
			}
		});
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		btnDelete.setIcon(new ImageIcon(Staff_Manage.class.getResource("/Image/delete.png")));
		btnDelete.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnDelete.setBackground(new Color(50, 205, 50));
		btnDelete.setBounds(1199, 660, 107, 33);
		contentPane.add(btnDelete);

		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				contentPane.removeAll();

				 new Edit_Staff(s).setVisible(true);;
//				contentPane.add(editStaffPanel);
//
//				contentPane.repaint();
//				contentPane.revalidate();

				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) {

					int id = (int) table.getValueAt(selectedRow, 0);
					String name = txtName.getText().trim();
					String gender = rdoMale.isSelected() ? "Male" : rdoFemale.isSelected() ? "Female" : "";
					Object comboBox1SelectedItem = comboBox1.getSelectedItem();
				    Object comboBox2SelectedItem = comboBox2.getSelectedItem();
				    
				    // Check if the selected item is not null before calling toString()
				    String comboBox1Value = (comboBox1SelectedItem != null) ? comboBox1SelectedItem.toString() : "";
				    String comboBox2Value = (comboBox2SelectedItem != null) ? comboBox2SelectedItem.toString() : "";

				    String nrc = comboBox2Value + comboBox1Value + txtn.getText().trim() + txtNrc.getText().trim();
//					String nrc = comboBox2.getSelectedItem().toString() + comboBox1.getSelectedItem().toString()
//							+ txtNrc.getText().trim();
					//Date dob = (Date) chooserDob.getDate();
					java.util.Date utilDate = Dob.getDate();  // Get date from JDateChooser
				    if (utilDate != null) {
				        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());  // Convert to java.sql.Date if needed
				        System.out.println("Date of Birth: " + sqlDate);
				    } else {
				        System.out.println("No date selected.");
				    }
					String phoneNumber = txtPhno.getText().trim();
					String address = txtAddress.getText().trim();
					String email = txtEmail.getText().trim();
					String password = txtpassword.getText().trim();
					
					String position = cboPosition.getSelectedItem().toString().trim();
					
					
					Pattern pattern = Pattern.compile("(\\d{1,2})/(\\w+)(\\(N\\))(\\d{6})");
					Matcher matcher = pattern.matcher(nrc);

					if (matcher.matches()) {
					    comboBox2.setSelectedItem(matcher.group(1) + "/");  // Set the first part (e.g., "12/")
					    comboBox1.setSelectedItem(matcher.group(2));        // Set the second part (e.g., "ABC")
					    txtn.setText(matcher.group(3).replaceAll("[()]", "")); // Set the third part, without parentheses (e.g., "N")
					    txtNrc.setText(matcher.group(4));                  // Set the fourth part (e.g., "123456")
					} else {
					    // Handle the case where the NRC format does not match
					    System.out.println("NRC format does not match: " + nrc);
					}

					// Set product data in the edit panel
					Edit_Staff editStaffFrame = new Edit_Staff(s);
					editStaffFrame.populateStaffDetails(name, utilDate, nrc, gender, phoneNumber, address, email, position);
					editStaffFrame.setVisible(true);

				}

//				new Edit_Staff().setVisible(true);
				dispose();
			}
		});
		btnEdit.setIcon(new ImageIcon(Staff_Manage.class.getResource("/image/editor.png")));
		btnEdit.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnEdit.setBackground(new Color(50, 205, 50));
		btnEdit.setBounds(1082, 660, 107, 33);
		contentPane.add(btnEdit);

		JButton btnView = new JButton("View");
		btnView.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					new View_Customer(s).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		btnView.setForeground(new Color(0, 0, 0));
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				contentPane.removeAll();
				
		        
				View_ManageStaff viewProductPanel = null;
		        viewProductPanel = new View_ManageStaff(s);
				contentPane.add(viewProductPanel);
				contentPane.add(viewProductPanel,BorderLayout.CENTER);
		        
				java.util.Date utilDate = Dob.getDate();  // Get date from JDateChooser
			    if (utilDate != null) {
			        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());  // Convert to java.sql.Date if needed
			        System.out.println("Date of Birth: " + sqlDate);
			    } else {
			        System.out.println("No date selected.");
			    }
//				viewProductPanel.setSize(580,620);
				setSize(527,738);
				
				viewProductPanel.setLocation(0,0);
		        contentPane.repaint();
		        contentPane.revalidate();
		        
		        new Product_Manage(s).setVisible(false);
		        
		        int selectedRow = table.getSelectedRow();
				if(selectedRow != -1 ) {
					
					int id = (int) table.getValueAt(selectedRow, 0);
					String name=txtName.getText().trim();
					
				       // panel.add(cboSize);
				        String address=txtAddress.getText().toString();
				         String position = cboPosition.getSelectedItem().toString();
				         String nrc=txtNrc.getText().toString();
		                String email = txtEmail.getText().trim();
		                String phone = txtPhno.getText().trim();
		                String gender = "";
				        if ("Male".equals(gender)) {
				            rdoMale.setSelected(true);
				        } else if ("Female".equals(gender)) {
				            rdoFemale.setSelected(true);
				        }

//	              
	                viewProductPanel.populateStaffDetails(name,utilDate, email,gender, phone, nrc, position, address);
		                
	            }
	        
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(null, "An error occurred while processing the data.");
	        }
			}
			
		});

		btnView.setIcon(new ImageIcon(Staff_Manage.class.getResource("/image/view-grid-detail.png")));
		btnView.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnView.setBackground(new Color(50, 205, 50));
		btnView.setBounds(965, 660, 107, 33);
		contentPane.add(btnView);

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
		btnBack.setIcon(new ImageIcon(Staff_Manage.class.getResource("/image/back.png")));
		btnBack.setFont(new Font("Mongolian Baiti", Font.BOLD, 15));
		btnBack.setBackground(new Color(50, 205, 50));
		btnBack.setBounds(1199, 89, 107, 33);
		contentPane.add(btnBack);

		JLabel lblUsername = new JLabel("Username               :");
		lblUsername.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblUsername.setBounds(10, 509, 169, 28);
		contentPane.add(lblUsername);

		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		txtUsername.setColumns(10);
		txtUsername.setBounds(174, 511, 290, 26);
		contentPane.add(txtUsername);
		
		JCheckBox chckbxShow = new JCheckBox("Show Password");
		chckbxShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (chckbxShow.isSelected()) {
		            // Show all password fields
		            txtconfirm.setEchoChar((char) 0);
		           
		            txtpassword.setEchoChar((char) 0);
		        } else {
		            // Hide all password fields (set to default echo char for password fields)
		        	txtconfirm.setEchoChar('*');
		           
		        	txtpassword.setEchoChar('*');
		        }
			}
		});
		chckbxShow.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		chckbxShow.setBackground(UIManager.getColor("Button.light"));
		chckbxShow.setBounds(327, 617, 137, 28);
		contentPane.add(chckbxShow);
		
		JLabel lblSearchHere = new JLabel("Search Here :");
		lblSearchHere.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblSearchHere.setBounds(893, 149, 107, 28);
		contentPane.add(lblSearchHere);

	}

	
	public boolean checkInput(){
	    if( checkAddress() &checkGender()& checkPassword()&checkEmail()& checkConfirm() & checkAddress1() & checkNRCNO() & checkNRC() & checkPositoin() & checkAddress() ){  return true;}
	    else return false;
	  }
	  
	  
	  
	  
	  public boolean checkNRCNO(){
	    if(txtNrc.getText().isEmpty() || !(Pattern.matches("\\d{6}",txtNrc.getText().toString().trim()))){
	      txtNrc.setForeground(Color.RED);
	      txtNrc.setBorder(new LineBorder(Color.RED));
	      txtNrc.setText("");
	      txtNrc.requestFocus();
	      return false;
	    }else{
	      txtNrc.setForeground(Color.BLACK);
	      txtNrc.setBorder(new LineBorder(Color.BLACK));
	      return true;
	    }
	  }
	  
	  
	  public boolean checkPositoin(){
	    if(cboPosition.getSelectedIndex()==0){
	      lblPosition.setForeground(Color.RED);
	      cboPosition.setBorder(new LineBorder(Color.RED));
	      return false;
	    }else{
	      lblPosition.setForeground(Color.BLACK);
	      cboPosition.setBorder(new LineBorder(Color.BLACK));
	      return true;
	    }
	  }
	  
	  public boolean checkPassword() {
	    lblPassword.setVisible(false);
	    if(txtpassword.getText().trim().isEmpty()) {
	      lblPassword.setVisible(true);
	      lblPassword.setText("*");
	      return false;
	    }
	    if(txtpassword.getText().length()>=8) {
	      return true;
	    }
	    else {
	      lblPassword.setVisible(true);
	      lblPassword.setText("Enter 8 character");
	      return false;
	    }
	  }
	  
	  public boolean checkConfirm() {
	    lblConfirmpsw.setVisible(false);
	    if(txtconfirm.getText().trim().isEmpty()) {
	      lblConfirmpsw.setVisible(true);
	      lblConfirmpsw.setText("*");
	      return false;
	    }
	    if(txtconfirm.getText().equals(txtpassword.getText())) {
	      return true;
	      
	    }
	    else {
	      lblConfirmpsw.setVisible(true);
	      lblConfirmpsw.setText("Enter 8 character and same pervious password");
	      return false;
	    }
	  }
	  
	  public boolean checkNRC(){
	    if(comboBox2.getSelectedIndex()==0){
	  lblNrc.setForeground(Color.RED);
	      comboBox2.setBorder(new LineBorder(Color.RED));
	      comboBox1.setBorder(new LineBorder(Color.RED));
	//    
	      return false;
	    }else{
	      lblNrc.setForeground(Color.BLACK);
	      comboBox2.setBorder(new LineBorder(Color.BLACK));
	      comboBox1.setBorder(new LineBorder(Color.BLACK));
	      txtNrc.setBorder(new LineBorder(Color.BLACK));
	      return true;
	    }
	  }
	  
	  public boolean checkAddress1(){
	    if(txtAddress.getText().isEmpty()){
	      //label_9.setForeground(Color.RED);
	      txtAddress.setBorder(new LineBorder(Color.RED));
	      txtAddress.setText("");
	      txtAddress.requestFocus();
	      return false;
	    }else{
	      //label_9.setForeground(Color.BLACK);
	      txtAddress.setBorder(new LineBorder(Color.BLACK));
	      return true;
	    }
	  }
	  
	  public static boolean checkName(String name) {
	    // Check if the name starts with a letter, ends with a letter, and contains only
	    // valid characters
	    return name != null && !name.trim().isEmpty() // Ensure the name is not empty or just whitespace
	        && name.matches("[a-zA-Z][a-zA-Z0-9]*( [a-zA-Z0-9]+)*"); // Name must start with a letter, and can be
	                                      // followed by letters, numbers, and single
	                                      // spaces
	  }

	  public static boolean validatePhoneNumber(String phoneNumber) {
	    // Remove all non-digit characters except for leading '+'
	    String cleanedNumber = phoneNumber.replaceAll("[^\\d+]", "");

	    // Check for phone number with country code
	    if (cleanedNumber.matches("\\+95[0-9]{9,10}")) {
	      return true; // Valid Myanmar number with country code
	    }

	    // Check for phone number without country code
	    if (cleanedNumber.matches("09[0-9]{9}")) {
	      return true; // Valid Myanmar mobile number without country code
	    }

	    // Check for landline numbers (e.g., 01XXXXXXXX or 0XYYYYYYYY)
	    if (cleanedNumber.matches("0[1-9][0-9]{7,8}")) {
	      return true; // Valid Myanmar landline number
	    }
	    
	    return false; // Invalid phone number
	  }
	  
	  public boolean checkEmail(){
	    if(txtName.getText().isEmpty()){
	      lblEmail.setForeground(Color.RED);
	      txtEmail.setBorder(new LineBorder(Color.RED));
	      txtEmail.setText("");
	      txtEmail.requestFocus();
	      return false;
	    }else{
	      if(Pattern.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", txtEmail.getText().trim()))
	      {
	      return true;
	      }
	    
	      lblEmail.setForeground(Color.BLACK);
	      
	      txtEmail.setBorder(new LineBorder(Color.BLACK));
	      return true;
	    }
	    
	  }

	  public static boolean validateEmail(String email) {
	    // Regular expression for validating email addresses
	    String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

	    // Check if the email matches the regex
	    return email != null && email.matches(emailRegex);
	  }
	  
	  

	  private void showMessage(String message) {
	    JOptionPane.showMessageDialog(this, message);
	  }

	  public boolean checkAddress() {
	    if (txtAddress.getText().isEmpty()) {
	      lblAddress.setForeground(Color.RED);
	      txtAddress.setBorder(new LineBorder(Color.RED));
	      txtAddress.setText("");
	      txtAddress.requestFocus();
	      return false;
	    } else {
	      lblAddress.setForeground(Color.BLACK);
	      txtAddress.setBorder(new LineBorder(Color.BLACK));
	      return true;
	    }
	  }

	  

	  public void Clear() {
	    txtName.setText("");
	    Dob.setDate(null);
	    comboBox2.setSelectedIndex(-1);
	    comboBox1.setSelectedIndex(-1);
	    txtNrc.setText("");
	    btnGender.clearSelection();
	    txtPhno.setText("");
	    txtAddress.setText("");
	    txtEmail.setText("");
	    txtUsername.setText("");
	    cboPosition.setSelectedItem("");
	    txtpassword.setText("");
	    txtconfirm.setText("");
	  }

	  public void populateStaffDetails(String name, Date dob, String nrc, String gender, String phno, String address,
	      String email, String position) {

	    String itemValue = "ItemValue"; // The value you want to select
	    comboBox2.setSelectedItem(itemValue); // This selects the item with the specified value

	    String itemValue2 = "ItemValue"; // The value you want to select
	    comboBox1.setSelectedItem(itemValue2); // This selects the item with the specified value

	    txtName.setText(name);
	    Dob.setDate(dob);
	    txtNrc.setText(nrc);
	    if ("Male".equalsIgnoreCase(gender)) {
	      rdoMale.setSelected(true);
	    } else if ("Female".equalsIgnoreCase(gender)) {
	      rdoFemale.setSelected(true);
	    } else {
	      // Handle case for invalid or no gender if necessary
	      btnGender.clearSelection();
	    }
	    txtPhno.setText("");
	    txtAddress.setText("");
	    txtEmail.setText("");
	    cboPosition.setSelectedItem("");

	  }
	  
	  public boolean checkGender(){
	    if(btnGender.isSelected(null)){
	      lblGender.setForeground(Color.RED);
	      return false;
	    }else{
	      lblGender.setForeground(Color.BLACK);
	      return true;
	    }
	  }

	  public void selectGender(String gender) {
	    if ("Male".equalsIgnoreCase(gender)) {
	      rdoMale.setSelected(true);
	    } else if ("Female".equalsIgnoreCase(gender)) {
	      rdoFemale.setSelected(true);
	    }
	    // Handle other cases if necessary
	  }
}
