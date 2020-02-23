package com.dujubin.java.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/**
 * @author CY_JFXX
 * @create 2020-02-21 13:01
 * 获取构造方法
 */
public class ReflectTest08 {
    public static void main(String[] args) {
        Class c= null;
        Constructor[] cs;
        try {
            c = Class.forName("java.lang.String");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        StringBuffer     sb=new StringBuffer();

        cs=c.getDeclaredConstructors();

        for(Constructor fl:cs){
            sb.append("\t");
            sb.append(Modifier.toString(fl.getModifiers())+" ");
            sb.append(c.getSimpleName()+"(");
            Class[] pt=fl.getParameterTypes();
            for (int j = 0; j < pt.length; j++) {
                if(j==pt.length-1)
                    sb.append(pt[j].getSimpleName()+" ");
                else
                    sb.append(pt[j].getSimpleName()+" ,");
            }

            sb.append("){}\n");

        }
        sb.append("}");
        System.out.println(sb);

    }
}
