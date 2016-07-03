package com.rong.flora.drink;


import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * Created by rongwf1 on 2016/7/3.
 */
public class DrinkMachine {
    private Integer capacity;
    private Integer remains;
    private Integer money;
    private Boolean isNormal;
    private static Map<String, Class> map;
    private static final Logger logger = Logger.getLogger(DrinkMachine.class);

    static {
        map = new HashMap<>();
        map.put("huiyuan", Juice.class);
        map.put("quechao", Coffee.class);
        map.put("pepsi", Coke.class);

    }

    public DrinkMachine(Integer money, Integer capacity) {
        this.money = money;
        this.isNormal = true;
        this.capacity = capacity;
        this.remains = capacity;
    }

    public Map addDrink(Integer num){
        Map<String, Object> ret = new HashMap<>();
        Integer cost = capacity - remains;
        if (isNormal){
            if(this.remains < this.capacity){
                if(num > cost){
                    ret.put("remain", capacity);
                    ret.put("reason", "ok");
                }else {
                    ret.put("remain", num+ remains);
                    ret.put("reason", " not full. ok");

                }
            }else {
                ret.put("remain", capacity);
                ret.put("reason", "this machine is full");
            }
        } else {
            logger.info("this machine is broken");
            ret.put("reason", "this machine is broken");
            ret.put("remain", remains);
        }
        return ret;
    }

    public Map buyDrink(Integer num, String name,Integer money, Map<String, Object> args){

        Map<String, Object> ret = new HashMap<>();
        List list = new LinkedList<>();
        Integer remain  = -1;

        if (args.get("price") == null) {
            logger.debug("price is not passed in");
            ret.put("remain", money);
            ret.put("drinks", list);
            return ret;
        } else {
            remain = money - num*(Integer)args.get("price");
            ret.put("remain", remain >= 0 ? remain: money);
        }

        for (int i = 0; i < num && remain >= 0; i++) {
            this.remains--;
            Class clz = map.get(name);
            if (clz.equals(Coffee.class)) {
                Coffee coffee = new Coffee("quechao", 30, true, (Integer)args.getOrDefault("shots", 1));
                list.add(coffee);

            } else if (clz.equals(Juice.class)) {
                Juice juice = new Juice("huiyuan", 10, true);
                list.add(juice);

            } else if (clz.equals(Coke.class)) {
                Coke coke = new Coke("pepsi", 5, true);
                list.add(coke);
            } else {
                logger.info("We do not server this kind of drink");
            }

        }
        ret.put("drinks", list);
        return ret;
    }

    public static void main(String[] args){
        DrinkMachine drinkMachine = new DrinkMachine(10, 10);
        Map<String, Object> arg = new HashMap<>();
        arg.put("shots", 10);
        arg.put("price", 2);
        logger.info(drinkMachine.buyDrink(2,"quechao", 20, arg));
        logger.info(drinkMachine.addDrink(1));
    }
}
