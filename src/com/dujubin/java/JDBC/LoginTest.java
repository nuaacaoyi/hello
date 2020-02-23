package com.dujubin.java.JDBC;

import java.sql.*;
import java.util.*;

/**
 * @author CY_JFXX
 * @create 2020-02-22 14:16
 * 如果程序设计不合理，可能会出现sql注入现象，bug。会导致SQL的含义被扭曲
 * 如何避免该问题： 使用PreparedStatement，该接口继承了Statement
 *
 *
 */
public class LoginTest {
    public static void main(String[] args) {
        //初始化一个界面,验证用户名和密码
        Map<String,String> userLoginInfo=initUI();
        login(userLoginInfo);

    }

    private static boolean login(Map<String, String> userLoginInfo) {
        ResourceBundle bundle=ResourceBundle.getBundle("com.mysqlTest2");//识别的是根目录src下文件


        Class c=null;
        //Driver dirver=null;
        Connection conn=null;
        Statement st=null;
        PreparedStatement ps=null;

        String url=bundle.getString("url");
        String user=bundle.getString("username");
        String password=bundle.getString("password");
        ResultSet rs=null;

        try {
           /* //可能存在sql注入的编码方式
            c=Class.forName(bundle.getString("driver"));//1.初始化+注册
            conn=DriverManager.getConnection(url,user,password);//2.获取链接对象
            st=conn.createStatement();//3.获取可操作对象
            String sql="select loginName,loginPwd from t_user where loginName='"+userLoginInfo.get("loginName")+"'";
                    //如果sql受到前台用户输入的信息影响 改变查询结果，就叫做 SQL注入   如 select * from t_user where n=name  and p=password or 1=1
            rs=st.executeQuery(sql);//4.执行sql语句*/

           /*
            * Statement 存在sql注入现象， PrepareStatement不存在sql注入现象
            * PrepareStatement的执行效率会比较高
            *   SQL执行的原理是，先编译，后执行。如果后一句sql与前一句一模一样，则不需要二次编译
            *   Statement每次执行都需要重新编译，相反，PrepareStatement只需要编译一次
            * PrepareStatement会在编译阶段做类型的安全检查
            * 因此，99%情况下使用PrepareStatement，极少情况下使用Statement
            *   只有在业务方面要求必须支持sql注入的时候，用Statement
            * */

            //不存在sql注入的编码方式
            c=Class.forName(bundle.getString("driver"));//1.初始化+注册
            conn=DriverManager.getConnection(url,user,password);//2.获取链接对象
            String sql="select loginName,loginPwd from t_user where loginName= ?";// ? 就是 占位符，不能引号括起来
            //预编译SQL语句，用户再输入任何的  sql关键字，就不会再生效了
            ps=conn.prepareStatement(sql);

            //给占位符传值  第一个问号下标是1  第二个问号下标是2  JDBC中所有下标从1开始
            ps.setString(1,userLoginInfo.get("loginName"));
            rs=ps.executeQuery();//4.执行sql语句


            if(rs.next()){
                if(userLoginInfo.get("loginPwd").equals(rs.getString("loginPwd"))){
                    System.out.println("登录成功");
                }else System.out.println("密码不正确");
            }else System.out.println("用户名不对");


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        //6关闭数据库
        if(rs!=null) {
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

        return  false;
    }


    private static Map<String,String> initUI() {
        Scanner in=new Scanner(System.in);
        System.out.println("用户名："   );
        String username=in.nextLine();
        System.out.println("密码：");
        String password=in.nextLine();
        Map<String,String> userLoginInfo=new HashMap<>();
        userLoginInfo.put("loginName",username);
        userLoginInfo.put("loginPwd",password);

        return userLoginInfo;
    }
}
