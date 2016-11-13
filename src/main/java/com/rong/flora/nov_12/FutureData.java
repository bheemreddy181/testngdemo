package com.rong.flora.nov_12;

/**
 * Created by lafengnan on 2016/11/12.
 */
public class FutureData implements Data {
    private RealDataImpl realData = null;
    private boolean isReady = false;

    public synchronized void setRealData(RealDataImpl realData) {
        if (isReady)
            return;
        this.realData = realData;
        isReady = true;
        notifyAll();
    }

    @Override
    public String getResult() throws InterruptedException {
        if (!isReady) wait();
        return realData.getResult();
    }

}
