package com.rong.flora.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rong on 16/8/9.
 */
public class KFC {
    private Map<String, Integer> price = new HashMap<>();

    public KFC(){
        price.put("bg", 10);
        price.put("coke", 5);
        price.put("icecream",5);
    }

    public Map<String, Integer> sell(Integer money){
        Map<String, Integer> list = new HashMap<>();
        price.forEach((k, v)-> {
                    if(money/v > 0)
                        list.put(k, money / v);
                }
        );
        System.out.println(list);
        return list;
    }

    public static void main(String[] args){
        KFC kfc = new KFC();
        kfc.sell(4);
    }
}
