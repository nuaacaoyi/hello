package com.dujubin.java.BufferedIOTest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author CY_JFXX
 * @create 2020-02-19 20:05
 */
public class BufferedWriterTest01 {
    public static void main(String[] args) {
        BufferedWriter bw=null;
        try {
              bw=new BufferedWriter(new FileWriter("D:\\TEMP.TXT"));
              bw.write("奥运会开幕式");
              bw.newLine();
              bw.write("一点也没有意思");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(bw!=null) {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
