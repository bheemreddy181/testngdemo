package com.rong.flora.Dec_7;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.time.Instant;
import java.util.Arrays;

/**
 * Created by rong on 2016/12/7.
 */
public class Loop {
    private  static  final Logger logger =  Logger.getLogger(Loop.class);
    private Integer[] data = new Integer[1<<13];
    // 1<<13 = 2^13
    private String[] data1 = new String[1<<5];

    public Loop() {
        for (int i = 0; i < data.length; i++) data[i] = i;
        for (int i = 0; i < data1.length; i++) data1[i] = RandomStringUtils.randomAlphabetic(i);
    }
    public void print(int index, int type){
        long begin = Instant.now().toEpochMilli();
        if (index > data.length){
            logger.debug("invalid length");
            return;
        }
        switch (type){
            case 1:
                for (int i = 0; i < index; i++){
                    logger.debug("data is: " + data[i]);
                }
                break;
            case 2:
                for (Integer i : data){
                    logger.debug("data is: " + i);
                }
                break;
        }
        long end = Instant.now().toEpochMilli();
        logger.debug(" run time is " + (end - begin));
    }

    public void print1(){
        for (int i = 0; i < data1.length; i++){
            if ( find(data1[i], 'a') > 1){
                    logger.debug(" data[" + i +"] is " + data1[i]);
                }
        }
    }

    private int find(String s, char c){
        int count = 0;
        for (int i = 0 ; i < s.length(); i++){
            if (s.charAt(i) == c){
                count++;
            }
        }
        return count;
    }

    public static void main(String... args) {
        Loop loop = new Loop();
//        loop.print(1<<10, 2);
        loop.print1();
    }
}
