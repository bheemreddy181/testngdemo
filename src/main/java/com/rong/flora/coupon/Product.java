package com.rong.flora.coupon;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rongwf1 on 2016/6/11.
 */
public class Product {
    private String name;
    private Integer price;
    private static Map<String,Integer> rules;
    private static Map<Integer,Integer> rule2;

    static {
        rules = new HashMap<>();
        rules.put("Coffee", 100);
        rule2 = new HashMap<>();
        rule2.put(10, 10);
    }

    public Product(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public static Map<String, Integer> getRules() {
        return rules;
    }

    public static void setRules(Map<String, Integer> rules) {
        Product.rules = rules;
    }

    public static Map<Integer, Integer> getRule2() {
        return rule2;
    }

    public static void setRule2(Map<Integer, Integer> rule2) {
        Product.rule2 = rule2;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
