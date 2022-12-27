package com.zqdfound.practice.design.observer;

/**
 * 观察者模式
 * 当对象间存在一对多关系时，则使用观察者模式（Observer Pattern）。
 * 比如，当一个对象被修改时，则会自动通知依赖它的对象。观察者模式属于行为型模式。
 *
 * @Author: zhuangqingdian
 * @Data:2022/12/27
 */
public class ZMain {
    public static void main(String[] args) {
        Subject subject = new Subject();
        new AObserver(subject);
        new BObserver(subject);

        subject.setState();
        subject.setState();
    }
}
