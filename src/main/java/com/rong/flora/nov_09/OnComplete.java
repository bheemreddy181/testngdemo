package com.rong.flora.nov_09;

/**
 * Created by lafengnan on 2016/11/9.
 */
@Deprecated
public class OnComplete implements IOnComplete {

    public void printReceipt(String proName, String merchant, int amount){
        System.out.println("proName = " + proName + "merchant= " + merchant + "amount =" + amount);
    }
}
