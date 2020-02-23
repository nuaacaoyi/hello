package com.dujubin.java.JDBC;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * @author CY_JFXX
 * @create 2020-02-22 16:29
 * JDBC事务机制：
 *    1.JDBC中的事务机制是自动提交的，只要执行任意一条sql语句，就自动提交一次
 *      这是JDBC默认的事务机制
 *    但在实际的业务需要中，通常都是N条DML语句共同联合才能完成，
 *    必须保证这些DML语句在同一个事务中同时成功或同时失败
 *    2. 验证下是否自动提交机制
 */
public class JDBCTest03 {
    public static void main(String[] args) {
        ResourceBundle bundle=ResourceBundle.getBundle("com.mysqlTest2");//识别的是根目录src下文件


        Class c=null;
        Driver dirver=null;
        Connection conn=null;
        Statement st=null;
        PreparedStatement ps=null;
        String url=bundle.getString("url");
        String user=bundle.getString("username");
        String password=bundle.getString("password");
        ResultSet rs=null;

        try {
            c=Class.forName(bundle.getString("driver"));// 2. 注册驱动的第二种写法，因为类加载会执行 静态代码块，而 Driver类中的静态代码块包含 注册驱动
            // 甚至是前面的c=都不用写，我们只需要  forName一下
            //1. 注册驱动的第一种写法
            //dirver= (Driver) c.newInstance();
            //DriverManager.registerDriver(dirver);
            //2. 获取连接对象
            conn= DriverManager.getConnection(url,user,password);



            String sql="update t_user set realName= ? where id=?";

            rs=st.executeQuery(sql);
            //5. 如果执行select   处理查询结果
            while (rs.next()) {
                //为true表明光标指向的行有数据
                for (int i = 0; i < 4; i++) {//此处不应该循环，应该根据列名取每个列  ，因为有些是int需要参与后续计算
                    System.out.print(rs.getString(i+1)+"  ");//可以跟列名，建议用列名
                }
                System.out.println("");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally {

            //6. 关闭数据库
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
