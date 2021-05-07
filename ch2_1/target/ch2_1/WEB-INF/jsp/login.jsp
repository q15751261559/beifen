<%--
  Created by IntelliJ IDEA.
  User: 33285
  Date: 2021/4/26
  Time: 0:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/login" method="post" name="registForm">
    <table>
        <tr>
            <td align="center" colspan="2">登录</td>
        </tr>
        <tr>
            <td>姓名:</td>
            <td>
                <input type="text" name="uname">
            </td>
        </tr>
        <tr>
            <td>密码：</td>
            <td>
                <input type="password" name="upass">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="注册">
                <input type="reset" value="重置">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
