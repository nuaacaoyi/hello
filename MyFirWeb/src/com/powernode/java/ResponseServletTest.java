package com.powernode.java;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author cy_hnmx
 * @create 2020-02-26-17:26
 */
public class ResponseServletTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");//应该放在这里，这是响应发送到客户端之前
        //super.doGet(req, resp);
        //向客户端浏览器输出内容
        // resp.getWriter().append("Served at: ").append(req.getContextPath());
        PrintWriter out=resp.getWriter();//获取 标准输出流
        out.print("你好，response对象");//除了 append，还可以使用 print  write等
        //response对象同样存在乱码问题
        /*
        * resp.setContentType("text/html");
        * resp.setCharacterEncoding("UTF-8"); 该方法是用于修改 contentype的character编码格式的，所以必须先有  setContentType
        * */
        // resp.setContentType("text/html;charset=UTF-8");//设置响应的MIME类型 ，如video/mp4   image/jpg 该方法需要在响应发送到客户端之前
        PrintWriter out2=resp.getWriter();
        out2.print("你好，response2对象");


        //out.close();//对于这个标准流的关闭要十分小心，因为这个标准输出流可能会有后续使用。
                    //由于在请求和响应结束关闭时，系统会自动关闭这个标准输出流，因此我们可以不写这句代码
    }

}
