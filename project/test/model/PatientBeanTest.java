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
    private UsersBean ub;
    
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
        ub = new UsersBean("jdbc:derby://localhost:1527/smartcare", "administrator", "admin");
        
    }
    
    @After
    public void tearDown() {
        System.out.println("== Tear Down");
        pb = null;
        ub = null;
    }

    @Test
    public void testGetPatient() throws SQLException{
        System.out.println("Get Patient");
        PatientBean instance = pb;
        
        String username = "uname";
        String expResult = null;
        Patient result = instance.getPatient(username);
        
        assertEquals(expResult, result);
        
        
        username = "caidan";
        expResult = "caidan";
        result = instance.getPatient(username);
        
        assertEquals(expResult, result.getUsername());
        
    }
    
    @Test
    public void testAddPatient() throws SQLException{
        System.out.println("Add Patient");
        PatientBean instance = pb;
        UsersBean ub_instance = ub;
        
        //Add user
        Users user = new Users("test","pass","client");
        ub_instance.addUser(user);
        
        Patient patient = new Patient("test", "testAddress", "nhs", "test");
        
        int expResult = 1;
        int result = instance.addPatient(patient);
        
        assertEquals(expResult, result);

        ub_instance.deleteUsers(user);
        instance.deletePatient(patient);
        
    }
    
    @Test
    public void testGetAllPatient() throws SQLException{
        System.out.println("Get All Patient");
        PatientBean instance = pb;
        
        ArrayList<Patient> expResult = null;
        ArrayList<Patient> result = instance.getAllPatients();
        
        assertNotEquals(expResult, result);
        
    }
    
    @Test
    public void testDeletePatient() throws SQLException{
        System.out.println("Delete Patient");
        PatientBean instance = pb;

        Patient patient = instance.getPatient("caidan");
        
        //Delete
        int expResult = 1;
        int result = instance.deletePatient(patient);
        instance.addPatient(patient);        
        
        assertEquals(expResult, result);
        
        
        
    }
    
    @Test
    public void testUpdatePatient() throws SQLException{
        System.out.println("Update Patient");
        PatientBean instance = pb;
        
        //Add test user to db
        Patient patient = instance.getPatient("caidan");
        
        patient.setType("private");
        
        int expResult = 1;
        int result = instance.updatePatient(patient);
       
        assertEquals(expResult, result);
    
    }
 
    
}
