package com.rong.flora.logic;

import com.rong.flora.friday.GreenTea;

import java.util.Random;

/**
 * Created by lafengnan on 16/5/23.
 */
public class Mccafe {

    GreenTea greenTea = new GreenTea();
    Coffee coffee = new Coffee();

    public Object getTeaOrCoffee(){

        Random random = new Random();
        Integer a = random.nextInt(100);
        if(a < 50){
            return greenTea;
        } else{
            return coffee;
        }


    }

    public static void main(String[] args){
        Mccafe mccafe = new Mccafe();
        for(int i = 0; i < 10; i++){
        System.out.println(mccafe.getTeaOrCoffee());
        }
    }
}
