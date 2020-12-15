<%-- 
    Document   : AdminMembers
    Created on : 15-Dec-2020, 12:25:29
    Author     : carl
--%>

<%@page import="model.Employees"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Current Members</title>
    </head>
    <body>
        <h1 id="textid">Admin Members List</h1>
        
        <%
            ArrayList<Employees> employee = (ArrayList<Employees>)request.getAttribute("employees");
        %>
        
        <table>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Address</th>
                    <th>DOB</th>
                </tr>
                <% 
                    for (int i = 0; i < employee.size(); i++) {
                        out.println("<tr>");
                        out.println("<td>" + employee.get(i).getId() + "</td>");
                        out.println("<td>" + employee.get(i).getName() + "</td>");
                        out.println("<td>" + employee.get(i).getAddress() + "</td>");
                        out.println("<td>" + employee.get(i).getDob() + "</td>");
                        out.println("<td><button onclick=\"submitIndex(this)\">Suspend Employee</button></td>");
                        out.println("</tr>");
                    }
                %>
                
            </table>
    </body>
</html>
