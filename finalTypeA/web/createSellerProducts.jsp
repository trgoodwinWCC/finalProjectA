<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create your product page</title>
    </head>
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
        <h1>Add a product page</h1>
        <form action="SellerPageServlet">
            <%-- edit this page for creating product --%>
            <input type="text" name="SellerTitle"/>Add your title here.
            <br/><input type="color" name="SellerTitleColor" value="#ff0000"/>Pick a color for your title.
            <br/><input type="text" name="SellerDesc"/>Add your description here.
            <%-- I may have to use j/s to populate the table I want.
            Or I could seperate the seller page and the product page. --%>
            <br/><input type="submit" name="action" value="Add product">
        </form>
    </body>
</html>
