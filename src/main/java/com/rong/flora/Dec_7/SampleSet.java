package com.rong.flora.Dec_7;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;

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

    public Map<Character, Integer> count(String s){
        long b = Instant.now().toEpochMilli();
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            characterIntegerMap.put(c ,characterIntegerMap.getOrDefault(c, 0)+1);
        }
        long e = Instant.now().toEpochMilli();
        System.out.println("count: " + (e - b) + " ms");
        return characterIntegerMap;
    }

    public int[] arrayCount(String s){
        long b = Instant.now().toEpochMilli();
        int[] ints = new int[1<<7];
        for (int i = 0; i < s.length(); i++){
            ints[s.charAt(i)]++;
        }
        long e = Instant.now().toEpochMilli();
        System.out.println("array count: " + (e - b) + " ms");
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
        int[] ints = sampleSet.arrayCount(s);
        Map<Character, Integer> cntMap = sampleSet.count(s);
        for (char c = 0; c < ints.length; c++) {
            if (ints[c] > 0) {
                System.out.println(c + " " + ints[c]);
            }
        }

        System.out.println(cntMap);
    }
}
