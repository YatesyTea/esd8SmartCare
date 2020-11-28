
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static javax.ws.rs.core.Response.status;



public class usersBean {
  //doQuery
    private Connection con;
    private Statement state;
    private ResultSet rs;

    //validate boolean
    private PreparedStatement ps;

    public String doQuery(String query) {
        StringBuilder sb = new StringBuilder();

        try {
            // You will need to explicitly load this driver in a web app

            con = DriverManager.getConnection("jdbc:derby://localhost:1527/smartcare", "administrator", "admin");
            state = con.createStatement();
            rs = state.executeQuery("SELECT * FROM ADMINISTRATOR.USERS");

            while (rs.next()) {
                sb.append(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
                sb.append("\n<br>");
                System.out.println("rs.setstring() output: " + rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }
            rs.close();
            state.close();
            con.close();
        } catch (SQLException e) {
            System.err.println("Error: " + e);

        }//try
        return sb.toString();
    }  
    public static boolean checkLogin(String username, String password){
        boolean valid = false;
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/smartcare", "username", "password");
            
            PreparedStatement ps = con.prepareStatement("SELECT * from USERNAME.USERS WHERE uname=? and passwd=? and roles=?");
            ps.setString(1, username);
            ps.setString(2, password);        
            
            ResultSet rs = ps.executeQuery();
            valid = rs.next();
            
        }
        catch (Exception e){
            System.out.print(e);
        }
        return valid;
        
    }
    
    
    
    
    
}
