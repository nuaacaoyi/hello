package com.guoxin.java.XPath;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

/**
 * @author CY_JFXX
 * @create 2020-03-21 9:39
 */
public class XpathTest03 {
    public static void main(String[] args) {
        try {
            //创建解析工厂
            DocumentBuilderFactory documentBuilderFactory= DocumentBuilderFactory.newInstance();
            //创建w3c解析器
            DocumentBuilder builder=documentBuilderFactory.newDocumentBuilder();
            // W3C的 Document（org.w3c.dom）对象树
            Document document= builder.parse("src/config/bookstore.xml");
            //创建XPath对象
            XPathFactory xPathFactory=XPathFactory.newInstance();
            XPath xPath=xPathFactory.newXPath();
            String titleXpath="/bookstore/book[@category='web'][2]/title/text()";
            String titleValue = (String) xPath.evaluate(titleXpath,document, XPathConstants.STRING);
            System.out.println(titleValue);

            String langXpath="/bookstore/book[@category='cooking']/title/@lang";
            String langValue= (String) xPath.evaluate(langXpath,document,XPathConstants.STRING);
            System.out.println(langValue);

            //获取bookstore节点下所有book节点的集合
            //XPath路径   /bookstore/book
            NodeList bookList= (NodeList) xPath.evaluate("bookstore/book",document,XPathConstants.NODESET);
            for (int i = 0; i < bookList.getLength(); i++) {
                Element bookElt= (Element) bookList.item(i);
                String titleValue01= (String) xPath.evaluate("title",bookElt,XPathConstants.STRING);
                String authorValue= (String) xPath.evaluate("author",bookElt,XPathConstants.STRING);
                String yearValue=(String) xPath.evaluate("year",bookElt,XPathConstants.STRING);
                String priceValue=(String) xPath.evaluate("price",bookElt,XPathConstants.STRING);
                System.out.println(titleValue01+" - "+authorValue+" - "+yearValue+" - "+priceValue);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
