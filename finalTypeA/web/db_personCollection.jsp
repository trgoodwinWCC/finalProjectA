<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Person Collection</title>
    </head>
    <body>
        <h1>Person Collection</h1>
        <form action="DB_PersonServlet">
            <input type="text" name="Name" /> Name
            <br><input type="text" name="EyeColor" /> Eye Color
            <br><input type="text" name="HairColor" /> Hair Color
            <br><input type="text" name="Height" /> Height
            <br><input type="text" name="Weight" /> Weight
            <br><input type="submit" name="action" value="add" />
            <input type="submit" name="action" value="Clear List"/>
        </form>
        <hr>                       
        <h3>${errorMessage}</h3>
        
        <c:if test="${!empty PersonCollection}">
            <table border="3">
                <tr><th>Name</th><th>Eye Color</th><th>Hair Color</th><th>Height</th><th>Weight</th></tr>
                <c:forEach var="person" items="${PersonCollection}"  varStatus="loopStatus" >
                    <tr>
                    <form action="DB_PersonServlet" >
                        <td><input type="text"  name="Name" value="${person.name}" /></td>
                        <td><input type="text"  name="EyeColor" value="${person.eyeColor}" /></td>
                        <td><input type="text"  name="HairColor" value="${person.hairColor}" /></td>
                        <td><input type="text"  name="Height" value="${person.height}" /></td>
                        <td><input type="text"  name="Weight" value="${person.weight}" /></td>
                        <td><input type="submit" name="action" value="remove" />
                            <input type="submit" name="action" value="update" />
                            <input type="hidden" name="index" value="${person.index}" />
                        </td>
                    </form>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </body>
</html>