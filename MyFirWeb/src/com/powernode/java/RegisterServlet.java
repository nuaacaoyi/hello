package com.powernode.java;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Map;

/**
 * @author cy_hnmx
 * @create 2020-02-26-14:50
 *
 */
public class RegisterServlet extends HttpServlet {
    // HttpServletRequest对于参数的处理是按照 MAP的结构存储的，而 MAP中的key是 参数名，MAP中的value是 String[]
    //本质上 request.getParameter("name")方法，就是  request.getParameterValues("name")[0]
    protected void doGet(HttpServletRequest req,HttpServletResponse res){
        try {
            req.setCharacterEncoding("UTF-8");//解决POST提交的中文乱码问题，无法解决GET提交时的中文乱码
                                            /*//解决GET提交的中文乱码，方案一：到 tomcat/conf/server.xml  在8080端口那里 增加 URIENCODING="UTF-8" ，
                                                                    这种方案需要重启服务器，如果tomcat中有多个虚拟主机，会很麻烦 */
                                            /*解决乱码方案二：该方案可以统一解决POST 和GET中的乱码*/
                                            /*String name=req.getParameter("name");
                                            byte[] bytes=name.getBytes("ISO8859-1");
                                            name=new String(bytes,"UTF-8");
                                            比较繁琐，因为每个字符串处理起来都比较麻烦
                                            这也是tomcat9只解决get乱码问题的原因，因为POST提交的乱码问题更容易处理*/
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(req.getParameter("username")+"-->"+req.getParameter("age"));

        Enumeration<String> ems=req.getParameterNames();
        /*当输入中文时，会输出乱码，主要原因是HTTP协议的底层传输协议是TCP协议，而TCP是一种基于“字节流”的通讯协议，因此会把所有的提交内容转成 字节 再传输
        web.xml选择的是 UTF-8(Unicode转码，一个中文占 3个 字节) ，TCP协议就会将中文转为UTF-8 码
        但tomcat解析的时候默认按照 ISO-8859-1 编码规则解码，该编码不支持中文，因此会出现乱码
                    需要注意的是，tomcat9.0对于GET提交方式的中文解码已经解决
        */
        while (ems.hasMoreElements()) {
            String name=ems.nextElement();
            System.out.println(name +"===="+req.getParameter(name));
        }

        Map<String,String[]> map=   req.getParameterMap();
        for(String key:map.keySet()){
            System.out.println(key+"--->"+req.getParameter(key));
        }
        req.setAttribute("company","河南津孚信息");//域属性设置
        req.setAttribute("address","郑州未来城");//域属性设置
        try {
            req.getRequestDispatcher("/some").forward(req,res);
            //输入url-pattern 地址  getRequestDispathcer返回的是一个对象，再调用该对象的forward方法调用其他servlet
            //实现跨servlet的调度，和参数等信息传递   域属性在这两个servlet中是共存的。 同时，tomcat还有自建的内部域属性
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }
    protected void doPost(HttpServletRequest req,HttpServletResponse res){
        //System.out.println(req.getParameter("username")+" 1-->1 "+req.getParameter("age"));
        doGet(req,res);

    }
}
