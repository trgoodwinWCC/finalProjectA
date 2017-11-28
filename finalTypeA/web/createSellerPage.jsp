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
                background-color:lightgrey;
                margin-right: 40px;
                float: right;
            }
        </style>
    </head>
    <c:set var="username" value="Test"/>
    <c:choose>
        <c:when test="${!empty username}">
            <span class="login">User <span style="font-size:large;color:blue"><c:out value="${username}"></c:out></span> is logged in</span>
        </c:when>
        <c:otherwise>
            <a class="login" href="login">Login</a>
            <%-- consider "including" the login part into this page --%>
        </c:otherwise>
    </c:choose>
    <body>
        <form action="SellerPageServlet">
            <input type="text" name="SellerTitle"/>Add your title here.
            <br/><input type="color" name="SellerTitleColor" value="#ff0000"/>Pick a color for your title.
            <br/><input type="text" name="SellerDesc"/>Add your description here.
            <%-- hhmmm --%>
            <br/><input type="number" name="NumberOfProd"/>Number of your products.
            <%-- I may have to use j/s to populate the table I want.
            Or I could seperate the seller page and the product page. --%>
            
        </form>
        <h1>Example?</h1>
    </body>
</html>