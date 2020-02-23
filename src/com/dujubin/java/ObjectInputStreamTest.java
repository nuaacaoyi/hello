package com.dujubin.java;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author CY_JFXX
 * @create 2020-02-20 11:00
 * 反序列化存在风险，如果User类class文件被删除，或者重新生成，则无法反序列化，因为java对每个序列化都有ID配对（序列化版本号），如果class对不上，则无法执行
 * User如果实现了Serializable接口，JVM会对User特殊对待
 *      会给该类添加一个属性，static final long serialVersionID
 * 如果要避免该问题，  需要自己添加一个序列化版本号，不让系统自动生成
 *
 * 如果针对于类中某个属性不想序列化，则需要在属性前面加上   transient 关键字
 */
public class ObjectInputStreamTest {
    public static void main(String[] args) {
        ObjectInputStream ois=null;
        try {
            ois=new ObjectInputStream(new FileInputStream("temp06"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Object o= null;
        try {
            o = ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(o);

        if(ois!=null) {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
