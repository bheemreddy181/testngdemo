package com.rong.flora.coupon;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lafengnan on 16/6/7.
 */
public class User {
    private String name;
    private Integer age;
    private String gender;
    private Integer id;
    private List<Coupon> coupons;

    public User(String name, Integer age, String gender, Integer id){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.id = id;
        this.coupons = new LinkedList<>();

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

    public List<Coupon> getCoupon() {
        return coupons;
    }

    public void setCoupon(List<Coupon> coupon) {
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

    public List<Coupon> addCoupon(Coupon coupon)throws Exception{
        if(coupon ==null){
            throw new Exception("invalid coupon");
        }

        Boolean isExists = false;

        for (int i = 0; i < coupons.size(); i++) {
            if (coupons.get(i).getId().equals(coupon.getId())) {
                isExists = true;
                break;
            }
        }

        if (!isExists){
            coupons.add(coupon);
        }

        return coupons;
    }
}
