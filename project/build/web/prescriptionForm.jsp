 <%-- 
    Document   : prescriptionForm
    Created on : 13-Dec-2020, 19:49:57
    Author     : fdent
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/style.css">
        <link rel="shorcut icon" type="image/png" href="image/favicon.png">
        <title>Issue Prescription</title>
    </head>
    <body>
        <form class="box" action="PrescriptionServlet.do" method="POST">
            <h1>Issue Prescription</h1>
            
            <input type="text" placeholder="Enter Client ID" name="pid" required>
            <input type="text" placeholder="Drug Name" name="drug" required>
            <input type="text" placeholder="Enter Dosage" name="dosage" required>
            <input type="text" placeholder ="Cost" name="cost" required>
            <input type="text" placeholder="Date Prescribed (FORMAT YYYY-MM-DD)" name="date" required>
            <input type="text" placeholder="Repeating" name="reissue" required>
            
            <input type="submit" value="Issue Prescription">
        </form>
    </body>
</html>
