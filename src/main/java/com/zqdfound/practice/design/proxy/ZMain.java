package com.zqdfound.practice.design.proxy;

/**
 * 在代理模式（Proxy Pattern）中，一个类代表另一个类的功能。这种类型的设计模式属于结构型模式。
 * 在代理模式中，我们创建具有现有对象的对象，以便向外界提供功能接口。
 * @Author: zhuangqingdian
 * @Data:2022/12/27
 */
public class ZMain {

    public static void main(String[] args) {
        Images images = new ProxyImages("文件名");
        images.display();//第一次从硬盘加载
        images.display();//第二次从缓存加载
    }
}
