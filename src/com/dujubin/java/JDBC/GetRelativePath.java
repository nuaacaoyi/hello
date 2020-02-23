package com.dujubin.java.JDBC;

/**
 * @author CY_JFXX
 * @create 2020-02-22 10:25
 * 没用
 */
public class GetRelativePath {

    public String path ;

    public GetRelativePath() {
        this.path=this.getClass().getClassLoader().getResource("./MysqlStudy.properties").getPath();
    }
}
