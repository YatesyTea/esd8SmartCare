
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
    
    /*
    *   Description: Gets a list of all the users in the database
    *   @param: None
    *   @return: ArrayList<Users> - Returns a list of Users
    */  
    public ArrayList<Users> getAllUsers()throws SQLException{
        try{
            ArrayList<Users> listUsers = new ArrayList<>();
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/smartcare", "administrator", "admin");
            
            //Get list of users
            String query = "SELECT * FROM USERS";
            state = con.createStatement();
            rs = state.executeQuery(query);
            
            //For each row in table create user & add to list
            while(rs.next()){
                String username = rs.getString("UNAME");
                String password = rs.getString("PASSWD");
                String role = rs.getString("ROLE");
                
                Users user = new Users(username, password, role);
                listUsers.add(user);
                
            }
            
            rs.close();
            state.close();
            
            return listUsers;
            
        } catch (SQLException e) {
            System.err.println("Error: " + e);
            return null;
        }//try
        
    }
    
    /*
    *   Description: Deletes a user from the database
    *   @param: Users
    *   @return: int (flag) returns (1) if user is successfully deleted
    */
    public int deleteUsers(Users user) throws SQLException{
        
        int flag = 0;
        try{
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/smartcare", "administrator", "admin");
            String query = "DELETE FROM USERS WHERE UNAME=?";
            ps = con.prepareStatement(query);
            ps.setString(1, user.getUsername());
            
            flag = ps.executeUpdate();
            ps.close();
            con.close();
            
            return flag;
            
        } catch (SQLException e) {
            System.err.println("Error: " + e);
            return flag;
        }//
    }
    
    /*
    *   Description: Updates a users information (password & role)
    *   @param: Users
    *   @return: int (flag) returns (1) if user info is successfully updated
    */
    public int updateUsers(Users user) throws SQLException{
    
        int flag = 0;
        try{
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/smartcare", "administrator", "admin");
            String query = "UPDATE USERS SET PASSWORD=?, ROLE=? WHERE UNAME=?";
            
            ps = con.prepareStatement(query);
            ps.setString(1, user.getPassword());
            ps.setString(2, user.getRole());
            ps.setString(3, user.getUsername());
            
            flag = ps.executeUpdate();
            ps.close();
            con.close();
                    
            return flag;
            
        } catch (SQLException e) {
            System.err.println("Error: " + e);
            return flag;
        }//
    }
    
    /*
    *   Description: Returns user information in db
    *   @param: String username - the id of the user in the table
    *   @return: Users - returns a user object (UNAME, PASSWD, ROLE) if the supplied username was valid
    */
    public Users getUser(String username) throws SQLException{
        
        Users user = null;
        try{
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/smartcare", "administrator", "admin");
            String query = "SELECT * FROM USERS WHERE UNAME=?";
            
            ps = con.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            
            if(rs.next()){
                String password = rs.getString("PASSWD");
                String role = rs.getString("ROLE");
                
                user = new Users(username, password, role);
            }
            
        } catch (SQLException e) {
            System.err.println("Error: " + e);
            
        }//
        
        return user;
    }
    
}
