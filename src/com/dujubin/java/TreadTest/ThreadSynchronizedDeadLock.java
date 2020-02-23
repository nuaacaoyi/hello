package com.dujubin.java.TreadTest;

/**
 * @author CY_JFXX
 * @create 2020-02-20 17:43
 *
 * t1线程需要锁对象o1 和 o2，它先锁o1；   t2线程需要锁对象o1 和 o2，它先锁o2
 * 此时，可能出现死锁
 */
public class ThreadSynchronizedDeadLock {
    public static void main(String[] args) {
        Object o1=new Object();
        Object o2=new Object();

        Thread t1=new Thread(new T1(o1,o2));
        Thread t2=new Thread(new T2(o1,o2));

        t1.start();
        t2.start();
    }
}


class T1 implements Runnable{
    Object o1;
    Object o2;

    public T1(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    public void run(){
        synchronized (o1){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o2){


            }
        }
    }
}

class T2 implements Runnable{
    Object o1;
    Object o2;

    public T2(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    public void run(){
        synchronized (o2){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o1){


            }
        }
    }
}