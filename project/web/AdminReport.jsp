<%-- 
    Document   : AdminReport.jsp
    Created on : 19-Jan-2021, 06:06:34
    Author     : fdent
--%>
<%@page import="model.Prescription"%>
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
        %>
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
                for (int i = 0; i < prescription.size(); i++) {
                    out.println("<tr>");
                    out.println("<td>" + prescription.get(i).getDrug() + "</td>");
                    out.println("<td>" + prescription.get(i).getDate() + "</td>");
                    out.println("<td>" + prescription.get(i).getCost() + "</td>");
                    out.println("</tr>");
                }
            %>
        </table>
        <h2>Surgeries</h2>
        <h1>Payments</h1>
        <h1>Weekly Turnover</h1>
    </body>
</html>
