
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
    
    private static String url;
    private static String user;
    private static String password;

    
    public PatientBean(String db, String user, String password) {
       this.url = db;
       this.user = user;
       this.password = password;
       
    }
    
    private boolean connect() throws SQLException{
        try{
            this.con = DriverManager.getConnection(this.url, this.user, this.password);
            return true;
        
        } catch (Exception e){
            System.out.print(e);
        }
        return false;
        
    }
    
    private boolean disconnect() throws SQLException{
        try{
            this.con.close();
            return true;
        
        } catch (Exception e){
            System.out.print(e);
            return false;
        }
        
    }
    
    /*
        Desc: Adds new patient to db
        @param: newPatient - Patient object (NAME,ADDRESS,TYPE,UNAME)
        @returns: int (flag) - returns an integer (1) based on whether a user was added to the db
    */
    public int addPatient(Patient newPatient){
        
        int flag = 0;
        try{
            if(connect()){
                //Format query
                String query = "INSERT INTO CLIENTS(CNAME, CADDRESS, CTYPE, UNAME) VALUES('"+ newPatient.getName() + "','" + newPatient.getAddress() + "','" +
                        newPatient.getType() + "','" + newPatient.getUsername() + "')";

                //Add to db
                state = con.createStatement();
                flag = state.executeUpdate(query);

                state.close();
                disconnect();   
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);

        }//try
        
        return flag;
    }
    
        /*
    *   Description: Gets a list of all the clients in the database
    *   @param: None
    *   @return: ArrayList<Users> - Returns a list of Patients
    */ 
    public ArrayList<Patient> getAllPatients()throws SQLException{
    
        try{
            if(connect()){
                //Get list of users
                String query = "SELECT * FROM CLIENTS";
                state = con.createStatement();
                rs = state.executeQuery(query);

                ArrayList<Patient> listPatient = new ArrayList<>();
                
                //For each row in table create user & add to list
                while(rs.next()){
                    String name = rs.getString("CNAME");
                    String address = rs.getString("CADDRESS");
                    String type = rs.getString("CTYPE");
                    String username = rs.getString("UNAME");

                    Patient patient = new Patient(name, address, type, username);
                    listPatient.add(patient);

                }

                rs.close(); state.close();
                disconnect();

                return listPatient;            
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
            
        }//try
        
        return null;
        
    }

    /*
    *   Description: Deletes a patient from the database
    *   @param: Patient
    *   @return: int (flag) returns (1) if patient is successfully deleted
    */
    public int deletePatient(Patient patient) throws SQLException{
        int flag = 0;
        try{
            if(connect()){
                String query = "DELETE FROM CLIENTS WHERE UNAME=?";

                ps = con.prepareStatement(query);
                ps.setString(1, patient.getUsername());
                flag = ps.executeUpdate();

                ps.close();
                disconnect();

            }            
        } catch (SQLException e) {
            System.err.println("Error: " + e);
            
        }//try
        
        return flag;
    }
    
    /*
    *   Description: Updates a users information (name, address & patient type)
    *   @param: Patient
    *   @return: int (flag) returns (1) if patient info is successfully updated
    */    
    public int updatePatient(Patient patient) throws SQLException{
        int flag = 0;
        try{
            if(connect()){
                String query = "UPDATE CLIENTS SET CNAME=?, CADDRESS=? , CTYPE=? WHERE UNAME=?";

                ps = con.prepareStatement(query);
                ps.setString(1, patient.getName());
                ps.setString(2, patient.getAddress());
                ps.setString(3, patient.getType());
                ps.setString(4, patient.getUsername());

                flag = ps.executeUpdate();
                ps.close();
                disconnect();
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);    
        }//try
        
        return flag;
    }
    
    /*
    *   Description: Retrieves a patients information from db
    *   @param: String username - the id of the patient in the table
    *   @return: Patient - returns a patient object (CNAME, CADDRESS, CTYPE, UNAME) if the supplied username was valid
    */
    public Patient getPatient(String username) throws SQLException{
        
        Patient patient = null;
        try{
            if(connect()){
                String query = "SELECT * FROM CLIENTS WHERE UNAME=?";

                ps = con.prepareStatement(query);
                ps.setString(1, username);
                rs = ps.executeQuery();
                
                //Check if patient was found in db
                if(rs.next()){
                    String name = rs.getString("CNAME");
                    String address = rs.getString("CADDRESS");
                    String type = rs.getString("CTYPE");

                    patient = new Patient(name, address, type, username);
                }
                
                rs.close(); ps.close();
                disconnect();
                
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);

        }//try
        
        return patient;
    }
    
    
    
    
    
}
