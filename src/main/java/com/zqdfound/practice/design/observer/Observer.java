package com.zqdfound.practice.design.observer;

/**
 * @Author: zhuangqingdian
 * @Data:2022/12/27
 */
public abstract class Observer {
    public Subject subject;
    public abstract void update();
}
