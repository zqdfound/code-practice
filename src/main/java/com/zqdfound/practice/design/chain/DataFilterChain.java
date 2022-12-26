package com.zqdfound.practice.design.chain;

import java.util.ArrayList;
import java.util.List;

/**
 * 责任链
 * @Author: zhuangqingdian
 * @Data:2022/12/26
 */
public class DataFilterChain implements MyFilter{

    private List<MyFilter> myFilters = new ArrayList<>();

    private int index = 0;

    public DataFilterChain addFilter(MyFilter myFilter){
        myFilters.add(myFilter);
        return this;
    }


    @Override
    public void doFilter(RequestMsg requestMsg, ResponseMsg responseMsg, DataFilterChain chain) {
        if(index == myFilters.size()){
            return;
        }
        MyFilter filter = myFilters.get(index);
        index ++;
        filter.doFilter(requestMsg,responseMsg,chain);
    }
}
