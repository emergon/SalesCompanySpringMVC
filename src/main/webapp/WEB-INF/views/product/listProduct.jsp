<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products</title>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
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
                <input type="submit" value="Add Product" 
                       onclick="window.location.href = '${pageContext.request.contextPath}/product/create';return false;"
                       class="add-button">
                <!--  add a search box -->
                <br/>
                <form:form id="search-form" action="${pageContext.request.contextPath}/product/search" method="GET">
                    Search product: <input type="text" name="searchName" />

                    <input type="submit" value="Search" class="search-button"/>
                </form:form>
                <table>
                    <tr>
                        <th>Code</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Actions</th>
                    </tr>
                    <c:forEach var="product" items="${listOfProducts}">
                        <!--construct the Update link-->
                        <c:url var="updateLink" value="/product/update">
                            <c:param name="productId" value="${product.pcode}"/>
                        </c:url>
                        <c:url var="deleteLink" value="/product/delete">
                            <c:param name="productId" value="${product.pcode}"/>
                        </c:url>
                        <tr>
                            <td>${product.pcode}</td>
                            <td>${product.pdescr}</td>
                            <td>${product.pprice}</td>
                            <td>
                                <a href="${updateLink}">Update</a>
                                |
                                <a href="${deleteLink}"
                                   onclick="if (!(confirm('Are you sure you want to delete this product?')))
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
