package com.dujubin.java.TreadTest;

/**
 * @author CY_JFXX
 * @create 2020-02-20 16:32
 * 两个线程 t1  和   t2
 * 异步编程： t1 和  t2 线程各执行各的，两个线程之间谁也不等谁
 * 同步编程：t1 和 t2线程执行，t1线程必须等t2线程执行结束后，t1线程才能执行。。线程同步会把程序等同于单线程
 * 目的： 数据安全；
 * 应用环境，何种条件下使用线程同步：
 *      1）必须是多线程环境下；2）多线程环境共享一个数据；3）共享的数据涉及修改操作
 * 可能用途：  银行账户取款
 */
public class ThreadSynchronizationTest01 {//演示多人对同一个账户进行取款操作

    public static void main(String[] args) {
        Account a=new Account("JACK",5000);
        Processor05 p=new Processor05(a);

        Thread t1=new Thread(p);
        Thread t2=new Thread(p);

        t1.start();
        t2.start();
    }
}
//抽象账户
class Account{
    private  String actno;
    private double balance;

    public Account(String actno, double balance) {
        this.actno = actno;
        this.balance = balance;
    }

    public Account() {
    }

    public void setActno(String actno) {
        this.actno = actno;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getActno() {
        return actno;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double money){
        //把需要同步的代码块放到  synchronized中,  但结果会影响程序执行效率
         /*原理： t1线程 和 t2线程
         * t1线程执行到此处，遇到了synchronized关键字，就会去找this的对象锁（对象的某个属性）
         * 如果找到了this对象锁，则进入同步语句块中执行程序，当同步语句块中的代码执行结束后，t1线程归还this的对象锁
         *
         * 在t1线程执行同步语句块的过程中，如果t2线程也来执行以下代码，也遇到synchronized关键字
         * 所以也去找this的对象锁，但该对象的对象锁被t1线程持有，所以只能等待
         * */
        synchronized (this){
            double after=this.balance-money;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.setBalance(after);
            System.out.println("取款成功"+1000+"，余额为"+this.getBalance());
        }
    }
}
//取款线程
class Processor05 implements Runnable{
    Account act;

    public Processor05(Account act) {
        this.act = act;
    }

    public  void run(){
        act.withdraw(1000);

    }
}