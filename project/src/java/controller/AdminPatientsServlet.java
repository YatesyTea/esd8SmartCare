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
import model.PatientBean;
import model.Patient;

/**
 *
 * @author Yates
 */
public class AdminPatientsServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        PatientBean pat = new PatientBean("jdbc:derby://localhost:1527/smartcare", "administrator", "admin");
        ArrayList<Patient> patient;
      
        if (request.getMethod() == "POST"){
            System.out.println("POST");
            String pid = request.getParameter("id");
            
            //Remove patient from db
//            int flag = pat.deletePatient(pid);
            
        }
        
        patient = pat.getAllPatients();
        request.setAttribute("patient", patient);    
        
        System.out.println(patient);
        RequestDispatcher view = request.getRequestDispatcher("AdminPatients.jsp");
        view.forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AdminPatientsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AdminPatientsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
