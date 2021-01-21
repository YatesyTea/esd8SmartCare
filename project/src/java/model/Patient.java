/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Reece
 */
public class Patient {

    private String name;
    private String address;
    private String type;
    private String username;
    private String dob;

    public Patient(String name, String address, String type, String username, String dob) {
        this.name = name;
        this.address = address;
        this.type = type;
        this.username = username;
        this.dob = dob;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String display() {
        return " name: " + this.name + " address: "
                + this.address + " dob: " + this.dob + " type: " + this.type;
    }
}
