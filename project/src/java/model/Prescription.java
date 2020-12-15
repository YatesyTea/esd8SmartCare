/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author fdent
 */
public class Prescription {
    
    private String type;
    private String patientName;
    private String date;
    private String dosage;
    private String doctor;

    public Prescription(String type, String patientName, String date, String dosage, String doctor) {
        this.type = type;
        this.patientName = patientName;
        this.date = date;
        this.dosage = dosage;
        this.dosage = doctor;
        
    }

    public String getType() {
        return type;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getDate() {
        return date;
    }
    public String getDosage() {
        return dosage;
    }
    
    public String getDoctor() {
        return doctor;
    }
    

    public void setType(String type) {
        this.type = type;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }
    
     public void setDate() {
         this.date = date;
    }
    
    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }    
}
