package dao;

import model.User;
import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDAO {

    public boolean insertUser(User user){
        boolean status = false;
        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement("INSERT INTO users(username, email, password) VALUES (?,?,?)");

            ps.setString(1,user.getUsername());
            ps.setString(2,user.getEmail());
            ps.setString(3,user.getPassword());

            int rows = ps.executeUpdate();

            if(rows > 0){
                status = true;
            }




            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}
