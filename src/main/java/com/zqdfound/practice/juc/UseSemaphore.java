package com.zqdfound.practice.juc;

import java.util.concurrent.Semaphore;

/**
 * Semaphore
 * 信号量，控制可以访问共享资源的线程数量
 * @Author: zhuangqingdian
 * @Data:2022/12/30
 */
public class UseSemaphore {

    public static void main(String[] args) {
        // 以A开始的信号量,初始信号量数量为1
        Semaphore semaphoreA = new Semaphore(1);
        // B、C信号量,A完成后开始,初始信号数量为0
        Semaphore semaphoreB = new Semaphore(0);
        Semaphore semaphoreC = new Semaphore(0);

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    semaphoreA.acquire();// A获取信号执行,A信号量减1,当A为0时将无法继续获得该信号量
                    System.out.println("A");
                    semaphoreB.release();// B释放信号，B信号量加1（初始为0），此时可以获取B信号量
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    semaphoreB.acquire();
                    System.out.println("B");
                    semaphoreC.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    semaphoreC.acquire();
                    System.out.println("C");
                    semaphoreA.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
