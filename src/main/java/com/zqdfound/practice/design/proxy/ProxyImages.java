package com.zqdfound.practice.design.proxy;

/**
 * @Author: zhuangqingdian
 * @Data:2022/12/27
 */
public class ProxyImages implements Images{

    private String fileName;
    private RealImages realImages;

    public ProxyImages(String fileName){
        this.fileName = fileName;
    }


    @Override
    public void display() {
        if(realImages == null){
            realImages = new RealImages(fileName);
        }
        realImages.display();
    }
}
