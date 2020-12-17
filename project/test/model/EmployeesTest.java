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
 * @author carl
 */
public class EmployeesTest {
    
    private Employees employee;

    public EmployeesTest() {  
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
        employee = new Employees("12", "test", "road", "02/12/1999");
    }

    @After
    public void tearDown() {
        System.out.println("== Tear Down");
        employee = null;
    }
    
    @Test
    public void testgetId() {
        System.out.println("Get ID");
        Employees instance = employee;

        String expResult = "12";
        String result = instance.getId();

        assertEquals(expResult, result);
    }

    @Test
    public void testsetId() {
        System.out.println("Set Username");
        Employees instance = employee;

        String uname = "1223";
        instance.setId(uname);

        String expResult = "1223";
        String result = instance.getId();

        assertEquals(expResult, result);
    }

    @Test
    public void testgetName() {
        System.out.println("Get Name");
        Employees instance = employee;

        String expResult = "test";
        String result = instance.getName();

        assertEquals(expResult, result);
    }

    @Test
    public void testsetName() {
        System.out.println("Set Name");
        Employees instance = employee;

        String uname = "Carl";
        instance.setName(uname);

        String expResult = "Carl";
        String result = instance.getName();

        assertEquals(expResult, result);
    }

    @Test
    public void testgetAddress() {
        System.out.println("Get Address");
        Employees instance = employee;

        String expResult = "road";
        String result = instance.getAddress();

        assertEquals(expResult, result);
    }

    @Test
    public void testsetAddress() {
        System.out.println("Set Address");
        Employees instance = employee;

        String uname = "Roadd";
        instance.setAddress(uname);

        String expResult = "Roadd";
        String result = instance.getAddress();

        assertEquals(expResult, result);
    }

    @Test
    public void testgetDob() {
        System.out.println("Get DOB");
        Employees instance = employee;

        String expResult = "02/12/1999";
        String result = instance.getDob();

        assertEquals(expResult, result);
    }

    @Test
    public void testsetDob() {
        System.out.println("Set DOB");
        Employees instance = employee;

        String uname = "12/01/1999";
        instance.setDob(uname);

        String expResult = "12/01/1999";
        String result = instance.getDob();

        assertEquals(expResult, result);
    }
   
}
    

