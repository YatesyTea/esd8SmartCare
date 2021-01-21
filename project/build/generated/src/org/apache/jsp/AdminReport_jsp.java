package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Prescription;
import model.Invoice;
import java.util.ArrayList;

public final class AdminReport_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Weekly Report</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            ArrayList<Prescription> prescription = (ArrayList<Prescription>)request.getAttribute("prescription");
            ArrayList<Invoice> operations = (ArrayList<Invoice>)request.getAttribute("operation");
        
      out.write("\n");
      out.write("        <div class=\"box\">\n");
      out.write("        <h1>Weekly Report</h1>\n");
      out.write("        <h1>Charges</h1>\n");
      out.write("        <h2>Prescriptions</h2>\n");
      out.write("         <table>\n");
      out.write("            <tr>\n");
      out.write("                <th>Prescription|</th>\n");
      out.write("                <th>Date Issued|</th>\n");
      out.write("                <th>Cost|</th>\n");
      out.write("                <th>Payment Type</th>\n");
      out.write("            </tr>\n");
      out.write("            \n");
      out.write("            ");

                String type1 = "NHS";
        
                float NHSPrescriptionTotal = 0;
                float PrivatePrescriptionTotal = 0;
                for (int i = 0; i < prescription.size(); i++) {
                    out.println("<tr>");
                    out.println("<td>" + prescription.get(i).getDrug() + "</td>");
                    out.println("<td>" + prescription.get(i).getDate() + "</td>");
                    out.println("<td>" + prescription.get(i).getCost() + "</td>");
                    out.println("<td>" + prescription.get(i).getType() + "</td>");
                    out.println("</tr>");
                    boolean equalTo = type1.equals(prescription.get(i).getType());
                    if (equalTo == true){
                        NHSPrescriptionTotal = NHSPrescriptionTotal + prescription.get(i).getCost();
                    } else
                        PrivatePrescriptionTotal = PrivatePrescriptionTotal + prescription.get(i).getCost();
                }   
            
      out.write("\n");
      out.write("        </table>\n");
      out.write("            ");

                out.println("<h4>" + "Total NHS Prescription Turnover: £" + NHSPrescriptionTotal + "</h4>");
                out.println("<h4>" + "Total Private Prescription Turnover: £" + PrivatePrescriptionTotal + "</h4>" + "\n");
                float TotalPrescriptionSum = NHSPrescriptionTotal + PrivatePrescriptionTotal;
                out.println("<h4>" + "Total Prescription Turnover: £" + TotalPrescriptionSum + "</h4>");
            
      out.write("\n");
      out.write("        <h2>Operations</h2>\n");
      out.write("        <table>\n");
      out.write("            <tr>\n");
      out.write("                <th>|Surgery|</th>\n");
      out.write("                <th>Date Issued|</th>\n");
      out.write("                <th>Cost|</th>\n");
      out.write("            </tr>\n");
      out.write("            \n");
      out.write("            ");

                float operationsTotal = 0;
                for (int j = 0; j < operations.size(); j++) {
                    out.println("<tr>");
                    out.println("<td>" + operations.get(j).getSurgery() + "</td>");
                    out.println("<td>" + operations.get(j).getDate() + "</td>");
                    out.println("<td>" + operations.get(j).getCost() + "</td>");
                    out.println("</tr>");
                    operationsTotal = operationsTotal + operations.get(j).getCost() ;
                }
            
      out.write("\n");
      out.write("        </table>\n");
      out.write("        ");

                out.println("<tr>" + "Total Operations Turnover: £" + operationsTotal + "</tr>");
            
      out.write("\n");
      out.write("        <h1>Weekly Turnover</h1>\n");
      out.write("        ");

                float totalTurnover = 0;
                totalTurnover = operationsTotal + TotalPrescriptionSum;
                out.println("<tr>" + "Total Operations Turnover: £" + totalTurnover + "</tr>");
            
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
