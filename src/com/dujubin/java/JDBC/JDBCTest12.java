package com.dujubin.java.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author CY_JFXX
 * @create 2020-02-22 17:09
 * 测试我们自己封装的工具类是否可用
 * 模糊查询功能
 * select * from students t where t.sname='ABC' for update;
 *      会形成悲观锁
 *
 *
 */
public class JDBCTest12 {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn=DBUtil.getConnection();
            String sql="select sname from students where sname like ?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,"_B%");
            rs=ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("sname"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,ps,rs);
        }
    }
}
