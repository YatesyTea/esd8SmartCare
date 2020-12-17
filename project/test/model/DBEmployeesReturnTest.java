/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
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
public class DBEmployeesReturnTest {
    
    public DBEmployeesReturnTest(){
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testgetEmployee(){
        System.out.println("getEmployee");
        DBEmployeesReturn instance = new DBEmployeesReturn();
        
        String id = "2";
        String expResult = "Emin Adyin";
        String result = instance.getEmployee(id).get(0).getName();
        
        assertEquals(expResult, result);  
    }
}
