package com.rong.flora.data_structure;

/**
 * Created by lafengnan on 16/10/25.
 */
public class LinkedListA<T> {
    Node<T> head;
    Node<T> tail;
    Integer len;
    public LinkedListA(){
        head = null;
        tail = null;
        len = 0;
    }

    public LinkedListA<T> append(T value){
        Node<T> node = new Node<>(value);
        if (head == null && tail == null){
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        len++;
        return this;
    }

    public void show(){
        Node<T> p = head;
        while (p!= null){
            System.out.print(p.value + "->");
            p = p.next;
        }
    }

    class Node<T>{
        T value;
        Node<T> next;
        public Node(T value){
            this.value = value;
            next = null;
        }
    }

    public static void main(String... args){
        LinkedListA<String> linkedListA = new LinkedListA<>();
        linkedListA.append("a").append("b").append("c").append("d");
        linkedListA.show();
    }
}

