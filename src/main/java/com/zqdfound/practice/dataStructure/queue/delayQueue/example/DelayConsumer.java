package com.zqdfound.practice.dataStructure.queue.delayQueue.example;

import java.util.concurrent.DelayQueue;

/**
 * @Author: zhuangqingdian
 * @Data:2023/1/6
 */
public class DelayConsumer implements Runnable{

    private DelayQueue<DelayMsg> delayQueue;

    public DelayConsumer(DelayQueue<DelayMsg> delayQueue){
        this.delayQueue = delayQueue;
    }

    @Override
    public void run() {
        while (true){
            try {
                DelayMsg delayMsg = delayQueue.take();
                System.out.println("receive delay msg: id="+delayMsg.getId()+" msg="+delayMsg.getMsg());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
