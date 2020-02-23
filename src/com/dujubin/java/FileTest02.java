package com.dujubin.java;

import java.io.File;

/**
 * @author CY_JFXX
 * @create 2020-02-20 11:43
 * 使用递归找出X目录下所有子文件
 */
public class FileTest02 {
    public static void main(String[] args) {
        File f=new File("E:\\韩剧");


        //调用防范，完成查找
        method1(f);
    }
    public static void method1(File file){
        //file有两种可能，一种是目录，一种是文件
        if(file.isFile()){
            return;
        }

        File[] fs=    file.listFiles();
        for(File subf:fs){
            System.out.println(subf.getAbsolutePath());
            method1(subf);
        }
    }
}
