/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/**
 *
 * @author fdent
 */
public class DBPrescriptionReturn {
    
    private Connection con;
    private Statement state;
    private ResultSet rs;

    public ArrayList<Prescription> getPrescriptionReport(String date1,String date2) {
        ArrayList<Prescription> result = new ArrayList<Prescription>();
        
    try {
        String ename= "Pepega";
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/smartcare", "administrator", "admin");
        state = con.createStatement();
        rs = state.executeQuery("SELECT PRESCRIPTIONS.FK_PID, PRESCRIPTIONS.FK_EID, "
                + "PRESCRIPTIONS.DRUG,PRESCRIPTIONS.DISSUE, PRESCRIPTIONS.DOSAGE, "
                + "PRESCRIPTIONS.COST, PRESCRIPTIONS.REISSUE, PATIENTS.PTYPE  "
                + "FROM PRESCRIPTIONS INNER JOIN PATIENTS ON PRESCRIPTIONS.FK_PID=PATIENTS.PID "
                + "WHERE DISSUE BETWEEN '"+ date1 + "' AND '"+ date2+"'");
        

        while (rs.next()) {
            result.add(new Prescription(rs.getInt(1), rs.getInt(2),rs.getString(3),rs.getString(4),rs.getInt(5), rs.getFloat(6), rs.getInt(7), rs.getString(8), ename));
        }
        
        rs.close();
        state.close();
        con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error: " + e);

        }
        return result;
    }
        public ArrayList<Prescription> getPrescription(int pid) {
        ArrayList<Prescription> result = new ArrayList<Prescription>();
        
    try {
        String type = "NHS";
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/smartcare", "administrator", "admin");
        state = con.createStatement();
        rs = state.executeQuery("SELECT PRESCRIPTIONS.FK_PID, PRESCRIPTIONS.FK_EID, "
                + "PRESCRIPTIONS.DRUG,PRESCRIPTIONS.DISSUE,PRESCRIPTIONS.DOSAGE, "
                + "PRESCRIPTIONS.COST, PRESCRIPTIONS.REISSUE, EMPLOYEE.ENAME  "
                + "FROM PRESCRIPTIONS INNER JOIN EMPLOYEE ON PRESCRIPTIONS.FK_EID=EMPLOYEE.EID "
                + "WHERE PRESCRIPTIONS.FK_PID="+ pid +"");

        while (rs.next()) {
            result.add(new Prescription(rs.getInt(1), rs.getInt(2),rs.getString(3),rs.getString(4),rs.getInt(5), rs.getFloat(6), rs.getInt(7), type, rs.getString(8)));
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
