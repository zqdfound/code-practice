package com.zqdfound.practice.design.chain;

/**
 * @Author: zhuangqingdian
 * @Data:2022/12/26
 */
public class BDataFilter implements MyFilter{
    @Override
    public void doFilter(RequestMsg requestMsg, ResponseMsg responseMsg, DataFilterChain chain) {
        requestMsg.setRequestMessage(requestMsg.getRequestMessage().replace("B","b"));
        chain.doFilter(requestMsg,responseMsg,chain);
        responseMsg.setResponseMessage(responseMsg.getResponseMessage()+"---BFilter()---");
    }
}
