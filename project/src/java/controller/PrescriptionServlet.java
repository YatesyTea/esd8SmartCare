/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.PrescriptionBean;
import model.Prescription;
import controller.UsersServlet;
import static model.PrescriptionBean.checkValid;
import java.util.Date;  
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import controller.UsersServlet;
import javax.servlet.http.Cookie;
import model.UsersBean;


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
     * @throws java.text.ParseException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        PrescriptionBean pb = new PrescriptionBean();
             
        //Create parameter variables using inputs taken from sign up form
        String d = request.getParameter("drug");
        int pid = Integer.parseInt(request.getParameter("pid"));    //get the entered login information 
        float cost = Float.parseFloat(request.getParameter("cost"));
        String dI = request.getParameter("date");
        int dsg = Integer.parseInt(request.getParameter("dosage"));
        int reI = Integer.parseInt(request.getParameter("reissue"));
        String type = "NHS";

        String employeeID = null;
        for (Cookie c: request.getCookies()){
                if(c.getName().equals("patient")){
                    employeeID = c.getValue();
                }
            }
        
        System.out.println("employeeID");
        int eid = Integer.parseInt(employeeID);
        String ename = "placeholder";
        
        String valid = checkValid(pid,eid);
        Prescription prescription1 = new Prescription(eid,pid,d,dI,dsg,cost,reI,type, ename);
        //System.out.print(prescription1);
        
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(PrescriptionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(PrescriptionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
