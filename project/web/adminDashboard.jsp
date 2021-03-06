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
                    <h1>View Patient Timetables</h1>
                    <form method="get" action="EmployeeTimetableServlet.do"><p style="text-align:center">
                            <input id="textboxid" type="SUBMIT" value="Patient Timetable" style="align-self: center">
                        </p></form>
                </div>
                <div class= "content b">
                    <h1>Produce Weekly Report</h1>
                    <form method="post" action="ReportServlet.do"><p style="text-align:center">
                            <input type="text" placeholder="Start Date(FORMAT YYYY-MM-DD)" name="date1" style="align-self: center"required>
                            <input type="text" placeholder="End Date (FORMAT YYYY-MM-DD)" name="date2" style="align-self: center"required>
                            <input id="textboxid" type="SUBMIT" value="Weekly Report" style="align-self: center">
                        </p></form>
                </div>
                <div class= "content c">
                    <h1>Manage Staff</h1> 
                    <form method="get" action="AdminEmployeesController.do"><p style="text-align:center">
                            <input id="textboxid" type="SUBMIT" value="Employees" style="align-self: center">
                        </p></form>
                    <h1>Manage Patients</h1> 
                    <form method="get" action="AdminPatientsServlet.do"><p style="text-align:center">
                            <input id="textboxid" type="SUBMIT" value="Patients" style="align-self: center">
                        </p></form>

                </div>
            </div>
        </div>
    </body>
</html>
