package com.dujubin.java.TreadTest;

/**
 * @author CY_JFXX
 * @create 2020-02-20 13:49
 * 多线程第一种方式：
 *   1.如何定义：继承java.lang.Thread  重写run方法
 *   2.如何创建线程
 *   3.如何启动线程
 */
public class ThreadTest02 {
    public static void main(String[] args) {
        //2.创建线程
        Thread t=new Processor();
        //3.启动
        t.start();//这段代码瞬间执行结束,只是告诉JVM重新启用一个栈
                //run方法不需要程序员调用，start后系统自动调用
        //t.run();//这种方式只是调用，不会启用新的线程
        for (int i = 0; i < 10; i++) {
            System.out.println("main---->"+i);

        }
        //有了多线程之后main方法结束只是主线程栈清空，  其他线程可能还在运行
    }
}

//1.定义一个线程
 class Processor extends Thread{
    public  void run(){
        for (int i = 0; i < 100; i++) {

            System.out.println("run---->"+i);
        }
    };
}