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

    private String name, address, dob, type, uname;

    public Employees(String name, String address, String dob, String uname) {

        this.name = name;
        this.address = address;
        this.dob = dob;
        this.uname = uname;
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

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String display() {
        return " name: " + this.name + " address: "
                + this.address + " dob: " + this.dob + " type: " + this.type;
    }
}
