package com.dujubin.java;

import java.util.Properties;

/**
 * @author CY_JFXX
 * @create 2020-02-19 11:38
 * HaspMap 默认初始化容量是16，加载因子是0.75
 * HashTable的默认初始化容量是11，加载因子也是0.75
 * java.util.properties；也是由 key 和value组成，但是key和value都是字符串类型
 */
public class MapTest02 {
    public static void main(String[] args) {

        //1.创建集合
        Properties p=new Properties();
        //2. 存
        p.setProperty("driver","Oracle.jdbc.driver.OracleDriver");
        p.setProperty("username","scott");
        p.setProperty("username","abcde");//key不能重复，重复会导致原value覆盖
        p.setProperty("password","tiger");
        p.setProperty("url","jdbc:oracle:thin:@192.168.1.100:1521:bjpowernode");

        //3.取,通过key获取value
        String v1=p.getProperty("driver");
        System.out.println(v1);


    }
}
