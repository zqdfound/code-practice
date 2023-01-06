package com.zqdfound.practice.dataStructure.queue.delayQueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 延时任务执行类
 * @Author: zhuangqingdian
 * @Data:2023/1/6
 */
public class DelayTask<T extends Runnable> implements Delayed {
    private final long time;
    private final T task;

    public DelayTask(long time, T task){
        this.time = time + System.nanoTime();
        this.task = task;
    }

    public T getTask(){
        return this.task;
    }

    @Override
    public int hashCode() {
        return this.task.hashCode();
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.time - System.nanoTime(),TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        DelayTask delayTask = (DelayTask)o;
        long diff = this.time - delayTask.time;
        if(diff > 0){
            return 1;
        }else if(diff < 0){
            return -1;
        }
        return 0;
    }


}
