package com.dujubin.java.TreadTest;

/**
 * @author CY_JFXX
 * @create 2020-02-20 16:06
 *
 * 我们较为推荐这种终止方式，这种比较安全
 */
public class ThreadTest04 {
    public static void main(String[] args) {
        Processor04 p=new Processor04();
        Thread t=new Thread(p);

        t.setName("t");

        t.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        p.r=false;

    }
}

class Processor04 implements Runnable{
    public boolean r=true;
    public void run(){

            try {
                for (int i = 0; i < 10; i++) {
                    if(r){
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName()+"-->"+i);
                    }
                    else{
                        return;
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }

}
