/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
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
public class UsersBeanTest {
    
    private UsersBean ub;
    
    public UsersBeanTest() {
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
        ub = new UsersBean("jdbc:derby://localhost:1527/smartcare", "administrator", "admin");
        
    }
    
    @After
    public void tearDown() {
        System.out.println("== Tear Down");
        ub = null;
    }
    
    public void testCheckLogin(){
        System.out.println("Check Login");
        UsersBean instance = ub;
        
        String uname = "uname";
        String password = "pass";
        String expResult = null;
        String result = ub.checkLogin(uname, password);
        
        assertEquals(expResult, result);
        
        uname = "admin";
        password = "admin_passwd";        
        expResult = "admin";
        result = ub.checkLogin(uname, password);
        
        assertEquals(expResult, result);
        
        
    }
    
    public void testGetUser() throws SQLException{
        System.out.println("Get User");
        
        String username = "uname";
        Users expResult = null;
        Users result = ub.getUser(username);
        
        assertEquals(expResult, result);
        
        
        username = "admin";
        expResult = new Users("admin","admin_passwd","admin");
        result = ub.getUser(username);
        
        assertEquals(expResult, result);
        
    }
    
    public void testAddUser(){
        System.out.println("Add User");
        
        Users user =  new Users("test","testPass","client");
        
    
    }
    
    public void testGetAllUsers(){
    
    }
    
    public void testDeleteUsers(){
    
    }
    
    public void testUpdateUsers(){
    
    }
    
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    // "jdbc:derby://localhost:1527/smartcare", "administrator", "admin"
    // @Test
    // public void hello() {}
}
