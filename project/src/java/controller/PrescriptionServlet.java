/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.PrescriptionBean;
import model.Prescription;
import static model.PrescriptionBean.checkValid;

/**
 *
 * @author fdent
 */
public class PrescriptionServlet extends HttpServlet {

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
        PrescriptionBean pb = new PrescriptionBean();
        
        //Create parameter variables using inputs taken from sign up form
        String t = request.getParameter("type");
        String pn = request.getParameter("pname");    //get the entered login information 
        String d = request.getParameter("date");
        String dsg = request.getParameter("dosage");
        String en = request.getParameter("ename");
        
        String valid = checkValid(pn,en);
        Prescription prescription1 = new Prescription(t,pn,d,dsg,en);
        System.out.print(prescription1);
        
        if (valid != null) {
            pb.addPrescription(prescription1);
            RequestDispatcher view = request.getRequestDispatcher("doctorDashboard.jsp");
            view.forward(request, response);
        }
        else {
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