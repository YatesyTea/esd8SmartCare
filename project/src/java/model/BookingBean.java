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
 * @author Reece
 */
public class BookingBean {

    private Connection con;
    private Statement state;
    private ResultSet rs;
    
    private PreparedStatement ps;

    private static String url;
    private static String user;
    private static String password;
    
    private boolean connect() throws SQLException{
        try{
            this.con = DriverManager.getConnection(this.url, this.user, this.password);
            return true;
        
        } catch (Exception e){
            System.out.print(e);
        }
        return false;
        
    }
    
    private boolean disconnect(){
        try{
            this.con.close();
            return true;
        
        } catch (Exception e){
            System.out.print(e);
            return false;
        }
        
    }
    
    
}
