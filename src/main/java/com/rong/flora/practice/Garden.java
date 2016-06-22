package com.rong.flora.practice;

import com.rong.flora.friday.GreenTea;
import sun.jvm.hotspot.oops.FieldType;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by lafengnan on 16/6/22.
 */
public class Garden<T> {
    private String name;
    private List<T> tList ;

    public Garden(String name){

        this.name = name;
        tList = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<T> gettList() {
        return tList;
    }

    public void settList(List<T> tList) {
        this.tList = tList;
    }

    @Override
    public String toString() {
        return "Garden{" +
                "name='" + name + '\'' +
                ", tList=" + tList +
                '}';
    }

    public void makeFruit(T fruit){
        if (fruit != null){
            tList.add(fruit);
        }
    }

    public static void main(String[] args){

        Garden<Fruit> fruitGarden = new Garden<>("Fruit garden");
        Garden<Rose> roseGarden = new Garden<>("Rose garden");
        Garden<Object> garden = new Garden<>("ooooo");

        fruitGarden.makeFruit(new Fruit());
        roseGarden.makeFruit(new Rose("white"));
        garden.makeFruit(new Fruit());
        garden.makeFruit(new Rose("pink"));
        fruitGarden.makeFruit(null);

        System.out.println(fruitGarden);
        System.out.println(roseGarden);
        System.out.println(garden);

    }

}
