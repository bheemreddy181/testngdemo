package com.rong.flora.july_29;

import java.util.HashMap;
import java.util.Map;

public class Search {

    public Integer biiSearch(Integer[] data, Integer begin, Integer end, Integer pattern){
        if (begin <= end){
            Integer mid = (end+begin)/2;
            if (pattern < data[mid]){
                return biiSearch(data, begin, (end+begin)/2-1,pattern );
            }else if (pattern > data[mid]){
                return biiSearch(data, (end+begin)/2 +1 , end, pattern);
            }else {
                return pattern;
            }
        }
        else {
            return null;
        }
    }

    public Integer biSearch(Integer[] data, Integer pattern){
        Integer mid = data.length/2;
        Integer begin = 0;
        Integer end = data.length;
        Integer rc = null;
        for (int i = begin; i < end; i++) {
            if (data[mid].equals(pattern)){
                rc = pattern;
                break;
            }else if (pattern < data[mid]){
                end = mid - 1;
            } else {
                begin = mid + 1;
                i = begin;
            }
            mid = (end + begin) >> 1;
        }
        return rc;
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
            map.put(data[i], count+1);
        }
        return map;
    }

    public static void main(String...args){
        Search search = new Search();
        Integer[] arg = {1,2,3,4,5};
        System.out.println(search.biiSearch(arg,0, 4, 5));
        System.out.println(search.biSearch(arg, 5));
        Integer[] data = {100, 1, 100, 2, 1000, 5,5,5};
        System.out.println(search.count(data));
        System.out.println(search.count1(data));
    }
}
