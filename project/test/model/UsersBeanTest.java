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
    
    @Test
    public void testCheckLogin(){
        System.out.println("Check Login");
        UsersBean instance = ub;
        
        String uname = "uname";
        String password = "pass";
        String expResult = null;
        String result = instance.checkLogin(uname, password);
        
        assertEquals(expResult, result);
        
        uname = "admin";
        password = "admin_passwd";        
        expResult = "admin";
        result = instance.checkLogin(uname, password);
        
        assertEquals(expResult, result);
        
        
    }
    
    @Test
    public void testGetUser() throws SQLException{
        System.out.println("Get User");
        UsersBean instance = ub;
        
        String username = "uname";
        String expResult = null;
        Users result = instance.getUser(username);
        
        assertEquals(expResult, result);
        
        
        username = "admin";
        expResult = "admin";
        result = instance.getUser(username);
        
        assertEquals(expResult, result.getUsername());
        
    }
    
    @Test
    public void testAddUser(){
        System.out.println("Add User");
        UsersBean instance = ub;
        
        Users user =  new Users("test","testPass","client");
        int expResult = 1;
        int result = instance.addUser(user);
        
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testGetAllUsers() throws SQLException{
        System.out.println("Get All Users");
        UsersBean instance = ub;
        
        ArrayList<Users> expResult = null;
        ArrayList<Users> result = instance.getAllUsers();
        
        assertNotEquals(expResult, result);
        
    }
    
    @Test
    public void testDeleteUsers() throws SQLException{
        System.out.println("Delete User");
        UsersBean instance = ub;
        
        //Add test user to db
        Users user = new Users("test","password","client");
        instance.addUser(user);
        
        //Delete
        int expResult = 1;
        int result = instance.deleteUsers(user);
        
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testUpdateUsers() throws SQLException{
        System.out.println("Update User");
        UsersBean instance = ub;
        
        //Add test user to db
        Users user = new Users("test","password","client");
        instance.addUser(user);
        user.setPassword("1234");
        
        int expResult = 1;
        int result = instance.updateUsers(user);
        instance.deleteUsers(user);
        
        assertEquals(expResult, result);
    
    }

}
