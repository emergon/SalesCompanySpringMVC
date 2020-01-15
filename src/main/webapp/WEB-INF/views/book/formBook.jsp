<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Book</title>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/add-customer-style.css">

    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <h3>Books</h3>
            </div>
        </div>
        <div id="container">
            <div id="content">
                <h4>Add New Book</h4>
                <form:form action="${pageContext.request.getContextPath()}/book/create" modelAttribute="book" method="post">
                    <table>
                        <tbody>
                            <form:hidden path="bid"/>
                            <tr>
                                <td><label>Name:</label></td>
                                <%--path: getter is called on load, setter is called on submit--%>
                                <%--path attribute will be populated from modelAttribute--%>
                                <td>
                                    <form:input path="bname"/>
                                    <form:errors path="bname" cssClass="error"/>
                                </td>
                            </tr>
                            <tr>
                                <td><label>Image URL:</label></td>
                                <td>
                                    <form:input path="bimage"/>
                                    <form:errors path="bimage" cssClass="error"/>
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
            <a id="backLink" href="${pageContext.request.getContextPath()}/book/list">Back to List</a>
        </div>
    </body>
</html>
