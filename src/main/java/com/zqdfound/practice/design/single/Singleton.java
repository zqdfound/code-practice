package com.zqdfound.practice.design.single;

/**
 *
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
