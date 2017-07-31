package com.rong.flora.june_04;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by rongwf1 on 2017/6/4.
 */
public class Min {
    public Map<String, Integer> cal(int[] args){
        Map<String, Integer> map = new HashMap<>();
        int max = args[0];
        int min = args[0];
        for (int i = 0; i < args.length; i++) {
            if (args[i] > max){
                max = args[i];
            }
            if (args[i] < min){
                min = args[i];
            }
        }
        map.put("max", max);
        map.put("min", min);
        System.out.println(map);
        return map;
    }

    public String[] reverse(String... args){
        Stack<String> stack = new Stack<>();
        String[] out = new String[args.length];
        for (String e : args){
            stack.push(e);
        }
        for (int i = 0; i < out.length; i++) {
            out[i] = stack.pop();
        }
        return out;
    }

    public Map<Integer, Integer> count(Integer... args){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < args.length; i++) {
            map.put(args[i], map.getOrDefault(args[i],0)+1);
        }
        return map;
    }

    public int[] count1(Integer... args){
        int[] array = new int[128];
        for (int e : args){
            array[e] += 1;
        }
        return array;
    }


    public static void main(String... args){
        int[] uu = {1,2,3,4};
        Min min = new Min();
        min.cal(uu);
        for (String e: min.reverse("a", "b", "o")){
            System.out.println(e);
        }
        System.out.println(min.count(1,2,3,4,2,1,1));
        int[] countArray = min.count1(1,2,3,4,2,1,1);
        for (int i = 0; i < countArray.length; i++) {
            if (countArray[i] != 0) {
                System.out.printf("%d: %d\n", i, countArray[i]);
            }
        }
    }
}
