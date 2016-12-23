package com.rong.flora.dec_7;

import java.time.Instant;

/**
 * Created by rong on 2016/12/22.
 */
public class ArrayClass<T> {
    private Object[] array;
    private int size;
    private int cap;

    public ArrayClass(int cap){
        this.cap = cap;
        this.size = 0;
        this.array = new Object[cap];
    }

    public void shrink(int newCap){
        long begin = Instant.now().toEpochMilli();
        int k = 0;
        Object[] temp = new Object[newCap];
        for (int i = 0; i < cap; i++) {
            if (array[i] != null){
                temp[k++] = array[i];
            }
        }
        array = temp;
        temp = null;
        this.cap = newCap;
        long end = Instant.now().toEpochMilli();
        System.out.println(" the shrink time is  " + (end-begin));
    }

    private int find(){
        int index = -1;
        for (int i = 0; i < cap; i++) {
            if (array[i] == null){
                index= i;
                break;
            }
        }
        return index;
    }
    @SuppressWarnings("unchecked")
    public void forEach(Consumer<T> consumer){
        for (Object t : array){
            consumer.action((T)t);
        }
    }
    public synchronized boolean add(T e){
        boolean flag = size < cap;
        if (flag){
            int index = find();
            array[index] = e;
            size++;
        }
        return flag;
    }

    public synchronized boolean delete(int index){
        boolean flag = index < size;
        if (flag){
            array[index] = null;
            size--;
        }
        return flag;
    }

    public synchronized boolean update(T e, int index){
        boolean flag = index < size;
        if (flag){
            array[index] = e;
        }
        return flag;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        return index < size ? (T) array[index] : null;
    }

    public static void main(String... args){
        ArrayClass<Integer> arrayClass = new ArrayClass<>(100);
        for (int i = 0; i < arrayClass.cap; i++) {
           System.out.println("the index is " + i + arrayClass.add(1000));
        }
        System.out.println(arrayClass.delete(1000));
        arrayClass.forEach(System.out::println);

        arrayClass.shrink(10000000);
    }

}
