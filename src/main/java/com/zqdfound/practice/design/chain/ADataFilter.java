package com.zqdfound.practice.design.chain;


/**
 * @Author: zhuangqingdian
 * @Data:2022/12/26
 */
public class ADataFilter implements MyFilter{
    @Override
    public void doFilter(RequestMsg requestMsg, ResponseMsg responseMsg, DataFilterChain chain) {
        requestMsg.setRequestMessage(requestMsg.getRequestMessage().replace("A","a"));
        chain.doFilter(requestMsg,responseMsg,chain);
        responseMsg.setResponseMessage(responseMsg.getResponseMessage()+"--AFilter()--");
    }
}
