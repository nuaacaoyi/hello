package com.dujubin.java.reflect;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author CY_JFXX
 * @create 2020-02-20 19:59
 * 获取class之后可以创建该类的对象
 */
public class ReflectTest03 {
    public static void main(String[] args) throws Exception {
        Class c=Class.forName("java.util.Date");

        //创建此Class对象锁表是类的一个新实例
        Object o=c.newInstance();//调用了 Date类的  无参数 构造方法，  说明要想使用reflect机制实例化对象，类中必须有无参数构造方法

        if(o instanceof Date){
            Date t=(Date)o;

            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(t));
        }
    }
}
