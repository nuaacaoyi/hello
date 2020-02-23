package com.dujubin.java;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author CY_JFXX
 * @create 2020-02-18 17:16
 */
public class CollectionTest01 {
    public static void main(String[] args) {
        //创建集合
        Collection c=new ArrayList();//多态
        //boolean x;
        //2.添加元素
         c.add(1);
         c.add(new Integer(100));

        Object o=new Object();
        c.add(o);
        Customer cus=new Customer("JACK",30);
        c.add(cus);

        Object[] ob=c.toArray();
        for (int i = 0; i < ob.length; i++) {
            System.out.println(ob[i]);
        }
        /*System.out.println(c.size());
        System.out.println(c.isEmpty());

        c.clear();
        System.out.println(c.size());
        System.out.println(c.isEmpty());*/
    }



}

class Customer{
    String name;
    int age;
    boolean sex;
    Customer(String name,int age){
        this.name=name;
        this.age=age;
    }

    public String toString(){
        return "Customer[name=xxx,age="+age+"]";
    }
}
