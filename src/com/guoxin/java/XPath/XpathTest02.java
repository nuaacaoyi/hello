package com.guoxin.java.XPath;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @author CY_JFXX
 * @create 2020-03-21 9:29
 */
public class XpathTest02 {
    public static void main(String[] args) {
        try {
            //创建解析器
            SAXReader reader=new SAXReader();
            //通过解析器的read方法将配置文件读取到内存当中，生成一个Document 对象树
            Document document=reader.read("src/config/server.xml");
            //获取connector节点元素对象的路径  server -> service -> connector
            Element portElt= (Element) document.selectSingleNode("//connector");
            System.out.println(portElt.attributeValue("port"));
            System.out.println(portElt.attribute(0).getValue());


        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
