package com.powernode.jsp;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

/**
 * @author CY_JFXX
 * @create 2020-03-14 15:15
 */
public class lowerToUpper extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        //获取字符串输出流  用于将  jspfragment 转化为字符串
        StringWriter sw=new StringWriter();
        //获取标签体对象
        JspFragment jf=this.getJspBody();
        //获取pagecontext对象
        PageContext pc=(PageContext)jf.getJspContext();
        //invoke不仅可以写入 标准输出流   也可以写入 字符串输出流
        jf.invoke(sw);
        //以文本形式获取输出流的内容
        String content =sw.toString();
        //小写转大写
        content=content.toUpperCase();
        //将转化大写后的字符串写入  标准输出流
        pc.getOut().print(content);

    }
}
