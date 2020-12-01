<%-- 
    Document   : index
    Created on : 01-Dec-2020, 12:41:30
    Author     : Yates
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div id="main">
            <form action="usersServlet.do" method="post">
                Name: <input type="text" name="username"/><br/><br/>
                Password: <input type="password" name="password"/><br/><br/>
                <input type="Submit" value="Login"/>
            </form>
        </div>
    </body>
</html>
