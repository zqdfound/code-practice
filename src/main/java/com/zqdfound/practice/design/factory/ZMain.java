package com.zqdfound.practice.design.factory;

/**
 * @Author: zhuangqingdian
 * @Data:2023/1/4
 */
public class ZMain {
    public static void main(String[] args) {
//        AbstractOperator addOp = new AddFactory().getOperator();
//        addOp.setA(1);
//        addOp.setB(2);
//        addOp.operator();

        AbstractOperator subOp = new SubFactory().getOperator();
        subOp.setA(1);
        subOp.setB(2);
        subOp.operator();
    }
}
