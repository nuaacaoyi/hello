package com.dujubin.java.JDBC;

import java.sql.*;

/**
 * @author CY_JFXX
 * @create 2020-02-22 17:04
 */
public class DBUtil {
    private DBUtil(){}

    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception{
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqlstudy",
                "root","root");
    }
    public static void close(Connection conn, Statement ps, ResultSet rs){
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
