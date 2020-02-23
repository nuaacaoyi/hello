package com.dujubin.java.reflect;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * @author CY_JFXX
 * @create 2020-02-21 10:56
 */
public class ReflectTest04 {
    public static void main(String[] args) {

        //1.创建属性对象
        Properties p = new Properties();//和map一样，key和value只能存储字符串，key不能重复  如果key重复则value覆盖

        //2.创建输入流
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("D:\\IOPropertiesTest02.properties");

            //3.将fis流中所有的数据加载到属性对象中
            p.load(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(p.getProperty("className"));


        Class c = null;
        Object o=null;
        try {
            c = Class.forName(p.getProperty("className"));

            //创建此Class对象锁表是类的一个新实例
            o = c.newInstance();//调用了 Date类的  无参数 构造方法，  说明要想使用reflect机制实例化对象，类中必须有无参数构造方法
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }


        if (o instanceof Date) {
            Date t = (Date) o;

            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(t));
        }
    }
}
