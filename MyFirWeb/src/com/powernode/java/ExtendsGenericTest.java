package com.powernode.java;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class ExtendsGenericTest extends GenericServletTest {

    @Override
    public void init(ServletConfig config) throws ServletException {
        //此时有点像 装饰者 模式
        //这句话非常容易忘记
        super.init(config);
        System.out.println("----------");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
        System.out.println("执行ExtendsGenericTest类的service方法");
        System.out.println(this.getInitParameter("address"));
        System.out.println(this.getServletName());
    }
}
