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
    private String employee;

    public Prescription(String type, String patientName, String date, String dosage, String employee) {
        this.type = type;
        this.patientName = patientName;
        this.date = date;
        this.dosage = dosage;
        this.employee = employee;
        
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
    
    public String getEmployee() {
        return employee;
    }
    

    public void setType(String type) {
        this.type = type;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
    
    public void setDate(String date) {
         this.date = date;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }
        
    public void setDoctor(String Employee) {
        this.employee = employee;
    }    
}
