package com.rong.flora.data_structure;


import java.security.NoSuchAlgorithmException;

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

        // linkedlist is empty
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
            System.out.print(p.value);
            System.out.print("->");
            p = p.next;
        }
        System.out.println();

    }

    public Boolean delete(Integer index){
        // if linkedlist is empty
        if (len == 0 || index >= len) return false;

        Node p = head;
        // delete head
        if(index == 0) {
            head = head.next;
            p.next = null;
            // linkedlist just has 1 node
            if (head == null){
                tail = null;
            }
        } else {
            for(int i = 1; i < index; i++) {
                p = p.next;
            }
            Node q = p.next;
            p.next = p.next.next;
            //delete tail
            if (q.next == null){
                tail = p;
            } else {
                q.next = null;
            }
        }
        return true;
    }

    public static void main(String[] args){
        SingleLinkedList list = new SingleLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.show();
        list.delete(0);
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
