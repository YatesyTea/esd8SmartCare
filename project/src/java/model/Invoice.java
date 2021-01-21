/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author carl
 */
public class Invoice {
    
    private int id, patient_id, employee_id;
    private String  date, surgery, type;
    private float cost;

    public Invoice(int employee_id, int patient_id, String surgery, String date,  float cost, String type) {
        //this.id = id;
        this.employee_id = employee_id;
        this.patient_id = patient_id;
        this.surgery = surgery;
        this.cost = cost;
        this.date = date;
        this.type = type;
    }

    public String getSurgery() {
        return surgery;
    }

    public void setSurgery(String surgery) {
        this.surgery = surgery;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }
    
    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
    
    public String display(){
        return  " Client: " + this.patient_id + " date: " 
                + this.date + " amount: " + this.cost; 
    }
}
