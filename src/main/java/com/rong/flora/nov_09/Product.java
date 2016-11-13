package com.rong.flora.nov_09;

/**
 * Created by lafengnan on 2016/11/10.
 */
public enum Product {
    CLOTHING(100, "clothing"),
    FOOD(10, "kfc"),
    BOOK(20, "friday"),
    DRINK(30, "starbucks"),
    CELLPHONE(1000, "apple"),
    LAPTOP(5000, "MAC");

    private Integer amount;
    private String desc;
    private Product(Integer amount, String desc){
        this.amount = amount;
        this.desc = desc;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
