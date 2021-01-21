<%-- 
    Document   : AdminReport.jsp
    Created on : 19-Jan-2021, 06:06:34
    Author     : fdent
--%>
<%@page import="model.Prescription"%>
<%@page import="model.Invoice"%>

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
            ArrayList<Invoice> operations = (ArrayList<Invoice>)request.getAttribute("operation");
        %>
        <div class="box">
        <h1>Weekly Report</h1>
        <h1>Charges</h1>
        <h2>Prescriptions</h2>
         <table>
            <tr>
                <th>Prescription|</th>
                <th>Date Issued|</th>
                <th>Cost|</th>
                <th>Payment Type</th>
            </tr>
            
            <%
                String type1 = "NHS";
        
                float NHSPrescriptionTotal = 0;
                float PrivatePrescriptionTotal = 0;
                for (int i = 0; i < prescription.size(); i++) {
                    out.println("<tr>");
                    out.println("<td>" + prescription.get(i).getDrug() + "</td>");
                    out.println("<td>" + prescription.get(i).getDate() + "</td>");
                    out.println("<td>" + prescription.get(i).getCost() + "</td>");
                    out.println("<td>" + prescription.get(i).getType() + "</td>");
                    out.println("</tr>");
                    boolean equalTo = type1.equals(prescription.get(i).getType());
                    if (equalTo == true){
                        NHSPrescriptionTotal = NHSPrescriptionTotal + prescription.get(i).getCost();
                    } else
                        PrivatePrescriptionTotal = PrivatePrescriptionTotal + prescription.get(i).getCost();
                }   
            %>
        </table>
            <%
                out.println("<h4>" + "Total NHS Prescription Turnover: £" + NHSPrescriptionTotal + "</h4>");
                out.println("<h4>" + "Total Private Prescription Turnover: £" + PrivatePrescriptionTotal + "</h4>" + "\n");
                float TotalPrescriptionSum = NHSPrescriptionTotal + PrivatePrescriptionTotal;
                out.println("<h4>" + "Total Prescription Turnover: £" + TotalPrescriptionSum + "</h4>");
            %>
        <h2>Operations</h2>
        <table>
            <tr>
                <th>|Surgery|</th>
                <th>Date Issued|</th>
                <th>Cost|</th>
                <th>Payment Type</th>
            </tr>
            
            <%
                String type2 = "NHS";
                float NHSOperationTotal = 0;
                float PrivateOperationTotal = 0;
                for (int j = 0; j < operations.size(); j++) {
                    out.println("<tr>");
                    out.println("<td>" + operations.get(j).getSurgery() + "</td>");
                    out.println("<td>" + operations.get(j).getDate() + "</td>");
                    out.println("<td>" + operations.get(j).getCost() + "</td>");
                    out.println("<td>" + operations.get(j).getType() + "</td>");
                    out.println("</tr>");
                    boolean equalTo = type2.equals(operations.get(j).getType());
                    if (equalTo == true){
                        NHSOperationTotal = NHSOperationTotal + operations.get(j).getCost();
                    } else
                        PrivateOperationTotal = PrivateOperationTotal + operations.get(j).getCost();
                }
            %>
        </table>
        <%
                out.println("<h4>" + "Total NHS Operation Turnover: £" + NHSOperationTotal + "</h4>");
                out.println("<h4>" + "Total Private Operation Turnover: £" + PrivateOperationTotal + "</h4>" + "\n");
                float TotalOperationSum = NHSOperationTotal + PrivateOperationTotal;
                out.println("<h4>" + "Total Operation Turnover: £" + TotalOperationSum + "</h4>");
            %>
        <h1>Weekly Turnover</h1>
        <%
                float totalTurnover = 0;
                totalTurnover = TotalOperationSum + TotalPrescriptionSum;
                out.println("<h1>" + "Total Turnover: £" + totalTurnover + "</h1>");
            %>
        </div>
    </body>
</html>
