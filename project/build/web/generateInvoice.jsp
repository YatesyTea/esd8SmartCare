<%-- 
    Document   : generateInvoice
    Created on : 18-Jan-2021, 18:39:09
    Author     : carl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/style.css">
        <link rel="shorcut icon" type="image/png" href="image/favicon.png">
        <title>Generate Invoice</title>
    </head>
    <body>
        <form class="box" action="InvoiceController.do" method="POST">
            <h1>Generate Invoice</h1>
            
            <!__<input type="text" placeholder="Op ID" name="id" required>_>
            <input type="text" placeholder="Doctors Name" name="eid" required>
            <input type="text" placeholder="Enter Patient ID" name="pid" required>
            <input type="text" placeholder="Surgery Type" name="surgery" required>
            <input type="text" placeholder="Date (FORMAT YYYY/MM/DD)" name="date" required>
            <input type="text" placeholder ="Cost" name="cost" required>
            
            <input type="submit" value="Generate Invoice">
        </form>
    </body>
</html>