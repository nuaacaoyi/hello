package com.bjpowernode.utils;

import java.sql.*;

/**
 * @author CY_JFXX
 * @create 2020-03-15 17:56
 */
public class JdbcUtils {

    private static Connection conn;
    static {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
    //获取connection对象
    public static Connection getConnection() throws SQLException {
        String url="jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC ";
        String user="root";
        String password="root";

            if(conn==null || conn.isClosed()){
                conn= DriverManager.getConnection(url,user,password);
            }
            return  conn;

    }
    //关闭资源
    public  static void close(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
        if (rs != null) {

                rs.close();

        }
        if(stmt!=null) {

                stmt.close();

        }

        if(conn!=null) {

                conn.close();

        }
    }
}
