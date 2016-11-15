package com.rong.flora.nov_12;


import org.apache.log4j.Logger;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lafengnan on 2016/11/14.
 */
public class WaitDemo {
    private List list;
    private static final Logger logger = Logger.getLogger(WaitDemo.class);

    public WaitDemo() {
        list = Collections.synchronizedList(new LinkedList<>());
    }

    public void print(String msg) {
        logger.info("Thread: " + Thread.currentThread().getName() + " " + msg);
    }

    public String pop() throws InterruptedException {
        print("in pop: entering");

        synchronized (list) {
            if (list.isEmpty()) {
                print("in pop: into wait");
                list.wait();
                print("in pop: out wait");
            }

            String item = (String)list.remove(0);
            print("in pop: exiting");

            return item;
        }
    }

    public void push(String item) {
        print("in push: entering");
        synchronized (list) {
            list.add(item);
            print("in push: after adding item, to notifyAll");
            list.notifyAll();
            print("in push: after adding item, notifyAll done");
        }
        print("in push: exiting");
    }

    public static void main(String... args) {
        WaitDemo demo = new WaitDemo();

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                try {
                    String item = demo.pop();
                    demo.print("in r1 item = " + item);
                } catch (InterruptedException e) {
                    logger.info(e.getMessage());
                }
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                demo.push("hello");
            }
        };

        try {
            Thread thread = new Thread(r1, "r1-0");
            thread.start();

            Thread.sleep(500);

            Thread thread2 = new Thread(r1, "r1-1");
            thread2.start();

            Thread.sleep(500);

            Thread thread3 = new Thread(r2, "r2");
            thread3.start();

            Thread.sleep(10_000);

            thread.interrupt();
            thread2.interrupt();
        } catch (InterruptedException e) {
            logger.info(e.getMessage());
        }
    }


}

