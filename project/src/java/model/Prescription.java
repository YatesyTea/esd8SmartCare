/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.*;

/**
 *
 * @author fdent
 */
public class Prescription {
    
    
    private int cid;
    private String drug;
    private String date;
    private float cost;
    private int dosage;
    private int reissue;
    private int eid;

    public Prescription(int cid, String drug, String date, float cost, int dosage, int reissue,int eid) {
        
        this.cid = cid;
        this.drug = drug;
        this.date = date;
        this.cost = cost;
        this.dosage = dosage;
        this.reissue = reissue;
        this.eid = eid;
        
    }
    
    public int getCid() {
        return cid;
    }

    public String getDrug() {
        return drug;
    }
    public String getDate() {
        return date;
    }
    
    public float getCost() {
        return cost;
    }
    
    public int getDosage(){
        return dosage;
    }
    
    public int getReissue(){
        return reissue;
    }
    
     public int getEid() {
        return eid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
    
    public void setDrug(String drug){
        this.drug = drug;
    }
    public void setDate(String date) {
         this.date = date;
    }

    public void setDosage(int dosage) {
        this.dosage = dosage;
    }
        
    public void setCost(float cost) {
        this.cost = cost;
    }
    
    public void setReissue(int reissue){
        this.reissue = reissue;
    }
    
     public void setEid(int eid) {
        this.eid = eid;
    }

}
