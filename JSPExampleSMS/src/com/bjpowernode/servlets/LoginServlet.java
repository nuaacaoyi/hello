package com.bjpowernode.servlets;

import com.bjpowernode.beans.Student;
import com.bjpowernode.service.IStudentService;
import com.bjpowernode.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author CY_JFXX
 * @create 2020-03-15 16:48
 * 视图层？ controller层？
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         //1. 接收请求参数
        String num=req.getParameter("num");
        String password=req.getParameter("password");
        //获取session用于填写提示信息
        HttpSession session= req.getSession();
        if(num == null || "".equals(num.trim())){//NULL判断是防止黑客通过get提交， equals才是判断用户是否输入的空串
           session.setAttribute("message","学号输入有误");
            //req.getRequestDispatcher("/login.jsp").forward(req,resp);  请求转发无法防止恶意刷新
            resp.sendRedirect(req.getContextPath()+"/login.jsp");//既能使用重定向又能使用请求转发时，我们选择重定向
            return;
        }
        if(password == null || "".equals(password.trim())){//NULL判断是防止黑客通过get提交， equals才是判断用户是否输入的空串
            session.setAttribute("message","密码输入有误");
            //req.getRequestDispatcher("/login.jsp").forward(req,resp);  请求转发无法防止恶意刷新
            resp.sendRedirect(req.getContextPath()+"/login.jsp");//既能使用重定向又能使用请求转发时，我们选择重定向
            return;
        }
        //2. 创建service对象
        IStudentService service =new StudentServiceImpl();

        //3. 调用service对象的checkUser()方法，验证用户合法性
        Student student =service.checkUser(num,password);//虽然用boolean能简化，但是返回student对象更容易后续的使用
        //4. 验证不通过，需要重新登录，跳转到 login.jsp，让用户再次输入登录信息。此时页面给出用户一些提示信息
        if(student == null){
            session.setAttribute("message","用户名或密码输入有误");
            resp.sendRedirect(req.getContextPath()+"/login.jsp");
            return;
        }
        //5. 验证通过后进入 index.jsp
        else{
            resp.sendRedirect(req.getContextPath()+"/index.jsp");
        }

    }
}
