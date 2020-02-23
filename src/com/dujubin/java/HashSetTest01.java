package com.dujubin.java;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author CY_JFXX
 * @create 2020-02-19 9:39
 */
public class HashSetTest01 {
    public static void main(String[] args) {
        Set s=new HashSet(20);//初始化最小容量是16，默认加载因子是0.75（即数组达到16*0.75时，就开始扩容）   数组扩容低效

        s.add(1);
        s.add(1);
        s.add(-1);
        s.add(100);
        s.add(85);
        Iterator it=s.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
