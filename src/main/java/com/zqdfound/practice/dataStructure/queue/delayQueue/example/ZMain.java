package com.zqdfound.practice.dataStructure.queue.delayQueue.example;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: zhuangqingdian
 * @Data:2023/1/6
 */
public class ZMain {
    public static void main(String[] args) {
        DelayQueue<DelayMsg> delayQueue = new DelayQueue<>();
        delayQueue.offer(new DelayMsg(1,"我他妈来辣！！！",2000));
        delayQueue.offer(new DelayMsg(2,"拟态baby辣🥵！！！",5000));
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(new DelayConsumer(delayQueue));
        executorService.shutdown();
    }
}
