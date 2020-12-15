<%-- 
    Document   : AdminCharges
    Created on : 15-Dec-2020, 19:45:43
    Author     : carl
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 id="textid">Admin Charges</h1>
        
        <%
            ArrayList<Charges> charges = (ArrayList<Charge>)request.getAttribute("claims");
        %>
        
        <div style="overflow-x:auto;">
            <table>
                <tr>
                    <th>ID</th>
                    <th>Client ID</th>
                    <th>Date</th>
                    <th>Amount</th>
                </tr>
                
                <% 
                    for (int i = 0; i < charge.size(); i++) {
                        out.println("<tr>");
                        out.println("<td>" + charge.get(i).getOId() + "</td>");
                        out.println("<td>" + charge.get(i).getCId() + "</td>");
                        out.println("<td>" + charge.get(i).getDate() + "</td>");
                        out.println("<td>" + charge.get(i).getAmount() + "</td>");
                        out.println("</tr>");
                    }
                %>
                
            </table>
    </body>
</html>
