package com.rong.flora.practice;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.*;

/**
 * Created by lafengnan on 16/7/6.
 */
public class Statistics {
    private static Set<User> userSet = new HashSet<>();

    private static Map<String, Integer> map = new HashMap<>();

    public static Set<User> getUserSet() {
        return userSet;
    }

    public static void setUserSet(Set<User> userSet) {
        Statistics.userSet = userSet;
    }

    public static Map<String, Integer> getMap() {
        return map;
    }

    public static void setMap(Map<String, Integer> map) {
        Statistics.map = map;
    }

    public Map<String, Integer> login(User user){
        String gender = user.getGender();
        Integer cnt = map.getOrDefault(gender, 0) ;
        map.put(gender, ++cnt);
        userSet.add(user);

        return map;
    }


    public static void main(String[] args){
        Statistics statistics = new Statistics();
        for(int i = 0; i < 10; i++){
            String nm = RandomStringUtils.random(5,"qwertyuio");
            String gen = RandomStringUtils.random(1,"fm" );
            User user = new User(gen, nm);
            statistics.login(user);

        }
        System.out.println(Statistics.getMap());
        System.out.println(Statistics.getUserSet());
    }
}

class User{
    private String name;
    private String gender;

    public User(String gender, String name) {
        this.gender = gender;
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "gender='" + gender + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}