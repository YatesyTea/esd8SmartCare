<%-- 
    Document   : AdminPatient
    Created on : 15-Dec-2020, 12:25:29
    Author     : carl
    Adapted for use of this file by Yates
--%>

<%@page import="model.Patient"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Current Patients</title>
    </head>
    <body>
        <button onclick="location.href = 'adminDashboard.jsp';">
            Back to Dashboard
        </button>
        <h1 id="textid">Patient List</h1>

        <%
            ArrayList<Patient> patient = (ArrayList<Patient>) request.getAttribute("patient");
        %>



        <table>
            <tr>
                <th>Name</th>
                <th>Address</th>
                <th>DOB</th>
                <th>Username</th>
                <th>Type</th>
            </tr>
                <% for (Patient a : patient)  { %>
                <form action= "AdminPatientsServlet.do" method="POST">
                <tr>
                    <td><%=a.getName()%></td>
                    <td><%=a.getAddress()%></td>
                    <td><%=a.getDob()%></td>
                    <td><%=a.getUsername()%></td>
                    <td><%=a.getType()%></td>
                    <td ><input type="Submit" name="action" value="Cancel"/></td>
                    
                    <input type="hidden" name="id" value="<%=a.getUsername()%>"/>
                    
                </tr>
                </form>
                <% }%>
        </table>
    </body>
</html>
