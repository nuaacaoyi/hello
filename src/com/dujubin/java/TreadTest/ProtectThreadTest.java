package com.dujubin.java.TreadTest;

/**
 * @author CY_JFXX
 * @create 2020-02-20 17:54
 * 守护线程
 *
 * 其他所有的用户线程结束，则守护线程退出
 * 守护线程一般都是无限执行的
 *
 * JAVA最著名的守护线程就是  垃圾回收器
 */
public class ProtectThreadTest {
    public static void main(String[] args) {
        Thread t1=new Thread(new Processor10());
        t1.setName("t1");
        //将t1这个用户线程  修改为  守护线程
        t1.setDaemon(true);

        t1.start();

        for (int i = 0; i < 15; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"-->"+i);

        }
    }
}
class Processor10 implements Runnable{
    public void run(){
        int i=0;
        while(true){
            i++;
            System.out.println(Thread.currentThread().getName()+"-->"+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}