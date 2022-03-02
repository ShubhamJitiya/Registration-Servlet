
package com.login.servlet;

import com.login.bean.LoginBean;
import com.login.dao.LoginDao;
import com.register.Servlet.RegisterServlet;
import com.register.bean.RegisterBean;
import com.register.dao.RegisterDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdk.internal.org.jline.utils.InfoCmp;


public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
            resp.setContentType("text/html");
            System.out.println("Inside login");
            String currentEmail = req.getParameter("email");
            String currentPass = req.getParameter("pass");
            
            System.out.println(req.getParameter("email"));
            System.out.println(req.getParameter("pass"));
            
            LoginBean bean = new LoginBean();
            bean.setUserEmail(currentEmail);
            bean.setUserPassword(currentPass);
            
            LoginDao dao = new LoginDao();
           
            if(dao.validate(bean)){
                resp.sendRedirect("Homepage.html");
        }else{
                resp.sendRedirect("Login.html");
            }
    }
}
