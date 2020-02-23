package com.dujubin.java.reflect;

/**
 * @author CY_JFXX
 * @create 2020-02-20 19:16
 * 获取Class对象的三种方式
 *//*
获取Class类型对象的三种方式
*/
import java.util.*;
//得有 Employee.class  才能执行通过
public class ReflectTest01
{
    public static void main(String[] args) throws Exception{
        //第一种方式
        Class c1=Class.forName("Employee");//c1引用保存内存地址指向堆中的对象，该对象代表的是 Employee整个类

        //第二种方式
        //java中每个类型都有class属性
        Class c2=Employee.class;//（静态属性？）

        //第三种方式
        Employee e=new Employee();
        Class c3=e.getClass();  //c3是运行时类， （e的运行时类 是 Employee）

        //因为Employee这个类在JVM中只有一个，所以c1 c2 c3的内存地址是相同的，指向 堆中的唯一 Employee对象
        System.out.println(c1==c2);//true
        System.out.println(c2==c3);//true


        //c4  c5 c6代表的都是 Date这个类
        Class c4= Date.class;
        Class c5=Class.forName("java.util.Date");//必须写带包的全名
        Date d=new Date();
        Class c6=d.getClass();
    }
}
