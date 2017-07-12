/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Rohan Ardhapurkar
 */
public class ValidateServ extends HttpServlet {

   

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
       String username,password;
       username=request.getParameter("username");
       password=request.getParameter("password");
       
       DBConn dbconn=new DBConn();
       
       if(dbconn.isValid(username, password)){
           Cookie ck=new Cookie("name",username);  
            response.addCookie(ck);
           RequestDispatcher rd=request.getRequestDispatcher("Welcome");
           rd.forward(request,response);
       }
       else{
           out.println("Username or password invalid");
            RequestDispatcher rd=request.getRequestDispatcher("LoginPage.html");
           rd.include(request,response);
           
       }
       
       
    }

   
}
