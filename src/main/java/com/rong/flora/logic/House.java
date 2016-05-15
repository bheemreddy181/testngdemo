package com.rong.flora.logic;

/**
 * Created by rongwf1 on 2016/5/15.
 */
public class House {
    private Integer location = 0;
    private  Integer price = 0;
    private Integer convenient = 0;
    private Integer decoration = 0;
    private  Integer houseTpye = 0;
    private  Integer traffic = 0;
    private Integer shouFu = 0;
    private Integer size = 0;
    private Integer id = 0;
    private Integer score = 0;
    private Integer square = 0;
    private Integer totalPrice = price * square;

    public Integer getTotalPrice() {
        totalPrice = price * square;
        return totalPrice;
    }

    public Integer getSquare() {
        return square;
    }

    public void setSquare(Integer square) {
        this.square = square;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getConvenient() {
        return convenient;
    }

    public void setConvenient(Integer convenient) {
        this.convenient = convenient;
    }

    public Integer getDecoration() {
        return decoration;
    }

    public void setDecoration(Integer decoration) {
        this.decoration = decoration;
    }

    public Integer getHouseTpye() {
        return houseTpye;
    }

    public void setHouseTpye(Integer houseTpye) {
        this.houseTpye = houseTpye;
    }

    public Integer getTraffic() {
        return traffic;
    }

    public void setTraffic(Integer traffic) {
        this.traffic = traffic;
    }

    public Integer getShouFu() {
        return shouFu;
    }

    public void setShouFu(Integer shouFu) {
        this.shouFu = shouFu;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "House{" +
                "location=" + location +
                ", price=" + price +
                ", convenient=" + convenient +
                ", decoration=" + decoration +
                ", houseTpye=" + houseTpye +
                ", traffic=" + traffic +
                ", shouFu=" + shouFu +
                ", size=" + size +
                ", id=" + id +
                ", score=" + score +
                ", square=" + square +
                ", totalPrice=" + getTotalPrice() +
                '}';
    }
}
