<%-- 
    Document   : RegisterUser
    Created on : 28-Nov-2020, 18:05:08
    Author     : carl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/style.css">
        <link rel="shorcut icon" type="image/png" href="image/favicon.png">
        <title>SmartCare - Sign Up</title>
    </head>
    <body>

        <form class="box" action="registerServlet.do" method="POST">
            <h1>Sign Up</h1>
            <h2>By Filling In Your Details</h2>


            <input type="text" placeholder="Enter Name" name="name" id ="nameid" required>

            <input type="text" placeholder="Enter Address" name="address" id="address" required>

            <input type="text" placeholder="Enter Username" name="uname" id ="unameid" required>

            <input type="password" placeholder="Enter Password" name="password" id="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"required>

            <input type="password" placeholder="Confirm Password" name="password1" id="confirmPassword" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required>

            <label for="type">Patient Type:</label>
            <select name ="type" id ="patient-type">
                <option value="NHS">NHS</option>
                <option value="private">Private</option>
            </select>
            <input type="submit" value="Register">

        </form>
    </body>
</html>