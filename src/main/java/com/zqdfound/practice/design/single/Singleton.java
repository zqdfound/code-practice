package com.zqdfound.practice.design.single;

/**
 * 单例，双重检查锁
 * @Author: zhuangqingdian
 * @Data:2022/12/26
 */
public class Singleton {
    private volatile Singleton uniqueSingleton;
    public Singleton(){}

    public Singleton getInstance(){
        if(uniqueSingleton == null){
            synchronized (this){
                if(uniqueSingleton == null){
                    uniqueSingleton = new Singleton();
                }
            }
        }
        return uniqueSingleton;
    }
}
