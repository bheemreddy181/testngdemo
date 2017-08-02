package com.rong.flora.july_29;

public class AlinkedList {
    private Node head;
    private Node tail;
    private Integer length;

    public AlinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }


    public static class Node{
        private Integer value;
        private Node next;

        public Node(Integer value){
            this.value = value;
            this.next = null;
        }
    }

    public boolean append(Integer value){
        Node node = new Node(value);
        if (length.equals(0)){
            tail = node;
            head = node;
        }else{
            tail.next = node;
            tail = node;
        }
        length +=1;
        return true;
    }

    public Integer findMid(){
        Node quick = head;
        Node slow = head;
        if (length.equals(0)){
            return null;
        }
        while (quick != null && quick.next != null){
            quick = quick.next.next;
            slow = slow.next;
        }
        return slow.value;
    }

    public static Integer biSearch(Integer[] data, Integer pattern, Integer begin, Integer end){
        if (begin <= end){
            Integer mid = (begin + end)/2;
            if (pattern.equals(data[mid])){
                return pattern;
            }else if(pattern < data[mid]){
               return biSearch(data, pattern, begin, mid-1);
            }else {
                return biSearch(data, pattern, mid+1, end);
            }
        }else {
            return null;
        }
    }
    public static void main(String... args){
        AlinkedList alinkedList = new AlinkedList();
        alinkedList.append(1);
        alinkedList.append(2);
        alinkedList.append(3);
        alinkedList.append(4);
        System.out.println(alinkedList.findMid());
        Integer[] data = {1,2,3,4};
        System.out.println(AlinkedList.biSearch(data, 3, 0 ,3));
    }



}
