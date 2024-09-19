package Admin;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import Constructors.Staff;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;

public class View_ManageStaff extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtName;
	private JTextField NRC3;
	private JTextField txtNRC4;
	private JTextField txtPhno;
	private JTextField txtAddress;
	private JTextField txtEmail;
	private JComboBox<String> comboBox2, comboBox1;
	private JDateChooser dateChooser ;
	private JComboBox cboPosition ;
	private final ButtonGroup btnGender = new ButtonGroup();
	private JComboBox NRC2,cboNrc1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdoFemale,rdoMale;
	/**
	 * Create the panel.
	 */
	public View_ManageStaff(Staff s) {
		getContentPane().setBackground(UIManager.getColor("Button.light"));
		setIconImage(Toolkit.getDefaultToolkit().getImage(View_ManageStaff.class.getResource("/Image/Logo-removebg-preview.png")));
		setTitle("VITALSIP Detox Juice");
		setBounds(0,0,543,738);
		setBackground(UIManager.getColor("Button.light"));
		getContentPane().setLayout(null);
		
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
		lblAdminDashboard.setBounds(0, 0, 486, 49);
		panel.add(lblAdminDashboard);
		
		JLabel lblStaffProfile = new JLabel("Staff Profile");
		lblStaffProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblStaffProfile.setForeground(Color.BLACK);
		lblStaffProfile.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblStaffProfile.setBackground(Color.LIGHT_GRAY);
		lblStaffProfile.setBounds(0, 115, 530, 36);
		getContentPane().add(lblStaffProfile);
		
		JLabel lblName = new JLabel("Name          :");
		lblName.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblName.setBounds(33, 161, 126, 28);
		getContentPane().add(lblName);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		txtName.setColumns(10);
		txtName.setBounds(187, 164, 290, 26);
		getContentPane().add(txtName);
		
		JLabel lblDob = new JLabel("DOB           :");
		lblDob.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblDob.setBounds(33, 213, 126, 28);
		getContentPane().add(lblDob);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(188, 217, 289, 23);
		getContentPane().add(dateChooser);
		
		JLabel lblNrc = new JLabel("NRC            : ");
		lblNrc.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblNrc.setBounds(33, 263, 126, 28);
		getContentPane().add(lblNrc);
		
		cboNrc1 = new JComboBox();
		cboNrc1.addItemListener(new ItemListener() {
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
				NRC2.removeAllItems();
				if (cboNrc1.getSelectedIndex() == 1) {
					for (int i = 0; i < d1.length; i++)
						NRC2.addItem(d1[i]);
				} else {
					if (cboNrc1.getSelectedIndex() == 2) {
						for (int i = 0; i < d2.length; i++)
							NRC2.addItem(d2[i]);
					} else {
						if (cboNrc1.getSelectedIndex() == 3) {
							for (int i = 0; i < d3.length; i++)
								NRC2.addItem(d3[i]);
						} else {
							if (cboNrc1.getSelectedIndex() == 4) {
								for (int i = 0; i < d4.length; i++)
									NRC2.addItem(d4[i]);
							} else {
								if (cboNrc1.getSelectedIndex() == 5) {
									for (int i = 0; i < d5.length; i++)
										NRC2.addItem(d5[i]);
								} else {
									if (cboNrc1.getSelectedIndex() == 6) {
										for (int i = 0; i < d6.length; i++)
											NRC2.addItem(d6[i]);
									} else {
										if (cboNrc1.getSelectedIndex() == 7) {
											for (int i = 0; i < d7.length; i++)
												NRC2.addItem(d7[i]);
										} else {
											if (cboNrc1.getSelectedIndex() == 8) {
												for (int i = 0; i < d8.length; i++)
													NRC2.addItem(d8[i]);
											} else {
												if (cboNrc1.getSelectedIndex() == 9) {
													for (int i = 0; i < d9.length; i++)
														NRC2.addItem(d9[i]);
												} else {
													if (cboNrc1.getSelectedIndex() == 10) {
														for (int i = 0; i < d10.length; i++)
															NRC2.addItem(d10[i]);
													} else {
														if (cboNrc1.getSelectedIndex() == 11) {
															for (int i = 0; i < d11.length; i++)
																NRC2.addItem(d11[i]);
														} else {
															if (cboNrc1.getSelectedIndex() == 12) {
																for (int i = 0; i < d12.length; i++)
																	NRC2.addItem(d12[i]);
															} else {
																if (cboNrc1.getSelectedIndex() == 13) {
																	for (int i = 0; i < d13.length; i++)
																		NRC2.addItem(d13[i]);
																} else {
																	if (cboNrc1.getSelectedIndex() == 14) {
																		for (int i = 0; i < d14.length; i++)
																			NRC2.addItem(d14[i]);
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
		cboNrc1.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		cboNrc1.setBackground(UIManager.getColor("Button.light"));
		cboNrc1.setBounds(187, 265, 58, 28);
		getContentPane().add(cboNrc1);
		
		 NRC2 = new JComboBox();
		NRC2.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		NRC2.setBackground(UIManager.getColor("Button.light"));
		NRC2.setBounds(246, 265, 97, 28);
		getContentPane().add(NRC2);
		
		NRC3 = new JTextField();
		NRC3.setText(" (N)");
		NRC3.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		NRC3.setColumns(10);
		NRC3.setBounds(347, 266, 35, 28);
		getContentPane().add(NRC3);
		
		txtNRC4 = new JTextField();
		txtNRC4.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		txtNRC4.setColumns(10);
		txtNRC4.setBounds(386, 266, 91, 26);
		getContentPane().add(txtNRC4);
		
		JLabel lblGender = new JLabel("Gender        :");
		lblGender.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblGender.setBounds(33, 311, 169, 28);
		getContentPane().add(lblGender);
		
		 rdoMale = new JRadioButton("Male");
		btnGender.add(rdoMale);
		rdoMale.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		rdoMale.setBackground(UIManager.getColor("Button.light"));
		rdoMale.setBounds(187, 316, 74, 21);
		getContentPane().add(rdoMale);
		
		 rdoFemale = new JRadioButton("Female");
		btnGender.add(rdoFemale);
		rdoFemale.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		rdoFemale.setBackground(UIManager.getColor("Button.light"));
		rdoFemale.setBounds(273, 315, 103, 21);
		getContentPane().add(rdoFemale);
		
		JLabel lblPhoneNo = new JLabel("Phone No   : ");
		lblPhoneNo.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblPhoneNo.setBounds(33, 360, 169, 28);
		getContentPane().add(lblPhoneNo);
		
		txtPhno = new JTextField();
		txtPhno.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		txtPhno.setColumns(10);
		txtPhno.setBounds(187, 362, 290, 26);
		getContentPane().add(txtPhno);
		
		JLabel lblAddress = new JLabel("Address      :");
		lblAddress.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblAddress.setBounds(33, 428, 169, 28);
		getContentPane().add(lblAddress);
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		txtAddress.setColumns(10);
		txtAddress.setBounds(187, 428, 290, 54);
		getContentPane().add(txtAddress);
		
		JLabel lblEmail = new JLabel("Email          :");
		lblEmail.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblEmail.setBounds(33, 508, 126, 28);
		getContentPane().add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		txtEmail.setColumns(10);
		txtEmail.setBounds(187, 511, 290, 26);
		getContentPane().add(txtEmail);
		
		JLabel lblPosition = new JLabel("Position     :");
		lblPosition.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblPosition.setBounds(33, 565, 126, 28);
		getContentPane().add(lblPosition);
		
		cboPosition = new JComboBox();
		cboPosition.setModel(new DefaultComboBoxModel(new String[] {"None", "Admin", "Staff", "Customer"}));
		cboPosition.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		cboPosition.setBackground(UIManager.getColor("Button.light"));
		cboPosition.setBounds(187, 567, 290, 28);
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
			}
		});
		btnBack.setIcon(new ImageIcon(View_ManageStaff.class.getResource("/image/back.png")));
		btnBack.setFont(new Font("Mongolian Baiti", Font.BOLD, 15));
		btnBack.setBackground(new Color(50, 205, 50));
		btnBack.setBounds(413, 72, 107, 33);
		getContentPane().add(btnBack);

	}
	
	public void populateStaffDetails( String name,java.util.Date dob, String email,String gender,String phno, String nrc, String position, String address) {
	       
        txtName.setText(name);
        cboPosition.setSelectedItem(position);
        

        dateChooser.setDate(dob);
       
        
        txtEmail.setText(String.valueOf(email));
        txtPhno.setText(String.valueOf(phno));

        
        txtAddress.setText(address);
        if (gender.equals("on")) {
        	rdoFemale.setSelected(true);
        	rdoMale.setSelected(false);
        } else if (gender.equals("off")) {
        	rdoFemale.setSelected(false);
            rdoMale.setSelected(true);
        } else {
            //  handle unexpected status values
        	rdoFemale.setSelected(false);
        	rdoMale.setSelected(false);
        }
       
    }
	

}
