package com.rong.flora.data_structure;


import java.util.LinkedList;
import java.util.List;

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

    public Integer getLen(){
        return len;
    }

    public Integer getHead(){

        return head.value;
    }

    public Integer getTail(){
        return tail.value;
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

    public Integer search(Integer index){
        if(index < 0 || index >= len) throw new RuntimeException("index:" + index +  " , size:" + len);
        Node p = head;
        for(int i = 0; i< index; i++){
            p = p.next;
        }
        return p.value;
    }

    public void swap(Integer left, Integer right){

        if(left < 0 || right < 0 || left >= len || right >= len)
            throw new RuntimeException("left:" + left + " right:" + right + ", len: " + len);
        if(left > right){
            Integer i = left;
            left = right;
            right = i;
        }
        Node p = head;
        Node q = head;
        for (int k = 0; k < right; k++ ){
            q = q.next;
            if (k >= right - left) p = p.next;
        }
//        for (int i = 0; i < left; i++){
//            p = p.next;
//
//        }
//        Node q = p;
//        for (int j = 0; j < right - left; j++){
//            q = q.next;
//        }
        Integer k = p.value;
        p.value = q.value;
        q.value = k;

    }

    public Integer seekMiddle(){
        if(len == 0) throw new RuntimeException("likedlist is empty");
        Node slow = head;
        Node quick = slow.next;
        while (quick != null) {
            if (quick.next == null) break;
                slow = slow.next;
                quick = quick.next.next;
        }

        return slow.value;
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

    public void testSeekMiddle(){
        seekMiddle();
        System.out.println(seekMiddle());
        show();
    }

    public void testSearch(int i) {
        System.out.println(search(i));
    }

    public void testInsert() {
        insert(1);
        insert(2);
        insert(3);
        insert(4);
//        insert(5);
        show();
    }

    public void testSwap(){
        swap(1,2);
        show();
        swap(2,1);
        show();
        swap(4,4);
        show();
    }
    public void testAppend() {
        append(1);
        append(2);
        append(3);
        append(4);
        append(5);
        show();
    }

    public void testDelete(int i) {
        delete(i);
        show();
    }

    public static void main(String[] args){
        SingleLinkedList list = new SingleLinkedList();
//        list.testSearch(0);
        list.testInsert();
        list.testSearch(0);
//        list.testSearch(10);
//        list.testSwap();
        list.testSeekMiddle();
//        list.testDelete(0);
//        list.testAppend();

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
