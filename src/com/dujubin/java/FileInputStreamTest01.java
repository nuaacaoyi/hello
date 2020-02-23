package com.dujubin.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author CY_JFXX
 * @create 2020-02-19 16:09
 * 文件字节输入流,按照字节方式读取文件
 *

 */
public class FileInputStreamTest01 {
    public static void main(String[] args) {
        //1.要读取某文件，创建流对象
        String path="D:\\javaworkplace\\hello\\123.txt";
        FileInputStream fis=null;
        try{
             fis=new FileInputStream(path);

            //2.开始读
            int i1=fis.read();//以字节的方式读取
            int i2=fis.read();//读第二个字节，1.如果读到最后没有数据，只能读出-1；2. 如果文件中有汉字，一个字节只能读取字符的一半
            System.out.println(i1+"--"+i2);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        finally {
            //3.保证流一定会释放
            try{
                if(fis != null) fis.close();
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }
}
