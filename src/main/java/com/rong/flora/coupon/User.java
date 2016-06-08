package com.rong.flora.coupon;

import java.util.*;

/**
 * Created by lafengnan on 16/6/7.
 */
public class User {
    private String name;
    private Integer age;
    private String gender;
    private Integer id;
    private Set<Coupon> coupons;

    public User(String name, Integer age, String gender, Integer id){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.id = id;
        this.coupons = new HashSet<>();

    }
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public Set<Coupon> getCoupon() {
        return coupons;
    }

    public void setCoupon(Set<Coupon> coupon) {
        this.coupons = coupon;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", id=" + id +
                ", coupons=" + coupons +
                '}';
    }

    public Set<Coupon> addCoupon(Coupon coupon)throws Exception{
        if(coupon ==null){
            throw new Exception("invalid coupon");
        }
        coupons.add(coupon);
        return coupons;
    }

    public Set<Coupon> addCouponList(List<Coupon> couponList)throws Exception{
        if (couponList == null){
            throw new Exception("invalid couponList");
        }
        coupons.addAll(couponList);
        return coupons;
    }
}
