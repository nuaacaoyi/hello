package com.dujubin.java;

import java.util.*;

/**
 * @author CY_JFXX
    存储在Map集合key部分的元素需要同时重写 equals和hashcode方法
 * @create 2020-02-19 11:13
 */

public class MapTest01 {
    public static void main(String[] args) {
        //1.创建Map集合，存身份证号和名字
        Map persons=new HashMap<>();
        persons.put("10000","JACK");
        persons.put("12000","JACK");
        persons.put("13000","LUCY");
        persons.put("14000","BRUCE");
        persons.put("10000","ALI");

        //3.判断键值对的个数   Map中的key无序不可重复
        System.out.println(persons.size());
        //4.集合中是否包含这样的key
        System.out.println(persons.containsKey("10000"));//true
        System.out.println(persons.containsValue("ALI"));//true,如果key重复，add会覆盖原来的key对应的value

        //persons.remove("10000");
        String s=(String)persons.get("10000");
        System.out.println(s);// 如果key重复，add会覆盖原来的key对应的value

        Collection values=persons.values();
        Iterator it=values.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        //10. entrySet
        Set entrySet=persons.entrySet();
        Iterator t3=entrySet.iterator();
        while (t3.hasNext()){
            System.out.println(t3.next());
        }
    }
}
