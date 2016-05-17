package com.rong.flora.logic;

import java.util.*;

/**
 * Created by rongwf1 on 2016/5/15.
 */
public class FindHouse {
    private Map<String, Integer> priority;

    public Map<String, Integer> getPriority() {
        return priority;
    }

    public void setPriority(Map<String, Integer> priority) {
        this.priority = priority;
    }

    public Integer score( House house){
        Integer score = 0;
        score += priority.get("location")/house.getLocation();
        score += house.getPrice()/10000*priority.get("price");
        score += house.getConvenient()*priority.get("convenient");
        score += house.getDecoration()*priority.get("decoration");
        score += house.getHouseTpye()*priority.get("houseType");
        score += house.getTraffic()*priority.get("traffic");
        score += house.getShouFu()*priority.get("shouFu");
        house.setScore(score);
        return score;
    }

    public void sort(List<House> houseList){

        for(House h :houseList){
            score(h);
        }

        houseList.sort(new Comparator<House>() {
            @Override
            public int compare(House o1, House o2) {
                return o2.getScore() - o1.getScore();
            }
        });

    }

    public static void main(String[] args){
        House house = new House();
        house.setLocation(20);
        house.setPrice(4);
        house.setConvenient(1);
        house.setDecoration(0);
        house.setHouseTpye(2);
        house.setTraffic(2);
        house.setShouFu(1);
        house.setSquare(57);
        house.setId(1);
        House house1 = new House();
        house1.setLocation(20);
        house1.setPrice(4);
        house1.setConvenient(2);
        house1.setDecoration(0);
        house1.setHouseTpye(1);
        house1.setTraffic(2);
        house1.setShouFu(1);
        house1.setSquare(57);
        house1.setId(2);

        House house2 = new House(30,5,0,0);
        List<House> houselist = new LinkedList<>();
        houselist.add(house);
        houselist.add(house1);

        FindHouse findHouse = new FindHouse();
        Map<String, Integer> priority = new HashMap<>();
        priority.put("location", 10);
        priority.put("price", 9);
        priority.put("convenient", 8);
        priority.put("decoration", 6);
        priority.put("houseType", 7);
        priority.put("traffic", 5);
        priority.put("shouFu", 4);

        findHouse.setPriority(priority);
        houselist.forEach(findHouse::score);

        System.out.println(houselist);
        findHouse.sort(houselist);
        System.out.println(houselist);
        System.out.println(House.getCount());
    }
}
