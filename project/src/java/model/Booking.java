/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Reece
 */
public class Booking {
    
    private String eID;         //Employee ID
    private String cID;         //Client ID
    private String bookingDate;
    private String bookingTime;

    public Booking(String eID, String cID, String bookingDate, String bookingTime) {
        this.eID = eID;
        this.cID = cID;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
    }

    public String geteID() {
        return eID;
    }

    public void seteID(String eID) {
        this.eID = eID;
    }

    public String getcID() {
        return cID;
    }

    public void setcID(String cID) {
        this.cID = cID;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

  
    
    
}
