package com.rong.flora.animal;

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

        Animal animal = new Dog("ears", "eyes", "legs", "mouse");
        animal.run("jump");
    }

}
