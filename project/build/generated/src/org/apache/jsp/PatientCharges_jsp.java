package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Charges;
import java.util.ArrayList;

public final class PatientCharges_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1 id=\"textid\">Patient Charges</h1>\n");
      out.write("        \n");
      out.write("        ");

            ArrayList<Charges> charges = (ArrayList<Charges>)request.getAttribute("charges");
        
      out.write("\n");
      out.write("        \n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <th>Patient ID</th>\n");
      out.write("                    <th>Date Issued</th>\n");
      out.write("                    <th>Amount</th>\n");
      out.write("                </tr>\n");
      out.write("                \n");
      out.write("                ");
 
                    for (int i = 0; i < charges.size(); i++) {
                        out.println("<tr>");
                        out.println("<td>" + charges.get(i).getPatient_id() + "</td>");
                        out.println("<td>" + charges.get(i).getDate() + "</td>");
                        out.println("<td>" + charges.get(i).getCost() + "</td>");
                        out.println("</tr>");
                    }
                
      out.write("\n");
      out.write("                \n");
      out.write("            </table>\n");
      out.write("    </body>\n");
      out.write("</html>");
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
