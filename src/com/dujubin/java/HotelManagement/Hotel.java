package com.dujubin.java.HotelManagement;

/**
 * @author CY_JFXX
 * @create 2020-02-18 19:29
 */
public class Hotel {
    Room[][] rooms;

    public Hotel(Room[][] rooms) {
        this.rooms = rooms;
    }

    Hotel() {
        rooms =new Room[5][10];
        for (int i = 0; i < rooms.length  ; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if(i==0 || i==1){
                    rooms[i][j]=new Room(100*(i+1)+j+1+"","标准间",false);
                }
                if(i==2 || i==3){
                    rooms[i][j]=new Room(100*(i+1)+j+1+"","双人间",false);
                } if(i==4){
                    rooms[i][j]=new Room(100*(i+1)+j+1+"","豪华间",false);
                }
            }

        }
    }
    public  void print(){
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                System.out.print(rooms[i][j]);
            }
            System.out.println();
        }
    }
}
