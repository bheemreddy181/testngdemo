package com.rong.flora.nov_13;

import com.rong.flora.nov_09.IOnComplete;
import com.rong.flora.nov_09.IOnFailure;
import org.apache.log4j.Logger;

/**
 * Created by rongwf1 on 2016/11/13.
 */
public interface IPayStatus extends IOnComplete, IOnFailure {
    Logger logger = Logger.getLogger(IPayStatus.class);
    default void printReceipt(String prodName, String merchant, int amount){
        logger.debug("product = " + prodName +" merchant = " + merchant + " amount = " + amount);
    }
    default void cancelTransaction(int id, int amount, String merchant){
        logger.debug("id = " + id +" merchant = " + merchant + " amount = " + amount);
    }
}
