package com.powernode.java;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author CY_JFXX
 * @create 2020-02-23 14:59
 */
public class MyFirServlet implements Servlet {
    private ServletConfig conf;
    public MyFirServlet() {
        System.out.println("创建第一个servlet实例");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.conf=servletConfig;
        System.out.println("servletConfig" +servletConfig);
        //servletConfigorg.apache.catalina.core.StandardWrapperFacade
    }

    @Override
    public ServletConfig getServletConfig() {
        return conf;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //获取Servlet的名称
        String servletName=conf.getServletName();
        System.out.println("servletName: "+servletName);

        ServletContext sc=conf.getServletContext();//单例，一个应用就一个对象
        System.out.println("servletContext: "+conf.getServletContext());

        System.out.println("InitParameter: "+conf.getInitParameter("name"));

        Enumeration<String> es= conf.getInitParameterNames();
        while (es.hasMoreElements()) {
            String name=es.nextElement();
            System.out.println(name+"-->"+conf.getInitParameter(name));
        }

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
