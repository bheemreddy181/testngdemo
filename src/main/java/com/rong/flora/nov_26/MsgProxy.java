package com.rong.flora.nov_26;

/**
 * Created by rong on 2016/11/28.
 */
public class MsgProxy implements IMsgProxy {

    public synchronized Message read(){
        return MsgQueue.read();
    }

    public synchronized boolean write(Message msg){
        return MsgQueue.write(msg);
    }
}
