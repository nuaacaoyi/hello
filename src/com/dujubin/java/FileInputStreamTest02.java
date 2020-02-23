package com.dujubin.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author CY_JFXX
 * @create 2020-02-19 16:24 *
 * while read() 每次访问只能访问一个字节  访问1MB=1024*1024bytes 就需要读 1024*1024次
 *  * 频繁的读写硬盘，对硬盘有伤害
 */
public class FileInputStreamTest02 {
    public static void main(String[] args) {
        FileInputStream fis= null;
        try {
            fis = new FileInputStream("D:\\javaworkplace\\hello\\123.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //遍历读
        while (true){
            int temp= 0;
            try {
                temp = fis.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(temp==-1)break;
            System.out.println(temp);
        }
        try {
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
