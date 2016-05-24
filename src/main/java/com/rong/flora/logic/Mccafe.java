package com.rong.flora.logic;

import com.rong.flora.friday.GreenTea;

import java.util.Random;

/**
 * Created by lafengnan on 16/5/23.
 */
public class Mccafe {

    private String name ;
    private static Integer price;
    static {
        price = 10;
        System.out.println("we");
    }
    //public Mccafe(){System.out.println("mccafe is great");}

    public Mccafe(String name){System.out.println("Mccafe is lost");}

    public Object getTeaOrCoffee(Double teaRatio){

        if (teaRatio > 1){
            System.out.println(" the value should be less than 1");
            return null;
        }
        Coffee coffee = new Coffee();
        GreenTea greenTea = new GreenTea();
        Random random = new Random();
        Integer a = random.nextInt(100);

        if (a < 100 * teaRatio) {
            return greenTea;
        } else {
            return coffee;
        }
    }

    public static void main(String[] args){
        Mccafe mccafe = new Mccafe("ikea");
        for(int i = 0; i < 10; i++){
            System.out.println(mccafe.getTeaOrCoffee(1.0));
        }
    }
}
