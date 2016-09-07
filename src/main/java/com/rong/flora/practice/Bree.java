package com.rong.flora.practice;

import java.util.*;

/**
 * Created by rongwf1 on 16/9/6.
 */
public class Bree {

    public Map<String, List<Integer>> finding(String data){
        Map<String, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < data.length(); i ++){
           if(!map.containsKey(String.valueOf(data.charAt(i)))) {
               map.put(String.valueOf(data.charAt(i)), new LinkedList<>());
               map.get(String.valueOf(data.charAt(i))).add(1);
           } else {
               Integer cnt = map.get(String.valueOf(data.charAt(i))).get(0)+1;
               map.get(String.valueOf(data.charAt(i))).set(0, cnt);

           }
            map.get(String.valueOf(data.charAt(i))).add(i);
//           map.put(String.valueOf(data.charAt(i)), map.getOrDefault(String.valueOf(data.charAt(i)), 0)+1);
        }
//        for(char c :data.toCharArray()){
//            map.put(String.valueOf(c), map.getOrDefault(String.valueOf(c), 0)+1);
//        }
        return map;
    }

    /**
     *
     * @param mmap
     * @param edge
     * @return
     */
    public Map<String, Integer> show(final Map<String, Integer> mmap, Integer edge){
        Map<String, Integer> copy = new HashMap<>(mmap);
        mmap.forEach((k,v)->{
            if(v <= edge){
                copy.remove(k);
            }
        });
        return copy;
    }

    public Map<String, List<Integer>> show1(Map<String, List<Integer>> mmap, Integer edge){
        Map<String, List<Integer>> copy = new HashMap<>(mmap);
        mmap.forEach((k, v)->{
            if(v.get(0) <= edge){
                copy.remove(k);
            }
        });
        return copy;
    }

    public String reverse(String data){
        String result = "";
        for(int i = data.length()-1; i >= 0;i--){
            result += data.charAt(i);
        }
        return  result;
    }

    public static void main(String[] args){
        Bree bree = new Bree();
//        System.out.println(bree.show1(bree.finding("aaabbbbccd"),1)
        System.out.println(bree.reverse("abcdef"));

    }
}
