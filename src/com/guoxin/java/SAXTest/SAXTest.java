package com.guoxin.java.SAXTest;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * @author CY_JFXX
 * @create 2020-03-21 8:43
 */
public class SAXTest {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        //创建解析器工厂
        SAXParserFactory saxParserFactory=SAXParserFactory.newInstance();
        //创建解析器
        SAXParser saxParser=saxParserFactory.newSAXParser();
        //创建解析处理器
        MyDefaultHanlder dh=new MyDefaultHanlder();
        //通过解析器的parser方法解析
        saxParser.parse("src/config/persons.xml",dh);
    }
}


class MyDefaultHanlder extends DefaultHandler{

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.print("<"+qName+">");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.print("</"+qName+">");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.print(new String(ch,start,length));
    }
}