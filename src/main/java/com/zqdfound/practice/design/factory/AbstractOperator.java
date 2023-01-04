package com.zqdfound.practice.design.factory;

/**
 * @Author: zhuangqingdian
 * @Data:2023/1/4
 */
public abstract class AbstractOperator {
    public int a ;
    public int b ;

    public void setA(int a){
        this.a = a;
    }
    public void setB(int b){
        this.b = b;
    }

    public abstract void operator();
}
