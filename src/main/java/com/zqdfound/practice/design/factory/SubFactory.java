package com.zqdfound.practice.design.factory;

/**
 * @Author: zhuangqingdian
 * @Data:2023/1/4
 */
public class SubFactory extends AbstractFactory{
    @Override
    public AbstractOperator getOperator() {
        return new SubOperator();
    }
}
