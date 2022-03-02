
package com.register.dao;

import com.register.bean.RegisterBean;
import com.register.conn.DBConnect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao {
   public String RegisterinDB(RegisterBean bean) throws ClassNotFoundException, SQLException{
   
       Connection con = DBConnect.getConn();
       String sql = "insert into Student(name, email, pass) values (?,?,?)";
       int i = 0;
       try {
           PreparedStatement preparedStatement = con.prepareStatement(sql);
           preparedStatement.setString(1, bean.getName());
           preparedStatement.setString(2, bean.getEmail());
           preparedStatement.setString(3, bean.getPass());
           
           i = preparedStatement.executeUpdate();
           
           
       } catch (Exception e) {
           e.printStackTrace();
       }
       if(i>0){
           return "User is registered";
       }else{
           return "Error !!";
       }
   }
    
}
