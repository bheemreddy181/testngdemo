package com.rong.flora.nov_21;

import java.util.*;

/**
 * Created by lafengnan on 2016/11/21.
 */
public class IteratorTest {

   private List<String> list = new LinkedList<>();

    public List<String> getList(){
        return list;
    }
    public Boolean checkNum(String str){
        for (int i = 0; i< str.length(); i++){
            if ((str.charAt(i) < 48) || (str.charAt(i) > 57)){
                return false;
            }
        }
        return true;
    }

    public static void main(String... args){
        IteratorTest iteratorTest = new IteratorTest();
//        iteratorTest.getList().add("echo");
//        iteratorTest.getList().add("yumi");
        iteratorTest.getList().addAll(Arrays.asList("echo","yumi"));
        Iterator<String> iterator = iteratorTest.getList().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println(iteratorTest.checkNum("echo"));
        System.out.println(iteratorTest.checkNum("12"));
        System.out.println(iteratorTest.checkNum("1o2"));

        Map<String, String> map = new HashMap<>();
        map.put("name", "kfc");
        map.put("favor", "nice");

        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry ee = it.next();
            System.out.println("key =" + ee.getKey());
            System.out.println("value =" + ee.getValue());
        }
    }



}
