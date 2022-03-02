
package com.register.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
    public static Connection getConn(){
        Connection con = null;
        String loadDriver = "com.mysql.cj.jdbc.Driver";
        String dbUrl = "jdbc:mysql://localhost:3306/registration_form";
        String userName = "root";
        String pswd = "admin";
        
        try {
            //1. Load Driver
            Class.forName(loadDriver);

            //2. Create the connection object
            con = DriverManager.getConnection(dbUrl, userName, pswd);
          
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    
}
