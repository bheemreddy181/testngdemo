package com.rong.flora.coupon;

/**
 * Created by lafengnan on 16/6/7.
 */
public class Coupon {
    private Integer id;
    private Integer count;
    private Integer value;

    public Coupon(Integer id, Integer count, Integer value){
        this.id = id;
        this.count = count;
        this.value =value;
    }

    public Integer getCount() {
        return count;
    }

    public Integer getId() {
        return id;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "count=" + count +
                ", id=" + id +
                ", value=" + value +
                '}';
    }
}
