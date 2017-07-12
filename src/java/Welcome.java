/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rohan Ardhapurkar
 */
public class Welcome extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html");
            int count=0;
            PrintWriter out=response.getWriter();
            Cookie ck[]=request.getCookies();  
            if(ck!=null){  
                String name=ck[0].getValue();  
            if(!name.equals("")||name!=null){  
                count++;
                out.print("<b>Welcome to Profile</b>");  
                out.print("<br>Welcome, "+name);  
                out.print("<br>Attempt</b>"+count);
            }  
            }
            else{  
            
            out.print("Please login first");  
            request.getRequestDispatcher("LoginPage.html").include(request, response);  
        }         
    }

   
}
