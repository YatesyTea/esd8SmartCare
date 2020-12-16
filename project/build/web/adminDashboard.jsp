<%-- 
    Document   : adminLogin
    Created on : 28-Nov-2020, 17:31:41
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
                <h1>Welcome Admin</h1>
            </div>
            <div class="box content">
                <div class= "content a">
                    <h1>View Client Timetables</h1>
                </div>
                <div class= "content b">
                    <h1>Documents</h1>
                    
                    <form method="post" action="AdminChargesController.do"><p style="text-align:center">
                    <input id="textboxid" type="SUBMIT" value="Charges" style="align-self: center">
                    </p></form>
                    
                </div>
                <div class= "content c">
                    <h1>Manage Staff</h1>
                    
                    <form method="post" action="AdminEmployeesController.do"><p style="text-align:center">
                    <input id="textboxid" type="SUBMIT" value="Employees" style="align-self: center">
                    </p></form>
                    
                    
                    
                </div>
            </div>
        </div>
    </body>
</html>
