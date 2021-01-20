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
import javax.servlet.http.Cookie;

import model.UsersBean;

/**
 *
 * @author carl
 */
public class DBCharges {
    
    private Connection con;
    private Statement state;
    private ResultSet rs;
    
    
    public ArrayList<Charges> getCharges(int pid) {
        ArrayList<Charges> result = new ArrayList<Charges>();
        //UsersBean ub = new UsersBean("jdbc:derby://localhost:1527/smartcare", "administrator", "admin");    //call loginbean class
        
        try {
            
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/smartcare", "administrator", "admin");
            state = con.createStatement();
            rs = state.executeQuery("SELECT FK_EID, FK_PID, OTYPE, ODATE, OTIME, NSLOT, CHARGE FROM OPERATIONS WHERE FK_PID=?");
            
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

}
