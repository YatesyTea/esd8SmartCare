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
                    <th>Employee</th>
                    <th>Patient</th>
                    <th>Date</th>
                    <th>Time</th>
                </tr>
                <% for (Appointment a : appointments)  { %>
                <form action= "EmployeeTimetableServlet.do" method="POST">
                <tr>
                    <td><%=a.geteID()%></td>
                    <td><%=a.getcID()%></td>
                    <td><%=a.getAppointmentDate()%></td>
                    <td><%=a.getAppointmentTime()%></td>
                    <td ><input type="Submit" name="action" value="Edit"/></td>
                    <td ><input type="Submit" name="action" value="Cancel"/></td>
                    <input type="hidden" name="id" value="<%=a.getsID()%>"/>
                    
                    
                </tr>
                
                </form>
                <% }%>
            </table>
    </body>
</html>
