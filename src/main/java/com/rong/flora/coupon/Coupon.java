package com.rong.flora.coupon;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.*;

/**
 * Created by lafengnan on 16/6/7.
 */
public class Coupon implements Comparable<Coupon>{
    private String id;
    private Integer validTimes;
    private Integer value;
    private Date expireAt;

    public Coupon(Integer validTimes, Integer value, Date expireAt){
        this.id = RandomStringUtils.randomAlphanumeric(20);
        this.validTimes = validTimes;
        this.value =value;
        this.expireAt = expireAt;
    }

    public int compareTo(Coupon other){
        return this.value - other.value;

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

    public Date getExpireAt() {
        return expireAt;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "id='" + id + '\'' +
                ", validTimes=" + validTimes +
                ", value=" + value +
                ", expireAt=" + expireAt +
                '}';
    }

    public static List<Coupon> makeCoupon(Integer count, Integer validTimes, Integer value, Date expireAt){

        List<Coupon> couponList = new LinkedList<>();
        for (int i =0 ; i < count; i++){
            Coupon coupon = new Coupon(validTimes,value, expireAt);
            couponList.add(coupon);
        }

        return couponList;
    }

}
