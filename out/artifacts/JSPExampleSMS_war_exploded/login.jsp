<%--
  Created by IntelliJ IDEA.
  User: chy
  Date: 2020/3/15
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    ${message  }<br>
    <form action="${pageContext.request.contextPath}/loginServlet" method="post">
        学号： <input type="text" name="num" /><br>
        密码： <input type="password" name="password" /><br>
        <input type="submit" value="登录">
    </form>
    <a href="#">注册</a>
</body>
</html>
