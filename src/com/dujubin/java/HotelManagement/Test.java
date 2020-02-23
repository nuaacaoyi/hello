package com.dujubin.java.HotelManagement;

import java.util.Scanner;

/**
 * @author CY_JFXX
 * @create 2020-02-18 19:44
 */
public class Test    {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("欢迎使用酒店管理系统，酒店列表如下所示");
        Hotel h=new Hotel();
        h.print();
    }
}
