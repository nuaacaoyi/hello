package com.dujubin.java;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author CY_JFXX
 * @create 2020-02-19 17:23
 */
public class FileOuputStreamTest01 {
    public static void main(String[] args) {
        FileOutputStream fos=null;
        try {
           /* //1.创建流
            fos=new FileOutputStream("D:\\javaworkplace\\hello\\23.txt");//文件不存在时会自动创建
            //2.开始写
            String message="Hello World!";
            byte[] bytes=message.getBytes();

            fos.write(bytes);  //文件写入会把之前内容覆盖掉，除非构造函数增加append参数*/

            //1.追加的方式写入
            fos=new FileOutputStream("D:\\javaworkplace\\hello\\23.txt",true);//文件不存在时会自动创建
            //2.开始写
            String message="Hello World!";
            byte[] bytes=message.getBytes();

            fos.write(bytes);  //文件写入会把之前内容覆盖掉，除非构造函数增加append参数


            //3.推荐最后的时候为了保证数据完全写入，所以要刷新
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos!=null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
