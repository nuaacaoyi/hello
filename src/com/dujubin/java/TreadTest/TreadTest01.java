package com.dujubin.java.TreadTest;

/**
 * @author CY_JFXX
 * @create 2020-02-20 13:44
 * 方法调用在内存空间是栈结构   main压栈 m1压栈 m2压栈 m3压栈  m3运行完弹栈  m2弹栈  m1弹栈  main弹栈
 */
public class TreadTest01 {
    public static void main(String[] args) {
        m1();
    }
    public static void m1(){
        m2();
    }
    public static void m2(){
        m3();

    }
    public static void m3(){
        System.out.println("m3启动了");
    }
}
