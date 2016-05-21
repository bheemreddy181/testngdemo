package com.rong.flora.friday;

/**
 * Created by rongwf1 on 2016/5/21.
 */
public class Server implements Power {
    public Integer machineType;
    protected String brand;
    private Integer price;
    static Integer sales ;
    static {
        sales = 0;
        System.out.println("1990");
    }

    public Server(){
        Server.sales++;
        System.out.println("1991");
    }

    public Server(Integer machineType, String brand, Integer price) {
        this.machineType = machineType;
        this.brand = brand;
        this.price = price;
        Server.sales++;
    }


    public Integer totalPrice(){
        return sales*price;
    }
    public Integer getMachineType() {
        return machineType;
    }

    public void setMachineType(Integer machineType) {
        this.machineType = machineType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public static Integer getSales() {
        return sales;
    }

    public static void setSales(Integer sales) {
        Server.sales = sales;
    }

    public Boolean isOn(){
        System.out.println("power is on");
        return true;
    }

    public Boolean isOff(){
        System.out.println("power is off");
        return false;
    }

    public Boolean powerOn(){
        return true;
    }

    public Boolean powerOff(){
        return false;
    }
}


