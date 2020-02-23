package com.dujubin.java;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author CY_JFXX
 * @create 2020-02-19 9:55
 */
public class HashSetTest02   {
    public static void main(String[] args) {
        Set em=new HashSet();
        Employee e1=new Employee("1000","JACK");
        Employee e2=new Employee("1000","JACK1");
        Employee e3=new Employee("2000","A");
        Employee e4=new Employee("2001","B");
        Employee e5=new Employee("3000","C");
        Employee e6=new Employee("3001","D");
        Employee e7=new Employee("4000","E");
        Employee e8=new Employee("4001","F");

        em.add(e1);
        em.add(e2);
        em.add(e3);
        em.add(e4);
        em.add(e5);
        em.add(e6);
        em.add(e7);
        em.add(e8);

        System.out.println(em.size());
        System.out.println(e1.hashCode());
        System.out.println(e2.hashCode());
    }
}

//根据需求   该公司编号范围是 1000-9999
class Employee{
    String no;
    String name ;


    public Employee(String no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(no, employee.no) &&
                Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return no.hashCode();
    }
}
