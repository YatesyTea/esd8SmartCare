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
public class Employees {
    private String id, name, address, dob, type;

    public Employees(String id, String name, String address, String dob) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.dob = dob;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
   
    public String display(){
        return "id: " + this.id + " name: " + this.name + " address: " 
                + this.address + " dob: " + this.dob + " type: " + this.type;
    }
}
    

