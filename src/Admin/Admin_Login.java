package Admin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;

import Dao.CRUD_Dao;
import Dao.Other_Dao;
import Admin.Admin_Dashboard;
import Admin.Staff_Dashboard;
import Constructors.Account;
import Constructors.Staff;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

public class Admin_Login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtEmail;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JCheckBox chckbxShowPassword;
    private CRUD_Dao crud_Dao;
    private JLabel lblPassword;
   
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Admin_Login frame = new Admin_Login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Admin_Login() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Admin_Login.class.getResource("/Image/Logo-removebg-preview.png")));
    	// Load icon image
        URL iconUrl = Admin_Login.class.getResource("/image/photo_2024-08-09_22-52-21-removebg-preview.png");
        if (iconUrl != null) {
            setIconImage(Toolkit.getDefaultToolkit().getImage(iconUrl));
        } else {
            System.err.println("Icon image resource not found.");
        }
        
        setTitle("VITALSIP Detox Juice");
        setBackground(new Color(255, 255, 255));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 479, 658);
        contentPane = new JPanel();
        contentPane.setBackground(UIManager.getColor("Button.light"));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblWelcome = new JLabel("Please Login Here");
        lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
        lblWelcome.setBackground(new Color(0, 0, 0));
        lblWelcome.setForeground(new Color(85, 177, 65));
        lblWelcome.setFont(new Font("Times New Roman", Font.BOLD, 30));
        lblWelcome.setBounds(50, 309, 358, 50);
        contentPane.add(lblWelcome);

        JLabel lblEmail = new JLabel("Username   :");
        lblEmail.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
        lblEmail.setBounds(50, 377, 170, 28);
        contentPane.add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBackground(UIManager.getColor("Button.light"));
        txtEmail.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
        txtEmail.setColumns(10);
        txtEmail.setBounds(171, 379, 237, 26);
        contentPane.add(txtEmail);

        lblPassword = new JLabel("Password    :");
        lblPassword.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
        lblPassword.setBounds(50, 435, 170, 28);
        contentPane.add(lblPassword);

        btnLogin = new JButton("Login");
        btnLogin.setIcon(new ImageIcon(Admin_Login.class.getResource("/Image/log-in.png")));
        btnLogin.setForeground(Color.BLACK);
        btnLogin.setFont(new Font("Mongolian Baiti", Font.BOLD, 15));
        btnLogin.setBackground(new Color(34, 139, 34));
        btnLogin.setBounds(171, 542, 101, 26);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogin(getDefaultCloseOperation());
                dispose();
            }
        });
        contentPane.add(btnLogin);

        chckbxShowPassword = new JCheckBox("Show Password");
        chckbxShowPassword.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
        chckbxShowPassword.setBackground(UIManager.getColor("Button.light"));
        chckbxShowPassword.setBounds(253, 480, 155, 28);
        chckbxShowPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chckbxShowPassword.isSelected()) {
                    txtPassword.setEchoChar((char) 0);
                } else {
                    txtPassword.setEchoChar('*');
                }
            }
        });
        contentPane.add(chckbxShowPassword);

        txtPassword = new JPasswordField();
        txtPassword.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
        txtPassword.setBackground(UIManager.getColor("Button.light"));
        txtPassword.setBounds(171, 437, 237, 26);
        contentPane.add(txtPassword);

     // Load logo image
        URL logoUrl = Admin_Login.class.getResource("/image/Logo-removebg-preview.png");
//        if (logoUrl != null) {
//            JLabel lblNewLabel = new JLabel("");
//            lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
//            lblNewLabel.setIcon(new ImageIcon(logoUrl));
//            lblNewLabel.setBounds(0, 48, 455, 207);
//            contentPane.add(lblNewLabel);
//        } else {
//            System.err.println("Logo image resource not found.");
//        }


        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(81, 192, 61));
        panel.setBounds(-113, 10, 578, 50);
        contentPane.add(panel);
        
        JLabel lblAdminDashboard = new JLabel("Vitalsip Detox Juice");
        lblAdminDashboard.setFont(new Font("Times New Roman", Font.BOLD, 25));
        lblAdminDashboard.setBounds(119, 0, 459, 59);
        panel.add(lblAdminDashboard);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setIcon(new ImageIcon(Admin_Login.class.getResource("/Image/Logo-removebg-preview.png")));
        lblNewLabel_1.setBounds(0, 99, 465, 212);
        contentPane.add(lblNewLabel_1);

        try {
            crud_Dao = new CRUD_Dao();
        } catch (SQLException e) {
            e.printStackTrace(); // This will print the stack trace to the console
            showMessage("Failed to connect to the database: " + e.getMessage()); // Display the error message
            System.exit(1);
        }

    }

    private void handleLogin(int staffID) {
    	if(checkPassword()) {
        String email = txtEmail.getText().trim();
        String password = new String(txtPassword.getPassword()).trim();

        if (email.isEmpty()) {
            showMessage("Email cannot be empty.");
            return;
        }

        if (password.isEmpty()) {
            showMessage("Password cannot be empty.");
            return;
        }

        

        try {
        	Other_Dao dao = new Other_Dao();
        	Staff s = dao.authenticateUser(email, password); 
        		
            if (s.getPosition() != null) {
                if ("admin".equalsIgnoreCase(s.getPosition())) {
                    // Open Admin Dashboard
                    Admin_Dashboard adminDashboard = new Admin_Dashboard(s);
                    adminDashboard.setVisible(true);
                    
                } else {
                    // Open Staff Dashboard
                    Staff_Dashboard staffDashboard = new Staff_Dashboard(s);
                    staffDashboard.setVisible(true);
                }
                this.dispose(); // Close the login frame
            } else {
                showMessage("Invalid email or password.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showMessage("An error occurred while authenticating.");
        }
    }
    }
    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(emailRegex);
    }

    public boolean checkPassword() {
		lblPassword.setVisible(false);
		if(txtPassword.getText().trim().isEmpty()) {
			lblPassword.setVisible(true);
			lblPassword.setText("*");
			return false;
		}
		if(txtPassword.getText().length()>=8) {
			return true;
		}
		else {
			lblPassword.setVisible(true);
			lblPassword.setText("Enter 8 character");
			return false;
		}
	}
	
	
	
    
    
   
    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
