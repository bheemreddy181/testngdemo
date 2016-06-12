package com.rong.flora.coupon;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by rongwf1 on 2016/6/12.
 */
public class Point {
    private Product product;
    private Integer minPrice;
    private Integer maxPrice;
    private static Set<Product> rules;


    static {
        rules = new HashSet<>();

    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }

    public Integer getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Integer maxPrice) {
        this.maxPrice = maxPrice;
    }

    public static Set<Product> getRules() {
        return rules;
    }

    public static void setRules(Set<Product> rules) {
        Point.rules = rules;
    }

    public static Boolean checkIfProHasPoints(Product product){
        Boolean hasPoints = false;
        if(rules.contains(product)){
            hasPoints = true;
        }
        return hasPoints;
    }

    public static Integer getPoints(Product product, Integer num){
        Integer points = 0;
        Integer totalPrice = product.getPrice()*num;

        if(totalPrice < 100){
            return points;
        }
        if(100  <= totalPrice && totalPrice < 500){

            points = (totalPrice/100)*10;
        }
        if( totalPrice >= 500){
            points =100+((totalPrice-500)/100)*20;
        }
        return points;
    }


    public static Set<Product> addProToRule(Product product){
        rules.add(product);
        return rules;
    }



}
