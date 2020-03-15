package com.bjpowernode.Dao;

import com.bjpowernode.beans.Student;
import com.bjpowernode.utils.JdbcUtils;

import java.sql.*;

/**
 * @author CY_JFXX
 * @create 2020-03-15 17:52
 */
public class IStudentDaoImpl implements IStudentDao {
    private Connection conn;
    private Statement stmt;
    private PreparedStatement ps;
    private ResultSet rs;
    @Override
    public Student selectStudentLogin(String num, String password) {
        Student student=null;

        String sql="select * from student where num=? and password=?";
        try {
            conn= JdbcUtils.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1,num);
            ps.setString(2,password);
            rs=ps.executeQuery();
            if(rs.next()){
                student=new Student();
                student.setId(rs.getInt("id"));
                student.setAge(rs.getInt("age"));
                student.setName(rs.getString("name"));
                student.setPassword(rs.getString("password"));
                student.setScore(rs.getDouble("score"));
                student.setNum(rs.getString("num"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                JdbcUtils.close(conn,stmt,rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return student;
    }
}
