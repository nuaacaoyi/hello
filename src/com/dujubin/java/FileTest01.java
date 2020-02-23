package com.dujubin.java;

import java.io.File;

/**
 * @author CY_JFXX
 * @create 2020-02-20 11:29
 */
public class FileTest01 {
    public static void main(String[] args) {
        String path="D:\\学习\\JAVA";//可以是相对路径，也可以是绝对路径

        File f1=new File(path);
        //if(!f1.exists())f1.mkdir();//创建目录
        //if(!f1.exists())f1.createNewFile();//创建文件

        System.out.println(f1.exists());

        File f5=new File("c:/a/b/c/d/e");
        //if(!f5.exists())f5.mkdirs();//创建多重目录
    }
}
