package com.dujubin.java.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.*;

/**
 * @author CY_JFXX
 * @create 2020-02-21 11:39
 * 反编译获取类属性
 */
public class ReflectTest05{
    public static void main(String[] args)  throws Exception{
        Class c=  Class.forName("java.util.Date");
        //Field[] fs=c.getFields();//只能获取 public类型的属性
        //System.out.println(fs.length);
        //System.out.println(fs[0].getName());
        //如果要获取所有的属性
        Field[] fs1=c.getDeclaredFields();

        StringBuffer sb=new StringBuffer();
        sb.append(Modifier.toString(c.getModifiers())+" class "+c.getSimpleName()+" {\n");

        for(Field fl:fs1){
            int i=fl.getModifiers();
            String strM=Modifier.toString(i);
            sb.append("\t");
            sb.append(strM+" ");
            sb.append(fl.getType().getSimpleName()+" ");
            sb.append(fl.getName()+";\n");

        }
        sb.append("}");
        System.out.println(sb);

    }
}