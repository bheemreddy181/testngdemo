package com.rong.flora.nov_12;

/**
 * Created by lafengnan on 2016/11/12.
 */
public class RealDataImpl implements Data {
    private String data;

    public RealDataImpl(String data) {
        this.data = data;
    }

    @Override
    public String getResult() throws InterruptedException {
        return data;
    }
}
