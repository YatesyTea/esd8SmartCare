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

    
     public int addPrescription(Prescription newPrescription){
        
        int flag = 0;
        try{
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/smartcare", "administrator", "admin");
            
            //Check if user already exists in db 
            String query = "SELECT CLIENTS.CNAME, EMPLOYEE.ENAME FROM CLIENTS, EMPLOYEE WHERE CLIENTS.CNAME='" + newPrescription.getPatientName() + "',EMPLOYEE.ENAME='" + newPrescription.getDoctor() + "'";
            state = con.createStatement();
            rs = state.executeQuery(query);
            
            //If user doesn't exist - add to db
            if(rs.next()){
                state.close();
                rs.close();
                System.err.println("Hi");
                
                //Format user data
                query = "INSERT INTO PRESCRIPTION(PTYPE,CNAME, DISSUE, DOSAGE ,DNAME) VALUES('"+ newPrescription.getType() + "','" + newPrescription.getPatientName() + "','" + newPrescription.getDate() + "','" + newPrescription.getDosage() + "',,'" + newPrescription.getDoctor() +"')";
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
