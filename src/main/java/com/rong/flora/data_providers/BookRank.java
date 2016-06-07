package com.rong.flora.data_providers;

import com.rong.flora.logic.Book;

/**
 * Created by rongwf1 on 16/5/18.
 */
public class BookRank {
    private static Integer count = 0;

    public BookRank(){
        count++;
    }

    public static Integer getCount() {
        return count;
    }

    public static void main(String[] args){
        BookRank bookRank = new BookRank();
        System.out.println(BookRank.getCount());
         new BookRank();

        System.out.println(BookRank.getCount());

 }
}


