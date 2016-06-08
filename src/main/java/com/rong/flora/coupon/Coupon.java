package com.rong.flora.coupon;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by lafengnan on 16/6/7.
 */
public class Coupon {
    private String id;
    private Integer validTimes;
    private Integer value;

    public Coupon(Integer validTimes, Integer value){
        this.id = RandomStringUtils.randomAlphanumeric(20);
        this.validTimes = validTimes;
        this.value =value;
    }

    public Integer getValidTimes() {
        return validTimes;
    }

    public String getId() {
        return id;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "id='" + id + '\'' +
                ", validTimes=" + validTimes +
                ", value=" + value +
                '}';
    }

    public static List<Coupon> makeCoupon(Integer count, Integer validTimes,Integer value){

        List<Coupon> couponList = new LinkedList<>();
        for (int i =0 ; i < count; i++){
            Coupon coupon = new Coupon(validTimes,value);
            couponList.add(coupon);
        }

        return couponList;
    }
}
