package com.zqdfound.practice.design.single;

/**
 * 单例，双重检查锁
 * @Author: zhuangqingdian
 * @Data:2022/12/27
 */
public class ZMain {
    public static void main(String[] args) {
        Singleton singleton = new Singleton();
        System.out.println("addr:" + singleton.getInstance());
        for (int i = 0; i < 100; i++) {
            System.out.println(singleton.getInstance());
        }
    }
}
