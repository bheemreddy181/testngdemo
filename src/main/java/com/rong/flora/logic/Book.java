package com.rong.flora.logic;

/**
 * Created by rongwf1 on 16/5/18.
 */
public class Book {
    private String name;
    public Integer page;
    protected Integer price;

    public void printBook(){
        System.out.println(name + page + price);
    }
}

class BookStore{
    public String address;
    protected String name;
    private Integer sales;
}

class EnglishBook extends Book{
    public void printEnglishBook(){
        System.out.println( page + price);
    }
}

class Lost extends EnglishBook{
    public void printLost(){
        System.out.println( page + price);
    }
}