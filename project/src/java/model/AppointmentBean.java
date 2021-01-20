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
 * @author Reece
 */
public class AppointmentBean {

    private Connection con;
    private Statement state;
    private ResultSet rs;
    
    private PreparedStatement ps;

    private static String url;
    private static String user;
    private static String password;

    public AppointmentBean(String url, String user, String password) {
        this.url = url;
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

    public int addAppointment(Appointment newAppointment){
        
        int flag = 0;
        try{
            if(connect()){
                //Format query
                String query = "INSERT INTO APPOINTMENT(FK_EID, FK_PID, ADATE, ATIME) VALUES('"+ newAppointment.geteID() + "','" + newAppointment.getcID() + "','" +
                        newAppointment.getAppointmentDate() + "','" + newAppointment.getAppointmentTime() + "')";

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
    
    public ArrayList<Appointment> getAllAppointments()throws SQLException{
    
        try{
            if(connect()){
                //Get list of users
                String query = "SELECT * FROM APPOINTMENT";
                state = con.createStatement();
                rs = state.executeQuery(query);

                ArrayList<Appointment> listAppointment = new ArrayList<>();
                
                //For each row in table create user & add to list
                while(rs.next()){
                    String eID = rs.getString("FK_EID");
                    String cID = rs.getString("FK_PID");
                    String sDate = rs.getString("ADATE");
                    String sTime = rs.getString("ATIME");

                    Appointment appointment = new Appointment(eID, cID, sDate, sTime);
                    listAppointment.add(appointment);

                }

                rs.close(); state.close();
                disconnect();

                return listAppointment;            
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
            
        }//try
        
        return null;
        
    }
    
    public ArrayList<Appointment> getAllAppointmentByID(int id, String userType)throws SQLException{
        int flag = 0;
        System.out.println(userType);
        try{
            if(connect()){
                //Get list of users
                if (userType == "employee"){
                    String query = "SELECT * FROM APPOINTMENT WHERE FK_EID=?";
                    ps = con.prepareStatement(query);
                    ps.setInt(1, id);
                    
                    rs = ps.executeQuery();
        
                  
                }
                else{
                    String query = "SELECT * FROM APPOINTMENT WHERE FK_PID=?";
                    ps.setInt(1, id);
                    
                    rs = ps.executeQuery(query);
                }
                
                ArrayList<Appointment> listAppointment = new ArrayList<>();
                    
                    while(rs.next()){
                        String eID = rs.getString("FK_EID");
                        String cID = rs.getString("FK_PID");
                        String sDate = rs.getString("ADATE");
                        String sTime = rs.getString("ATIME");

                        Appointment appointment = new Appointment(eID, cID, sDate, sTime);
                        listAppointment.add(appointment);

                    }

                rs.close(); ps.close();
                disconnect();

                return listAppointment;            
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
            
        }//try
        
        return null;
        
    }
    
    public int deleteAppointment(String appointmentID) throws SQLException{
        int flag = 0;
        try{
            if(connect()){
                String query = "DELETE FROM APPOINTMENT WHERE SID=?";

                ps = con.prepareStatement(query);
                ps.setString(1, appointmentID);
                flag = ps.executeUpdate();

                ps.close();
                disconnect();

            }            
        } catch (SQLException e) {
            System.err.println("Error: " + e);
            
        }//try
        
        return flag;
    }
    
    public int updateAppointment(Appointment appointment, String appointmentID) throws SQLException{
        int flag = 0;
        try{
            if(connect()){
                String query = "UPDATE APPOINTMENT SET FK_EID=?, FK_PID=?, ADATE=?, ATIME=? WHERE SID=?";

                ps = con.prepareStatement(query);
                ps.setString(1, appointment.geteID());
                ps.setString(2, appointment.getcID());
                ps.setString(3, appointment.getAppointmentDate());
                ps.setString(4, appointment.getAppointmentTime());
                ps.setString(5, appointmentID);
                
                flag = ps.executeUpdate();
                ps.close();
                disconnect();
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);    
        }//try
        
        return flag;
    }
    
    
    
}
