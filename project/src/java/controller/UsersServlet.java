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
import javax.servlet.http.HttpSession;

import model.UsersBean;


public class UsersServlet extends HttpServlet {

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
        UsersBean ub = new UsersBean();    //call loginbean class

        String u = request.getParameter("username");    //get the entered login information 
        String p = request.getParameter("password");

        String role = ub.checkLogin(u, p);      //get the login role

        if (role != null) { //check if user name and password is valid
   
           //Redirect user based on role in db
            if ("admin".equals(role)){
                HttpSession session = request.getSession();
                session.setAttribute("admin", role);
                session.setAttribute("uname",u);
                session.setMaxInactiveInterval(10 * 600);
                RequestDispatcher view = request.getRequestDispatcher("adminDashboard.jsp");
                view.forward(request, response);
            }else if ("nurse".equals(role)){
                HttpSession session = request.getSession();
                session.setAttribute("nurse", role);
                session.setAttribute("uname",u);
                session.setMaxInactiveInterval(10 * 60);
                RequestDispatcher view = request.getRequestDispatcher("nurseDashboard.jsp");
                view.forward(request, response);
            }else if ("client".equals(role)){
                HttpSession session = request.getSession();
                session.setAttribute("client", role);
                session.setAttribute("uname",u);
                session.setMaxInactiveInterval(10 * 60);
                RequestDispatcher view = request.getRequestDispatcher("clientDashboard.jsp");
                view.forward(request, response);
            }else{
                HttpSession session = request.getSession();
                session.setAttribute("doctor", role);
                session.setAttribute("uname",u);
                session.setMaxInactiveInterval(10 * 60);
                RequestDispatcher view = request.getRequestDispatcher("doctorDashboard.jsp");
                view.forward(request, response);
            }  
        //If invalid input - return to login screen
       } else {
           RequestDispatcher view = request.getRequestDispatcher("index.jsp");
           view.forward(request, response);
       }
    
 
    }
    
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
