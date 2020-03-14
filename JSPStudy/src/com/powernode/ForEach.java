package com.powernode;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

/**
 * @author CY_JFXX
 * @create 2020-03-14 17:56
 * 定义标签处理器
 */
public class ForEach extends SimpleTagSupport {
    private Object items;
    private String var;//当前遍历对象要放入域中的  属性名   即 EL取值的变量名


    private Collection coll;
    public Collection getColl() {
        if(items instanceof List) {
            return (List)items;
        }else if(items instanceof Set){
            return (Set)items;
        }else  if(items instanceof Map){
            return ((Map) items).entrySet();//将map转化
        }else if(items instanceof Object[]){
            return Arrays.asList((Object[])items);//将对象转化为数组，然后再调用asList方法将数组变为list
        }else if(items instanceof int[]){//基本数据类型的数组不能通过  Arrays.aslist方法解决
            List nums=new ArrayList();
            //遍历数组将元素放入list并返回
            for (int num :
                    (int[])items){
                nums.add(num);
            }
            return nums;
        }else if(items.getClass().isArray()){//判断items是否是一个数组
            List nums=new ArrayList();
            //遍历数组将元素放入list并返回
            for (int i = 0; i < Array.getLength(items); i++) {
                nums.add(Array.get(items,i));
            }
            return nums;
        }

        return coll;
    }

    @Override
    public void doTag() throws JspException, IOException {

            for (Object obj :
                    getColl()) {
                this.getJspContext().setAttribute(var,obj.toString());
                this.getJspBody().invoke(null);

            }


    }


    public void setVar(String var) {
        this.var = var;
    }

    public void setItems(Object items) {
        this.items = items;
    }
}
