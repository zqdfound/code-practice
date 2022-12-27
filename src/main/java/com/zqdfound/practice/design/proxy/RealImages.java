package com.zqdfound.practice.design.proxy;

/**
 * @Author: zhuangqingdian
 * @Data:2022/12/27
 */
public class RealImages implements Images{

    private String fileName;

    public RealImages(String fileName){
        this.fileName = fileName;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("load "+fileName+" from disk");
    }

    @Override
    public void display() {
        System.out.println("fileName is: " + fileName);
    }
}
