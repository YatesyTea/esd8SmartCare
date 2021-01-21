package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Appointment;
import java.util.ArrayList;

public final class patientTimetable_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("   <body>\n");
      out.write("        <h1 id=\"textid\">Timetable</h1>\n");
      out.write("\n");
      out.write("        ");

            ArrayList<Appointment> appointments = (ArrayList<Appointment>)request.getAttribute("appointments");
        
      out.write("\n");
      out.write("        \n");
      out.write("        <form action=\"\" method \"GET\">\n");
      out.write("              <input type=\"Submit\" name=\"new\" value=\"Request Appointment\"/>\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <table>\n");
      out.write("                <tr>\n");
      out.write("                    <th>Employee</th>\n");
      out.write("                    <th>Patient</th>\n");
      out.write("                    <th>Date</th>\n");
      out.write("                    <th>Time</th>\n");
      out.write("                </tr>\n");
      out.write("                ");
 for (Appointment a : appointments)  { 
      out.write("\n");
      out.write("                <form action= \"EmployeeTimetableServlet.do\" method=\"POST\">\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print(a.geteID());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(a.getcID());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(a.getAppointmentDate());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(a.getAppointmentTime());
      out.write("</td>\n");
      out.write("                    <td ><input type=\"Submit\" name=\"action\" value=\"Cancel\"/></td>\n");
      out.write("                    \n");
      out.write("                    <input type=\"hidden\" name=\"id\" value=\"");
      out.print(a.getsID());
      out.write("\"/>\n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                </tr>\n");
      out.write("                \n");
      out.write("                </form>\n");
      out.write("                ");
 }
      out.write("\n");
      out.write("            </table>\n");
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
