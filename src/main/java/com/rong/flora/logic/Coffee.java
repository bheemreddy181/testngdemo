package com.rong.flora.logic;

/**
 * Created by rongwf1 on 2016/5/2.
 */
public class Coffee {
    private CoffeeConfig coffeeConfig;

    private Integer price;

    public Coffee(CoffeeConfig coffeeConfig, Integer price){
        this.coffeeConfig = coffeeConfig;
        this.price = price;
    }


    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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
                ", price=" + price +
                '}';
    }
}
