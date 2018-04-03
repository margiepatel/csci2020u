package sample;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

    //Variables
    private JFrame frame;
    private JTextField txtUsername;
    private JPasswordField passwordField;
    private JFrame frmLoginSystem;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login window = new Login();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Login() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(200, 200, 500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel LoginSystem = new JLabel("LOGIN SYSTEM");
        LoginSystem.setHorizontalAlignment(SwingConstants.CENTER);
        LoginSystem.setFont(new Font("Tahoma", Font.BOLD, 20));
        LoginSystem.setBounds(163, 13, 170, 29);
        frame.getContentPane().add(LoginSystem);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblUsername.setBounds(82, 67, 106, 29);
        frame.getContentPane().add(lblUsername);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblPassword.setBounds(91, 133, 97, 29);
        frame.getContentPane().add(lblPassword);

        txtUsername = new JTextField();
        txtUsername.setBounds(226, 71, 155, 22);
        frame.getContentPane().add(txtUsername);
        txtUsername.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(226, 137, 155, 22);
        frame.getContentPane().add(passwordField);

        /**
         * Login Button/Function.
         */
        JButton btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String password = passwordField.getText();
                String username = txtUsername.getText();

                /**
                 * Opens the billing system is you enter the correct user name and password
                 */
                if(password.contains("billing") && username.contains("billingsystem")){
                    passwordField.setText(null);
                    txtUsername.setText(null);

                    Billing info = new Billing();
                    Billing.main(null);
                    //info.main(null);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password", "Login Error",JOptionPane.ERROR_MESSAGE);
                    passwordField.setText(null);
                    txtUsername.setText(null);
                }

            }
        });
        btnLogin.setBounds(37, 215, 97, 25);
        frame.getContentPane().add(btnLogin);

        /**
         * Clear Function/Button.
         */

        JButton btnReset = new JButton("Clear");
        btnReset.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                txtUsername.setText(null);
                passwordField.setText(null);
            }
        });
        btnReset.setBounds(192, 215, 97, 25);
        frame.getContentPane().add(btnReset);

        /**
         * Exit Function/Button.
         */

        JButton btnExit = new JButton("Exit");
        btnExit.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmLoginSystem = new JFrame("Exit");
                if(JOptionPane.showConfirmDialog(frmLoginSystem, "Confirm if you want to exit", "Login Systems",
                        JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION){
                    System.exit(0);
                }
            }
        });
        btnExit.setBounds(348, 215, 97, 25);
        frame.getContentPane().add(btnExit);
    }
}

