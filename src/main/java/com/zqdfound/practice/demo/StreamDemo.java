package com.zqdfound.practice.demo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * 流常用方法
 * @Author: zhuangqingdian
 * @Data:2022/12/27
 */
public class StreamDemo {
    public static void main(String[] args) {
        List<Integer> filterList = Arrays.asList(1,2,3,4,5,6,7,8,9);
        System.out.println(filterList.stream().reduce(Integer::sum).get());
        //筛选，遍历
        filterList.stream().filter(l-> l>5 ).forEach(l-> System.out.println(l));

        // 匹配（find/match）
        // 匹配第一个
        Optional<Integer> findFirst = filterList.stream().filter(l -> l > 5).findFirst();
        // 匹配任意（适用于并行流）
        Optional<Integer> findAny = filterList.parallelStream().filter(l -> l > 6).findAny();
        // 是否包含符合特定条件的元素
        boolean anyMatch = filterList.stream().anyMatch(l -> l > 6);

        //聚合（max/min/count)
        List<String> list = Arrays.asList("adnm", "admmt", "pot", "xbangd", "weoujgsd");
        Optional<String> max = list.stream().max(Comparator.comparing(String::length));
        Optional<String> min = list.stream().min(Comparator.comparing(String::length));
        System.out.println("最长的字符串：" + max.get());
        System.out.println("最短的字符串：" + min.get());
    }





}
