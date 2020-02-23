package com.dujubin.java.BufferedIOTest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author CY_JFXX
 * @create 2020-02-19 19:33
 */
public class BufferedReaderTest01 {
    public static void main(String[] args) {
        //创建一个带有字符串缓冲区的输入流
        FileReader fr=null;
        BufferedReader br=null;
        try {
            fr=new FileReader("D:\\javaworkplace\\hello\\src\\com\\dujubin\\java\\BufferedIOTest\\BufferedReaderTest01.java");
            br=new BufferedReader(fr);

            String temp=null;
            while((temp=br.readLine())!=null){//readline()读取一行，且不带换行符
                System.out.println(temp);
            }

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(br!=null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        /*关闭时只需要关闭最外层的包装流
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
