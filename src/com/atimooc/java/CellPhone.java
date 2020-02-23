package com.atimooc.java;

/**
 * @author CY_JFXX
 * @create 2020-02-14 15:56
 */
public class CellPhone extends Phone {
    @Override
    public void call() {
        System.out.println("通过键盘电话");
    }

    @Override
    public void message() {
        System.out.println("通过键盘短信");
    }
}
