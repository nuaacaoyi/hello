package com.powernode;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.List;

/**
 * @author CY_JFXX
 * @create 2020-03-14 17:06
 */
public class ForEachList extends SimpleTagSupport {
    private List<String> items;
    private String var;//当前遍历对象要放入域中的  属性名   即 EL取值的变量名

    @Override
    public void doTag() throws JspException, IOException {
         for (Object name :
                items) {
             //由于EL中只能处理四大域中的数据，所以需要将当前遍历对象放入到page域中
             //其key为var所指定的名称，而 value则为当前的遍历对象obj
             this.getJspContext().setAttribute(var,name.toString());
             this.getJspBody().invoke(null);

        }
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public void setVar(String var) {
        this.var = var;
    }
}
