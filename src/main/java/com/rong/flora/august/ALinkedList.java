package com.rong.flora.august;

public class ALinkedList {
    private Node head;
    private Node tail;
    private Integer length;

    public ALinkedList(){
        head = null;
        tail = null;
        length = 0;
    }

    public void append(Integer value){
        Node node = new Node(value);
        if (length.equals(0)){
            head = node;
            tail = node;
        }else {
            tail.next = node;
            tail = node;
        }
        length += 1;
    }

    public void insert(Integer value){
        Node node = new Node(value);
        if (length.equals(0)){
            head = node;
            tail = node;
        }else {
            node.next = head;
            head = node;
        }
        length += 1;
    }

    public void show(){
        Node p = head;
        while (p!= null){
            System.out.print(p.value + "->");
            p = p.next;
        }
    }

    public Integer search(Integer index){
        if (index < 0 || index > length){
            System.out.println("this index is invalid");
        }
            Node p = head;
            for (int i = 0; i < index; i++) {
                p = p.next;
            }
            return p.value;
    }

    public static class Node{
        private Integer value;
        private Node next;

        public Node(Integer value){
            this.value = value;
            next = null;
        }
    }

    public static void main(String... args){
        ALinkedList aLinkedList = new ALinkedList();
        aLinkedList.append(1);
        aLinkedList.append(2);
        aLinkedList.append(3);
        aLinkedList.show();
        System.out.println(aLinkedList.search(1));

    }
}
