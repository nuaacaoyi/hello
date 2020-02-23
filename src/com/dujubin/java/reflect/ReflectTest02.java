package com.dujubin.java.reflect;

/**
 * @author CY_JFXX
 * @create 2020-02-20 19:55
 */
public class ReflectTest02 {
    public static void main(String[] args) {
        A a=new A();
        //Class.forName("A");//会将A.class装载到JVM
        Class c=a.getClass();
        System.out.println("aaaa");
    }
}

class A
{
    static{
        System.out.println("A....");
    }
}