package com.rong.flora.animal;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by lafengnan on 16/6/15.
 */
public class Dog extends Animal{
    public Dog(String ears, String eyes, String legs, String mouse) {
        super(ears, eyes, legs, mouse);
    }

    @Override
    public void eat(String food){
        setMouse(food);
        System.out.println("Dog :" + getMouse());
    }

    public void listen(String music){
        setEars(music);
        System.out.println("Dog :" + getEars());
    }

    public void watch(String movie){
        setEyes(movie);
        System.out.println("Dog :" + getEyes());
    }

    public void run(String go){
        setLegs(go);
        System.out.println("Dog :" + getLegs());
    }

    public static void main(String[] args){

        Animal dog = new Dog("ears", "eyes", "legs", "mouse");
        Animal cat = new Cat("ears", "eyes", "legs", "mouse","miaomiao", "cat1");
        Cat cat2 = new Cat("ears", "eyes", "legs", "mouse", "fish", "cat2");
        CatFood catFood = new CatFood("pepper", 100);
        dog.run("jump 1");
        dog.run("jump 2");
        cat.run("jump");
        cat.eat("fish");
        cat2.changeMiao("hehe");
        cat2.eatFood(catFood);
        cat2.produceCat(3);
        System.out.println(cat2.getChild());
        System.out.println(cat2.getChildren());
        Field[] catFields = cat.getClass().getDeclaredFields();
        Method[] methods = cat.getClass().getDeclaredMethods();
        for (Field field : catFields) {
            System.out.println(field);
        }
        for (Method method : methods) {
            System.out.println(method);
        }
    }
}
