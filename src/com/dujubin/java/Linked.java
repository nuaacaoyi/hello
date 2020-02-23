package com.dujubin.java;

/**
 * @author CY_JFXX
 * @create 2020-02-18 16:57
 * java语言模拟单向链表
 */
public class Linked {
    Entry entry;
    Linked(){
        entry=new Entry(null,null);
    }

    //增
    //删
    //查

    static  class Entry{
        Object data;
        Entry next;

        Entry(){

        }

        Entry(Object data,Entry next){
            this.data=data;
            this.next=next;
        }
    }
}
