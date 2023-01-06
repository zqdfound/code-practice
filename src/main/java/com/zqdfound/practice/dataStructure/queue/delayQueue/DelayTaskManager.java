package com.zqdfound.practice.dataStructure.queue.delayQueue;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.*;

/**
 * 延时任务管理类
 *
 * @Author: zhuangqingdian
 * @Data:2023/1/6
 */
public class DelayTaskManager {

    //延时队列
    private DelayQueue<DelayTask> delayQueue;
    // 守护线程
    private Thread daemonThread;
    //线程池
    private volatile ThreadPoolExecutor threadPool;

    public DelayTaskManager() {
        System.out.println("初始化延时任务管理类...");
        this.delayQueue = new DelayQueue<>();
        this.threadPool = getThreadPool();
        this.daemonThread = new Thread(() -> {
            doTask();
        });
        this.daemonThread.setName("监控线程");
        this.daemonThread.start();
    }

    private void doTask() {
        while (true) {
            Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
            System.out.println("当前存活线程数:" + map.size());
            int taskNum = delayQueue.size();
            System.out.println("当前延时任务数量:" + taskNum);
            try {
                DelayTask delayTask = delayQueue.take();
                if (delayTask != null) {
                    Optional.ofNullable(delayTask).ifPresent(l ->
                            this.threadPool.execute(l.getTask())
                    );
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 添加任务
     * @param task
     * @param time
     * @param timeUnit
     */
    public void put(Runnable task, long time,TimeUnit timeUnit){
        //获取延时时间
        long timeOut = TimeUnit.NANOSECONDS.convert(time,timeUnit);
        DelayTask delayTask = new DelayTask<>(timeOut,task);
        this.delayQueue.put(delayTask);
    }

    public boolean remove(DelayTask delayTask){
        return delayQueue.remove(delayTask);
    }


    public ThreadPoolExecutor getThreadPool() {
        if (threadPool != null) {
            return threadPool;
        } else {
            synchronized (ThreadPoolExecutor.class) {
                if (threadPool == null) {
                    // 设置线程池线程数量
                    threadPool = new ThreadPoolExecutor(
                            5,
                            10,
                            3,
                            TimeUnit.SECONDS,
                            new LinkedBlockingQueue<>(10),
                            Executors.defaultThreadFactory(),
                            new ThreadPoolExecutor.CallerRunsPolicy());
                }
            }
        }
        return threadPool;
    }


}
