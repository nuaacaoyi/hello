<%@ page errorPage="/error.jsp" %>
<%--
  Created by IntelliJ IDEA.
  User: CY
  Date: 2020-03-10
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://mycompany123.com" prefix="ct"%>
<html>
    <head>
        <title>index3</title>
    </head>
    <body>

        <br><!--自定义标签-->
        <ct:getip/>
        <br>
        <%
            String name="bjpowernode";
            pageContext.setAttribute("name",name);
        %>
        <ct:lowerToUpper>abec</ct:lowerToUpper>
        <br>
        <ct:lowerToUpper>${name}</ct:lowerToUpper>
        <!--自定义标签的属性-->
        <%
            boolean gender=true;
            pageContext.setAttribute("gender",gender);

        %>
        <br>
        <ct:if test="${gender}">男</ct:if>
        <ct:if test="not ${gender}">女</ct:if>
    </body>
</html>
