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

    public DBEmployeesReturn(String db, String user, String password) {
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
                String query = "INSERT INTO EMPLOYEE(ENAME, EADDRESS, DOB, UNAME) VALUES('" + newEmployee.getName() + "','" +
                        newEmployee.getAddress() + "','" + newEmployee.getDob() + "','" + newEmployee.getUname() + "' )";

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
    
    public int deleteEmployee(String eid) throws SQLException{
        int flag = 0;
        try{
            if(connect()){
                String query = "DELETE FROM EMPLOYEE WHERE EID=?";

                ps = con.prepareStatement(query);
                ps.setString(1, eid);
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
    
        public Employees getEmployee(String id) throws SQLException{
        
        Employees employee = null;
        try{
            if(connect()){
                String query = "SELECT * FROM EMPLOYEE WHERE EID=?";

                ps = con.prepareStatement(query);
                ps.setString(1, id);
                rs = ps.executeQuery();
                
                //Check if patient was found in db
                if(rs.next()){
                    String name = rs.getString("ENAME");
                    String address = rs.getString("EADDRESS");
                    String username = rs.getString("UNAME");

                    employee = new Employees(id, name, address, username);
                }
                
                rs.close(); ps.close();
                disconnect();
                
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);

        }//try
        
        return employee;
    }
    
    
    
    
    public ArrayList<Employees> getAllEmployee() {
        ArrayList<Employees> result = new ArrayList<Employees>();
        
        try {
            if (connect()){
                state = con.createStatement();
                rs = state.executeQuery("SELECT * FROM EMPLOYEE");
            
                while (rs.next()) {
                    result.add(new Employees(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
                
                }
                rs.close();
                state.close();
                con.close();
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);

        }
        return result;
    }    
}
