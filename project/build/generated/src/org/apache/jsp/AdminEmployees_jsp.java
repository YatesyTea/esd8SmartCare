package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Employees;
import java.util.ArrayList;

public final class AdminEmployees_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Current Employees</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <button onclick=\"location.href = 'adminDashboard.jsp';\">\r\n");
      out.write("            Back to Dashboard\r\n");
      out.write("        </button>\r\n");
      out.write("        <button onclick=\"location.href = 'adminCreateEmployee.jsp';\">\r\n");
      out.write("            Create Employee\r\n");
      out.write("        </button>\r\n");
      out.write("        <h1 id=\"textid\">Admin Employees List</h1>\r\n");
      out.write("\r\n");
      out.write("        ");

            ArrayList<Employees> employee = (ArrayList<Employees>) request.getAttribute("employees");
        
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <table>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <th>Name</th>\r\n");
      out.write("                <th>Address</th>\r\n");
      out.write("                <th>DOB</th>\r\n");
      out.write("                <th>Username</th>\r\n");
      out.write("            </tr>\r\n");
      out.write("            ");
 for (Employees e : employee) {
      out.write("\r\n");
      out.write("            <form action= \"AdminEmployeesController.do\" method=\"POST\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>");
      out.print(e.getName());
      out.write("</td>\r\n");
      out.write("                    <td>");
      out.print(e.getAddress());
      out.write("</td>\r\n");
      out.write("                    <td>");
      out.print(e.getDob());
      out.write("</td>\r\n");
      out.write("                    <td>");
      out.print(e.getUname());
      out.write("</td>\r\n");
      out.write("                    <td ><input type=\"Submit\" value=\"Suspend\"/></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <input type=\"hidden\" name=\"id\" value=\"");
      out.print(e.getUname());
      out.write("\"/>\r\n");
      out.write("            </form>\r\n");
      out.write("            ");
 }
      out.write("\r\n");
      out.write("        </table>\r\n");
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
