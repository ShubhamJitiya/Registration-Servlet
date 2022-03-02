
package com.register.Servlet;

import com.register.bean.RegisterBean;
import com.register.dao.RegisterDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            System.out.println("Inside post");
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String pass = req.getParameter("pass");
            
            RegisterBean bean = new RegisterBean(name, email, pass);
            RegisterDao dao = new RegisterDao();
            String result = dao.RegisterinDB(bean);
            
            if (result.equals("User is registered")) {
                RequestDispatcher dispatcher = req.getRequestDispatcher("index.html");
                dispatcher.include(req, resp);
            } else {
                RequestDispatcher dispatcher = req.getRequestDispatcher("Register.html");
                dispatcher.include(req, resp);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
           
    }

