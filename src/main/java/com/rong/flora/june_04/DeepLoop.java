package com.rong.flora.june_04;

/**
 * Created by rongwf1 on 2017/6/4.
 */
public class DeepLoop {
    public static void main(String... args) {
        System.out.println("main");
        start(args);
    }

    public static void start(String... args) {
        System.out.println("start");
        begin(args);
    }

    public static void begin(String... args) {
        System.out.println("begin");
        main(args);
    }
}
