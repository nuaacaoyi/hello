package com.powernode.jsp;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * @author CY_JFXX
 * @create 2020-03-14 16:32
 * JSP中自定义标签的属性功能设置
 */
public class IfTag extends SimpleTagSupport {
    private boolean test;

    public void setTest(boolean test) {
        this.test = test;
    }

    @Override
    public void doTag() throws JspException, IOException {
        if(test){
            JspFragment jf=this.getJspBody();
            JspWriter out=jf.getJspContext().getOut();
            //invoke方法的参数可以是NULL，他会自动判断如果为null则向本片段（this）取标准输出流
            jf.invoke(out);
        }


    }
}
