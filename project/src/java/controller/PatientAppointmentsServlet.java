/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Appointment;
import model.AppointmentBean;

/**
 *
 * @author Reece
 */
@WebServlet(name = "PatientAppointmentsServlet", urlPatterns = {"/PatientAppointmentsServlet.do"})
public class PatientAppointmentsServlet extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String patientID = null;
            AppointmentBean b = new AppointmentBean("jdbc:derby://localhost:1527/smartcare", "administrator", "admin");
            Appointment a;
            
            if (request.getMethod().equals("POST")){
                
                String action = request.getParameter("action");
                int sid = Integer.parseInt(request.getParameter("id"));
                
                if (action.equals("Cancel")){
                    b.deleteAppointment(sid);
                    
                }
                
            }
            
            //Get user id
            for (Cookie c: request.getCookies()){
                if(c.getName().equals("patient")){
                    patientID = c.getValue();

                }
            }
            
            //Convert to int
            int pid = Integer.parseInt(patientID);
            System.out.println("PID " + pid);
            ArrayList<Appointment> appointments;
            appointments = b.getAllAppointmentByID(pid, "patient");
            
            request.setAttribute("appointments", appointments);    
            RequestDispatcher view = request.getRequestDispatcher("patientTimetable.jsp");
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
        } catch (SQLException ex) {
            Logger.getLogger(PatientAppointmentsServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(PatientAppointmentsServlet.class.getName()).log(Level.SEVERE, null, ex);
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
