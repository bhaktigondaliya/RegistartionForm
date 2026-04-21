package ui;

import dao.UserDAO;
import javax.swing.*;
import model.User;

public class RegisterUI extends JFrame {

    JTextField usernameField, emailField;
    JPasswordField passwordField;
    JButton registerBtn, loginBtn;

    public RegisterUI() {

        setTitle("User System");
        setSize(400, 300);
        setLayout(null);

        // Username
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 50, 100, 30);
        add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(150, 50, 150, 30);
        add(usernameField);

        // Email
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 90, 100, 30);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(150, 90, 150, 30);
        add(emailField);

        // Password
        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 130, 100, 30);
        add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 130, 150, 30);
        add(passwordField);

        // Register Button
        registerBtn = new JButton("Register");
        registerBtn.setBounds(180, 180, 120, 40);
        add(registerBtn);

        // Login Button
        loginBtn = new JButton("Login");
        loginBtn.setBounds(50, 180, 120, 40);
        add(loginBtn);

        // 🔹 Register Logic
        registerBtn.addActionListener(e -> {

            String username = usernameField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields are required!");
                return;
            }

            User u = new User(username, email, password);
            UserDAO dao = new UserDAO();

            boolean result = dao.insertUser(u);

            if (result) {
                JOptionPane.showMessageDialog(this, "Registration Successful!");

                usernameField.setText("");
                emailField.setText("");
                passwordField.setText("");

            } else {
                JOptionPane.showMessageDialog(this, "User already exists!");
            }
        });

        // 🔹 Login Logic
        loginBtn.addActionListener(e -> {

            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            if (email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Enter email & password!");
                return;
            }

            User u = new User(null, email, password);
            UserDAO dao = new UserDAO();

            boolean result = dao.loginUser(u);

            if (result) {
                JOptionPane.showMessageDialog(this, "Login Successful!");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials!");
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new RegisterUI();
    }
}