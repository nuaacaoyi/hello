package com.dujubin.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

/**
 * @author CY_JFXX
 * @create 2020-02-18 17:35
 * Iterator iterator 获取集合所依赖的迭代器对象；
 * 通过迭代器中的方法完成集合的迭代（遍历  ）
 */
public class CollectionTest02 {

    public static void main(String[] args) throws Exception {
        Collection c=new ArrayList();

        c.add(1000);
        c.add(3.14);//自动包装为Integer对象
        c.add(false);

        Integer i1=new Integer(10);
        Integer i2=new Integer(10);
        c.add(i1);

        Manager m1=new Manager(123,"JACK");
        Manager m2=new Manager(123,"JACK");
        Manager m3=new Manager(123,"JACK");
        System.out.println("--------");
        System.out.println(c.size());
        c.add(m1);
        System.out.println(c.size());
        c.add(m2);
        System.out.println(c.size());
        c.remove(m3);//该方法类似于 contains 底层同样调用 equals方法
        //c.remove(m3);
        //c.remove(m3);
        System.out.println(c.size());
        System.out.println("--------");
        //迭代，或者叫遍历

        Iterator it=c.iterator();//获取C集合的迭代器， 典型的  多态 的应用
                                // Iterator是接口，面向接口编程
        //System.out.println(it);
        //2. 调用方法完成遍历
        //System.out.println(c.contains("3.14"));//false

        System.out.println(c.contains(i2));//true  说明contains底层调用的是 equals 而且是重载后的方法
        System.out.println(c.contains(m2));// 若Manager未重写 equals方法，则返回 false


        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
    static class Manager{
        int no;
        String name;
        Manager(int no,String name){
            this.no=no;
            this.name=name;
        }
        Manager(){}

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Manager manager = (Manager) o;
            return no == manager.no &&
                    Objects.equals(name, manager.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(no, name);
        }

        @Override
        public String toString() {
            return "Manager{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
