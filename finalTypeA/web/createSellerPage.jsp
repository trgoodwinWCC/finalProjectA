<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create a seller page</title>
        <%-- test value for backgroundColor <c:set var="backgroundColor" value="blue"/> --%>
        <style>
            body {
                background-color: <c:out value="${backgroundColor}">peach</c:out>;
            }
            .login {
                color: red;
                margin-right: 40px;
                float: right;
            }
        </style>
    </head>
    <c:choose>
        <c:when test="${!empty username}">
            <c:out value="${username} is logged in"></c:out>
        </c:when>
        <c:otherwise>
            <a class="login" href="login">Login</a>
        </c:otherwise>
    </c:choose>
    <body>
    
        <h1>Example?</h1>
    </body>
</html>