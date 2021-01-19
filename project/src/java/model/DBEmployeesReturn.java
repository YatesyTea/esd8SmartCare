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
import java.util.*;

/**
 *
 * @author carl
 */
public class DBEmployeesReturn {
    
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
    
    public int addEmployee(Employees newEmployee){
        
        int flag = 0;
        try{
            if(connect()){
                //Format query
                String query = "INSERT INTO EMPLOYEE(EID, ENAME, EADDRESS, UNAME) VALUES('"+ newEmployee.getId() + "','" + newEmployee.getName() + "','" +
                        newEmployee.getAddress() + "','" + newEmployee.getDob() + "')";

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
    
    public int deleteEmployee(Employees employee) throws SQLException{
        int flag = 0;
        try{
            if(connect()){
                String query = "DELETE FROM EMPLOYEE WHERE EID=?";

                ps = con.prepareStatement(query);
                ps.setString(1, employee.getId());
                flag = ps.executeUpdate();

                ps.close();
                disconnect();

            }            
        } catch (SQLException e) {
            System.err.println("Error: " + e);
            
        }//try
        
        return flag;
    }
    
    public int updateEmployee(Employees employee) throws SQLException{
    
        int flag = 0;
        try{
            if(connect()){
                String query = "UPDATE EMPLOYEE SET ENAME=?, EADDRESS=? WHERE EID=?";
                
                ps = con.prepareStatement(query);
                ps.setString(1, employee.getName());
                ps.setString(2, employee.getAddress());

                flag = ps.executeUpdate();
                ps.close();
                disconnect();

                return flag;
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
        }//
        
        return flag;
    }
    
    
    public ArrayList<Employees> getEmployee() {
        ArrayList<Employees> result = new ArrayList<Employees>();
        
        
        
        try {
            
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/smartcare", "administrator", "admin");
            state = con.createStatement();
            rs = state.executeQuery("SELECT * FROM EMPLOYEE");
            
            while (rs.next()) {
                
                result.add(new Employees(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
                
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
