<%@ page import="java.util.HashSet" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
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
    <br>
        -------------遍历Set------------
    <br>
    <%
      Set<String> schools=new HashSet<>();
        schools.add("清华大学");
        schools.add("北京大学");
        schools.add("人民大学");
        schools.add("交通大学");

      pageContext.setAttribute("schools",schools);
    %>
    <ct:forEach items="${schools}"  var="school">
        ${school}<br>
    </ct:forEach>
    <br>
    -------------遍历Map------------
    <br>
    <%
        Map<String,Object> infos=new HashMap<>();
        infos.put("name","赵六");
        infos.put("age",23);
        infos.put("score",99);
        pageContext.setAttribute("infos",infos);
    %>
    <ct:forEach items="${infos}"  var="info">
        ${info}<br>
    </ct:forEach>
    <br>
    -------------遍历Object数组------------
    <br>
    <%
        Object[] citys={"北京","上海","广州"};
        pageContext.setAttribute("citys",citys);
    %>
    <ct:forEach items="${citys}"  var="city">
        ${city}<br>
    </ct:forEach>
    -------------遍历int数组------------
    <br>
    <%
        int[] ages={23,44,55};
        pageContext.setAttribute("ages",ages);
    %>
    <ct:forEach items="${ages}"  var="age">
        ${age}<br>
    </ct:forEach>
    -------------遍历String数组------------
    <br>
    <%
        String[] addresses={"金水区","经开区","高新区"};
        pageContext.setAttribute("addresses",addresses);
    %>
    <ct:forEach items="${addresses}"  var="address">
        ${address}<br>
    </ct:forEach>
</body>
</html>
