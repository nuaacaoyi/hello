package com.atimooc.java;

/**
 * @author CY_JFXX
 * @create 2020-02-14 15:57
 */
public class SmartPhone extends Phone implements IPlayGame {
    @Override
    public void call() {
        System.out.println("通过语音电话");
    }

    @Override
    public void message() {
        System.out.println("通过语音短信");
    }

    @Override
    public void playGame() {
        System.out.println("手机可以打游戏");
    }
}
