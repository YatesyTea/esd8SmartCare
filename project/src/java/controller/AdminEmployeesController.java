/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DBEmployeesReturn;
import model.Employees;

/**
 *
 * @author carl
 */
public class AdminEmployeesController extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        DBEmployeesReturn emp = new DBEmployeesReturn("jdbc:derby://localhost:1527/smartcare", "administrator", "admin");
        ArrayList<Employees> employee;
      
        if (request.getMethod() == "POST"){
            System.out.println("POST");
            String eid = request.getParameter("id");
            
            //Remove employee from db
            int flag = emp.deleteEmployee(eid);
            
        }
        
        employee = emp.getAllEmployee();
        request.setAttribute("employees", employee);    
        
        RequestDispatcher view = request.getRequestDispatcher("AdminEmployees.jsp");
        view.forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AdminEmployeesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AdminEmployeesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
