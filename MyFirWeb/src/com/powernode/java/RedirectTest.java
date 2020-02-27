package com.powernode.java;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author cy_hnmx
 * @create 2020-02-27-10:37
 * 请求转发，服务器内跳转，用户一次请求发往资源1 （服务器内部再资源1调用资源2，资源2调用资源3，最终资源10向 客户端响应），用户最后得到一次响应
 * 重定向，服务器外跳转 ，用户一次请求资源1，资源1一次响应，之后用户再一次请求资源2，资源2再一次响应，最后10次请求，10次响应。 只不过后面的9次请求是浏览器自己提交的，用户感知不到
 *      特性： 请求转发只能在当前应用内跳转；  而重定向可以跳转到其他应用
 *      请求转发：1.浏览器只发出一次请求，收到一次响应；2.请求所转发到的资源可以直接获取到请求中所携带的数据；
 *               3.浏览器地址栏显示的为用户所提交的请求路径；4.只能跳转到当前应用的资源中。
 *       重定向： 1.浏览器发出多次请求，接收多次响应；2.重定向到的资源不能直接获取到用户提交请求中所携带的数据；
 *               3.浏览器地址栏显示的为重定向的请求路径，而非用户提交请求的路径。
 *                      因此，重定向有个很重要的功能：    防止表单重复提交
 *               4.重定向可以跳转到其他应用的资源
 */
public class RedirectTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        String name=req.getParameter("username");
        name = new String(name.getBytes("ISO8859-1"),"UTF-8");
        String age=req.getParameter("age");
        System.out.println("name" +"===="+name);
        System.out.println("AGE" +"===="+age);
        //实现请求转发
        req.getRequestDispatcher("jumpServlet").forward(req,resp);//请求转发的方式：如果页面的请求提交方式是POST，则跳转时提交方式依然是POST  path前的/可加可不加？
        /*//实现重定向  重定向时会改变URL地址栏（侧面说明这是浏览器的另外一次请求）
        // 重定向时 需要在path中增加 ?变量名=变量值的方式传递，且 请求提交方式是   GET
        // 重定向时也会出现中文乱码，由于 name 是 UTF-8 ，GET提交时是按照 TCP的字节流方式传输， 所以会乱码   所以需要将name打散成字节
        name=URLEncoder.encode(name,"UTF-8");//将字符串重新编码，将字符串打散成字节
        resp.sendRedirect("jumpServlet?pname="+name+"&page="+age);//重定向可以跳转到其他应用  location=   /Module1/jumpServlet*/

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doPost(req, resp);
        doGet(req, resp);
    }
}
