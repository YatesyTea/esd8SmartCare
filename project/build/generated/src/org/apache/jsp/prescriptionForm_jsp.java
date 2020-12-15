package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class prescriptionForm_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"style/style.css\">\n");
      out.write("        <link rel=\"shorcut icon\" type=\"image/png\" href=\"image/favicon.png\">\n");
      out.write("        <title>Issue Prescription</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form class=\"box\" action=\"PrescriptionServlet.do\" method=\"POST\">\n");
      out.write("            <h1>Issue Prescription</h1>\n");
      out.write("\n");
      out.write("            <input type=\"text\" placeholder=\"Enter Prescription Type\" name=\"type\" required>\n");
      out.write("            <input type=\"text\" placeholder=\"Enter Patient Name\" name=\"pname\" required>\n");
      out.write("            <input type=\"text\" placeholder=\"Enter Date \" name=\"date\" required>\n");
      out.write("            <input type=\"text\" placeholder=\"Enter Dosage\" name=\"dosage\" required>\n");
      out.write("            <input type=\"text\" placeholder=\"Issued by\" name=\"dname\" required>\n");
      out.write("            <input type=\"submit\" value=\"Issue Prescription\">\n");
      out.write("\n");
      out.write("        </form>\n");
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
