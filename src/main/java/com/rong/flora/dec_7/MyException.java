package com.rong.flora.dec_7;

/**
 * Created by rongwf1 on 2016/12/10.
 */
public class MyException extends RuntimeException {

    public MyException(String message){
        super(message);
    }

    public MyException(String message, Throwable cause){
        super(message, cause);
    }

}
