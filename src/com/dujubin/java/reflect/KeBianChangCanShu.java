package com.dujubin.java.reflect;

import java.util.Date;
import java.util.Timer;

/**
 * @author CY_JFXX
 * @create 2020-02-20 20:08
 */
public class KeBianChangCanShu {
    //m1方法有一个int类型的可变长参数
    public static void m1(int... a){//m1方法在调用的时候，传递的实参可以是0-N个
        System.out.println("Test");
    }

    public static void m1(int a){//如果有精确匹配到方法，则不会再去执行可变长参数方法
        System.out.println(a);
    }
    public static void m2(String... args){//可变长参数可以当做 数组使用
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
    }

    public static void m3(Class... args){
        for (int i = 0; i < args.length; i++) {
            Class c=args[i];
            try {
                System.out.println(c.newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
    //public static void m4(String... a,int i){ }//可变长参数必须在最后一个参数位置上，并且只能出现一次
    public static void m4(int i,String... a){ }//可变长参数必须在最后一个参数位置上，并且只能出现一次

    public static void main(String[] args) {
        m1();
        m1(1);
        m1(1,2);
        m1(3,4,5,6,7);

        m2("运行","旅游","体育");

        m3(Date.class, Timer.class);
    }
}


