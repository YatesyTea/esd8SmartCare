/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UsersBean;
import model.Users;
import model.Employees;
import model.DBEmployeesReturn;

/**
 *
 * @author Yates
 */
public class AddEmployeeServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DBEmployeesReturn eb = new DBEmployeesReturn("jdbc:derby://localhost:1527/smartcare", "administrator", "admin");
        UsersBean ub = new UsersBean("jdbc:derby://localhost:1527/smartcare", "administrator", "admin");

        //Create parameter variables using inputs taken from sign up form
        String n = request.getParameter("name");
        String d = request.getParameter("dob");
        String u = request.getParameter("username");    //get the entered login information 
        String p = request.getParameter("password");
        String p1 = request.getParameter("password1");
        String a = request.getParameter("address");
        String role = request.getParameter("role");

        /*Create new instance of User and Employee using their appropriate 
         attributes in order to insert them into the database*/
        Users user1 = new Users(u, p, role);
        ub.addUser(user1);
        Employees employee1 = new Employees(n, a, d, u);
        eb.addEmployee(employee1);
        RequestDispatcher view = request.getRequestDispatcher("adminDashboard.jsp");
        view.forward(request, response);
    }    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
