package com.dujubin.java;

import java.util.*;

/**
 * @author CY_JFXX
 * @create 2020-02-19 14:32
 * 在编译阶段统一集合元素类型
 */
public class GenericTest02 {
    public static void main(String[] args) {
        //创建一个集合，只能存储String类型
        List<String> strs=new ArrayList<String>();

        Map<String,Integer> maps=new HashMap<String,Integer>(   );
        maps.put("西瓜",10);
        maps.put("苹果",9);
        maps.put("香蕉",20);

        Set<String> keys=maps.keySet();
        Iterator<String>    it=keys.iterator();
        while(it.hasNext()){
            String k=it.next();
            Integer v=maps.get(k);
            System.out.println(k+"--->"+v);
        }

        //添加元素
        //strs.add(1);//报错
        strs.add("1");
    }
}
