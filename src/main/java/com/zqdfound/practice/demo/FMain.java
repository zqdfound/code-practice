package com.zqdfound.practice.demo;

/**
 * @Author: zhuangqingdian
 * @Data:2022/12/29
 */
public class FMain {
    public static void main(String[] args) {
        Long current = System.currentTimeMillis()/1000;
        String nonce = "4t9w323t23t";
        System.out.println(current);
        System.out.println(CheckSumBuilder.getCheckSum("6b273b99b450",nonce,current.toString()));
    }
}
