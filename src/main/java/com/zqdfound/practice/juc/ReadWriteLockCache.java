package com.zqdfound.practice.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReentrantReadWriteLock
 * 读写锁实现简单缓存
 * @Author: zhuangqingdian
 * @Data:2022/12/30
 */
public class ReadWriteLockCache {

    private Map<String,Object> cacheMap = new HashMap<>();
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Lock readLock = readWriteLock.readLock();
    private Lock writeLock = readWriteLock.writeLock();

    public Object getCache(String key){
        readLock.lock();
        try {
            return cacheMap.get(key);
        }finally {
            readLock.unlock();
        }
    }

    public void putCache(String key,Object value){
        writeLock.lock();
        try {
            cacheMap.put(key,value);
        }finally {
            writeLock.unlock();
        }
    }


}
