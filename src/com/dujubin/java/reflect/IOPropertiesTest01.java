package com.dujubin.java.reflect;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author CY_JFXX
 * @create 2020-02-21 8:35
 * IO + Properties联合应用
 * 典型应用于  数据库配置文件读取
 * = : 空格  都可以用，取最前面作为分隔符
 * 如果有中文怎么办   cmd 回车  native2ascii  回车    张三  得到ascii码  \u5f20\u4e09
 *
 * 反射机制的强大之处在于java可以提供特别灵活的代码，只用改配置文件，不用反复编译
 * 可以极大的降低代码之间的耦合度！！！
 */
public class IOPropertiesTest01 {
    public static void main(String[] args) {
        //1.创建属性对象
        Properties p=new Properties();//和map一样，key和value只能存储字符串，key不能重复  如果key重复则value覆盖

        //2.创建输入流
        FileInputStream fis =null;
        try {
            fis=new FileInputStream("D:\\IOPropertiesTest01.txt");

            //3.将fis流中所有的数据加载到属性对象中
            p.load(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(p.getProperty("username"));

    }
}
