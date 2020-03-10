<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
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
        <%--JSP注释不会被翻译到html页面，不会存在于 标准输出流out.write里，也不会响应给客户端--%>
        <!--HTML注释会被翻译到html页面，存在于 标准输出流out.write里，响应给客户端，查看源码可以看到-->
        Hello JSP World!
        <%//JSP代码段可以写到任意位置，不一定要在<body></body>里，甚至是把代码段拆分好几部分各自放在不同的位置
            System.out.println("Java代码段");//会输出到控制台   作为java语句会翻译到 jspservlet的service方法中，不会进入 标准输出流
            Date now=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
            out.print("now = "+sdf.format(now));
        %>
    </body>
</html>
