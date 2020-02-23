package com.dujubin.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author CY_JFXX
 * @create 2020-02-19 17:06
 */
public class FileInputStreamTest04 {
    public static void main(String[] args) {
        FileInputStream fis=null;
        String path="D:\\javaworkplace\\hello\\123.txt";

        try {
            fis=new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[] bytes=new byte[1024];//每次读取1KB

      /*  while(true){
            int temp= 0;
            try {
                temp = fis.read(bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(temp==-1)break;
            System.out.println(new String(bytes,0,temp));
        }*/
      int temp=0;
      while (true)
      {
          try {
              if (!((temp=fis.read(bytes))!= -1)) break;
          } catch (IOException e) {
              e.printStackTrace();
          }
          System.out.print(new String(bytes,0,temp));
      }
        try {
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
