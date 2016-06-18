package com.rong.flora.animal;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by rongwf1 on 2016/6/18.
 */
public class Cat extends Animal {

    private String miao;
    private String name;
    private Integer bags;
    private CatFood catFood;
    private Integer child;
    private List<Cat> children;

    public Cat(String ears, String eyes, String legs, String mouse, String miao, String name) {
        super(ears, eyes, legs, mouse);
        this.miao = miao;
        this.name = name;
        this.child = 0;
        this.children = new LinkedList<>();

    }

    public String toString() {
        return "Cat{" +
                "miao='" + miao + '\'' +
                ", name='" + name + '\'' +
                ", bags=" + bags +
                ", catFood=" + catFood +
                ", child=" + child +
                ", children=" + children +
                '}';
    }


    public List<Cat> getChildren() {
        return children;
    }

    public void setChildren(List<Cat> children) {
        this.children = children;
    }

    public String getMiao() {
        return miao;
    }

    public void setMiao(String miao) {
        this.miao = miao;
    }

    public Integer getBags() {
        return bags;
    }

    public void setBags(Integer bags) {
        this.bags = bags;
    }

    public CatFood getCatFood() {
        return catFood;
    }

    public void setCatFood(CatFood catFood) {
        this.catFood = catFood;
    }

    public Integer getChild() {
        return child;
    }

    public void setChild(Integer child) {
        this.child = child;
    }

    public void eat(String food) {
        setMouse(food);
        System.out.println("Cat :" + getMouse());
    }

    public void listen(String music) {
        setEars(music);
        System.out.println("Cat :" + getEars());
    }

    public void watch(String movie) {
        setEyes(movie);
        System.out.println("Cat :" + getEyes());
    }

    public void run(String go) {
        setLegs(go);
        System.out.println("Cat :" + getLegs());
    }

    public void changeMiao(String miao) {
        miao = "string...";
    }

    public void eatFood(CatFood catFood) {
        this.catFood = catFood;
    }

    public List<Cat> produceCat(Integer child) {
        for (int i = 0; i < child; i++) {
            Cat cat = new Cat(RandomStringUtils.random(5), RandomStringUtils.random(5), RandomStringUtils.random(5),
                    RandomStringUtils.random(5), RandomStringUtils.random(5), RandomStringUtils.random(5));
            children.add(cat);
            System.out.println(children);
        }
        this.child += child;
        return children;
    }
}
    class CatFood {

        private String favor;
        private Integer price;

        public CatFood(String favor, Integer price) {
            this.favor = favor;
            this.price = price;
        }

        public String getFavor() {
            return favor;
        }

        public void setFavor(String favor) {
            this.favor = favor;
        }

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "CatFood{" +
                    "favor='" + favor + '\'' +
                    ", price=" + price +
                    '}';
        }
    }


