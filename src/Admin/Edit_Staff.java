package Admin;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
import java.sql.Date;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

import Dao.CRUD_Dao;
import Dao.Other_Dao;
import DetoxProduct.Product_Manage;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class Edit_Staff extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtName;
	private JTextField txtn;
	private JTextField txtNrc;
	private JTextField txtPhno;
	private JTextField txtAddress;
	private JTextField txtEmail;
	private JDateChooser chooserDob;
	private JComboBox comboBox2, comboBox1;
	private final ButtonGroup btnGender = new ButtonGroup();
	private JComboBox cboPosition ;
	private JRadioButton rdoMale, rdoFemale;

	/**
	 * Create the panel.
	 */
	public Edit_Staff(Staff s) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Edit_Staff.class.getResource("/Image/Logo-removebg-preview.png")));
		getContentPane().setBackground(UIManager.getColor("Button.light"));
        setTitle("VITALSIP Detox Juice");
        setBounds(0, 0, 540, 738);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        
        initializeNrcOptions();

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(81, 192, 61));
        panel.setBounds(0, 0, 530, 54);
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
		lblAdminDashboard.setBounds(0, 3, 486, 49);
		panel.add(lblAdminDashboard);

		JLabel lblName = new JLabel("Name          :");
		lblName.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblName.setBounds(33, 151, 126, 28);
		getContentPane().add(lblName);

		txtName = new JTextField();
		txtName.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		txtName.setColumns(10);
		txtName.setBounds(187, 154, 290, 26);
		getContentPane().add(txtName);

		JLabel lblDob = new JLabel("DOB           :");
		lblDob.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblDob.setBounds(33, 203, 126, 28);
		getContentPane().add(lblDob);

		chooserDob = new JDateChooser();
		chooserDob.setBounds(187, 203, 289, 23);
		getContentPane().add(chooserDob);

		JLabel lblNrc = new JLabel("NRC            : ");
		lblNrc.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblNrc.setBounds(33, 253, 126, 28);
		getContentPane().add(lblNrc);

		comboBox2 = new JComboBox();
		comboBox2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		comboBox2.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		comboBox2.setBackground(UIManager.getColor("Button.light"));
		comboBox2.setBounds(187, 255, 58, 28);
		getContentPane().add(comboBox2);

		comboBox1 = new JComboBox();
		comboBox1.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		comboBox1.setBackground(UIManager.getColor("Button.light"));
		comboBox1.setBounds(246, 255, 97, 28);
		getContentPane().add(comboBox1);

		txtn = new JTextField();
		txtn.setText(" (N)");
		txtn.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		txtn.setColumns(10);
		txtn.setBounds(347, 256, 35, 28);
		getContentPane().add(txtn);

		txtNrc = new JTextField();
		txtNrc.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		txtNrc.setColumns(10);
		txtNrc.setBounds(386, 256, 91, 26);
		getContentPane().add(txtNrc);

		JLabel lblGender = new JLabel("Gender        :");
		lblGender.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblGender.setBounds(33, 301, 169, 28);
		getContentPane().add(lblGender);

		rdoMale = new JRadioButton("Male");
		btnGender.add(rdoMale);
		rdoMale.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		rdoMale.setBackground(UIManager.getColor("Button.light"));
		rdoMale.setBounds(187, 306, 74, 21);
		getContentPane().add(rdoMale);

		rdoFemale = new JRadioButton("Female");
		btnGender.add(rdoFemale);
		rdoFemale.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		rdoFemale.setBackground(UIManager.getColor("Button.light"));
		rdoFemale.setBounds(273, 305, 103, 21);
		getContentPane().add(rdoFemale);

		JLabel lblPhoneNo = new JLabel("Phone No   : ");
		lblPhoneNo.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblPhoneNo.setBounds(33, 350, 169, 28);
		getContentPane().add(lblPhoneNo);

		txtPhno = new JTextField();
		txtPhno.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		txtPhno.setColumns(10);
		txtPhno.setBounds(187, 352, 290, 26);
		getContentPane().add(txtPhno);

		JLabel lblAddress = new JLabel("Address      :");
		lblAddress.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblAddress.setBounds(33, 409, 169, 28);
		getContentPane().add(lblAddress);

		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		txtAddress.setColumns(10);
		txtAddress.setBounds(187, 409, 290, 54);
		getContentPane().add(txtAddress);

		JLabel lblEmail = new JLabel("Email          :");
		lblEmail.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblEmail.setBounds(33, 489, 126, 28);
		getContentPane().add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		txtEmail.setColumns(10);
		txtEmail.setBounds(187, 492, 290, 26);
		getContentPane().add(txtEmail);

		JLabel lblPosition = new JLabel("Position     :");
		lblPosition.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblPosition.setBounds(33, 546, 126, 28);
		getContentPane().add(lblPosition);

		cboPosition = new JComboBox();
		cboPosition.setModel(new DefaultComboBoxModel(new String[] {"None", "Admin", "Staff", "Customer"}));
		cboPosition.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		cboPosition.setBackground(UIManager.getColor("Button.light"));
		cboPosition.setBounds(187, 548, 290, 28);
		getContentPane().add(cboPosition);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new Staff_Manage(s).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		btnBack.setIcon(new ImageIcon(View_ManageStaff.class.getResource("/image/back.png")));
		btnBack.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnBack.setBackground(new Color(50, 205, 50));
		btnBack.setBounds(413, 72, 107, 33);
		getContentPane().add(btnBack);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

