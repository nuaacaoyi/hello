package com.powernode.java;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author cy_hnmx
 * @create 2020-02-26-10:59
 */
public class LoginServletTest extends HttpServlet{

    //Request对象所涵盖的信息，主要是  请求内容 ，使用 HTTPWATCH 抓包工具可以抓到浏览器的请求内容
    //请求的生命周期非常短暂，一次请假，一次响应
    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse res) {
        System.out.println("---------");
    }

    //public  HttpServlet s;
   /* 仿照自定义HttpServlet
    @Override
   public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
        System.out.println("-----------");
        HttpServletRequest request=(HttpServletRequest)req;
        HttpServletResponse response=(HttpServletResponse)res;
        //获取请求的提交方式
        String me=request.getMethod();
        System.out.println(me);
        //把常量放在 .equals前的好处是，不会有空指针异常
        if("POST".equals(me)){
            doPost(request,response);

        }else{
            doGet(request,response);
        }

    }*/
  /*  private void doPost(HttpServletRequest req,HttpServletResponse res){
        System.out.println("POST提交");
    }
    private void doGet(HttpServletRequest req,HttpServletResponse res){
        System.out.println("GET提交");
    }*/
}
