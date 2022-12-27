package com.zqdfound.practice.design.observer;

/**
 * @Author: zhuangqingdian
 * @Data:2022/12/27
 */
public class AObserver extends Observer{

    public AObserver(Subject subject){
        this.subject = subject;
        this.subject.addObserver(this);
    }

    @Override
    public void update() {
        System.out.println("依赖A发生改变。。。");
    }
}
