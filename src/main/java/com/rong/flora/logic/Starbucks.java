package com.rong.flora.logic;

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
            coffeeList.addAll(makeCoffee(coffeeConfig, num));

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

        List<Coffee> coffeeList = new LinkedList<>();

        List<CoffeeConfig> coffeeConfigs = new LinkedList<CoffeeConfig>();
        coffeeConfigs.add(new CoffeeConfig("latte", 1, 1));
        coffeeConfigs.add(new CoffeeConfig("mocha", 2, 2));
        for (CoffeeConfig coffeeConfig: coffeeConfigs){

            coffeeList.addAll(starbucks.buyCoffeeWithCount(coffeeConfig, 10));
        }
        System.out.println(starbucks.getCount());
        System.out.println(starbucks.getIncome());
        for (int i= 0; i<coffeeList.size(); i++){
            System.out.println("idx:" + i + "\n"+"syrup:" + coffeeList.get(i).getCoffeeConfig().getSyrup()+"\n"+
            "shots:"+coffeeList.get(i).getCoffeeConfig().getShots() +"\n"+"price:" + coffeeList.get(i).getPrice()+"\n" +
            "name:" + coffeeList.get(i).getCoffeeConfig().getName());
        }
    }
}
