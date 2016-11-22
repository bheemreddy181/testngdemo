package com.rong.flora.nov_19;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Created by rongwf1 on 2016/11/19.
 */
public enum  Singleton {
    insta;
    private static final Logger logger = Logger.getLogger(Singleton.class);

    private Singleton(){}


    public static  Singleton getInstance(){
        return insta;
    }
     public String toString(){
         return "" + hashCode();
     }


    public static void main(String... args) throws Exception, IOException, RuntimeException {

        FutureTask<Singleton> task1 = new FutureTask<Singleton>(new Callable<Singleton>() {
            @Override
            public Singleton call() throws Exception {
                return Singleton.getInstance();
//                Singleton singleton = Singleton.getInstance(Singleton.class);
            //    return singleton;
            }
        });

        FutureTask<Singleton> task2 = new FutureTask<Singleton>(new Callable<Singleton>() {
            @Override
            public Singleton call() throws Exception {
                return Singleton.getInstance();
//                Singleton singleton = Singleton.getInstance(LinkedList.class);
                //return singleton;
            }
        });

        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(task1);
        service.execute(task2);
        System.out.println(task1.get());
        System.out.println(task2.get());
        service.shutdown();
    }
}
