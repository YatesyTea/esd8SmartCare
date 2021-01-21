<%-- 
    Document   : patientTimetable
    Created on : 21-Jan-2021, 00:06:30
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
        <h1 id="textid">Appointments</h1>

        <%
            ArrayList<Appointment> appointments = (ArrayList<Appointment>)request.getAttribute("appointments");
        %>
        
        <form action="" method="GET">
              <input type="Submit" name="new" value="Request Appointment"/>
        </form>
        
        <table>
                <tr>
                    <th>Doctor/Nurse</th>
                    <th>Date</th>
                    <th>Time</th>
                </tr>
                <% for (Appointment a : appointments)  { %>
                <form action= "EmployeeTimetableServlet.do" method="POST">
                <tr>
                    <td><%=a.geteID()%></td>
                    <td><%=a.getAppointmentDate()%></td>
                    <td><%=a.getAppointmentTime()%></td>
                    <td ><input type="Submit" name="action" value="Cancel"/></td>
                    
                    <input type="hidden" name="id" value="<%=a.getsID()%>"/>
                    
                </tr>
                </form>
                <% }%>
            </table>
    </body>
</html>
