package com.zqdfound.practice.dataStructure.queue.delayQueue.example;

import lombok.Data;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 延时消息
 * @Author: zhuangqingdian
 * @Data:2023/1/6
 */
@Data
public class DelayMsg implements Delayed {

    private int id;
    private String msg;
    private long executeTime;

    public DelayMsg(int id,String msg,long delayTime){
        this.id = id;
        this.msg = msg;
        this.executeTime = TimeUnit.NANOSECONDS.convert(delayTime,TimeUnit.MILLISECONDS) + System.nanoTime();
    }



    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.executeTime - System.nanoTime(),TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        DelayMsg delayMsg = (DelayMsg)o;
        return Integer.valueOf(this.id) > Integer.valueOf(delayMsg.id) ? 1
                : (Integer.valueOf(this.id) < Integer.valueOf(delayMsg.id) ? -1 : 0);
    }

}
