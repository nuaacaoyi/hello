package com.dujubin.java;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author CY_JFXX
 * @create 2020-02-18 16:20
 */
public class ListTest01 {
    //List 存进去是什么顺序，取出来就是什么顺序
    public static void main(String[] args) {
        ArrayList al=new ArrayList(6);//扩容特别浪费内存空间，最好在初始化的时候将容量预测清楚
        al.add(100);
        al.add(99);
        al.add(23);
        al.add(250);
        al.add(250);
        al.add("abc");

        al.add(1,34);
//        Collections.sort(al);//编译没错，执行报错，不同类型无法比较

        //System.out.println(al.get(3));
        Iterator it=al.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
