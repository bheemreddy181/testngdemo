package com.rong.flora.drink;

/**
 * Created by rongwf1 on 2016/7/3.
 */
public class Coffee {
    private String name;
    private Integer price;
    private Boolean iced;
    private Integer shots;

    public Coffee(String name, Integer price, Boolean iced, Integer shots) {
        this.name = name;
        this.price = price;
        this.iced = iced;
        this.shots = shots;
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

    public Integer getShots() {
        return shots;
    }

    public void setShots(Integer shots) {
        this.shots = shots;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", iced=" + iced +
                ", shots=" + shots +
                '}';
    }
}
