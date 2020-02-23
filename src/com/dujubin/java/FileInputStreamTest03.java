package com.dujubin.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author CY_JFXX
 * @create 2020-02-19 16:32
 * 每次读取多个字节，存储到byte数组中  byte数组相当于临时缓存区
 *
 * 这个效率比read高
 */
public class FileInputStreamTest03 {
    public static void main(String[] args) {
        //1.创建输入流
        FileInputStream fis=null;
        try {
             fis=new FileInputStream("D:\\javaworkplace\\hello\\123.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        byte[] bytes=new byte[6];//每一次允许读取的最多字节数
        try {
            int i1=fis.read(bytes);// 返回的是本次读取的字节数
            System.out.println(new String(bytes));
            int i2=fis.read(bytes);// 返回的是本次读取的字节数，如果读取字节不超过6，则会将bytes前几个覆盖
            System.out.println(new String(bytes,0,i2));
            //System.out.println(new String(bytes));
            int i3=fis.read(bytes);// 返回的是本次读取的字节数,如果没有值，则返回-1  此时 bytes不变
            System.out.println(i1);
            System.out.println(i2);
            System.out.println(i3);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
