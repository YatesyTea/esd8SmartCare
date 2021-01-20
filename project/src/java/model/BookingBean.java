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

    public int addBooking(Booking newBooking){
        
        int flag = 0;
        try{
            if(connect()){
                //Format query
                String query = "INSERT INTO BOOKING_SLOTS(EID, CID, SDATE, STIME) VALUES('"+ newBooking.geteID() + "','" + newBooking.getcID() + "','" +
                        newBooking.getBookingDate() + "','" + newBooking.getBookingTime() + "')";

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
    
    public ArrayList<Booking> getAllBookings()throws SQLException{
    
        try{
            if(connect()){
                //Get list of users
                String query = "SELECT * FROM BOOKING_SLOTS";
                state = con.createStatement();
                rs = state.executeQuery(query);

                ArrayList<Booking> listBooking = new ArrayList<>();
                
                //For each row in table create user & add to list
                while(rs.next()){
                    String eID = rs.getString("EID");
                    String cID = rs.getString("CID");
                    String sDate = rs.getString("SDATE");
                    String sTime = rs.getString("STIME");

                    Booking booking = new Booking(eID, cID, sDate, sTime);
                    listBooking.add(booking);

                }

                rs.close(); state.close();
                disconnect();

                return listBooking;            
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
            
        }//try
        
        return null;
        
    }
    
    public ArrayList<Booking> getAllBookingsByID(String id, String userType)throws SQLException{
        int flag = 0;
        
        try{
            if(connect()){
                //Get list of users
                if (userType == "Employee"){
                
                    String query = "SELECT * FROM BOOKING_SLOTS WHERE EID=" + id;
                    state = con.prepareStatement(query);
                    rs = state.executeQuery(query);
        
                  
                }
                else{
                    String query = "SELECT * FROM BOOKING_SLOTS WHERE CID=" + id;
                    state = con.prepareStatement(query);
                    rs = state.executeQuery(query);
                
                }
                
                ArrayList<Booking> listBooking = new ArrayList<>();
                    
                    while(rs.next()){
                        String eID = rs.getString("EID");
                        String cID = rs.getString("CID");
                        String sDate = rs.getString("SDATE");
                        String sTime = rs.getString("STIME");

                        Booking booking = new Booking(eID, cID, sDate, sTime);
                        listBooking.add(booking);

                    }

                rs.close(); state.close();
                disconnect();

                return listBooking;            
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
            
        }//try
        
        return null;
        
    }
    
    public int deleteBooking(String bookingID) throws SQLException{
        int flag = 0;
        try{
            if(connect()){
                String query = "DELETE FROM BOOKING_SLOTS WHERE SID=?";

                ps = con.prepareStatement(query);
                ps.setString(1, bookingID);
                flag = ps.executeUpdate();

                ps.close();
                disconnect();

            }            
        } catch (SQLException e) {
            System.err.println("Error: " + e);
            
        }//try
        
        return flag;
    }
    
    public int updateBooking(Booking booking, String bookingID) throws SQLException{
        int flag = 0;
        try{
            if(connect()){
                String query = "UPDATE BOOKING_SLOTS SET EID=?, CID=?, SDATE=?, STIME=? WHERE SID=?";

                ps = con.prepareStatement(query);
                ps.setString(1, booking.geteID());
                ps.setString(2, booking.getcID());
                ps.setString(3, booking.getBookingDate());
                ps.setString(4, booking.getBookingTime());
                ps.setString(5, bookingID);
                
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
