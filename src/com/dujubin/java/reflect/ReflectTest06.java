package com.dujubin.java.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author CY_JFXX
 * @create 2020-02-21 12:32
 * 反编译获取某个类的所有方法
 */
public class ReflectTest06 {
    public static void main(String[] args) {
        Class c= null;
        try {
            c = Class.forName("java.lang.String");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Method[] fs1=c.getDeclaredMethods();

        StringBuffer sb=new StringBuffer();
        sb.append(Modifier.toString(c.getModifiers())+" class "+c.getSimpleName()+" {\n");

        for(Method fl:fs1){
            int i=fl.getModifiers();
            String strM=Modifier.toString(i);
            sb.append("\t");
            sb.append(strM+" ");
            sb.append(fl.getReturnType().getSimpleName()+" ");
            sb.append(fl.getName()+"(");
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

