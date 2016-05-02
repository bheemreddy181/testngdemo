package com.rong.test.logic;

/**
 * Created by rongwf1 on 2016/4/17.
 */

public class HelloWorld {
    private String message;

    public HelloWorld(String meg){
        this.message = meg;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer oper(Integer a, Integer b){
        return a + b;
    }
}
