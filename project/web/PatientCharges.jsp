<%-- 
    Document   : PatientCharges
    Created on : 19-Jan-2021, 14:14:38
    Author     : carl
--%>

<%@page import="model.Charges"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 id="textid">Patient Charges</h1>
        
        <%
            ArrayList<Charges> charges = (ArrayList<Charges>)request.getAttribute("charges");
        %>
        
            <table>
                <tr>
                    <th>ID</th>
                    <th>Patient ID</th>
                    <th>Date Issued</th>
                    <th>Amount</th>
                </tr>
                
                <% 
                    for (int i = 0; i < charges.size(); i++) {
                        out.println("<tr>");
                        out.println("<td>" + charges.get(i).getId() + "</td>");
                        out.println("<td>" + charges.get(i).getPatient_id() + "</td>");
                        out.println("<td>" + charges.get(i).getDate() + "</td>");
                        out.println("<td>" + charges.get(i).getCost() + "</td>");
                        out.println("</tr>");
                    }
                %>
                
            </table>
    </body>
</html>