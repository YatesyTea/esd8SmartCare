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
         <title>SmartCare - Client Booking</title>
    </head>
    <body>

        <form class="box" action="RegisterServlet.do" method="POST">
            <h1>Book an appointment </h1>
            <h2>By Filling In Your Details</h2>

            <input type="text" placeholder="Enter ID" name="name" id ="nameid" required>

            <input type="text" placeholder="Enter Address" name="address" id="address" required>

            <input type="text" placeholder="Enter Username" name="username" id ="unameid" required>

            <label for="choice">Doctor or Nurse</label>
            <select name ="choice" id ="patient-prefrance">
                <option value="doctor">Doctor</option>
                <option value="nurse">Nurse</option>
            </select>
            
             <input type="text" placeholder="Date (FORMAT YYYY/MM/DD)" name="date" required>
            
              <input type="text" placeholder="Enter a time" name="time" id ="unameid" required>
              
            <input type="submit" value="submit">

        </form>
    </body>
</html>