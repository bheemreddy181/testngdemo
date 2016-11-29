package com.rong.flora.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rongwf1 on 2016/11/29.
 */
public class Green {
    private static int i=0;
    public int dot(int foo){
        if (foo == 0) return 0-foo;
        else if (foo < 0) return dot(foo+1)-2;
        else return dot(foo-1)+2;

    }

    public void com(int[] data){

        int min = data[0];
        int max = data[0];
        for (int i =1; i < data.length; i++){
            min = data[i] < min ? data[i] : min;
            max = data[i] > max ? data[i] : max;
//            if (data[i] < min){
//                min = data[i];
//            }
//            if (data[i] > max){
//                max = data[i];
//            }
        }
        System.out.println(min);
        System.out.println(max);
    }

    public void count(int[] data){
        Map<Integer, Integer> map = new HashMap<>();
        for (int d : data)  map.put(d, map.getOrDefault(d, 0) + 1);
        System.out.println(map);
    }

    public static void main(String... args){
        Green green = new Green();
        int[] data = {1,2,3,4,5,6,7,8};
        int[] data1 = {2,3,4,5,8,7,8};
        green.com(data);
        green.count(data1);
        System.out.println(green.dot(7000));
    }

//    public static void begin(String... args){
//        System.out.println("begin, i= " +i++);
//        main(args);
//    }
//    public static void main(String... args){
//        System.out.println("main , i= "+ i++);
//        start(args);
//    }
//    public static void start(String... args){
//        System.out.println("start, i= " +i++);
//        begin("start");
//
//    }

}
