package com.rong.flora.nov_09;

/**
 * Created by flora on 2016/11/9.
 */
public interface IShopping {
    Integer select(Product product);
    boolean pay(int amount, IOnComplete onComplete, IOnFailure onFailure);
}
