package com.rong.test.logic;

/**
 * Created by rongwf1 on 2016/5/2.
 */
public class CoffeeConfig {
    private String name;
    private int shots;
    private  int syrup;
    private int count;

    public CoffeeConfig(String name, int shots, int syrup, int count){
        this.name = name;
        this.shots = shots;
        this.syrup = syrup;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getShots() {
        return shots;
    }

    public void setShots(int shots) {
        this.shots = shots;
    }

    public int getSyrup() {
        return syrup;
    }

    public void setSyrup(int syrup) {
        this.syrup = syrup;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "CoffeeConfig{" +
                "name='" + name + '\'' +
                ", shots=" + shots +
                ", syrup=" + syrup +
                ", count=" + count +
                '}';
    }
}
