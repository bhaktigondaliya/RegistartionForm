package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection(){
        Connection con = null;

        try {

            String url = "jdbc:mysql://localhost:3306/mydb";
            String user = "root";
            String password = "bhakti";

            con = DriverManager.getConnection(url,user,password);

            System.out.println("Connected Successfully");

            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }













    
      
    
}
