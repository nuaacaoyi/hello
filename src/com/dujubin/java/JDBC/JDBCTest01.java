package com.dujubin.java.JDBC;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.*;
import java.util.Properties;

/**
 * @author CY_JFXX
 * @create 2020-02-22 8:46
 * 根据配置文件  创建JDBC对象，并对数据库实现操作
 */
public class JDBCTest01 {
    public static void main(String[] args) {

        //1.创建属性对象
        Properties p = new Properties();//和map一样，key和value只能存储字符串，key不能重复  如果key重复则value覆盖

        //2.创建输入流
        FileInputStream fis = null;

        try {
            fis = new FileInputStream("D:\\javaworkplace\\hello\\PropertiesFIles\\MysqlStudy.properties");

            //3.将fis流中所有的数据加载到属性对象中
            p.load(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Class c=null;
        Driver dirver=null;
        Connection conn=null;
        Statement st=null;
        String url=null;
        String user=null;
        String password=null;

        try {
            c=Class.forName(p.getProperty("driver"));// 2. 注册驱动的第二种写法，因为类加载会执行 静态代码块，而 Driver类中的静态代码块包含 注册驱动
                                                    // 甚至是前面的c=都不用写，我们只需要  forName一下
            //1. 注册驱动的第一种写法
              //dirver= (Driver) c.newInstance();
              //DriverManager.registerDriver(dirver);
            //获取其他配置项
            url=p.getProperty("url");
            user=p.getProperty("username");
            password=p.getProperty("password");

            //2. 获取连接对象
            conn=DriverManager.getConnection(url,user,password);
            //3. 获得操作数据库的对象(专门执行sql语句的)
            st=conn.createStatement();
            //4. 执行SQL语句
                String sql="insert into students(sname,age,score,sex)values('ABC','20','95','1')";
                //专门执行DML语句（insert delete update） 返回值是影响数据库中的记录条数
            int count=st.executeUpdate(sql);
             System.out.println(count==1?"保存成功":"失败");
            //5. 如果执行select   处理查询结果

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally {

            //6. 关闭数据库
            if(st!=null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }



    }

}
