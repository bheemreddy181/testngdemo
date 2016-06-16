package com.rong.flora.coupon;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
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
        Point p = new Point();
        System.out.println(p);
//        User user = new User("lee", 20, "male",1,1000);
//        try{
//            user.addCouponList(Coupon.makeCoupon(1, 1, 100, DateUtil.getDateFromString("2016-06-30", "yyyy-MM-dd")));
//            user.addCouponList(Coupon.makeCoupon(1, 1, 20, DateUtil.getDateFromString("2016-06-01", "yyyy-MM-dd")));
//            //Set<Coupon> couponSet= user.getCouponsForProduct(new Product("Coffee", 18), 10);
////            System.out.println(user.getCoupon());
////            System.out.println(user.getAsset());
////            System.out.println(user.getProduct());
//            User jerry = new User("jerry", 30,"male",123,100);
//            user.addFriend(jerry);
////            System.out.println(user);
//
//            User jack = new User("jack", 20,"male",456,200);
//            user.addFriend(jack);
////            System.out.println(user);
//            System.out.println(PointTransInfo.getPointTransInfos());
//            Product product = new Product("Coffee", 15);
//            Point.addProToRule(product);
//            Boolean it = user.buyProduct(product,10);
//
//            user.sendPointToFriend(jack, 5);
//            System.out.println(PointTransInfo.getPointTransInfos());
//
////            System.out.println(user.getProduct());
////            System.out.println(user.getAsset());
////            System.out.println(user.getCoupon());
//        }catch (Exception e){
//            e.printStackTrace();
//            System.out.println(e.getMessage());
//        }
//
////        System.out.println(user);
    }
}
