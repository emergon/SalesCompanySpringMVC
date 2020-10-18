<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Salesman</title>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/add-style.css">
        
    </head>
    <body>
        <div id="top">
            <%@include file="../header.jsp" %>
        </div>
        <div id="wrapper">
            <div id="header">
                <h3>Salesmen</h3>
            </div>
        </div>
        <div id="container">
            <div id="content">
                <h4>Add New Salesman</h4>
                <form:form action="${pageContext.request.getContextPath()}/salesman/create" modelAttribute="salesman" method="post">
                    <table>
                        <tbody>
                            <form:hidden path="scode"/>
                            <tr>
                                <td><label>Name:</label></td>
                                <%--path: getter is called on load, setter is called on submit--%>
                                <%--path attribute will be populated from modelAttribute--%>
                                <td>
                                    <form:input path="sname"/>
                                    <form:errors path="sname" cssClass="error"/>
                                </td>
                            </tr>
                            <tr>
                                <td><label>City:</label></td>
                                <td>
                                    <form:input path="scity"/>
                                    <form:errors path="scity" cssClass="error"/>
                                </td>
                            </tr>
                            <tr>
                                <td><label>Commission:</label></td>
                                <td>
                                    <form:input path="scomm" type="number" step="0.01"/>
                                    <form:errors path="scomm" cssClass="error"/>
                                </td>
                            </tr>
                            <tr>
                                <td><label></label></td>
                                <td><input type="submit" value="Submit" class="save"></td>
                            </tr>
                        </tbody>
                    </table>
                </form:form>
            </div>
            <a id="backLink" href="${pageContext.request.getContextPath()}/salesman/list">Back to List</a>
        </div>
        <div id="bottom">
            <%@include file="../footer.jsp" %>
        </div>
    </body>
</html>
