package com.dujubin.java;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author CY_JFXX
 * @create 2020-02-20 10:53
 */
public class ObjectOutputStreamTest {
    public static void main(String[] args) {
        User u=new User("JACK");
        ObjectOutputStream oos=null;
        try {
            oos=new ObjectOutputStream(new FileOutputStream("temp06"));
            oos.writeObject(u);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


        if(oos!=null) {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

class User implements Serializable {//Serializable是标志性接口，没有属性和方法，用于JVM的识别
    private  String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
