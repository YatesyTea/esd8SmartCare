
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


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
