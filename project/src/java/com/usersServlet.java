/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.loginBean;


public class usersServlet extends HttpServlet {

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
      loginBean lb = new loginBean();    //call loginbean class

        String u = request.getParameter("username");    //get the entered login information 
        String p = request.getParameter("password");
        
        
       
        String a = lb.doQuery("");      //get the login role

       if (loginBean.checkLogin(u, p)) { //check if user name and password is valid
           
           //if valid check the persons role and display relevent view
                   if ("admin".equals(a)){
                    RequestDispatcher view = request.getRequestDispatcher("adminLogin.jsp");
                    view.forward(request, response);
                   }else if ("nurse".equals(a)){
                     RequestDispatcher view = request.getRequestDispatcher("nurseLogin.jsp");
                     view.forward(request, response);
                     }else if ("client".equals(a)){
                     RequestDispatcher view = request.getRequestDispatcher("clientLogin.jsp");
                     view.forward(request, response);
                   }else{
                    RequestDispatcher view = request.getRequestDispatcher("doctorLogin.jsp");
                     view.forward(request, response);
                   }  
           //if invalid go back to login screen
       } else {
           RequestDispatcher view = request.getRequestDispatcher("index.html");
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
