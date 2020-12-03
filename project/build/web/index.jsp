<%-- 
    Document   : index
    Created on : 01-Dec-2020, 12:41:30
    Author     : Yates
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="style/style.css">
        <link rel="shorcut icon" type="image/png" href="image/favicon.png">
        <title>SmartCare - Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
            <form class="box" action="usersServlet.do" method="post">
                <h1>Welcome To SmartCare</h1>
                <h1>Login or Sign Up</h1>
                <input type="text" name="username" placeholder="Username"/>
                <input type="password" name="password" placeholder="Password"/>
                <input type="Submit" value="Login"/>
            </form>
         <input type="submit" value="Sign Up" onclick="location.href='registerUser.jsp'"/> 
    </body>
</html>
