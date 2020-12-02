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
                <input type="text" name="username" placeholder="Username"/><br/><br/>
                <input type="password" name="password" placeholder="Password"/><br/><br/>
                <input type="Submit" value="Login"/>
                <input type="Submit" value="Sign Up"/>
            </form>
    </body>
</html>
