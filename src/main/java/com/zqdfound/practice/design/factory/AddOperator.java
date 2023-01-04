package com.zqdfound.practice.design.factory;

/**
 * @Author: zhuangqingdian
 * @Data:2023/1/4
 */
public class AddOperator extends AbstractOperator{
    @Override
    public void operator() {
        int a = super.a;
        int b = super.b;
        System.out.println(a+b);
    }
}
