package com.powernode.java;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

/**
 * @author cy_hnmx
 * @create 2020-02-27-10:51
 */
public class JumpServletTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        System.out.println("已跳转？");
        PrintWriter out=resp.getWriter();
        out.print("This is a Redirect page");
        String name=req.getParameter("pname");

        //重定向编码了，这边就要解码，解码后再需要进行一次 中文乱码处理
        name=URLDecoder.decode(name,"UTF-8");
        name=new String(name.getBytes("ISO8859-1"),"UTF-8");


        System.out.println("name" +"===="+req.getParameter("pname"));
        System.out.println("AGE" +"===="+req.getParameter("page"));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        doGet(req,resp);
    }
}
