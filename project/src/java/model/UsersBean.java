
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static javax.ws.rs.core.Response.status;

public class UsersBean {
  //doQuery
    private Connection con;
    private Statement state;
    private ResultSet rs;
    
    private PreparedStatement ps;

    
    public static String checkLogin(String username, String password){
       
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/smartcare", "administrator", "admin");
           
            PreparedStatement ps = con.prepareStatement("SELECT ROLE from USERS WHERE uname=? and passwd=?");
            ps.setString(1, username);      //Format query
            ps.setString(2, password);        
      
            //Lookup user in db
            ResultSet rs = ps.executeQuery();
            
            //If user was found return role
            if(rs.next())
                return rs.getString(1);
            
        }
        catch (Exception e){
            System.out.print(e);
        }
        
        //If not found return null
        return null;
        
    }
   
    /*
        Description: Add new user to db
        @param: String array (data) - user data to be added to table (UNAME, PASSWORD, ROLE)
        @return: int (flag) - returns an integer (1) based on whether a user was added to the db
    */
    public int addUser(Users newUsers){
        
        int flag = 0;
        try{
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/smartcare", "administrator", "admin");
            
            //Check if user already exists in db
            String query = "SELECT * FROM USERS WHERE UNAME='" + newUsers.getUsername() + "'";
            state = con.createStatement();
            rs = state.executeQuery(query);
            
            //If user doesn't exist - add to db
            if(!rs.next()){
                state.close();
                rs.close();
                
                //Format user data
                query = "INSERT INTO USERS VALUES('"+ newUsers.getUsername() + "','" + newUsers.getPassword() + "','" + newUsers.getRole() + "')";
                state = con.createStatement();
                //Insert
                flag = state.executeUpdate(query);
                
            }
            
            state.close();
            con.close();
        } catch (SQLException e) {
            System.err.println("Error: " + e);

        }//try
        
        return flag;
    }
}
