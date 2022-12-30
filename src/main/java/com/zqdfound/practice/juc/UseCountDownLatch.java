package com.zqdfound.practice.juc;

import java.util.concurrent.CountDownLatch;

/**
 * countDownLatch
 * 模仿多线程批处理
 * @Author: zhuangqingdian
 * @Data:2022/12/30
 */
public class UseCountDownLatch {
    public static void main(String[] args) {
        int num = 2333;
        int batch = 1000;
        int threadNum = num/batch + (num % batch > 0? 1 : 0);
        final CountDownLatch latch = new CountDownLatch(threadNum);
        for (int i = 0; i < threadNum; i++) {
            new Thread(()->{
                    try {
                        System.out.println("子线程" + Thread.currentThread().getName() + "开始执行");
                        Thread.sleep(1000);
                        System.out.println("子线程"+Thread.currentThread().getName()+"执行完成");
                        latch.countDown();//当前线程调用此方法，则计数减一
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }).start();
        }

        try {
            System.out.println("主线程"+Thread.currentThread().getName()+"等待子线程执行完成...");
            latch.await();//阻塞当前线程，直到计数器的值为0
            System.out.println("主线程"+Thread.currentThread().getName()+"开始执行...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
