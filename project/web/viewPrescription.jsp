<%-- 
    Document   : viewPrescription
    Created on : 16-Dec-2020, 14:08:21
    Author     : frank
--%>

<%@page import="model.Prescription"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Prescription List</title>
    </head>
    <body>
        <h1>List of Your Prescriptions</h1>
        <%
            ArrayList<Prescription> prescription = (ArrayList<Prescription>)request.getAttribute("prescription");
        %>

        <table>
            <tr>
                <th>Prescription Type</th>
                <th>Name</th>
                <th>Date Issued</th>
                <th>Dosage</th>
                <th>Issued By</th>
            </tr>

            <%
                for (int i = 0; i < prescription.size(); i++) {
                    out.println("<tr>");
                    out.println("<td>" + prescription.get(i).getType() + "</td>");
                    out.println("<td>" + prescription.get(i).getPatientName() + "</td>");
                    out.println("<td>" + prescription.get(i).getDate() + "</td>");
                    out.println("<td>" + prescription.get(i).getDosage() + "</td>");
                    out.println("<td>" + prescription.get(i).getEmployee() + "</td>");
                    out.println("</tr>");
                }
            %>
        </table>
    </body>
</html>
