package com.dujubin.java.TreadTest;

/**
 * @author CY_JFXX
 * @create 2020-02-20 14:03
 * 多线程方式二：
 * 1.写一个类实现java.lang.Runnable；接口
 * 2.实现run方法
 *
 * 推荐使用该方法，因为实现接口的同时，还可以继承其他类
 */
public class TreadTest03 {
    public static void main(String[] args) {
        Thread t=new Thread(new Processor1());

        t.start();
    }
}
class Processor1 implements Runnable{
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println("run-->"+i);
        }
    }
}