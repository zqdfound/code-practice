package com.zqdfound.practice.dataStructure.queue.delayQueue;

import java.util.function.Supplier;

/**
 * 业务执行类
 * @Author: zhuangqingdian
 * @Data:2023/1/6
 */
public class DelayWorker implements Runnable{
    private Supplier<?> supplier;

    public DelayWorker(Supplier<?> supplier){
        this.supplier = supplier;
    }

    @Override
    public void run() {
        //执行业务
        System.out.println(Thread.currentThread().getName()+"-正在执行...");
        System.out.println(supplier.get());
    }
}
