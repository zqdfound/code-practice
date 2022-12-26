package com.zqdfound.practice.design.chain;

/**
 * @Author: zhuangqingdian
 * @Data:2022/12/26
 */
public interface MyFilter {
    void doFilter(RequestMsg requestMsg,ResponseMsg responseMsg,DataFilterChain chain);
}
