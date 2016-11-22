package com.rong.flora.practice;

import com.rong.flora.data_structure.SingleLinkedList;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by rongwf1 on 2016/10/23.
 */
public interface MyCollection<T> {
    void add(T i);
    void delete(int i);
    void update(int i, T t);
    T get(int i);

}
interface ACollection<T> extends MyCollection<T>{
    Integer length();
}


class LListCollection<T> implements ACollection<T>{
    SingleLinkedList<T> llinkedList = new SingleLinkedList<>();
    public void add(T e){
        llinkedList.append(e);
    }

    public void delete(int i){
        llinkedList.delete(i);
    }
    public Integer length(){
        return llinkedList.getLen();
    }
    public T get(int i){
        return llinkedList.search(i);
    }
    public void update(int i, T e){}

    @Override
    public String toString() {
        return "LListCollection{" +
                "llinkedList=" + llinkedList +
                '}';
    }
}

class ListCollection <T> implements ACollection<T> {
    Logger logger = Logger.getLogger(ListCollection.class);

    List<T> list = new LinkedList<>();
    public void add(T e){
        logger.info("adding...");
        list.add(e);
    }
    public void delete(int i){
        list.remove(i);
    }
    public void update(int i, T e){
        list.set(i, e);
    }

    public Integer length(){
        return list.size();
    }

    @Override
    public String toString() {
        return "ListCollection{" +
                "list=" + list +
                '}';
    }

    public T get(int i){
        return list.get(i);
    }

    public static void main(String... arg){
        ACollection<Integer> listCollection = new ListCollection<>();
//        listCollection = new LListCollection<>();
        listCollection.add(1);
        listCollection.add(2);
        listCollection.add(3);
        listCollection.add(4);
        listCollection.delete(1);
        listCollection.update(1,10);
        listCollection.get(0);
        System.out.println(listCollection.length());
        System.out.println(listCollection.toString());
        ACollection<String> stringList = new LListCollection<>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        stringList.add("d");
        stringList.get(1);
        System.out.println(stringList.toString());

    }
}

