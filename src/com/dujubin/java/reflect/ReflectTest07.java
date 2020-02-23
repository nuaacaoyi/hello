package com.dujubin.java.reflect;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author CY_JFXX
 * @create 2020-02-21 12:44
 * 通过某个特定的方法，通过反射机制执行
 * 尝试调用length()方法
 */
public class ReflectTest07 {

    public static void main(String[] args) {
        String a="abcdefghskj";
        Method m1;
        Method m2;
        Constructor m3;
        Class c;
        //1.获取类
        try {
            c = Class.forName("java.lang.String");
            //2.获取某个特定方法
            m1=c.getDeclaredMethod("length");
            m2=c.getDeclaredMethod("lastIndexOf", String.class);

            m3=c.getConstructor(String.class);

            //3.通过反射机制执行这个方法
            Object o=c.newInstance();
            Object re= m1.invoke(o);
            Object rr=m2.invoke(o,"a");
            System.out.println(re.toString()+"--"+rr.toString());

            //4.通过反射机制执行构造方法实例化对象
            Object ab=m3.newInstance("abcdef");
            System.out.println(ab);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


}
