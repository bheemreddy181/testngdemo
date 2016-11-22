package com.rong.flora.nov_12;

import org.apache.log4j.Logger;
//import redis.clients.jedis.Jedis;

import java.util.concurrent.*;

/**
 * Created by lafengnan on 2016/11/12.
 */
public class MultiThreadDemo {

//    private final Jedis jedis = new Jedis("127.0.0.1", 6379);
//    private static final Logger logger = Logger.getLogger(MultiThreadDemo.class);
//
//    public Jedis getJedis() {return jedis;}
//
//    public static void main(String... args) throws Exception{
//
//        MultiThreadDemo demo = new MultiThreadDemo();
//
//        FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                Thread.currentThread().setName("hello thread");
//                logger.info(Thread.currentThread().getName());
//                demo.getJedis().set("demo", "hello");
//                Thread.sleep(10000);
//                return demo.getJedis().get("demo");
//            }
//        });
//
//        ExecutorService executor = Executors.newFixedThreadPool(2);
//        executor.execute(futureTask);
//
//        while (true) {
//            try {
//                if (futureTask.isDone()) {
//                    logger.info(futureTask.get());
//                    break;
//                }
//            } catch (InterruptedException e) {
//                logger.debug(e.getMessage());
//                break;
//            } finally {
//                executor.shutdown();
//            }
//        }
//    }
}
