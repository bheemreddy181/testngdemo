package com.rong.flora.practice;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by lafengnan on 16/6/20.
 */
public class Fruit implements Juice{
    private Map<String ,List<String>> info;
    private List<Map<String, Integer>> name;
    private static List<Fruit> fruits;

    static {

        fruits = new LinkedList<>();

    }

    public Fruit(){
        this.info = new HashMap<>();
        this.name = new LinkedList<>();
        Fruit.addFruit(this);
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "info=" + info +
                ", name=" + name +
                '}';
    }
//   public void addInfo(Map<String, List<String>> info){

 //       this.info.putAll(info);

  //  }

    public void addSingleInfo(String name, String info){
        if(this.info.keySet().contains(name)) {
            this.info.get(name).add(info);
        } else{
            List<String> infoList = new LinkedList<>();
            infoList.add(info);
            this.info.put(name, infoList);

        }
    }

    public void deleteSingleInfo(String name, String info){
        if (this.info.containsKey(name)){
        this.info.get(name).remove(info);
        } else {
            System.out.println(" does not exist this fruit in db");
        }

    }

    public void addName(String name, Integer sales){

        Map<String, Integer> nameMap = new HashMap<>();
        nameMap.put(name, sales);
        this.name.add(nameMap);
    }

    public static void addFruit(Fruit fruit){
        fruits.add(fruit);
    }

    public static List<Fruit> getFruit(){
        return fruits;
    }

    public void makeJuice(){
        System.out.println(" make juice");
    }

    public void makeMixedJuice(List<Fruit> fruitList){
        fruits = fruitList;
        System.out.println("1" + fruitList.toString());

    }


    public static void main(String[] args){

        Fruit fruit = new Fruit();
        Fruit fruit1 = new Fruit();
        Juice juice = new Fruit();

        fruit.addSingleInfo("apple", "like u");
        fruit.addSingleInfo("orange", "sunny");

        System.out.println(fruit);
        fruit.deleteSingleInfo("apple", "like u");
        fruit.deleteSingleInfo("kiwi", "like u");
        juice.makeJuice();
        juice.makeMixedJuice(fruits);
        System.out.println(Fruit.getFruit());
    }

}

