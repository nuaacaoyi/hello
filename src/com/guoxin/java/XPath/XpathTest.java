package com.guoxin.java.XPath;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @author CY_JFXX
 * @create 2020-03-21 9:04
 */
public class XpathTest {
    public static void main(String[] args) {
        try {
            //创建解析器
            SAXReader reader=new SAXReader();
            //通过解析器的read方法将配置文件读取到内存当中，生成一个Document 对象树
            Document document=reader.read("src/config/sys-config.xml");
            // driver-name 节点元素的路径：  config -> database-info -> driver-name
            //driver-name节点元素的xpath路径  /config/database-info/driver-name
            Element drivernameElt= (Element) document.selectSingleNode("/config/database-info/driver-name");
            //获取driver-name节点元素对象的文本内容
            System.out.println(drivernameElt.getStringValue());


            //user节点元素的路径： config -> database-info ->user
            //user节点的xpath路径： /config/database-info/user
            //user节点的xpath路径： config//user
            //User节点的xpath路径：  //user
            Element userElt= (Element) document.selectObject("//user");
            System.out.println(userElt.getTextTrim());

            //如果有两个passwor可以使用  谓语  [1] 第一个
            Element passwordElt= (Element) document.selectSingleNode("//password");
            System.out.println(passwordElt.getTextTrim());
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }
}
