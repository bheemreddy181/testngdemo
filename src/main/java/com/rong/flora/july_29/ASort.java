package com.rong.flora.july_29;


import java.util.HashMap;
import java.util.Map;

public class ASort {

    public Integer biSearch(Integer[] data, Integer pattern, Integer begin, Integer end){
        if (begin <= end){
            Integer mid = begin + (end-begin)/2;
            if (pattern.equals(data[mid])){
                return pattern;
            }else if(pattern < data[mid]){
                return biSearch(data, pattern, begin, mid-1);
            }else {
                return biSearch(data, pattern, mid+1, end);
            }
        }else {
            return null;
        }
    }

    public Integer[] sort(Integer[] data){
        for (int i = 0; i < data.length-1; i++) {
            for (int j = 0; j < data.length-1-i; j++) {
                if (data[j] > data[j+1]){
                    Integer tmp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tmp;
                }
            }
        }
        return data;
    }

    public Map<Integer, Integer> count(Integer[] data){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < data.length; i++) {
            Integer count = map.get(data[i]);
            if (count == null){
                map.put(data[i], 1);
            }else {
                map.put(data[i], count+1);
            }
        }
        return map;
    }

    public Map<Integer, Integer> count1(Integer[] data){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < data.length; i++) {
            Integer count = map.getOrDefault(data[i], 0);
            map.put(data[i],count+1 );
        }
        return map;
    }

    public static void main(String... args){
        ASort asort = new ASort();
        Integer[] data = {2,3,4,5,6,8};
        System.out.println(asort.biSearch(data, 8, 0, 6));
        Integer[] data1 = {3,2,1,9};
        asort.sort(data1);
        for (Integer i : data1){
            System.out.println(i);
        }

        Integer[] data2= {1000, 1,1,100,2,2,2};
        System.out.println(asort.count(data2));
        System.out.println(asort.count1(data2));
    }
}
