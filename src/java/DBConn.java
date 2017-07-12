import java.sql.*;
import java.io.*;
/**
 *
 * @author Rohan Ardhapurkar
 */
public class DBConn {
    public Connection conn;
    public PreparedStatement stmt;
    public ResultSet rs;
    boolean result;
    
    public DBConn(){
        try{
            com.mysql.jdbc.Driver d=new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(d);
            
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","root");
            
        }
        catch(Exception e){
        }
        
    }
    
        public boolean isValid(String username,String password){
            try{
            result=false;
            stmt=conn.prepareStatement("select * from login where login_name=? and password=?");
            stmt.setString(1,username);
            stmt.setString(2, password);
            rs=stmt.executeQuery();
            result=rs.next();
            }
            catch(Exception e1){
            }
            return result;
        }
    
}
