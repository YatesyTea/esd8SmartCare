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
 * @author carl
 */
public class DBCharges {
    
    private Connection con;
    private Statement state;
    private ResultSet rs;
    
    public ArrayList<Charge> getCharges() {
        ArrayList<Charge> result = new ArrayList<Charge>();
        
        
        try {
            
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/smartcare", "administrator", "admin");
            state = con.createStatement();
            rs = state.executeQuery("SELECT * FROM OPERATIONS");
            
            while (rs.next()) {
                
                result.add(new Charge(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDouble(4)));
                
            }
            
            rs.close();
            state.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error: " + e);

        }
        return result;
    
}
