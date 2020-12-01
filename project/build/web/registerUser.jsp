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
        <title>Registration Page</title>
    </head>
    <body>
        <form action="registerServlet.do" method="POST">
            <p> Please fill in this form.<p>
            <hr>
            
            <label for="name">Full Name<br/></label>
            <input type="text" placeholder="Enter Name" name="name" id ="nameid" required>
            
            <label for="address"><br/>Address<br/></label>
            <input type="text" placeholder="Enter Address" name="address" id="address" required>
            
            <label for="uname">Username<br/></label>
            <input type="text" placeholder="Enter Username" name="uname" id ="unameid" required>
     
            <label for="password"><br/>Password<br/></label>
            <input type="password" placeholder="Enter Password" name="password" id="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"required>

            <label for="password1"><br/>Confirm Password</br></label>
            <input type="password" placeholder="Confirm Password" name="password1" id="confirmPassword" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required>
            </br>
            
            <label for="type">Patient Type<br/></label>
            <select name ="type" id ="patient-type">
                <option value="NHS">NHS</option>
                <option value="private">Private</option>
            </select>
            <button type="submit" class="registerbtn">Register</button>
            
        </form>
    </body>
</html>