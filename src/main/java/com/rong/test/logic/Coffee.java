package com.rong.test.logic;

import com.sun.org.apache.bcel.internal.generic.FLOAD;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rongwf1 on 2016/5/2.
 */
public class Coffee {
    private CoffeeConfig coffeeConfig;

    private static Map<String, BigDecimal> price = new HashMap<String, BigDecimal>();
    static {
        price.put("latte", BigDecimal.valueOf(1.23));
        price.put("mocha", BigDecimal.valueOf(2.13));
    }

    public Coffee(CoffeeConfig coffeeConfig){
        this.coffeeConfig = coffeeConfig;

    }

//    public String toString (){
//        return name +  " has " + shots + " and " + syrup;
//    }


    public static Map<String, BigDecimal> getPrice() {
        return price;
    }

    public CoffeeConfig getCoffeeConfig() {
        return coffeeConfig;
    }

    public void setCoffeeConfig(CoffeeConfig coffeeConfig) {
        this.coffeeConfig = coffeeConfig;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "coffeeConfig=" + coffeeConfig +
                '}';
    }
}
