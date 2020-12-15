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
import model.PrescriptionBean;
import model.Prescription;

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
        String dn = request.getParameter("dname");
        
        Prescription prescription1 = new Prescription(t,pn,d,dsg,dn);
        pb.addPrescription(prescription1);
       
        }
    }
