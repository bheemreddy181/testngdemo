package com.rong.flora.feb_18;

import com.rong.flora.practice.Green;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by rongwf1 on 2017/2/18.
 */
public class GreenDot {
    public int[] minMax(int[] array)throws RuntimeException{

        if (array ==null){
            throw new NullPointerException("this array is null");
        }
        int length = array.length;
        if (length == 0){
            throw new RuntimeException(" this array is empty");
        }
        int[] minMax = {array[0], array[0]};
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minMax[0]){
                minMax[0] = array[i];
            }
            if (array[i] > minMax[1]){
                minMax[1] = array[i];
            }
        }
        return minMax;
    }

    public static Map<Integer, Integer> cal(Integer[] array){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) != null){
                int cnt = map.get(array[i]) + 1;
                map.put(array[i], cnt);
            } else {
                map.put(array[i], 1);
            }
        }
        return map;
    }

    public static Map<Integer, Integer> cal2(Integer[] array){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int cnt = map.getOrDefault(array[i], 0);
            map.put(array[i], cnt+1);
        }
        return map;
    }

    public static void  main(String... args){
        Integer[] array = { 1000,1000, 1, 5,6,6};
        System.out.println(GreenDot.cal(array));

    }

}
