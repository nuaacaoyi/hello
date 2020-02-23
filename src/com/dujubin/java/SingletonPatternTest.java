package com.dujubin.java;

import com.powernode.java.MyFirServlet;

/**
 * @author CY_JFXX
 * @create 2020-02-23 15:59
 * 单例模式----重要应用   Servlet
 */
public class SingletonPatternTest {
    public static void main(String[] args) {
        //SingletonPatternUser类只能单实例
        SingletonPatternUser u1=SingletonPatternUser.getInstance();
        SingletonPatternUser u2=SingletonPatternUser.getInstance();
        System.out.println(u1==u2);//true

        //MyFirServlet可以多次new，但tomcat启动时，只init一次，其他调用只调用方法？
        MyFirServlet s1=new MyFirServlet();
        MyFirServlet s2=new MyFirServlet();

        System.out.println(s1==s2);
    }

}
