package com.rong.flora.nov_09;


import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import static com.rong.flora.nov_09.Product.CLOTHING;
import static com.rong.flora.nov_09.Product.DRINK;
import static com.rong.flora.nov_09.HttpStatusCode.*;
import static com.rong.flora.nov_09.Product.FOOD;

/**
 * Created by  rong on 2016/11/9.
 */
public class Shopping implements IShopping {
    private static final Logger logger = Logger.getLogger(Shopping.class);
    private String proName;
    private String merchant;
    private Boolean isPresent;

    public Shopping(String proName, String merchant){
        this.proName = proName;
        this.merchant = merchant;
    }

    /**
     * Various products to select:
     * 1. clothing
     * 2. food
     * 3. book
     * 4. drink
     * 5. cell phone
     * 6. laptop
     * ...
     * @return
     */
    public Integer select (Product product){
        isPresent = false;
        return  product.getAmount();
    }

    public boolean add(Product product){
        isPresent = true;
        return isPresent;
    }

    public boolean pay(int amount, IOnComplete onComplete, IOnFailure onFailure){
        if (onComplete != null)
            onComplete.printReceipt(proName, merchant, amount);
        return true;
    }

    public static void main(String... args)throws Exception{
        Shopping shop = new Shopping("op", "1");
        IShopping shopping = new IShopping() {
            @Override
            public Integer select(Product product) {
                return null;
            }

            @Override
            public boolean pay(int amount, IOnComplete onComplete, IOnFailure onFailure) {
                return false;
            }
        };

        shopping = new IShopping() {
            @Override
            public Integer select(Product product) {
                return null;
            }

            @Override
            public boolean pay(int amount, IOnComplete onComplete, IOnFailure onFailure) {
                return false;
            }
        };

//        FutureTask<Integer> selectTask = new FutureTask<Integer>(new Callable<Integer>() {
//            @Override
//            public Integer call() throws Exception {
//                logger.debug("thread id = "+ Thread.currentThread().getId() );
//                return shop.select(CLOTHING);
//            }
//        });
//
//        FutureTask<Boolean> addTask = new FutureTask<>(new Callable<Boolean>() {
//            @Override
//            public Boolean call() throws Exception {
//                logger.debug("thread id = "+ Thread.currentThread().getId() );
//                return shop.add(FOOD);
//            }
//        });
//
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.submit(selectTask);
//        executorService.submit(addTask);
//        executorService.shutdown();
//
//        logger.debug("addTask return: " + addTask.get());
//        logger.debug("selectTask return: " + selectTask.get());
//        shop.pay(shop.select(DRINK), new IOnComplete() {
//                    @Override
//                    public void printReceipt(String prodName, String merchant, int amount) {
//                        System.out.println("prodName = " + prodName + "merchant =" + merchant + "amount =" + amount);
//                    }
//                },
//                new IOnFailure() {
//                    @Override
//                    public void cancelTransaction(int id, int amount, String merchant) {
//                        System.out.println("11.9");
//                    }
//                }
//        );
//
//        shop.pay(10000,
//                ((prodName, merchant, amount) -> System.out.println("prodName = "+ prodName + "merchant =" + merchant + "amount =" + amount)),
//                ((id, amount,merchant)-> System.out.println("trump")));

    }
}
