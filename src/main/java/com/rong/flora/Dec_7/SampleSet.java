package com.rong.flora.dec_7;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.lang.reflect.Method;
import java.time.Instant;
import java.util.*;

/**
 * Created by rong on 2016/12/14.
 */
public class SampleSet {
    private Set<Integer> integers = new HashSet<>();

    public Set<Integer> getIntegers() {
        return integers;
    }

    public void setIntegers(Set<Integer> integers) {
        this.integers = integers;
    }

    public boolean add(Integer e){
       return integers.add(e);
    }

    @Engine
    public Object count(String s){
        Method[] methods = getClass().getDeclaredMethods();
        for (Method method : methods){
            if (method.isAnnotationPresent(Engine.class)){
                Engine annotation = method.getAnnotation(Engine.class);
                if (annotation.engine().equals("array")){
                    return arrayCount(s);
                }else if (annotation.engine().equals("map")){
                    return countWithMap(s);
                }
            }
        }
        return countWithMap(s);
    }
    private Map<Character, Integer> countWithMap(String s){
        long b = Instant.now().toEpochMilli();
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        Map<Character, Integer> maxMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            characterIntegerMap.put(c ,characterIntegerMap.getOrDefault(c, 0)+1);
            if (maxMap.isEmpty()) {
                maxMap.put(c, 1);
            } else {
                if (c.equals(maxMap.keySet().toArray()[0])){
                    maxMap.put(c, maxMap.get(c) + 1);
                } else {
                    if (characterIntegerMap.get(c) > (Integer)maxMap.values().toArray()[0]) {
                        maxMap.clear();
                        maxMap.put(c, characterIntegerMap.get(c));
                    }
                }
            }
        }
        long e = Instant.now().toEpochMilli();
        System.out.println("countWithMap: " + (e - b) + " ms, max char: " + maxMap);
        System.out.println("countWithMap reduce: " + characterIntegerMap.values().stream().reduce(Math::max).get());
        return characterIntegerMap;
    }

    private int[] arrayCount(String s){
        long b = Instant.now().toEpochMilli();
        int[] ints = new int[(1 << 7) + 2];
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            ints[c]++;
            if (ints[128] == 0){
                ints[128] = 1;
                ints[129] = c;
            } else {
                if (ints[129]== c){
                    ints[128] += 1;
                } else {
                if (ints[c] > ints[128]){
                    ints[128] = ints[c];
                    ints[129] = c;
                }
                }
            }
        }
        long e = Instant.now().toEpochMilli();
        System.out.println("countWithArray: " + (e - b) + " ms, max char: " + (char)ints[129] + " times: " + ints[128]);

        return ints;
    }

    public static void main(String... args) {
        SampleSet sampleSet = new SampleSet();
        for (int i = 0; i < 10; i++) {
            System.out.println(sampleSet.add(RandomUtils.nextInt(1, 10)));
        }
//        System.out.println(sampleSet.getIntegers());
        sampleSet.getIntegers().forEach(System.out::println);
        sampleSet.getIntegers().retainAll(Arrays.asList(new int[]{1, 2, 3}));
        sampleSet.getIntegers().forEach(System.out::println);

        String s = RandomStringUtils.randomAscii(10000000);
//        int[] ints = sampleSet.arrayCount(s);
//        Map<Character, Integer> cntMap = sampleSet.countWithMap(s);
        sampleSet.count(s);
//        for (char c = 0; c < ints.length; c++) {
//            if (ints[c] > 0) {
//                System.out.println(c + " " + ints[c]);
//            }
//        }
//
//        System.out.println(cntMap);
    }
}
