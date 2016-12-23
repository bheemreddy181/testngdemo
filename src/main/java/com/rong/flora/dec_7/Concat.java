package com.rong.flora.dec_7;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;

import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by rongwf1 on 2016/12/17.
 */
public class Concat {

    private static final Logger logger = Logger.getLogger(Concat.class);

    public static String concatString(String sa, String sb){
        List<String> list = new LinkedList<>();
        char[] chars = new char[sa.length() + sb.length()];
//        for (int i = 0; i < sa.length(); i++) {
//            chars[i] = sa.charAt(i);
//        }
//        for (int j = sa.length(); j < sa.length()+sb.length(); j++){
//            chars[j] =  sb.charAt(j);
//        }

        for (int i = 0; i <sa.length()+sb.length(); i++){
            chars[i] = i < sa.length()?sa.charAt(i): sb.charAt(i - sa.length());
        }

        return  new String(chars);
    }

    public char[] findSameCharWithDLoop(String sa, String sb){
        char[] chars = new char[1<<7];
        long b = Instant.now().toEpochMilli();
        for (int i = 0; i < sa.length(); i++){
            char c = sa.charAt(i);
            for (int j = 0; j < sb.length(); j++){
                if (c == sb.charAt(j)){
                    chars[c] = c;
                }
            }
        }
        long e = Instant.now().toEpochMilli();
        logger.debug(" double loop run time is " + (e-b));
        return chars;
    }

    public char[] findSameCharWithArray(String sa, String sb){
        char[] chars = new char[1<<7];
        boolean[] filter = new boolean[1<<7];
        long b = Instant.now().toEpochMilli();
        for (int i = 0; i < sa.length(); i++){
            filter[sa.charAt(i)] = true;
        }
        for (int i = 0; i < sb.length(); i++){
            char c = sb.charAt(i);
            if (filter[c]){
                chars[c] = c;
            }
        }
        long e = Instant.now().toEpochMilli();
        logger.debug("the array run time is " + (e-b));
        return chars;
    }

    public static void main(String... args){
        Concat concat = new Concat();
        String sa = RandomStringUtils.randomAscii(100000);
        String sb = RandomStringUtils.randomAscii(100000);
        concat.findSameCharWithArray(sa, sb);
        concat.findSameCharWithDLoop(sa, sb);
        String rt = Concat.concatString("a", "b");

        logger.debug(rt);
    }
}
