package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class patientDashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"style/dashboardStyle.css\">\r\n");
      out.write("        <link rel=\"shorcut icon\" type=\"image/png\" href=\"image/favicon.png\">\r\n");
      out.write("        <title>SmartCare - Dashboard</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"wrapper\">\r\n");
      out.write("            <div class=\"box header\">\r\n");
      out.write("                <h1>Welcome Client</h1>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"box content\">\r\n");
      out.write("                <div class= \"content a\">\r\n");
      out.write("                    <h1>View Appointments</h1>\r\n");
      out.write("                    <form method=\"get\" action=\"PatientAppointmentsServlet.do\"><p style=\"text-align:center\">\r\n");
      out.write("                    <input id=\"textboxid\" type=\"SUBMIT\" value=\"View Appointments\" style=\"align-self: center\">\r\n");
      out.write("                    </p></form>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class= \"content b\">\r\n");
      out.write("                    <h1>Book Appointment</h1>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class= \"content c\">\r\n");
      out.write("                    <h1>Prescriptions</h1>\r\n");
      out.write("                    <form method=\"post\" action=\"ViewPrescriptionServlet.do\"><p style=\"text-align:center\">\r\n");
      out.write("                    <input id=\"textboxid\" type=\"SUBMIT\" value=\"View Prescriptions\" style=\"align-self: center\">\r\n");
      out.write("                        </p></form>\r\n");
      out.write("                </div>                \r\n");
      out.write("                <div class= \"content d\">\r\n");
      out.write("                    <h1>View Charges</h1>\r\n");
      out.write("                    <form method=\"post\" action=\"PatientChargeController.do\"><p style=\"text-align:center\">\r\n");
      out.write("                    <input id=\"textboxid\" type=\"SUBMIT\" value=\"Charges\" style=\"align-self: center\">\r\n");
      out.write("                    </p></form>                   \r\n");
      out.write("                </div>\r\n");
      out.write("                </div>                \r\n");
      out.write("                <div class= \"content e\">\r\n");
      out.write("                    <h1>Book appointment</h1>\r\n");
      out.write("                    <form method=\"post\" action=\"ClientBookingServlet.do\"><p style=\"text-align:center\">\r\n");
      out.write("                    <input id=\"textboxid\" type=\"SUBMIT\" value=\"Book appintment\" style=\"align-self: center\">\r\n");
      out.write("                    </p></form>                   \r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
