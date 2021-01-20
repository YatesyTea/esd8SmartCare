/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Charges;
import model.DBCharges;

/**
 *
 * @author carl
 */
public class PatientChargeController extends HttpServlet {
       
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
//        Cookie[] cookie = request.getCookies();
//        String pid1 = cookie1[0].getValue();
//        int pid = Integer.parseInt(pid1);
//        System.out.println(cookie1[0] + " PatientID:");
        
        String patientID = null;
        
        for (Cookie c: request.getCookies()){
                if(c.getName().equals("patient")){
                    patientID = c.getValue();
                }
            }        
        
        int pid = Integer.parseInt(patientID);
        
        System.out.println("Patient id = " + pid);       
        
        DBCharges chr = new DBCharges();       
        ArrayList<Charges> charges;
        charges = chr.getCharges(pid);
        request.setAttribute("charges", charges);
           
        RequestDispatcher view = request.getRequestDispatcher("PatientCharges.jsp");
        view.forward(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
    }
}

