package com.zqdfound.practice.dataStructure.queue.delayQueue;

import java.util.concurrent.TimeUnit;

/**
 * @Author: zhuangqingdian
 * @Data:2023/1/6
 */
public class ZMain {
    public static void main(String[] args) {
        DelayTaskManager manager = new DelayTaskManager();
        manager.put(new DelayWorker(()-> "AAAA"),3, TimeUnit.SECONDS);
        manager.put(new DelayWorker(()-> "BBBB"),5, TimeUnit.SECONDS);
        manager.put(new DelayWorker(()-> "CCCC"),7, TimeUnit.SECONDS);
    }
}
