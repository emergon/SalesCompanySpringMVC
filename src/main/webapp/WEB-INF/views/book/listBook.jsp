<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Books</title>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <h3>Books</h3>
            </div>
        </div>
        <div id="container">
            <div id="content">
                <input type="submit" value="Add Book" 
                       onclick="window.location.href = '${pageContext.request.contextPath}/book/create';return false;"
                       class="add-button">

                <table>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Image</th>
                        <th>Actions</th>
                    </tr>
                    <c:forEach var="book" items="${listOfBooks}">
                        <!--construct the Update link-->
                        <c:url var="updateLink" value="/book/update">
                            <c:param name="bookId" value="${book.bid}"/>
                        </c:url>
                        <c:url var="deleteLink" value="/book/delete">
                            <c:param name="bookId" value="${book.bid}"/>
                        </c:url>
                        <tr>
                            <td>${book.bid}</td>
                            <td>${book.bname}</td>
                            <td>
                                <img class="card-img-top mt-2" style="display: block; margin-left: auto; margin-right: auto; width: 20%; height: 3vw; object-fit: cover;" 
                                     src="${book.bimage}" alt="Card image cap">
                            </td>
                            <td>
                                <a href="${updateLink}">Update</a>
                                |
                                <a href="${deleteLink}"
                                   onclick="if (!(confirm('Are you sure you want to delete this book?')))
                                               return false">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>
