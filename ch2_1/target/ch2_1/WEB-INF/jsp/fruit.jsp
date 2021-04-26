<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 石振宇
  Date: 2021/4/26
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>水果信息情况</title>
</head>
<body>
<table border="1px" width="400px">
    <thead>
    <th>名称</th>
    <th>价格</th>
    <th>产地</th>
    </thead>
    <tbody>
    <c:forEach items="${fruitList}" var="fruit">
        <tr>
            <td>${fruit.name}</td>
            <td>${fruit.price}</td>
            <td>${fruit.producing_area}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
