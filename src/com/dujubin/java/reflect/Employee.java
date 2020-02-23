package com.dujubin.java.reflect;

/**
 * @author CY_JFXX
 * @create 2020-02-20 19:18
 */
public class Employee {
    //Field
    String name;

    //Constructor
    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    //Method
    public void work(){
        System.out.println("在工作");
    }

}
