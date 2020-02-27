package com.powernode.java;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author cy_hnmx
 * @create 2020-02-27-14:24
 *
 */
public class RequestDispatchTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);

        PrintWriter out=resp.getWriter();
        out.print("forward之前<br>");
        //请求转发时， request会进行增强，将用户请求 和 本次系统内部请求，包在一起形成一个  request（装饰者模式）
        // forward方法只会对request增强，对 response不变
        //dispatch指的是自身servlet，会陷入死循环
        req.getRequestDispatcher("dispatch2").include(req,resp);//请求转发的方式：如果页面的请求提交方式是POST，则跳转时提交方式依然是POST  path前的/可加可不加？
        /*
        * forward()与include()的区别，主要表现在标准输出流的开启时间不同：
        * forward(): forwar这个单词表示的意思是“向前”，说明当前的请求还未结束，需要继续“向前”
        *            所以服务器不会在这里先打开标准输出流。所以此时写入到out中的数据是不会写入到客户端浏览器中到
        *            使用forward()方法的servlet，其标准输出流还未开启
         *            对客户端的响应肯定不是 使用 forward()方法的Servlet给出的
        * include(): include这个单词的意思是“包含”，说明当前的请求已经结束，可以对客户端进行响应了。
        *            其不仅将自己的数据写入了标准输出流，还要将其他数据包含到自己的输出流中
        *            使用include方法的servlet，其标准输出流已经开启
        *            对客户端的响应是由使用 include() 方法的Servlet给出的
        *
        * 结论： 使用forward时，Servlet不应向Response写入数据
        * */



        out.print("forward之后<br>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        doGet(req,resp);
    }
}
