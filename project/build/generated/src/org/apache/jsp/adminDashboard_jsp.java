package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class adminDashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("                <h1>Welcome Admin</h1>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"box content\">\r\n");
      out.write("                <div class= \"content a\">\r\n");
      out.write("                    <h1>View Patient Timetables</h1>\r\n");
      out.write("                    <form method=\"get\" action=\"EmployeeTimetableServlet.do\"><p style=\"text-align:center\">\r\n");
      out.write("                            <input id=\"textboxid\" type=\"SUBMIT\" value=\"Patient Timetable\" style=\"align-self: center\">\r\n");
      out.write("                        </p></form>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class= \"content b\">\r\n");
      out.write("                    <h1>Produce Weekly Report</h1>\r\n");
      out.write("                    <form method=\"post\" action=\"ReportServlet.do\"><p style=\"text-align:center\">\r\n");
      out.write("                            <input type=\"text\" placeholder=\"Start Date(FORMAT YYYY-MM-DD)\" name=\"date1\" style=\"align-self: center\"required>\r\n");
      out.write("                            <input type=\"text\" placeholder=\"End Date (FORMAT YYYY-MM-DD)\" name=\"date2\" style=\"align-self: center\"required>\r\n");
      out.write("                            <input id=\"textboxid\" type=\"SUBMIT\" value=\"Weekly Report\" style=\"align-self: center\">\r\n");
      out.write("                        </p></form>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class= \"content c\">\r\n");
      out.write("                    <h1>Manage Staff</h1> \r\n");
      out.write("                    <form method=\"get\" action=\"AdminEmployeesController.do\"><p style=\"text-align:center\">\r\n");
      out.write("                            <input id=\"textboxid\" type=\"SUBMIT\" value=\"Employees\" style=\"align-self: center\">\r\n");
      out.write("                        </p></form>\r\n");
      out.write("\r\n");
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
