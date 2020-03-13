<%@ page import="com.powernode.jsp.Student" %>
<%@ page import="com.powernode.jsp.School" %>
<%@ page errorPage="/error.jsp" %>
<%--
  Created by IntelliJ IDEA.
  User: CY
  Date: 2020-03-10
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Hello JSP World!<br>
<%//JSP代码段可以写到任意位置，不一定要在<body></body>里，甚至是把代码段拆分好几部分各自放在不同的位置
    Student studen=new Student("张三",25,new School("郑州大学","高新区"));
    pageContext.setAttribute("student",studen);
%>
学生是 ${pageScope.student}<br>
学校位置 = ${pageScope.student.school.address}<br>
</body>
</html>
