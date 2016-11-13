package com.rong.flora.nov_09;

/**
 * Created by lafengnan on 2016/11/9.
 */
public interface IOnFailure {
    void cancelTransaction(int id, int amount, String merchant);
}
