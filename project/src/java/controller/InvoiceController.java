/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DBInvoice;
import static model.DBInvoice.checkValid;
import model.Invoice;

/**
 *
 * @author carl
 */
@WebServlet(name = "InvoiceController", urlPatterns = {"/InvoiceController"})
public class InvoiceController extends HttpServlet {

   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        DBInvoice pb = new DBInvoice();
             
        //Create parameter variables using inputs taken from sign up form
        //int id = Integer.parseInt("id");
        int eid = Integer.parseInt(request.getParameter("eid"));
        int pid = Integer.parseInt(request.getParameter("pid"));
        String sur = request.getParameter("surgery");
        String dI = request.getParameter("date");   
        float c = Float.parseFloat(request.getParameter("cost"));
        String type = "NHS";
        
        
        String valid = checkValid(pid,eid);
        Invoice invoice1 = new Invoice(eid,pid,sur,dI,c,type);
        System.out.print(invoice1);
        
        if (valid != null) {
           pb.addInvoice(invoice1);
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
           Logger.getLogger(InvoiceController.class.getName()).log(Level.SEVERE, null, ex);
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
           Logger.getLogger(InvoiceController.class.getName()).log(Level.SEVERE, null, ex);
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
