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
public class UsersTest {

    private Users user;

    public UsersTest() {
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
        user = new Users("test", "test", "doctor");
    }

    @After
    public void tearDown() {
        System.out.println("== Tear Down");
        user = null;
    }

    // Test Methods
    @Test
    public void testGetUsername() {
        System.out.println("Get Username");
        Users instance = user;

        String expResult = "test";
        String result = instance.getUsername();

        assertEquals(expResult, result);
    }

    @Test
    public void testSetUsername() {
        System.out.println("Set Username");
        Users instance = user;

        String uname = "Uname";
        instance.setUsername(uname);

        String expResult = "Uname";
        String result = instance.getUsername();

        assertEquals(expResult, result);
    }

    @Test
    public void testGetPassword() {
        System.out.println("Get Password");
        Users instance = user;

        String expResult = "test";
        String result = instance.getPassword();

        assertEquals(expResult, result);
    }

    @Test
    public void testSetPassword() {
        System.out.println("Set Password");
        Users instance = user;

        String uname = "THE BIG P";
        instance.setPassword(uname);

        String expResult = "THE BIG P";
        String result = instance.getPassword();

        assertEquals(expResult, result);
    }

    @Test
    public void testGetRole() {
        System.out.println("Get Role");
        Users instance = user;

        String expResult = "doctor";
        String result = instance.getRole();

        assertEquals(expResult, result);
    }
}
