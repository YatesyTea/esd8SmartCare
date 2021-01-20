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
public class Appointment {
    
    private String sID;
    private String eID;         //Employee ID
    private String cID;         //Client ID
    private String AppointmentDate;
    private String AppointmentTime;

    public Appointment(String sID, String eID, String cID, String AppointmentDate, String AppointmentTime) {
        this.sID = sID;
        this.eID = eID;
        this.cID = cID;
        this.AppointmentDate = AppointmentDate;
        this.AppointmentTime = AppointmentTime;
    }

    public Appointment(String eID, String cID, String bookingDate, String bookingTime) {
        this.eID = eID;
        this.cID = cID;
        this.AppointmentDate = bookingDate;
        this.AppointmentTime = bookingTime;
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

    public String getAppointmentDate() {
        return AppointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.AppointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return AppointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.AppointmentTime = appointmentTime;
    }

    public String getsID() {
        return sID;
    }

    public void setsID(String sID) {
        this.sID = sID;
    }


    
    
}
