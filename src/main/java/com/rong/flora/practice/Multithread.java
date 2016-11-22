package com.rong.flora.practice;

import java.util.concurrent.*;

/**
 * Created by rongwf1 on 2016/11/12.
 */
public class Multithread {
    Integer i = 0;
    Semaphore semaphore = new Semaphore(1);

    public void add() throws Exception {
        semaphore.acquire();
        i++;
        System.out.println(Thread.currentThread().getName() + " value: " + i);
        semaphore.release();
    }

    public static void main(String... args)throws Exception{

        Multithread multithread = new Multithread();
        FutureTask<Integer> task1 = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.currentThread().setName("task1");
                multithread.add();
                return 0;
            }
        });

        FutureTask<Integer> task2 = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.currentThread().setName("task2");
                multithread.add();
                return 0;
            }
        });

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        int i = 0;
        while (true){
            System.out.print("loop: " + i++ +"\n");
            executorService.submit(task1);
            executorService.submit(task2);
            Thread.sleep(1000);
        }

    }

}
