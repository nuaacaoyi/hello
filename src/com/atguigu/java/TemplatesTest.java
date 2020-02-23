package com.atguigu.java;

import com.atguigu.bean.Hello;

import java.util.ArrayList;

/**
 * @author CY_JFXX
 * @create 2020-02-13 18:47
 */
public class TemplatesTest {

     //模板一 psvm
     public static void main(String[] args) {
         //模板二 sout   //扩展 soutp  /   soutm  / soutv  /xxxx.sout
         System.out.println("HelloWorld!!!");
         
         //模板三： fori   //扩展  iter   /   itar
         String[] arr= new String[]{"tom","jerry","Hanmeimei"};
         for (int i = 0; i <arr.length ; i++) {
             System.out.println(arr[i]);
         }
        //模板四：list.for

     }

     public  void method(){
         //模板五： ifn  扩展  inn  xx.nn   xxx.null
         ArrayList list=new ArrayList();
         list.add(123);
         list.add(3456);
         list.add(789);

         if (list == null) {

         }
     }

     //模板六  prsf 生成私有静态常量
    //扩展 psf  /  psfi   /  psfs
    private static final int a=1;
     private static final Hello he= new Hello();

}
