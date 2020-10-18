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
        <title>Home Page</title>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
    </head>
    <body>
        <div id="top">
            <%@include file="./header.jsp" %>
        </div>
        <div id="wrapper">
            
            <div id="header">
                <h3>Welcome to our application!</h3>
            </div>
            
        </div>
        
        
        <div id="bottom">
            <%@include file="./footer.jsp" %>
        </div>
    </body>
</html>
