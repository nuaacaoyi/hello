package com.dujubin.java.Decorator;

/**
 * @author CY_JFXX
 * @create 2020-02-19 20:26
 * 装饰者模式要求：
 * 1.装饰者中含有被装饰者的引用
 * 2.装饰者和被装饰者实现同一个接口或者同一个类型（保持内部方法同名等）
 */
public class C {
    A a;
    public C(A a1) {
        this.a=a1;
    }

    public void m1(){
        System.out.println("扩展代码");
        a.m1();
        System.out.println("扩展代码");
    }

}
