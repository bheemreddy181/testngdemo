package com.rong.flora.june_03;

import sun.rmi.runtime.Log;

import java.lang.reflect.Method;

/**
 * Created by rongwf1 on 2017/6/3.
 */
public class Seesaw {
    private String name;
    private int num;

    private void logger(String message){
        System.out.println(message);
    }

    @Logger(toUse = false)
    public void makeCoffee(String coffeName, Integer num){
        this.name = coffeName;
        this.num = num;
    }

    @Logger
    public void drinkCoffee(){
        this.name = "";
        this.num = 0;
    }

    public static void call(Seesaw inst, String methodName, Object... args) {
        Method[] methods = inst.getClass().getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].getName().equals(methodName) &&
                    methods[i].isAnnotationPresent(Logger.class)) {
                Logger logger = methods[i].getAnnotation(Logger.class);
                if (logger.toUse()) {
                    String msg = "";
                    for (Object arg : args) {
                        msg += arg.toString() + ", ";
                    }
                    inst.logger("Method: " + methodName + " is invoking with args: " + msg);
                    try {
                        methods[i].invoke(inst, args);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String... args){
        Seesaw seesaw = new Seesaw();
        Seesaw.call(seesaw, "makeCoffee", "mocha", 1);
        Seesaw.call(seesaw, "drinkCoffee");
    }
}
