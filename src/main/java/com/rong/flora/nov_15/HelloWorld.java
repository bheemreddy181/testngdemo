package com.rong.flora.nov_15;

/**
 * Created by lafengnan on 2016/11/15.
 */
public class HelloWorld {
    static {
        System.loadLibrary("HelloWorld");
    }

    public static native void hello();

    @SuppressWarnings("static-access")
    public static void main(String... args) {
        new HelloWorld().hello();
    }
}
