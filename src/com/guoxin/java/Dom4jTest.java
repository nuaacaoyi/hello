package com.guoxin.java;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.Iterator;

/**
 * @author CY_JFXX
 * @create 2020-03-20 21:33
 * 使用Dom4j 框架？ jar包
 */
public class Dom4jTest {
    public static void main(String[] args) {

        try {
            //创建解析器
            SAXReader reader= new SAXReader();
            //通过解析器的read方法将配置文件读取到内存中，生成一个Document[org.dom4j包下的类]对象树
            Document document= reader.read("src/config/student.xml");
            //获取根节点
            Element rootElement=document.getRootElement();
            //遍历根节点
            Iterator<Element> rootIter=rootElement.elementIterator();
            while(rootIter.hasNext()){
                Element student=rootIter.next();
                Iterator<Element> innerIter= student.elementIterator();
                while(innerIter.hasNext()){
                    Element innerElt=innerIter.next();
                    String innerValue=innerElt.getStringValue();
                    System.out.print(innerValue+"  ");
                }
                System.out.println(" ");
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
