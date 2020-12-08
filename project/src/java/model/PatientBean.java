
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
import java.util.ArrayList;


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
            String query = "INSERT INTO CLIENTS(CNAME, CADDRESS, CTYPE, UNAME) VALUES('"+ newPatient.getName() + "','" + newPatient.getAddress() + "','" +
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
    
    public ArrayList<Patient> getAllPatients()throws SQLException{
    
        try{
            ArrayList<Patient> listPatient = new ArrayList<>();
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/smartcare", "administrator", "admin");
            
            //Get list of users
            String query = "SELECT * FROM CLIENTS";
            state = con.createStatement();
            rs = state.executeQuery(query);
            
            //For each row in table create user & add to list
            while(rs.next()){
                String name = rs.getString("CNAME");
                String address = rs.getString("CADDRESS");
                String type = rs.getString("CTYPE");
                String username = rs.getString("UNAME");
                
                Patient patient = new Patient(name, address, type, username);
                listPatient.add(patient);
                
            }
            
            rs.close();
            state.close();
            
            return listPatient;
            
            
            
        } catch (SQLException e) {
            System.err.println("Error: " + e);
            return null;
        }//try
        
    }
    
    public int deletePatient(Patient patient) throws SQLException{
        int flag = 0;
        try{
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/smartcare", "administrator", "admin");
            String query = "DELETE FROM CLIENTS WHERE UNAME=?";
            
            ps = con.prepareStatement(query);
            ps.setString(1, patient.getUsername());
            flag = ps.executeUpdate();
            
            ps.close();
            con.close();
            
        } catch (SQLException e) {
            System.err.println("Error: " + e);
            
        }//try
        
        return flag;
    }
    
    public int updatePatient(Patient patient) throws SQLException{
        int flag = 0;
        try{
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/smartcare", "administrator", "admin");
            String query = "UPDATE CLIENTS SET CNAME=?, CADDRESS=? , CTYPE=?, WHERE UNAME=?";
            
            ps = con.prepareStatement(query);
            ps.setString(1, patient.getName());
            ps.setString(2, patient.getAddress());
            ps.setString(3, patient.getType());
            ps.setString(4, patient.getUsername());
            
            flag = ps.executeUpdate();
            ps.close();
            con.close();
            
        } catch (SQLException e) {
            System.err.println("Error: " + e);
            
        }//try
        
        return flag;
    }
    
    public Patient getPatient(String username) throws SQLException{
        
        Patient patient = null;
        try{
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/smartcare", "administrator", "admin");

            String query = "SELECT * FROM CLIENTS WHERE UNAME=?";
            
            ps = con.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            
            if(rs.next()){
                String name = rs.getString("CNAME");
                String address = rs.getString("CADDRESS");
                String type = rs.getString("CTYPE");
                
                patient = new Patient(name, address, type, username);
            }
      
        } catch (SQLException e) {
            System.err.println("Error: " + e);

        }//try
        
        return patient;
    }
    
    
    
    
    
}
