/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.login.dao;

import com.login.bean.LoginBean;
import com.register.conn.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Shubh
 */
public class LoginDao {
    public boolean validate(LoginBean bean){
        boolean result = false;
        Connection connection = DBConnect.getConn();
        String sql = "select * from Student where email=? and pass=?";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, bean.getUserEmail());
            ps.setString(2, bean.getUserPassword());
            ResultSet rs = ps.executeQuery();
            result = rs.next();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
