package com.powernode.jsp;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * @author CY_JFXX
 * @create 2020-03-14 14:50
 * 获取客户端IP的类，需要获取到 request，在request有getIP的方法
 */
public class ClientIPTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        //获取当前pageContext对象
        PageContext pc=(PageContext)this.getJspContext();
        //获取请求对象
        ServletRequest sr=pc.getRequest();
        //获取ip
        String ip=sr.getRemoteAddr();
        //获取标准输出流
        JspWriter out=pc.getOut();

        out.print(ip);

    }
}
