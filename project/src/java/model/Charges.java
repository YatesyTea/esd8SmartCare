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
    
    private int id;
    private String client_id, date;
    private double amount;

    public Charges(int id, String client_id, String date, double amount) {
        this.id = id;
        this.client_id = client_id;
        this.amount = amount;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    public String display(){
        return "id: " + this.id + " Client: " + this.client_id + " date: " 
                + this.date + " amount: " + this.amount;
    }
}
