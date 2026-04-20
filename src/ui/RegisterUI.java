package ui;
import dao.UserDAO;
import javax.swing.*;
import model.User;

public class RegisterUI extends JFrame {

    JTextField usernameField, emailField;
    JPasswordField passwordField;
    JButton registerBtn;

    public RegisterUI() {

        setTitle("Registration Form");
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

        // Button
        registerBtn = new JButton("Register");
        registerBtn.setBounds(130, 180, 120, 40);
        add(registerBtn);

        // Button Click Logic
        registerBtn.addActionListener(e -> {

            String username = usernameField.getText();
            System.out.println("got u");
            String email = emailField.getText();
            System.out.println("got u");
            String password = new String(passwordField.getPassword());
            System.out.println("got u");

            User u = new User(username,email,password);
            System.out.println("passed");

            UserDAO dao = new UserDAO();
            boolean result = dao.insertUser(u);



            if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields are required!");
            } else {
                JOptionPane.showMessageDialog(this, "Registration Successful!");

                // Clear fields after success
                usernameField.setText("");
                emailField.setText("");
                passwordField.setText("");
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /*public static void main(String[] args) {
        new RegisterUI();
    }*/
}