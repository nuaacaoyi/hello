package com.dujubin.java.HotelManagement;

/**
 * @author CY_JFXX
 * @create 2020-02-18 19:29
 */
public class Room {
    private  String no;
    private String type;// 标准件  豪华间 双人间
    private boolean isUse;//true表示可用


    public Room() {
    }

    public Room(String no, String type, boolean isUse) {
        this.no = no;
        this.type = type;
        this.isUse = isUse;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isUse() {
        return isUse;
    }

    public void setUse(boolean use) {
        isUse = use;
    }

    @Override
    public String toString() {
        return "Room{" +
                "no='" + no + '\'' +
                ", type='" + type + '\'' +
                ", isUse=" + isUse +
                '}';
    }
}
