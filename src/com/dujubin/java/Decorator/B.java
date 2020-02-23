package com.dujubin.java.Decorator;

/**
 * @author CY_JFXX
 * @create 2020-02-19 20:18
 */
public class B extends  A {
    public void m1(){
        System.out.println("扩展代码1");
        super.m1();
        System.out.println("扩展代码2");
    }
}
