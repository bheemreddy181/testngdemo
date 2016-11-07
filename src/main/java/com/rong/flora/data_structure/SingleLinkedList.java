package com.rong.flora.data_structure;


/**
 * Created by rong 16/10/13.
 */
public class SingleLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private Integer len;

    public SingleLinkedList() {
        head = null;
        tail = null;
        len = 0;
    }

    public Integer getLen() {
        return len;
    }

    public T getHead() {

        return head.value;
    }

    public T getTail() {
        return tail.value;
    }

    public Boolean append(T value) {
        Node<T> node = new Node<>(value);
        if (node == null) return false;

        // linkedlist is empty
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        len++;
        return true;
    }

    public Boolean insert(T value) {
        Node<T> node = new Node<>(value);
        if (node == null) return false;
        if (head == null) {
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

    public void show() {
        Node p = head;
        while (p != null) {
            System.out.print(p.value);
            System.out.print("->");
            p = p.next;
        }
        System.out.println();

    }

    public T search(Integer index) {
        if (index < 0 || index >= len) throw new RuntimeException("index:" + index + " , size:" + len);
        Node<T> p = head;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.value;
    }

    public void swap(Integer left, Integer right) {

        if (left < 0 || right < 0 || left >= len || right >= len)
            throw new RuntimeException("left:" + left + " right:" + right + ", len: " + len);
        if (left > right) {
            Integer i = left;
            left = right;
            right = i;
        }
        Node<T> p = head;
        Node<T> q = head;
        for (int k = 0; k < right; k++) {
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
        T k = p.value;
        p.value = q.value;
        q.value = k;

    }

    public T seekMiddle() {
        if (len == 0) throw new RuntimeException("likedlist is empty");
        Node<T> slow = head;
        Node<T> quick = slow.next;
        while (quick != null) {
            if (quick.next == null) break;
            slow = slow.next;
            quick = quick.next.next;
        }

        return slow.value;
    }

    public Boolean delete(Integer index) {
        // if linkedlist is empty
        if (len == 0 || index >= len) return false;

        Node p = head;
        // delete head
        if (index == 0) {
            head = head.next;
            p.next = null;
            // linkedlist just has 1 node
            if (head == null) {
                tail = null;
            }
        } else {
            for (int i = 1; i < index; i++) {
                p = p.next;
            }
            Node q = p.next;
            p.next = p.next.next;
            //delete tail
            if (q.next == null) {
                tail = p;
            } else {
                q.next = null;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "SingleLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                ", len=" + len +
                '}';
    }

    public static void main(String[] args){
        TestSingleLinkedList test = new TestSingleLinkedList();
//        list.testSearch(0);
        test.testInsert();
        test.testSearch(0);
//        test.testSearch(10);
//        test.testSwap();
        test.testSeekMiddle();
//        test.testDelete(0);
//        test.testAppend();

    }
}

class Node<T>{
    Node<T> next;
    T value;

    public Node(T value){
        this.next = null;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}

class TestSingleLinkedList {
    private SingleLinkedList<Integer> list = new SingleLinkedList<>();
    public void testSeekMiddle(){
        list.seekMiddle();
        System.out.println(list.seekMiddle());
        list.show();
    }

    public void testSearch(int i) {
        System.out.println(list.search(i));
    }

    public void testInsert() {
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
//        insert(5);
        list.show();
    }

    public void testSwap(){
        list.swap(1,2);
        list.show();
        list.swap(2,1);
        list.show();
        list.swap(4,4);
        list.show();
    }
    public void testAppend() {
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        list.show();
    }

    public void testDelete(int i) {
        list.delete(i);
        list.show();
    }
}


