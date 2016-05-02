package com.rong.test.logic;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by rongwf1 on 2016/5/2.
 */
public class Starbucks {

    private int count = 0;
    private BigDecimal income = BigDecimal.ZERO;
    public BigDecimal getIncome() {

        return income;
    }

    public int getCount() {
        return count;
    }

//    public List<Coffee> buyCoffee(int shots, int syrup , String name, int count){
//        List<Coffee> coffeeList = new LinkedList<Coffee>();
//        this.count += count;
//        income = income.add(Coffee.getPrice().get(name).multiply(BigDecimal.valueOf(count)));
//        for (int i=0 ;i < count ; i++ ){
//           coffeeList.add(new Coffee(shots, syrup,name));
//        }
//return coffeeList;
//
//    }

    public List<Coffee> buyCoffee(List<CoffeeConfig> coffeeConfigs){
        List<Coffee> coffeeList = new LinkedList<Coffee>();
        for(int i =0 ; i< coffeeConfigs.size(); i++){
            coffeeList.addAll(makeCoffee(coffeeConfigs.get(i)));
            count += coffeeConfigs.get(i).getCount();
            income = income.add(Coffee.getPrice().get(coffeeConfigs.get(i).getName()).multiply(BigDecimal.valueOf(coffeeConfigs.get(i).getCount())));
        }
           return coffeeList;
    }

    public List<Coffee> makeCoffee(CoffeeConfig coffeeConfig){
        List<Coffee> coffeeList = new LinkedList<Coffee>();
        for( int i = 0; i < coffeeConfig.getCount(); i++){
            coffeeList.add(new Coffee (coffeeConfig) );
        }
        return coffeeList;
    }

    public static void main(String[] args){
        Starbucks starbucks = new Starbucks();
     List<CoffeeConfig> coffeeConfigs = new LinkedList<CoffeeConfig>();
        coffeeConfigs.add(new CoffeeConfig("latte", 1, 1,3));
        coffeeConfigs.add(new CoffeeConfig("mocha", 2, 2,4));
        List<Coffee> uu = starbucks.buyCoffee(coffeeConfigs);

      for (int i= 0; i< uu.size(); i++) {
          System.out.println(uu.get(i));
      }
        System.out.println(starbucks.getCount());
        System.out.println(starbucks.getIncome());
    }
}
