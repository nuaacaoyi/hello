package com.atimooc.java;

/**
 * @author CY_JFXX
 * @create 2020-02-14 16:04
 */
public  class Rectangele extends Shape {
    @Override
    public double zhouChangh(double chang,double kuan) {
        return 2*(chang+kuan);
    }

    @Override
    public double mianJi(double chang,double kuan) {
        return chang*kuan;
    }
}
