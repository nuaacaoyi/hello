package com.powernode.java;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

public class AnotherServlet  implements Servlet {
    private ServletConfig conf;
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
        //获取servletContext对象
        ServletContext sc=conf.getServletContext();
        Enumeration<String> es= sc.getInitParameterNames();//获取的是整个应用的公共属性
        while (es.hasMoreElements()){
            String name=es.nextElement();
            System.out.println(name+"-->"+sc.getInitParameter(name));

        }
        //设置域属性  也是全局性变量 可以放到别的servlet中访问
        sc.setAttribute("email","cayi@mxsvc.cn");
        System.out.println(sc.getContextPath());
        System.out.println(sc.getRealPath("index.jsp"));


    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
