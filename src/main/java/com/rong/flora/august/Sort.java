package com.rong.flora.august;

import java.util.HashMap;
import java.util.Map;

public class Sort {

    public Map<Integer, Integer> count(Integer[] data) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < data.length; i++) {
            Integer count = map.getOrDefault(data[i], 0);
            map.put(data[i], count + 1);
        }
        return map;
    }

    public Map<Integer, Integer> count1(Integer[] data) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < data.length; i++) {
            Integer count = map.get(data[i]);
            if (count == null) {
                map.put(data[i], 1);
            } else {
                map.put(data[i], count + 1);
            }
        }
        return map;
    }

    public Integer[] asort(Integer[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j] > data[j + 1]) {
                    Integer tmp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = tmp;
                }
            }
        }
        return data;
    }

    public Integer biSearch(Integer[] data, Integer pattern, Integer begin, Integer end) {
            Integer mid = begin + (end - begin) / 2;
            if (pattern.equals(data[mid])) {
                return pattern;
            } else if (pattern < data[mid]) {
                return biSearch(data, pattern, begin, mid - 1);
            } else {
                return biSearch(data, pattern, mid + 1, end);
            }
    }

    public static void main(String... args){
        Sort sort = new Sort();
//        Integer[] data = {1,2,2,3,3,3,4};
//        System.out.println(sort.count(data));
//        System.out.println(sort.count1(data));
//        Integer[] data1 = {8,3,7,6,5,4,1};
//        sort.asort(data1);
//        for (Integer a : data1){
//            System.out.print(a);
//        }
        Integer[] data2 = {1,3,5,7,9};
        System.out.println(sort.biSearch(data2, 9, 0, 4));
    }
}