//					int sid=Integer.parseInt(txtID.getText());
					String name = txtName.getText().trim();

//			        JComboBox<String> comboBox = new JComboBox<>();
					String gender = rdoMale.isSelected() ? "Male" : rdoFemale.isSelected() ? "Female" : "";
					String nrc = comboBox2.getSelectedItem().toString() + comboBox1.getSelectedItem().toString()
							+ txtNrc.getText().trim();
					Date dob = (Date) chooserDob.getDate();
					String phoneNumber = txtPhno.getText().trim();
					String address = txtAddress.getText().trim();
					String email = txtEmail.getText().trim();
//					String password = passwordField.getText().trim();
					String position = cboPosition.getSelectedItem().toString().trim();
//			        comboBox.addItem(positon);

//					public Staff (int id, String name, String email, String gender, String phno, String NRC, String position, String address, Date dob) {

					Staff staff = new Staff(name, email, gender, nrc, position, address, dob);
					staff.setName(name);

					try {

						int id = new CRUD_Dao().updateStaff(staff);
						if (id > 0) {
							JOptionPane.showMessageDialog(null, "Update Successful");
							Clear();

							JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(Edit_Staff.this);

							parentFrame.dispose(); // This will close the current window

							Product_Manage productManageFrame = new Product_Manage(s);
							productManageFrame.setVisible(true);

						} else {
							JOptionPane.showMessageDialog(null, "Update failed. Please try again.");
						}
					} catch (NumberFormatException ex) {
						// Handle the case where input is not a valid number
						JOptionPane.showMessageDialog(null, "Please enter valid numbers for ID, quantity, and price.");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "An error occurred while updating the record.");
				}
				dispose();
			}
		});

		btnUpdate.setIcon(new ImageIcon(Edit_Staff.class.getResource("/image/folder-upload.png")));
		btnUpdate.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnUpdate.setBackground(new Color(50, 205, 50));
		btnUpdate.setBounds(411, 650, 109, 33);
		getContentPane().add(btnUpdate);
		
		JLabel lblEditStaff = new JLabel("Edit Staff Informatin");
		lblEditStaff.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditStaff.setForeground(Color.BLACK);
		lblEditStaff.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblEditStaff.setBackground(Color.LIGHT_GRAY);
		lblEditStaff.setBounds(0, 105, 530, 36);
		getContentPane().add(lblEditStaff);

	}
	
	private void initializeNrcOptions() {
		// TODO Auto-generated method stub
		
	}

	public void Clear() {
		txtName.setText("");
		chooserDob.setDate(null);
		comboBox2.setSelectedIndex(-1);
		comboBox1.setSelectedIndex(-1);
		txtNrc.setText("");
		btnGender.clearSelection();
		txtPhno.setText("");
		txtAddress.setText("");
		txtEmail.setText("");
		cboPosition.setSelectedItem("");
	}
	
	public void populateStaffDetails(String name, java.util.Date dob, String nrc, String gender, String phno, String address, String email, String position) {

//	    // Pattern to match the NRC format: 1/XX(N)123456
//	    Pattern pattern = Pattern.compile("(\\d{1,2})/(\\w+)\\((N)\\)(\\d{6})");
//	    Matcher matcher = pattern.matcher(nrc);
//
//	    // If the NRC format matches, populate the fields accordingly
//	    if (matcher.matches()) {
//	        comboBox2.setSelectedItem(matcher.group(1) + "/"); // Region/state number
//	        comboBox1.setSelectedItem(matcher.group(2)); // Township letters
//	        txtn.setText(matcher.group(3).replaceAll("[()]", ""));// N (no parentheses here, only the letter)
//	        txtNrc.setText(matcher.group(4)); // Last 6 digits
//	    } else {
//	        // Show an error message if the NRC format is incorrect
//	        JOptionPane.showMessageDialog(null, "NRC format is incorrect.");
//	    }

	    // Set other staff details
		String selectedValue1 = (String) comboBox1.getSelectedItem(); // Get the selected item from comboBox1
		String selectedValue2 = (String) comboBox2.getSelectedItem(); // Get the selected item from comboBox2
		
	    txtName.setText(name);
	    chooserDob.setDate(dob); // Set the date of birth
	    txtPhno.setText(phno);
	    txtAddress.setText(address);
	    txtn.setText(nrc);
	    txtNrc.setText(nrc);
	    txtEmail.setText(email);
	    cboPosition.setSelectedItem(position); // Set the position

	    // Set the gender based on the provided value
	    if ("Male".equalsIgnoreCase(gender)) {
	        rdoMale.setSelected(true);
	    } else if ("Female".equalsIgnoreCase(gender)) {
	        rdoFemale.setSelected(true);
	    } else {
	        btnGender.clearSelection(); // Clear if invalid gender
	    }
	}

}