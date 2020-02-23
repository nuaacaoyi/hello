package com.dujubin.java.JDBC;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * @author CY_JFXX
 * @create 2020-02-22 16:37
 * sql脚本
 *  drop table if exists t_act;
 *  create table t_act(
 *      actno bigint,
 *      balance double(7,2)
 *  );
 *  insert into t_act(actno,balance)values(111,20000);
 *  insert into t_act(actno,balance)values(222,0);
 *  insert into t_act(actno,balance)values(333,10000);
 *  commit;
 *  select * from t_act
 *  尝试进行事务管理机制，将多个DML语句统一执行，或者统一不执行
 *  三行代码：
 *      conn.setAutoCommit(false);
 *      conn.commit();
 *      conn.rollback();
 */
public class JDBCTest11 {
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
            // 将DML语句提交设置为手动提交
            conn.setAutoCommit(false);


            String sql="update t_act set balance= ? where actno=?";
            ps=conn.prepareStatement(sql);

            //给？传值
            ps.setDouble(1,10000);
            ps.setInt(2,111);
            int count=ps.executeUpdate();

            String s=null;
            s.toString();//空指针异常导致以下DML语句未执行，导致数据异常

            //给？传值
            ps.setDouble(1,10000);
            ps.setInt(2,222);
            count +=ps.executeUpdate();

            conn.commit();//手工提交
            System.out.println(count==2?"转账成功":"转账失败");
            //5. 如果执行select   处理查询结果


        }  catch (Exception ex) {
            if (conn != null) {
                try {
                    conn.rollback();//手动回滚
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            ex.printStackTrace();
        }finally {

            //6. 关闭数据库  可以封装成一个静态类方法
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(ps!=null) {
                try {
                    ps.close();
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
