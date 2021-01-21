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
    
    private int eid;
    private int pid;
    private String drug;
    private String date;
    private float cost;
    private int dosage;
    private int reissue;
    private String type;
    private String ename;

    public Prescription(int eid,int pid, String drug, String date, int dosage, float cost,int reissue, String type, String ename) {
        
        this.pid = pid;
        this.drug = drug;
        this.date = date;
        this.cost = cost;
        this.dosage = dosage;
        this.reissue = reissue;
        this.eid = eid;
        this.type = type;
        this.ename = ename;
        
    }
    
    public int getPid() {
        return pid;
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
     
     public String getType() {
        return type;
    }
     public String getEname() {
        return ename;
    }


    public void setCid(int pid) {
        this.pid = pid;
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
    public void setType(String type) {
        this.type = type;
    }
    public void setEname(String ename) {
        this.ename = ename;
    }


}
