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
        <title>Current Employees</title>
    </head>
    <body>
        <button onclick="location.href = 'adminDashboard.jsp';">
            Back to Dashboard
        </button>
        <button onclick="location.href = 'adminCreateEmployee.jsp';">
            Create Employee
        </button>
        <h1 id="textid">Admin Employees List</h1>

        <%
            ArrayList<Employees> employee = (ArrayList<Employees>) request.getAttribute("employees");
        %>



        <table>
            <tr>
                <th>Name</th>
                <th>Address</th>
                <th>DOB</th>
                <th>Username</th>
            </tr>
            <% for (Employees e : employee) {%>
            <form action= "AdminEmployeesController.do" method="POST">
                <tr>
                    <td><%=e.getName()%></td>
                    <td><%=e.getAddress()%></td>
                    <td><%=e.getDob()%></td>
                    <td><%=e.getUname()%></td>
                    <td ><input type="Submit" value="Suspend"/></td>
                </tr>
                <input type="hidden" name="id" value="<%=e.getUname()%>"/>
            </form>
            <% }%>
        </table>
    </body>
</html>
