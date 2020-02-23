package com.dujubin.java.BufferedIOTest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

/**
 * @author CY_JFXX
 * @create 2020-02-19 19:49
 */
public class BufferedReaderTest02 {
    public static void main(String[] args) throws FileNotFoundException {
        //创建带有缓冲区的字符输入流
        BufferedReader br=null;

        //文件字节输入流
        FileInputStream fis=new FileInputStream("D:\\javaworkplace\\hello\\src\\com\\dujubin\\java\\BufferedIOTest\\BufferedReaderTest02.java");
        //第一层包装  字符输入流
        InputStreamReader isr=new InputStreamReader(fis);
        //第二层包装  带有缓冲区的字符输入流
        br=new BufferedReader(isr);
    }
}
