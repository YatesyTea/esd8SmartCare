<%-- 
    Document   : patientTimetable
    Created on : 20-Jan-2021, 20:16:27
    Author     : Reece
--%>

<%@page import="model.Appointment"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
   <body>
        <h1 id="textid">Timetable</h1>

        <%
            ArrayList<Appointment> appointments = (ArrayList<Appointment>)request.getAttribute("appointments");
        %>
        
        
        
        <table>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Address</th>
                    <th>DOB</th>
                </tr>
                <% for (Appointment a : appointments)  { %>
                <form action= "AdminEmployeesController.do" method="POST">
                <tr>
                    <td><%=a.geteID()%></td>
                    <td><%=a.getcID()%></td>
                    <td><%=a.getAppointmentDate()%></td>
                    <td><%=a.getAppointmentTime()%></td>
                    <td ><input type="Submit" value="Suspend"/></td>
                </tr>
                
                </form>
                <% }%>
            </table>
    </body>
</html>
