
package model;

/**
 * @author Reece Perrott
 * 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class PatientBean {

    private Connection con;
    private Statement state;
    private ResultSet rs;

    //validate boolean
    private PreparedStatement ps;
    
    
    /*
        Desc: Adds new patient to db
        @param: newPatient - Patient object (NAME,ADDRESS,TYPE,UNAME)
        @returns: int (flag) - returns an integer (1) based on whether a user was added to the db
    */
    public int addPatient(Patient newPatient){
        
        int flag = 0;
        try{
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/smartcare", "administrator", "admin");
            
            //Format query
            String query = "INSERT INTO CLIENTS VALUES('"+ newPatient.getName() + "','" + newPatient.getAddress() + "','" +
                    newPatient.getType() + "','" + newPatient.getUsername() + "')";
            
            //Add to db
            state = con.createStatement();
            flag = state.executeUpdate(query);
            
            state.close();
            con.close();
        } catch (SQLException e) {
            System.err.println("Error: " + e);

        }//try
        
        return flag;
    }
    
    
    
    
    
    
    
}
