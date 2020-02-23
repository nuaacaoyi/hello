package com.atimooc.java;

/**
 * @author CY_JFXX
 * @create 2020-02-14 11:15
 */
public   class Telphone {


    private float screen;

    public float getCup() {
        return cup;
    }

    public float cup;
    float mem;
    void call(){
        System.out.println("Telphone有打电话功能");
    }
    public void message(){
        System.out.println("Telphone有发短信功能 screen: "+ screen);
    }
    public Telphone(){

    }
    public  Telphone( float nscreen,float ncpu,float nmem){
        if(nscreen<3.5f){
            System.out.println("您输入的屏幕大小有问题");
            screen=3.5f;
        }
        else{
            screen=nscreen;
        }

        cup=ncpu;
        mem=nmem;
    }

    public float getScreen(){
        return screen;
    }
    public void setScreen(float nscreen){
        screen=nscreen;
    }
}
