package com.dujubin.java;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author CY_JFXX
 * @create 2020-02-19 14:24
 */
public class GenericTest01 {
    public static void main(String[] args) {
        Set s=new HashSet();

        A a=new A();
        B b=new B();
        C c=new C();

        s.add(a);
        s.add(b);
        s.add(c);

        Iterator it=s.iterator();
        while (it.hasNext()){ //需求：针对不同的类型调用不同的方法
            Object o=it.next();
            if(o instanceof A){
                ((A) o).m1();
            }if(o instanceof B){
                ((B) o).m2();
            }if(o instanceof C){
                ((C) o).m3();
            }
        }
    }
}
class A{
    public void m1(){
        System.out.println("A's m1...");
    }
}
class B{
    public void m2(){
        System.out.println("B's m2...");
    }
}class C{
    public void m3(){
        System.out.println("C's m3...");
    }
}