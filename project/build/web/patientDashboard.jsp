<%-- 
    Document   : patientDashboard
    Created on : 19-Jan-2021, 15:47:31
    Author     : carl
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
                <h1>Welcome Client</h1>
            </div>
            <div class="box content">
                <div class= "content a">
                    <h1>View Appointments</h1>
                    <form method="get" action="PatientAppointmentsServlet.do"><p style="text-align:center">
                    <input id="textboxid" type="SUBMIT" value="View Appointments" style="align-self: center">
                    </p></form>
                </div>
                <div class= "content b">
                    <h1>Book Appointment</h1>
                </div>
                <div class= "content c">
                    <h1>Prescriptions</h1>
                    <form method="post" action="ViewPrescriptionServlet.do"><p style="text-align:center">
                    <input id="textboxid" type="SUBMIT" value="View Prescriptions" style="align-self: center">
                        </p></form>
                </div>                
                <div class= "content d">
                    <h1>View Charges</h1>
                    <form method="post" action="PatientChargeController.do"><p style="text-align:center">
                    <input id="textboxid" type="SUBMIT" value="Charges" style="align-self: center">
                    </p></form>                   
                </div>
            </div>
        </div>
    </body>
</html>
