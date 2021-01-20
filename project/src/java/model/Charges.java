/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author carl
 */
public class Charges {
    
    private int id, patient_id;
    private String  date;
    private double cost;

    public Charges(int id, int patient_id, String date, double cost) {
        this.id = id;
        this.patient_id = patient_id;
        this.cost = cost;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    
    public String display(){
        return "id: " + this.id + " Client: " + this.patient_id + " date: " 
                + this.date + " amount: " + this.cost;
    }
}
