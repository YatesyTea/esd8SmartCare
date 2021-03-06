<%-- 
    Document   : doctorLogin
    Created on : 28-Nov-2020, 16:07:04
    Author     : samue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/dashboardStyle.css">
        <link rel="shorcut icon" type="image/png" href="image/favicon.png">
        <title>SmartCare - Dashboard</title>
    </head>
    <body>
        <div class="wrapper">
            <div class="box header">
                <h1>Welcome Doctor</h1>
            </div>
            <div class="box content">
                <div class= "content a">
                    <h1>Issue Prescription</h1>
                    <button onclick="location.href= 'prescriptionForm.jsp';">
                        Issue Prescription
                    </button> 
                </div>
                <div class= "content b">
                    <h1>Generate Invoice</h1>
                    <button onclick="location.href= 'generateInvoice.jsp';">
                        Generate Invoice
                    </button> 
                </div>
                <div class= "content c">
                    <h1>View Patient Timetables</h1>
                    <form method="get" action="EmployeeTimetableServlet.do"><p style="text-align:center">
                    <input id="textboxid" type="SUBMIT" value="Patient Timetable" style="align-self: center">
                    </p></form>
                </div>
            </div>
        </div>
</body>
</html>
