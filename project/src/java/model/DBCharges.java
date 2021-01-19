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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

/**
 *
 * @author carl
 */
public class DBCharges {
    
    private Connection con;
    private Statement state;
    private ResultSet rs;
    
    public ArrayList<Charges> getCharges() {
        ArrayList<Charges> result = new ArrayList<Charges>();
        
        
        try {
            
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/smartcare", "administrator", "admin");
            state = con.createStatement();
            rs = state.executeQuery("SELECT * FROM OPERATIONS");
            
            while (rs.next()) {
                
                result.add(new Charges(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4)));
                
            }
            
            rs.close();
            state.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error: " + e);

        }
        return result;
    
    }
// Dont know if this will work but would need new database table to put payments or charges into
//    public String makeClaim(String ID, String patietnt_ID, double amount) throws SQLException, ParseException {
//        try {
//            
//            Class.forName("org.apache.derby.jdbc.ClientDriver");
//            con = DriverManager.getConnection("jdbc:derby://localhost:1527/smartcare", "administrator", "admin");
//            state = con.createStatement();
//
//            LocalDate todayLocalDate = LocalDate.now(ZoneId.of("Europe/London"));
//
//            String query = " insert into charges (id, patient_id, date, amount)" + " values (?, ?, ?, ?, ?)";
//       
//
//            PreparedStatement Stmt = con.prepareStatement(query);
//            Stmt.setString(1, ID);
//            Stmt.setString(3, client_ID);
//            Stmt.setDate(3, java.sql.Date.valueOf(todayLocalDate));
//            Stmt.setString(4, "APPLIED");
//            Stmt.setDouble(5, amount);
//            Stmt.executeUpdate();
//
//            rs.close();
//            state.close();
//            con.close();
//        } catch (ClassNotFoundException | SQLException e) {
//            System.err.println("Error: " + e);
//
//        }
//
//        return ("A");
//    }
}
