<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Salesmen</title>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
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
                <input type="submit" value="Add Salesman" 
                       onclick="window.location.href = '${pageContext.request.contextPath}/salesman/create';return false;"
                       class="add-button">
                <!--  add a search box -->
                <br/>
                <form:form id="search-form" action="${pageContext.request.contextPath}/salesman/search" method="GET">
                    Search salesman: <input type="text" name="searchName" />

                    <input type="submit" value="Search" class="search-button"/>
                </form:form>
                <table>
                    <tr>
                        <th>Code</th>
                        <th>Name</th>
                        <th>City</th>
                        <th>Commission</th>
                        <th>Actions</th>
                    </tr>
                    <c:forEach var="salesman" items="${listOfSalesmen}">
                        <!--construct the Update link-->
                        <c:url var="updateLink" value="/salesman/update">
                            <c:param name="salesmanId" value="${salesman.scode}"/>
                        </c:url>
                        <c:url var="deleteLink" value="/salesman/delete">
                            <c:param name="salesmanId" value="${salesman.scode}"/>
                        </c:url>
                        <tr>
                            <td>${salesman.scode}</td>
                            <td>${salesman.sname}</td>
                            <td>${salesman.scity}</td>
                            <td>${salesman.scomm}</td>
                            <td>
                                <a href="${updateLink}">Update</a>
                                |
                                <a href="${deleteLink}"
                                   onclick="if (!(confirm('Are you sure you want to delete this salesman?')))
                                               return false">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
        <div id="bottom">
            <%@include file="../footer.jsp" %>
        </div>
    </body>
</html>
