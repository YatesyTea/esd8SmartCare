
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

    //will query the table and find the users role from the entered information
    public String doQuery(String query) {
        StringBuilder sb = new StringBuilder(); //will hold the string

        try {
            // You will need to explicitly load this driver in a web app

            con = DriverManager.getConnection("jdbc:derby://localhost:1527/smartcare", "administrator", "admin");
            state = con.createStatement();
            rs = state.executeQuery("SELECT * FROM ADMINISTRATOR.USERS");

            while (rs.next()) {
                sb.append( rs.getString(3)); //set string to the role
                System.out.println("rs.setstring() output: " + rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3)); //print username password and role for testing/checking
            }
            rs.close(); //make sure to clsoe afterwards
            state.close();
            con.close();
        } catch (SQLException e) {
            System.err.println("Error: " + e); //make sure to print out error if it doesnt work

        }//try
        return sb.toString();
    }  

     //checks to see if the user has entered the correct information by quering the table and then return valid if so
    
    public static boolean checkLogin(String username, String password){
        boolean valid = false;
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/smartcare", "username", "password");
            
            PreparedStatement ps = con.prepareStatement("SELECT * from USERNAME.USERS WHERE uname=? and passwd=? and roles=?"); //as long as these cells have data in
            ps.setString(1, username);      //set string to input
            ps.setString(2, password);        
      
            ResultSet rs = ps.executeQuery(); //look for username and password
            valid = rs.next();
            
        }
        catch (Exception e){
            System.out.print(e);
        }
        return valid;
        
    }
    
   
    /*
        Description: Add new user to db
        @param: String array (data) - user data to be added to table (UNAME, PASSWORD, ROLE)
        @return: int (flag) - returns an integer (1) based on whether a user was added to the db
    */
    public int addUser(String[] data){
        
        int flag = 0;
        try{
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/smartcare", "administrator", "admin");
            
            //Check if user already exists in db
            String query = "SELECT * FROM USERS WHERE UNAME='" + data[0].trim() + "'";
            state = con.createStatement();
            rs = state.executeQuery(query);
            
            //If user doesn't exist - add to db
            if(!rs.next()){
                state.close();
                rs.close();
                
                //Format user data
                query = "INSERT INTO USERS VALUES('" + data[0].trim() + "','" + data[1].trim() + "','" + data[2].trim() + "')";
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
