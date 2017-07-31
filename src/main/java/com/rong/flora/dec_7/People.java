package com.rong.flora.dec_7;

/**
 * Created by rongwf1 on 2017/1/16.
 */
public class People {
    private String name;
    private int age;
    public People(){
        System.out.println(" this is the constructor1");
    }
    public People(String name, int age){
        System.out.println(" this is the constructor2");
        this.age = age;
        this.name = name;
    }

    public static void main(String... args){
       // People  people = new People();
//        Student student = new Student("jack", 10, 2);
        Student student = new Student();
        student.move();
    }
}
class Student extends People{
    private int grade;
    public Student(){
        System.out.println(" this is student 1");
    }

    public Student(String name, int age,int grade){
//        super(name, age);
        System.out.println(" this  is student 2");
        this.grade = grade;
    }

    public void move(){
        System.out.println(" this is move");
    }

}
class Foo {
    int i = 0;
}

class Bar extends Foo {
    int i = 1;
    public static void main(String... args) {
        Foo foo = new Bar();
        System.out.println(foo.i);
    }
}