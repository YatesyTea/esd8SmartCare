<%-- 
    Document   : adminCreateEmployee
    Created on : 20-Jan-2021, 22:16:46
    Author     : Yates
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/style.css">
        <link rel="shorcut icon" type="image/png" href="image/favicon.png">
        <title>SmartCare - Create Employee</title>
    </head>
</head>
<body>
    <form class="box" action="AddEmployeeServlet.do" method="POST">
        <h1>Create Employee</h1>
        <h2>By Filling In These Details</h2>

        <input type="text" placeholder="Enter Name" name="name" id ="nameid" required>

        <input type="text" placeholder="Enter Address" name="address" id="address" required>

        <input type="date" placeholder="Enter DOB" name="dob" id="dob" required>

        <input type="text" placeholder="Enter Username" name="username" id ="unameid" required>

        <input type="password" placeholder="Enter Password" name="password" id="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"required>

        <input type="password" placeholder="Confirm Password" name="password1" id="confirmPassword" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required>

        <label for="role">Employee Type:</label>
        <select name ="role" id ="role">
            <option value="doctor">Doctor</option>
            <option value="nurse">Nurse</option>
        </select>
        <input type="submit" value="Create Employee">

        <button onclick="location.href = 'adminDashboard.jsp';">
            Back to Dashboard
        </button>
</body>
</html>
