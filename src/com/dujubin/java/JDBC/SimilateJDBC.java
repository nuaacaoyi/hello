package com.dujubin.java.JDBC;

/**
 * @author CY_JFXX
 * @create 2020-02-21 17:06
 * 我是java程序员
 */
public class SimilateJDBC {
    public static void main(String[] args) {
        SimiulateJDBCInter jd=new SimiulateDateBase();
        jd.getConnection();

        Class c= null;
        try {
            //可以通过properties配置文件读取使用的哪个数据库，进而实现解耦合
            c = Class.forName("SimiulateDateBase");
            SimiulateJDBCInter si=(SimiulateJDBCInter)c.newInstance();
            si.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
