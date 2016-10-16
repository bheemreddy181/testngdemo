package com.rong.flora.data_structure;

/**
 * Created by rongwf1 on 2016/10/16.
 */
public class Stack {
    private SingleLinkedList store;
    private int capacity;


    public Stack(int capacity){
        store = new SingleLinkedList();
        this.capacity = capacity;
    }

    public Stack (){
        this(100);
    }

    public boolean isEmpty() {
        return store.getLen().equals(0);
    }

    public int pop() {
        Integer value;
        try {
            value = store.search(0);
            store.delete(0);
        } catch (RuntimeException e){
            throw new RuntimeException("stack is empty");
        }
        return value;
    }


    public void push(int v) {
        if (store.getLen() < capacity)
        {
            store.insert(v);
        } else {
            throw new RuntimeException("stack is full");
        }
    }

    public void extend(int newCapacity){
        if (newCapacity - capacity >= 100){
            capacity = newCapacity;
        } else {
            throw new RuntimeException("new capacity should be bigger than origin capacity + 100");
        }
    }

    public int top() {
        int v = 0;
        try {
            v = store.getHead();
        } catch (NullPointerException e){
            throw new RuntimeException("stack is empty");
        }
        return v;
    }

    public int bottom() {
        int v = 0;
        try {
            v = store.getTail();
        } catch (NullPointerException e) {
            throw new RuntimeException("stack is empty");
        }
        return v;
    }

    public void show(){
        store.show();
    }
    public static void main(String... args){
        Stack stack = new Stack();
        System.out.println(stack.isEmpty());
        stack.show();
        System.out.println(stack.pop());
        stack.push(1);
        stack.push(2);
        stack.push(6);
        stack.show();
        System.out.println(stack.pop());
        stack.show();
        stack.push(3);
        System.out.println(stack.bottom());
        stack.show();
        System.out.println(stack.top());
        stack.show();
    }
}
