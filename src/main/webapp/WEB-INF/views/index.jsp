<%-- 
    Document   : index
    Created on : Nov 30, 2019, 2:59:21 PM
    Author     : anastasios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome to our application!</h1>
        <p>
            Logged in as : ${user.username} | <a href="logout">Logout</a>
        </p>
        <p>
            <a href="customer/list">Customers</a>
        </p>
        <p>
            <a href="book/list">Books</a>
        </p>
    </body>
</html>
