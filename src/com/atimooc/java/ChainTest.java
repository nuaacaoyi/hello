package com.atimooc.java;

/**
 * @author CY_JFXX
 * @create 2020-02-16 20:25
 */
public class ChainTest {
    /**
     * test1()  抛出喝大了异常
     * test2() 调用test1，捕获喝大了异常，并且包装成新异常
     *main() 调用test2，尝试
     */
    public static void main(String[] args) {
        ChainTest ct=new ChainTest();
        try{
            ct.test2();
        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void test1() throws DrunkException {
        throw new DrunkException("喝车别开酒");
    }
    public void test2(){
        try {
            test1();
        }catch (DrunkException e)
        {
            RuntimeException newExc=new RuntimeException("司机一滴酒，亲人两行泪");
            newExc.initCause(e);
            throw newExc;
        }
    }
}
