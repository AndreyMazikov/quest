<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>USERS</h1>
    <c:forEach var="user" items="${requestScope.users}">
       User: <a href="/user?id=${user.id}">${user.login}</a><br>
    </c:forEach>
</body>
</html>
