package com.atimooc.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author CY_JFXX
 * @create 2020-02-18 13:58
 */
public class DateTest01 {
    public static void main(String[] args) throws ParseException {
        Calendar c=Calendar.getInstance();
        String strTime="2008,08,08";
        Date d=new SimpleDateFormat("yyyy,MM,dd").parse(strTime);
        c.setTime(d);
        System.out.println(c.get(Calendar.DAY_OF_MONTH));
        /*long now=System.currentTimeMillis();
        System.out.println(now);
        Date t2=new Date(System.currentTimeMillis()-1000*60*10);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        System.out.println(sdf.format(t2));*/
    }
}
