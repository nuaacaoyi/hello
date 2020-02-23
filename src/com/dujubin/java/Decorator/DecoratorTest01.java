package com.dujubin.java.Decorator;

/**
 * @author CY_JFXX
 * @create 2020-02-19 20:17
 *
 * 需求  A类有个方法m1，过段时间 m1不够用了，需要升级
 * 方案一：采用继承的方式将 A类方法继承给B，在B中重写。 可以实现，但存在缺陷：  A和B之间的关联程度太强了，如果B类或A类需要调整，两个都需要变动，程序员比较忌讳
 * 方案二：装饰者模式  使用C类包装A类
 */
public class DecoratorTest01 {
    public static void main(String[] args) {
        /*方案一
        A a=new B();
        a.m1();*/
        A a=new A();
        C c=new C(a);
        c.m1();
    }
}
