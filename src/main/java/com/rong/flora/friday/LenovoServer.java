package com.rong.flora.friday;

/**
 * Created by rongwf1 on 2016/5/21.
 */
public class LenovoServer extends Server implements NetworkInterface{
    private Integer uuid;

    public LenovoServer(Integer uuid) {
        super();
        this.uuid = uuid;
    }

    public LenovoServer(Integer machineType, String brand, Integer price, Integer uuid) {
        super(machineType, brand, price);
        this.uuid = uuid;
    }

    @Override
    public Integer totalPrice(){
        return 100;
    }

    @Override
    public String ping(){
        System.out.println("ping");
        return "ping ok";
    }

    @Override
    public String netStat(){
        System.out.println("netstat");
        return "netstat ok";
    }

}
