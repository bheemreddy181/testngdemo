package com.rong.flora.nov_19;

import org.apache.log4j.Logger;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Created by rongwf1 on 2016/11/19.
 */
public  class SingleStaticInnerClass {

    private static final Logger logger = Logger.getLogger(SingleStaticInnerClass.class);
    int outCnt = 0;

    private SingleStaticInnerClass(){};

    private static final class Inner{
        private static SingleStaticInnerClass instance = new SingleStaticInnerClass();
    }
    public static SingleStaticInnerClass getInstance(){
        return Inner.instance;
    }

    public class GenericInner {
        private int giCnt = 0;
        public GenericInner(int i) {
            outCnt = 1;
            giCnt = i;
        }

        public int getGiCnt() {return giCnt;}
    }

    public static void main(String... args) throws Exception{
       FutureTask<SingleStaticInnerClass> futureTask = new FutureTask<SingleStaticInnerClass>(new Callable<SingleStaticInnerClass>() {
           @Override
           public SingleStaticInnerClass call() throws Exception {
               return SingleStaticInnerClass.getInstance();
           }
       });


        FutureTask<SingleStaticInnerClass> futureTask1 = new FutureTask<SingleStaticInnerClass>(new Callable<SingleStaticInnerClass>() {
            @Override
            public SingleStaticInnerClass call() throws Exception {
                return SingleStaticInnerClass.getInstance();
            }
        });

        FutureTask<SingleStaticInnerClass> futureTask2 = new FutureTask<SingleStaticInnerClass>(
                ()->SingleStaticInnerClass.getInstance()
        );

        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(futureTask);
        service.execute(futureTask1);
        logger.debug(futureTask.get());
        logger.debug(futureTask1.get());
        service.shutdown();

        SingleStaticInnerClass inst = SingleStaticInnerClass.getInstance();
        GenericInner gi = inst.new GenericInner(1);
        GenericInner gi2 = inst.new GenericInner(2);
        logger.info(gi.getGiCnt());
        logger.info(gi2.getGiCnt());
    }
}
