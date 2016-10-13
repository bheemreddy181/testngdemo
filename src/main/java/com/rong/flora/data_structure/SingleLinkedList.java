package com.rong.flora.data_structure;


/**
 * Created by rong 16/10/13.
 */
public class SingleLinkedList {
    private Node head;
    private Node tail;
    private Integer len;

    public SingleLinkedList(){
        head = null;
        tail = null;
        len = 0;
    }

    public Boolean append(Integer value){
        Node node = new Node(value);
        if(node == null) return false;

        if(head == null){
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        len++;
        return true;
    }

    public Boolean insert(Integer value){
        Node node = new Node(value);
        if(node == null) return false;
        if(head == null){
            head = node;
            tail = node;
            len++;
        } else {
            node.next = head;
            head = node;
            len++;
        }
        return true;
    }

    public void show(){
        Node p = head;
        while (p != null){
            System.out.println(p.value);
            p = p.next;
        }

    }

    public static void main(String[] args){
        SingleLinkedList list = new SingleLinkedList();
        list.show();
        list.insert(1);
        list.show();
        list.insert(2);
        list.show();
    }

}

class Node{
    Node next;
    Integer value;

    public Node(Integer value){
        this.next = null;
        this.value = value;
    }

}
