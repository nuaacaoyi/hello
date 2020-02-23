package com.atimooc.java;

import java.util.Objects;

/**
 * @author CY_JFXX
 * @create 2020-02-14 14:39
 */
public class Dog extends Aniaml {
    public int age=13;
    public void eat(){
        System.out.println("年龄"+age+"的狗狗可以吃东西");
    }
    public Dog(){
        System.out.println("Dog类执行");
    }
    public void method(){
        super.eat();
    }

    @Override
    public String toString() {
        return "Dog{" +
                "age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return age == dog.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }
}
