package com.rong.flora.practice;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.sun.tools.javac.jvm.Gen;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.IOException;
import java.util.*;

import static com.rong.flora.practice.Gender.FEMALE;

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
        Gender gender = user.getGender();
        Integer cnt = map.getOrDefault(gender, 0) ;
        map.put(gender.name(), ++cnt);
        userSet.add(user);

        return map;
    }

    public void sendPoints(String nm, Integer p, String gender){

        Statistics.userSet.forEach(user -> {
            switch (user.getGender()) {
                case FEMALE:
                    break;
                case MALE:
                    break;
            }
            if(user.getName().contains(nm)) {
                if(user.getGender().equals(FEMALE)) {
                    user.addPoint(p);
                }
                user.addPoint(p);
            }});

//        Statistics.userSet
//                .stream()
//                .filter(user -> user.getName().contains(nm))
//                .forEach(user -> user.addPoint(p));

    }


    public static void main(String[] args){
        Statistics statistics = new Statistics();
        for(int i = 0; i < 10; i++){
            String nm = RandomStringUtils.random(5,"qwertyuio");
            Random random = new Random();
            Gender gender =  Gender.valueOf(random.nextInt(1));
//            String gen = RandomStringUtils.random(1,"fm" );
            User user = new User(gender, nm, 0);
            statistics.login(user);

        }

        statistics.sendPoints("i",10, "f");
        System.out.println(Statistics.getMap());
        Statistics.getUserSet()
                .stream()
                .filter(user -> user.getPoint() > 0)
                .forEach(System.out::println);
//        Statistics statistics = new Statistics();
//        for(int i = 0; i < 10; i++){
//            String nm = RandomStringUtils.random(5,"qwertyuio");
//            String gen = RandomStringUtils.random(1,"fm" );
//            User user = new User(gen, nm, 0);
//            statistics.login(user);
//
//        }
//
//        statistics.sendPoints("i",10, "f");
//        System.out.println(Statistics.getMap());
//        Statistics.getUserSet()
//                .stream()
//                .filter(user -> user.getPoint() > 0)
//                .forEach(System.out::println);

        OkHttpClient client = MyOkHttpClient.getClient();
//        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://www.lu.com")
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response.body().toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

class User{
    private String name;
    private Gender gender;
//    private String gender;
    private Integer point;

    public User(Gender gender, String name, Integer point) {
        this.gender = gender;
        this.name = name;
        this.point = point;

    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public void addPoint(Integer point){
        this.point += point;
    }

    @Override
    public String toString() {
        return "User{" +
                "gender='" + gender + '\'' +
                ", name='" + name + '\'' +
                ", point=" + point +
                '}';
    }
}