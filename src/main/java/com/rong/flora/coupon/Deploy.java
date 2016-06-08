package com.rong.flora.coupon;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by lafengnan on 16/6/7.
 */
public class Deploy {

    public void deployCoupon(User user, Integer count, Coupon coupon){

        try{

            user.addCoupon(coupon);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }

    public void deployCouponList(User user, List<Coupon> couponList){

        try{

            user.addCouponList(couponList);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args){
        User user = new User("lee", 20, "male",1);
        try{
            user.addCouponList(Coupon.makeCoupon(10, 1, 100));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        System.out.println(user);
    }
}
