package dao;

import db.DBConnection;
import java.sql.*;
import model.User;

public class UserDAO {

    public boolean insertUser(User user) {
        boolean status = false;

        try (Connection con = DBConnection.getConnection()) {

            // 1. Check if email already exists
            String checkQuery = "SELECT * FROM users WHERE email = ?";
            PreparedStatement checkPs = con.prepareStatement(checkQuery);
            checkPs.setString(1, user.getEmail());

            ResultSet rs = checkPs.executeQuery();

            if (rs.next()) {
                // Email already exists
                return false;
            }

            // 2. Insert user using registartion
            String insertQuery = "INSERT INTO users(username, email, password) VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(insertQuery);

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }


    public boolean loginUser(User user){
        boolean status = false;
        try(Connection con = DBConnection.getConnection()) {
            String Query = "SELECT password FROM Users WHERE password = ?";
            PreparedStatement ps2 = con.prepareStatement(Query);
            ps2.setString(1,user.getPassword());
            ResultSet rss = ps2.executeQuery();
            if(rss.next()){
                return true;
            }else{
                return false;
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();

        }
        return status;
    }
}