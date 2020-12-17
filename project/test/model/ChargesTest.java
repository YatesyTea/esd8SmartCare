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
public class ChargesTest {

    private Charges charge;

    public ChargesTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        System.out.println("=== Set Up");
        charge = new Charges(1, 1, "12-01-2018", 1);
    }

    @After
    public void tearDown() {
        charge = null;
    }

// Testing Zone
    @Test
    public void testGetId() {
        System.out.println("Test Get ID");
        Charges instance = charge;

        int expResult = 1;
        int result = instance.getId();

        assertEquals(expResult, result);
    }

    @Test
    public void testSetId() {
        System.out.println("Test Set ID");
        Charges instance = charge;

        instance.setId(2);

        int expResult = 2;
        int result = instance.getId();

        assertEquals(expResult, result);
    }

    @Test
    public void testGetClient_Id() {
        System.out.println("Test Get Client Id");
        Charges instance = charge;

        int expResult = 1;
        int result = instance.getClient_id();

        assertEquals(expResult, result);
    }

    @Test
    public void testSetClient_Id() {
        System.out.println("Test Set Client_id");
        Charges instance = charge;

        instance.setClient_id(2);

        int expResult = 2;
        int result = instance.getClient_id();

        assertEquals(expResult, result);
    }

    @Test
    public void testGetDate() {
        System.out.println("Test Get Date");
        Charges instance = charge;

        String expResult = "12-01-2018";
        String result = instance.getDate();

        assertEquals(expResult, result);
    }

    @Test
    public void testSetDate() {
        System.out.println("Test Set Date");
        Charges instance = charge;

        String newDate = "12-11-2018";
        String expResult = newDate;
        instance.setDate(newDate);

        String result = instance.getDate();

        assertEquals(expResult, result);
    }

    @Test
    public void testGetAmount() {
        System.out.println("Test Get Amount");
        Charges instance = charge;

        double expResult = 1;
        double result = instance.getAmount();

        assertEquals(expResult, result, 0.001);
    }

    @Test
    public void testSetAmount() {
        System.out.println("Test Set Amount");
        Charges instance = charge;
        
        double testAmount = 2.52;
        instance.setAmount(testAmount);

        double expResult = testAmount;
        double result = instance.getAmount();

        assertEquals(expResult, result, 0.001);
    }
}
