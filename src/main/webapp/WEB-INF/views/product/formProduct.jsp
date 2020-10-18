<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Customer</title>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/add-style.css">
        
    </head>
    <body>
        <div id="top">
            <%@include file="../header.jsp" %>
        </div>
        <div id="wrapper">
            <div id="header">
                <h3>Products</h3>
            </div>
        </div>
        <div id="container">
            <div id="content">
                <h4>Add New Customer</h4>
                <form:form action="${pageContext.request.getContextPath()}/product/create" modelAttribute="product" method="post">
                    <table>
                        <tbody>
                            <form:hidden path="pcode"/>
                            <tr>
                                <td><label>Description:</label></td>
                                <%--path: getter is called on load, setter is called on submit--%>
                                <%--path attribute will be populated from modelAttribute--%>
                                <td>
                                    <form:input path="pdescr"/>
                                    <form:errors path="pdescr" cssClass="error"/>
                                </td>
                            </tr>
                            <tr>
                                <td><label>Price:</label></td>
                                <td>
                                    <form:input path="pprice"/>
                                    <form:errors path="pprice" cssClass="error"/>
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
            <a id="backLink" href="${pageContext.request.getContextPath()}/product/list">Back to List</a>
        </div>
        <div id="bottom">
            <%@include file="../footer.jsp" %>
        </div>
    </body>
</html>
