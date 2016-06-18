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
    private Integer asset;
    private Set<Coupon> coupons;
    private List<Product> products;
    private Integer point;
    private Set<User> friends;

    public User(String name, Integer age, String gender, Integer id, Integer asset ){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.id = id;
        this.asset = asset;
        this.point = 0;
        this.coupons = new HashSet<>();
        this.products = new LinkedList<>();
        this.friends = new HashSet<>();

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

    public List<Product> getProduct() {
        return products;
    }

    public void setProduct(List<Product> products) {
        this.products = products;
    }

    public Integer getAsset() {
        return asset;
    }

    public void setAsset(Integer asset) {
        this.asset = asset;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", id=" + id +
                ", asset=" + asset +
                ", coupons=" + coupons +
                ", products=" + products +
                ", point=" + point +
                ", friends=" + friends +
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

    public Set<Coupon> getCouponsForProduct(Product product, Integer num ){

        Integer totalPrice = product.getPrice()*num;

        if (Product.getRules().keySet().contains(product.getName()) &&
                Product.getRules().get(product.getName()) <= totalPrice){
            return validCouponList();
        }
        return new HashSet<>();
    }

    public Integer getPointForProduct(Product product, Integer num){
        return Point.checkIfProHasPoints(product)?
             Point.getPoints(product, num):0;

    }


    public Boolean buySuccess(Integer amount){
        return asset >= amount;
    }

    public Coupon selectMinCoupon(){
        Coupon minCoupon = (Coupon)validCouponList().toArray()[0];

        Iterator<Coupon> iterator = validCouponList().iterator();
        while (iterator.hasNext()){
            Coupon coupon1 = iterator.next();
            if(coupon1.compareTo(minCoupon) < 0){
                minCoupon = coupon1;
            }
        }
        return minCoupon;
    }

    public Set<Coupon> validCouponList(){

        Set<Coupon> validCouponList = new HashSet<>();
        Iterator<Coupon> it = coupons.iterator();
        while (it.hasNext()) {
            Coupon coupon = it.next();
            if(coupon.getExpireAt().after(new Date())){
                validCouponList.add(coupon);
            }
        }
        return validCouponList;
    }

    public Set<Coupon> invalidCouponList(){
        Set<Coupon> invalidCouponList = new HashSet<>();
        Iterator<Coupon> it = coupons.iterator();
        while(it.hasNext()){
            Coupon coupon = it.next();
            if(coupon.getExpireAt().before(new Date())){
                invalidCouponList.add(coupon);
            }
        }
        return invalidCouponList;
    }

    public Set<Coupon> getValidCouponList(){
       return validCouponList();

    }
    public Set<Coupon> getInvalidCouponList(){
        return invalidCouponList();
    }
    public Boolean buyProduct(Product product, final Integer num) {
        Boolean isSuccess = false;
        Integer pay = product.getPrice() * num;

        if (buySuccess(product.getPrice() * num)) {
            if (!getCouponsForProduct(product, num).isEmpty()){
                Coupon minCoupon = selectMinCoupon();
                pay -= minCoupon.getValue();
                coupons.remove(minCoupon);
            }
            products.add(product);
            point += getPointForProduct(product, num);
            asset -= pay;
            isSuccess = true;
        }
        return isSuccess;
    }

    public Set<User> addFriend(User user){
        friends.add(user);
        return friends;
    }

    public Boolean sendPointToFriend(User user, Integer points){

        if(friends.contains(user) && point >= points){
            point -= points;
            user.addPoint(points);
            PointTransInfo.addTransInfo(this, user, points);
            return true;

        }
        return false;
    }

    public Integer addPoint(Integer point){
        this.point += point;
        return point;

    }
}
