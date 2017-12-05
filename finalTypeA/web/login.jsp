<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Seller Login</title>
    </head>
    <body>
        <h2>Login</h2>
        <form action="createSellerPage">
            <input type="text" name="SellerName">
            <input type="password" name="SellerPassword">
            <input type="submit" name="action" value="Login">
        </form>
        <h2>Create account</h2>
        <form action="SellerPageServlet">
            <input type="text" name="CreateSellerName">
            <input type="password" name="CreateSellerPassword">
            <input type="submit" name="action" value="Create Account">
        </form>
    </body>
</html>
