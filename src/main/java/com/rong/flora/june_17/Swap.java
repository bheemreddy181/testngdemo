package com.rong.flora.june_17;

/**
 * Created by rongwf1 on 2017/6/20.
 */
public class Swap {

    public void sswap(int a, int b){
        int tmp = a;
        a = b;
        b = tmp;
        System.out.println("a: " + a +", b: "+ b);
    }

    public static void main(String... args){
        Swap swap = new Swap();
        swap.sswap(1,2);
        Integer[] myList = new Integer[3];
        String[] names = new String[10];
        System.out.println(myList.length);
        System.out.println(names.length);
        for (int i = 0; i < myList.length; i++) {
            System.out.println(myList[i]);
        }
//        for (int i: myList){
//            System.out.println(i);
//        }
//        for(String s: names){
//            System.out.println(s);
//        }
    }
}
