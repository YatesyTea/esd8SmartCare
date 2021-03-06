/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author fdent
 */
public class PrescriptionBean {
    
    
    private Connection con;
    private Statement state;
    private ResultSet rs;
    
    private PreparedStatement ps;
    
    /**
     *
     * @param patientName
     * @param doctorName
     * @return
     */
    public static String checkValid(int pid, int eid){
        String valid = "valid";
        
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/smartcare", "administrator", "admin");
           
            PreparedStatement ps = con.prepareStatement("SELECT PID FROM PATIENTS WHERE PATIENTS.PID=" + pid + "");
      
            //Lookup user in db
            ResultSet rs = ps.executeQuery();
            
            //If user was found return role
            if(rs.next()){
                PreparedStatement ps1 = con.prepareStatement("SELECT EID FROM EMPLOYEE WHERE EMPLOYEE.EID = " + eid + "");
                ResultSet rs1 = ps1.executeQuery();
                if (rs1.next())
                    return valid;
            }
            
        }
        catch (Exception e){
            System.out.print(e);
        }
        
        //If not found return null
        return null;
        
    }
    
        public int addPrescription(Prescription newPrescription){
        
        int flag = 0;
        try{
            //Connect to DB.
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/smartcare", "administrator", "admin");
            
            //Format query to insert prescription info into DB.
            String query = "INSERT INTO PRESCRIPTIONS(FK_PID, FK_EID, DRUG, DISSUE, DOSAGE, COST , REISSUE) VALUES("+ newPrescription.getPid() + "," + newPrescription.getEid() + ",'" + newPrescription.getDrug() + "','" + newPrescription.getDate() + "'," 
                    + newPrescription.getDosage() + "," + newPrescription.getCost()+ "," + newPrescription.getReissue()+")";
            
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
