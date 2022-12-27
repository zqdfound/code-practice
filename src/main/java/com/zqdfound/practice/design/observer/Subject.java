package com.zqdfound.practice.design.observer;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhuangqingdian
 * @Data:2022/12/27
 */
@Data
public class Subject {
    private List<Observer> observerList = new ArrayList<>();

    public void setState(){
        System.out.println("主体状态发生改变...");
        notifyAllObservers();
    }

    public void addObserver(Observer observer){
        this.observerList.add(observer);
    }

    private void notifyAllObservers() {
        for (Observer ob: observerList) {
            ob.update();
        }
    }
}
