package com.rong.test.logic;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by rongwf1 on 2016/5/2.
 */
public class Starbucks {

    private int count = 0;
    private Integer income = 0;
    private static Map<String, Integer> priceTable = new HashMap<>();
    static {
        priceTable.put("latte", 30);
        priceTable.put("mocha", 33);
    }

    public int getCount() {
        return count;
    }

    public Integer getIncome() {
        return income;
    }

    public List<Coffee> buyCoffeeWithCount(CoffeeConfig coffeeConfig, Integer num) {
        List<Coffee> coffeeList = new LinkedList<>();
        for (int i =0;i< num; i++){
            coffeeList.addAll(makeCoffee(coffeeConfig, num));

        }
        count += num;
        income += priceTable.get(coffeeConfig.getName())*num;
        return coffeeList;
    }


    public List<Coffee> makeCoffee(CoffeeConfig coffeeConfig, Integer num){
        List<Coffee> coffeeList = new LinkedList<Coffee>();

        for( int i = 0; i < num; i++){
            Coffee coffee = new Coffee(coffeeConfig, priceTable.get(coffeeConfig.getName()));
            coffeeList.add(coffee);
        }
        return coffeeList;
    }

    public static void main(String[] args){
        Starbucks starbucks = new Starbucks();

        Starbucks starbucks1;

        List<CoffeeConfig> coffeeConfigs = new LinkedList<CoffeeConfig>();
        coffeeConfigs.add(new CoffeeConfig("latte", 1, 1));
        coffeeConfigs.add(new CoffeeConfig("mocha", 2, 2));
        for (CoffeeConfig coffeeConfig: coffeeConfigs){

            List<Coffee> uu = starbucks.buyCoffeeWithCount(coffeeConfig, 10);
        }

        System.out.println(starbucks.getCount());
        System.out.println(starbucks.getIncome());
    }
}
