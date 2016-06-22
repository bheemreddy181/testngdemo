package com.rong.flora.practice;

/**
 * Created by lafengnan on 16/6/22.
 */
public class Rose {
    private String color;

    public Rose(String color){
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Rose{" +
                "color='" + color + '\'' +
                '}';
    }
}
