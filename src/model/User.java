package model;

public class User {

    private String username;
    private String email;
    private String password;

    // Constructor
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // Getter methods
    public String getUsername() {
        System.out.println("got u");
        return username;
    }

    public String getEmail() {
        System.out.println("got u");
        return email;
    }

    public String getPassword() {
        System.out.println("got u");
        return password;
    }
}