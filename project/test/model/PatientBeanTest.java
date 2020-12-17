/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Yates
 */
public class PatientBeanTest {
    
    private PatientBean pb;
    
    public PatientBeanTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        System.out.println("== Set Up");
        pb = new PatientBean("jdbc:derby://localhost:1527/smartcare", "administrator", "admin");
        
    }
    
    @After
    public void tearDown() {
        System.out.println("== Tear Down");
        pb = null;
    }

    @Test
    public void testGetUser() throws SQLException{
        System.out.println("Get User");
        PatientBean instance = pb;
        
        String username = "uname";
        String expResult = null;
        Patient result = pb.getPatient(username);
        
        assertEquals(expResult, result);
        
        
        username = "meaydin";
        expResult = "meaydin";
        result = pb.getPatient(username);
        
        assertEquals(expResult, result.getUsername());
        
    }
    
    @Test
    public void testAddUser(){
        System.out.println("Add User");
        PatientBean instance = pb;
        
        Patient patient = new Patient("test","testAddress","nhs","test");
        int expResult = 1;
        int result = pb.addPatient(patient);
        
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testGetAllUsers() throws SQLException{
        System.out.println("Get All Users");
        PatientBean instance = pb;
        
        ArrayList<Patient> expResult = null;
        ArrayList<Patient> result = pb.getAllPatients();
        
        assertNotEquals(expResult, result);
        
    }
    
    @Test
    public void testDeleteUsers() throws SQLException{
        System.out.println("Delete User");
        PatientBean instance = pb;
        
        //Add test user to db
        Patient patient = new Patient("test","testAddress","nhs","test");
        pb.addPatient(patient);
        
        //Delete
        int expResult = 1;
        int result = pb.deletePatient(patient);
        
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testUpdatePatient() throws SQLException{
        System.out.println("Update User");
        PatientBean instance = pb;
        
        //Add test user to db
        Patient patient = new Patient("test","testAddress","nhs","test");
        pb.addPatient(patient);
        patient.setType("private");
        
        int expResult = 1;
        int result = pb.updatePatient(patient);
        pb.deletePatient(patient);
        
        assertEquals(expResult, result);
    
    }
 
    
}
