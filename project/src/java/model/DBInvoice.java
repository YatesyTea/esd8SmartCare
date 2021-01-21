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
import java.util.ArrayList;

/**
 *
 * @author carl
 */
public class DBInvoice {
    
    private Connection con;
    private Statement state;
    private ResultSet rs;
    private PreparedStatement ps;
    
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
    
    public int addInvoice(Invoice newInvoice){
        
        //System.out.print(newInvoice.getEmployee_id() + "','" + newInvoice.getPatient_id() + "'," + newInvoice.getSurgery() + "," + newInvoice.getDate() + "," + newInvoice.getCost()+ ")";
        
        int flag = 0;
        try{
            //Connect to DB.
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/smartcare", "administrator", "admin");
            
            //Format query to insert prescription info into DB.
            String query = "INSERT INTO OPERATIONS(FK_EID, FK_PID,OTYPE, ODATE, CHARGE) VALUES(" + newInvoice.getEmployee_id() + "," + newInvoice.getPatient_id() + ",'" + newInvoice.getSurgery() + "','"
                    + newInvoice.getDate() + "'," + newInvoice.getCost()+ ")";
            
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
    public ArrayList<Invoice> getOperationReport(String date1,String date2) {
        ArrayList<Invoice> result = new ArrayList<Invoice>();
        
        
        try {
            
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/smartcare", "administrator", "admin");
            state = con.createStatement();
            rs = state.executeQuery("SELECT OPERATIONS.FK_EID, OPERATIONS.FK_PID,"
                    + "OPERATIONS.OTYPE, OPERATIONS.ODATE, OPERATIONS.CHARGE, PATIENTS.PTYPE "
                    + "FROM OPERATIONS INNER JOIN PATIENTS ON OPERATIONS.FK_PID=PATIENTS.PID "
                    + "WHERE ODATE BETWEEN '"+ date1 + "' AND '"+ date2+"'");
            while (rs.next()) {
                
                result.add(new Invoice(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),rs.getFloat(5), rs.getString(6)));
                
            }
            rs.close();
            state.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error: " + e);

        }
        return result;
    
    }
    
}
