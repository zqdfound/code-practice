package com.zqdfound.practice.design;

import com.zqdfound.practice.design.chain.*;
import com.zqdfound.practice.design.single.Singleton;

/**
 * @Author: zhuangqingdian
 * @Data:2022/12/26
 */
public class RunMain {
//    public static void main(String[] args) {
//        RequestMsg requestMsg = new RequestMsg();
//        requestMsg.setRequestMessage("AAAA-------BBBB");
//        ResponseMsg responseMsg = new ResponseMsg();
//        responseMsg.setResponseMessage("");
//
//        DataFilterChain chain = new DataFilterChain();
//        chain.addFilter(new ADataFilter());
//        chain.addFilter(new BDataFilter());
//        chain.doFilter(requestMsg,responseMsg,chain);
//        System.out.println(requestMsg.getRequestMessage());
//        System.out.println(responseMsg.getResponseMessage());
//    }

    public static void main(String[] args) {
        Singleton singleton = new Singleton();
        System.out.println("addr:"+singleton.getInstance());
        for (int i = 0; i < 100; i++) {
            System.out.println(singleton.getInstance());
        }
    }

}
