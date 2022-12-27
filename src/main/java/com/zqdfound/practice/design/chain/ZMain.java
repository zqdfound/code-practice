package com.zqdfound.practice.design.chain;

/**
 * @Author: zhuangqingdian
 * @Data:2022/12/27
 */
public class ZMain {
    public static void main(String[] args) {
        RequestMsg requestMsg = new RequestMsg();
        requestMsg.setRequestMessage("AAAA-------BBBB");
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg.setResponseMessage("");

        DataFilterChain chain = new DataFilterChain();
        chain.addFilter(new ADataFilter());
        chain.addFilter(new BDataFilter());
        chain.doFilter(requestMsg, responseMsg, chain);
        System.out.println(requestMsg.getRequestMessage());
        System.out.println(responseMsg.getResponseMessage());
    }
}
