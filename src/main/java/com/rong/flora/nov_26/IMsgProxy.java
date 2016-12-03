package com.rong.flora.nov_26;

/**
 * Created by rong on 2016/11/28.
 */
public interface IMsgProxy {
    default boolean routing(int fd){
        return true;
    }
    Message read() ;
    boolean write(Message msg);
}
