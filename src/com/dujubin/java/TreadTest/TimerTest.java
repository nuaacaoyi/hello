package com.dujubin.java.TreadTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author CY_JFXX
 * @create 2020-02-20 18:01
 * 定时器的应用  每隔一段固定的时间，执行一段代码
 */
public class TimerTest {
    public static void main(String[] args) {
        //1.创建定时器
        Timer t=new Timer();

        try {
            t.schedule(new LogTimerTask(), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").parse("2020-02-20 18:37:59 999"),10*1000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

class LogTimerTask extends TimerTask{
    public void run(){
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()));
    }
}