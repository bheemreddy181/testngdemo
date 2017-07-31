package com.rong.flora.june_03;

/**
 * Created by rongwf1 on 2017/6/3.
 */
public class SeesawException extends Exception {
    public SeesawException(String message){
        super(message);
    }

    public SeesawException(String message, Throwable throwable){
        super(message, throwable);
    }

    public static void main(String... args) throws SeesawException {
        boolean i = true;
        if (i){
            throw new SeesawException("seesaw");
        }
    }
}
