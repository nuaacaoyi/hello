package com.dujubin.java;

/**
 * @author CY_JFXX
 * @create 2020-02-23 16:04
 * 实现单例模式
 */
public class SingletonPatternUser {
    private static SingletonPatternUser s;

    //构造方法私有化
    private SingletonPatternUser() {
    }
    //get方法获得对象
    public static SingletonPatternUser getInstance(){

        /*SingletonPatternUser s=new SingletonPatternUser();
        return  s;  无法实现单例  因为 还是new两次*/
        if (s == null) {
            s=new SingletonPatternUser();
        }
        return s;
    }
}
