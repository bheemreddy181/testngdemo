package com.rong.flora.data_structure;

import org.apache.log4j.Logger;

/**
 * Created by rongwf1 on 2016/12/24.
 */
public class PriorityQueue {

    private static final Logger logger = Logger.getLogger(PriorityQueue.class);
    private BinarySearchTree<Integer> bst;
    public PriorityQueue(){
        bst = new BinarySearchTree<>();
    }

    public void enqueue(Integer priority, String msg){
        bst.add(bst.root, priority, msg);
    }

    public String dequeue(){
        return bst.delete(bst.maximum(bst.root)).msg;
    }

    public static void main(String... args) {
        PriorityQueue pq = new PriorityQueue();
        pq.enqueue(10, "hello world");
        pq.enqueue(0, "rong");
        pq.enqueue(20, "anan");
        logger.info(pq.dequeue());
        pq.enqueue(100, "hahahah");
        pq.enqueue(50, "lxca");
        logger.info(pq.dequeue());
    }
}
