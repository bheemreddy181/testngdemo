package com.rong.flora.coupon;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by rongwf1 on 2016/6/12.
 */
public class Point {
    private Product product;
    private static Integer minPrice;
    private static Integer maxPrice;
    private static Integer priceStep;
    private static Integer pointStep;
    private static Set<Product> rules;



    static {
        rules = new HashSet<>();
        minPrice = 100;
        maxPrice = 500;
        pointStep = 5;
        priceStep = 100;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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

        if(totalPrice < minPrice){
            return points;
        }
        if(minPrice  <= totalPrice && totalPrice < maxPrice){

            points = (totalPrice/priceStep)*pointStep;
        }
        if( totalPrice >= maxPrice){
            points = minPrice + ((totalPrice - maxPrice)/priceStep)*2*pointStep;
        }
        return points;
    }


    public static Set<Product> addProToRule(Product product){
        rules.add(product);
        return rules;
    }



}
