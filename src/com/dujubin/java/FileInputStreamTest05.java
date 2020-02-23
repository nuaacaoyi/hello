package com.dujubin.java;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author CY_JFXX
 * @create 2020-02-19 17:16
 */
public class FileInputStreamTest05 {
    public static void main(String[] args) throws IOException {
        //1.创建流
        FileInputStream fis=new FileInputStream("D:\\javaworkplace\\hello\\123.txt");

        System.out.println(fis.available() );//返回文件大小，10 字节

        fis.skip(2);//跳过去多少个字节不读取
        System.out.println(fis.read());

        System.out.println(fis.available() );//返回l流中估计的剩余字节数

        fis.close();
    }
}
