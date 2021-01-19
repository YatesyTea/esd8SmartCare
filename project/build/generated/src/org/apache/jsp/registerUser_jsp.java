package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class registerUser_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link rel=\"stylesheet\" href=\"style/style.css\">\r\n");
      out.write("        <link rel=\"shorcut icon\" type=\"image/png\" href=\"image/favicon.png\">\r\n");
      out.write("        <title>SmartCare - Sign Up</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("\r\n");
      out.write("        <form class=\"box\" action=\"RegisterServlet.do\" method=\"POST\">\r\n");
      out.write("            <h1>Sign Up</h1>\r\n");
      out.write("            <h2>By Filling In Your Details</h2>\r\n");
      out.write("\r\n");
      out.write("            <input type=\"text\" placeholder=\"Enter Name\" name=\"name\" id =\"nameid\" required>\r\n");
      out.write("\r\n");
      out.write("            <input type=\"text\" placeholder=\"Enter Address\" name=\"address\" id=\"address\" required>\r\n");
      out.write("\r\n");
      out.write("            <input type=\"text\" placeholder=\"Enter Username\" name=\"username\" id =\"unameid\" required>\r\n");
      out.write("\r\n");
      out.write("            <input type=\"password\" placeholder=\"Enter Password\" name=\"password\" id=\"password\" pattern=\"(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}\" title=\"Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters\"required>\r\n");
      out.write("\r\n");
      out.write("            <input type=\"password\" placeholder=\"Confirm Password\" name=\"password1\" id=\"confirmPassword\" pattern=\"(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}\" required>\r\n");
      out.write("\r\n");
      out.write("            <label for=\"type\">Patient Type:</label>\r\n");
      out.write("            <select name =\"type\" id =\"patient-type\">\r\n");
      out.write("                <option value=\"NHS\">NHS</option>\r\n");
      out.write("                <option value=\"private\">Private</option>\r\n");
      out.write("            </select>\r\n");
      out.write("            <input type=\"submit\" value=\"Register\">\r\n");
      out.write("\r\n");
      out.write("        </form>\r\n");
      out.write("    </body>\r\n");
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
