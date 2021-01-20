<%-- 
    Document   : AdminReport.jsp
    Created on : 19-Jan-2021, 06:06:34
    Author     : fdent
--%>
<%@page import="model.Prescription"%>
<%@page import="model.Invoice"%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Weekly Report</title>
    </head>
    <body>
        <%
            ArrayList<Prescription> prescription = (ArrayList<Prescription>)request.getAttribute("prescription");
            ArrayList<Invoice> operations = (ArrayList<Invoice>)request.getAttribute("operation");
        %>
        <div class="box">
        <h1>Weekly Report</h1>
        <h1>Charges</h1>
        <h2>Prescriptions</h2>
         <table>
            <tr>
                <th>|Prescription|</th>
                <th>Date Issued|</th>
                <th>Cost|</th>
            </tr>
            
            <%
                float prescriptionTotal = 0;
                for (int i = 0; i < prescription.size(); i++) {
                    out.println("<tr>");
                    out.println("<td>" + prescription.get(i).getDrug() + "</td>");
                    out.println("<td>" + prescription.get(i).getDate() + "</td>");
                    out.println("<td>" + prescription.get(i).getCost() + "</td>");
                    out.println("</tr>");
                    prescriptionTotal = prescriptionTotal + prescription.get(i).getCost() ;
                }   
            %>
        </table>
            <%
                out.println("<tr>" + "Total Prescription Turnover: £" + prescriptionTotal + "</tr>");
            %>
        <h2>Operations</h2>
        <table>
            <tr>
                <th>|Surgery|</th>
                <th>Date Issued|</th>
                <th>Cost|</th>
            </tr>
            
            <%
                float operationsTotal = 0;
                for (int j = 0; j < operations.size(); j++) {
                    out.println("<tr>");
                    out.println("<td>" + operations.get(j).getSurgery() + "</td>");
                    out.println("<td>" + operations.get(j).getDate() + "</td>");
                    out.println("<td>" + operations.get(j).getCost() + "</td>");
                    out.println("</tr>");
                    operationsTotal = operationsTotal + operations.get(j).getCost() ;
                }
            %>
        </table>
        <%
                out.println("<tr>" + "Total Operations Turnover: £" + operationsTotal + "</tr>");
            %>
        <h1>Weekly Turnover</h1>
        <%
                float totalTurnover = 0;
                totalTurnover = operationsTotal + prescriptionTotal;
                out.println("<tr>" + "Total Operations Turnover: £" + totalTurnover + "</tr>");
            %>
        </div>
    </body>
</html>
