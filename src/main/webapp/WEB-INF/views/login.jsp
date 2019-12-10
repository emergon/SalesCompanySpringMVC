<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <script src="https://code.jquery.com/jquery-3.4.1.js"
                integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
                crossorigin="anonymous">
        </script>
        <script src = "https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
    </head>
    <body>
        <div align="center">
            <c:if test="${message != null}">
                <div align="center">
                    <h4>${message}</h4>
                    <p>Username:${user.username}</p>
                    <p>Password:${user.password}</p>
                    
                </div>
            </c:if>
            <h3>Please enter your credentials</h3>
            <form:form id="loginform" action="login" method="post" modelAttribute="user">

                <table>
                    <tr>
                        <td>Username:</td>
                        <td>
                            <form:input id="username" path="username" size="20"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td>
                            <form:input id="password" type="password" path="password" size="20"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <button type="submit">Login</button>
                        </td>
                    </tr>
                </table>
            </form:form>
        </div>
    </body>
    
    <script type="text/javascript">
        $(document).ready(function () {
            $('#loginform').validate({
                rules: {
                    username: "required",
                    password: "required"
                },
                messages: {
                    username: "Please enter username",
                    password: "Please enter password"
                }
            });
        });
        </script>
</html>
