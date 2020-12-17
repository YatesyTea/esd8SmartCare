/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
public class PatientTest {
    
    private Patient patient;
    
    public PatientTest() {
        
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
        patient = new Patient("test", "testAddress", "nhs", "uname");
    }
    
    @After
    public void tearDown() {
        System.out.println("== Tear Down");
        patient = null;
    }

        // Test Methods
    @Test
    public void testGetName() {
        System.out.println("Get name");
        Patient instance = patient;
        
        String expResult = "test";
        String result = instance.getName();

        assertEquals(expResult, result);
    }
   
    @Test
    public void testSetName() {
        System.out.println("Set Username");
        Patient instance = patient;

        String name = "patientName";
        instance.setName(name);

        String expResult = "patientName";
        String result = instance.getName();

        assertEquals(expResult, result);
    }

    @Test
    public void testGetAddress() {
        System.out.println("Get Address");
        Patient instance = patient;

        String expResult = "testAddress";
        String result = instance.getAddress();

        assertEquals(expResult, result);
    }

    @Test
    public void testSetAddresss() {
        System.out.println("Set Address");
        Patient instance = patient;

        String address = "My Address";
        instance.setAddress(address);

        String expResult = "My Address";
        String result = instance.getAddress();

        assertEquals(expResult, result);
    }

    @Test
    public void testGetType() {
        System.out.println("Get Type");
        Patient instance = patient;

        String expResult = "nhs";
        String result = instance.getType();

        assertEquals(expResult, result);
    }
    
    @Test
    public void testSetType(){
        System.out.println("Set Type");
        Patient instance = patient;
        
        String type = "private";
        instance.setType(type);
        
        String expResult = "private";
        String result = instance.getType();
        
        assertEquals(expResult, result);
    }
    
    @Test 
    public void testGetUsername(){
        System.out.println("Get Username");
        Patient instance = patient;
        
        String expResult = "uname";
        String result = instance.getUsername();
        
        assertEquals(expResult, result);
    }
    
}
