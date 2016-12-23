package com.rong.flora.dec_7;

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
    public boolean add(T e){
        boolean flag = size < cap;
        if (flag){
            int index = find();
            array[index] = e;
            size++;
        }
        return flag;
    }

    public boolean delete(int index){
        boolean flag = index < size;
        if (flag){
            array[index] = null;
            size--;
        }
        return flag;
    }

    public boolean update(T e, int index){
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
    }

}
