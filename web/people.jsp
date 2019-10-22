<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: eberk
  Date: 15.10.2019
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>People</title>
</head>
<body>
    <table>
        <thead>
        <tr><th>id</th><th>name</th><th>age</th></tr>
        </thead>
        <tbody>
            <c:forEach items="${people}" var="p">
                <tr>
                    <td>${p.id}</td><td>${p.name}</td><td>${p.age}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
