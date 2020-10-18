<%-- 
    Document   : header
    Created on : Oct 18, 2020, 3:18:34 PM
    Author     : anastasios
--%>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
    <h3>Sales Company</h3>
    <c:if test="${user.username != null}">
        <p>
            You are logged in as <b>${user.username}</b> | 
            <a href="${pageContext.request.contextPath}/logout">Logout</a>
        </p>
        <a href="${pageContext.request.contextPath}/product/list">Products</a>
        |
        <a href="${pageContext.request.contextPath}/customer/list">Customers</a>
        |
        <a href="#">Salesmen</a>
        |
        <a href="#">Sales</a>
        |
        <a href="${pageContext.request.contextPath}/book/list">Books</a>

    </c:if>
</div>