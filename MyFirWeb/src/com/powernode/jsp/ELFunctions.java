package com.powernode.jsp;

/**
 * @author cy_hnmx
 * @create 2020-03-13-17:53
 * EL自定义函数
 * 该类极其函数，需要在一个 扩展名为 .tld 的XML文件中进行注册
 *  tld， 全拼 tag library definition， 标签库定义
 *  XML文件是需要约束的，即需要配置文件头部。这个头部约束可以从以下文件中进行复制：
 *      在Tomcat安装目录下  webapps/examples/WEB-INF/jsp2/jsp2-example-taglib.tld
 *  这个 .tld 的 XML文件，需要定义在当前Web项目的WEB-INF目录下
 */
public class ELFunctions {
    public static String lowerToUpper(String source){
        return source.toUpperCase();
    }
}
