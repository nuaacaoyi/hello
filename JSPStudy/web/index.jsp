<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://mycompany.com" prefix="ct"%>
<%--
  Created by IntelliJ IDEA.
  User: chy
  Date: 2020/3/14
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>JSP学习</title>
</head>
<body>
    <%
      List<String> names=new ArrayList<>();
      names.add("张三");
      names.add("李四");
      names.add("王五");
      names.add("赵六");

      pageContext.setAttribute("names",names);
    %>
    <ct:forEachList items="${names}"  var="name">
        ${name}<br>
    </ct:forEachList>
</body>
</html>
