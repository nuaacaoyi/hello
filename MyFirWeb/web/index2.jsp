<%@ page import="com.powernode.jsp.Student" %>
<%@ page import="com.powernode.jsp.School" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
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

    //对EL运算符的检验
    String username=null;
    String schoolName="";
    List<Student> students=new ArrayList<>();

    pageContext.setAttribute("username",username);
    pageContext.setAttribute("schoolName",schoolName);
    pageContext.setAttribute("students",students);

%>
学生是 ${pageScope.student}<br>
学校位置 = ${pageScope.student.school.address}<br>

    <!-- empty对于没有定义的变量的运算结果为  true -->
    empty name = ${empty name}<br>

    <!-- empty对于NULL引用的运算结果为  true -->
    empty username = ${empty username}<br>

    <!-- empty对于空串的String变量的运算结果为  true -->
    empty schoolName = ${empty schoolName}<br>

    <!-- empty对于没有元素的数组或集合的运算结果为  true -->
    empty students = ${empty students}<br>

</body>
</html>
