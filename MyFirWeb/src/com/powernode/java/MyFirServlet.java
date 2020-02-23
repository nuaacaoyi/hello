package com.powernode.java;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author CY_JFXX
 * @create 2020-02-23 14:59
 */
public class MyFirServlet implements Servlet {
    public MyFirServlet() {
        System.out.println("创建第一个servlet实例");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("初始化");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("执行service方法");
    }

    @Override
    public String getServletInfo() {

        System.out.println("getServletInfo");
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("销毁第一个servlet实例");

    }
}
