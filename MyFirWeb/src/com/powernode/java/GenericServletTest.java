package com.powernode.java;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;
//模拟 GenericServlet 类

//装饰者模式？    适配器模式
// 适配器模式的意义在于 将两个接口不一致的类联合到一起使用，相当于  转接头（水管 直通、三通）
        // 如将Servlet和ServletConfig两个接口同时封装到GenericServlet类
// 装饰者模式的意义在于 在不改变原代码的前提下，增强或改变源代码 功能
// //定义一个抽象类GenericServletTest，其他类继承该抽象类，不用再实现 Servlet接口的其他方法
public abstract class GenericServletTest implements ServletConfig,Servlet {
    private  ServletConfig conf;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.conf=config;
    }

    @Override
    public ServletConfig getServletConfig() {
        return conf;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }

    @Override
    public String getServletName() {
        return conf.getServletName();
    }

    @Override
    public ServletContext getServletContext() {
        return conf.getServletContext();
    }

    @Override
    public String getInitParameter(String name) {
        return conf.getInitParameter(name);
    }

    @Override
    public Enumeration<String> getInitParameterNames() {
        return conf.getInitParameterNames();
    }
}
