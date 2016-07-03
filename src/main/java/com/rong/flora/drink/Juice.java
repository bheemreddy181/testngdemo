package com.rong.flora.drink;

/**
 * Created by rongwf1 on 2016/7/3.
 */
public class Juice {
    private String name;
    private Integer price;
    private Boolean iced;

    public Juice(String name, Integer price, Boolean iced) {
        this.name = name;
        this.price = price;
        this.iced = iced;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Boolean getIced() {
        return iced;
    }

    public void setIced(Boolean iced) {
        this.iced = iced;
    }
}
