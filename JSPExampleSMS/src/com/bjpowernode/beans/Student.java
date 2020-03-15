package com.bjpowernode.beans;

import java.io.Serializable;

/**
 * @author CY_JFXX
 * @create 2020-03-15 16:10
 */
public class Student implements Serializable {
    private String name;
    private int age;
    private double score;
    private Integer id;//业务无关主键  尽量不要写成int 因为int类型不能判空
    private String num;
    private String password;

    public Student(String name, int age, double score, String num) {
        this.name = name;
        this.age = age;
        this.score = score;
        this.num = num;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
