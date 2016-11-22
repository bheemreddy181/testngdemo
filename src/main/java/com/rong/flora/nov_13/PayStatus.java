package com.rong.flora.nov_13;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rongwf1 on 2016/11/13.
 */
public class PayStatus implements IPayStatus {
    private static final Logger logger = Logger.getLogger(PayStatus.class);

    @Override
    public void cancelTransaction(int id, int amount, String merchant){
        logger.debug("override id = " + id +" merchant = " + merchant + " amount = " + amount);

    }
    @Override
    public void printReceipt(String prodName, String merchant, int amount){
        logger.debug("override product = " + prodName +" merchant = " + merchant + " amount = " + amount);
    }
    public static void main(String... args){
        IPayStatus payStatus = new PayStatus();
        payStatus.cancelTransaction(1,2,"hi");
        payStatus.printReceipt("coffee", "hi", 10);
        payStatus = new IPayStatus() {
            @Override
            public void printReceipt(String prodName, String merchant, int amount) {
                logger.debug(" nimingleioverride product = " + prodName +" merchant = " + merchant + " amount = " + amount);
            }

            @Override
            public void cancelTransaction(int id, int amount, String merchant) {
                logger.debug("nimingleioverride id = " + id +" merchant = " + merchant + " amount = " + amount);
            }
        };
        payStatus.printReceipt("juice", "juicy", 100);
        payStatus.cancelTransaction(20, 10, "flag");

        Map<String, String> map = new HashMap<>();
        map.put("action", "delete");
        map.put("name", "blue");
        String ss = "hello";
        System.out.println(ss);
        System.out.println(map);
        System.out.println(new JSONObject(map));
        System.out.println(new JSONObject(map).toString());
        System.out.println(map.toString());

    }
}
