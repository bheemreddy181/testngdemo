package com.rong.flora.nov_26;

/**
 * Created by rong on 2016/11/28.
 */
public interface IMsgProxy {;
    default boolean routing(int fd){
        return true;
    }
    default Message read() {
        return null;
    }
    boolean write(Message msg);
    default Message read(int fd, int dst) {
        return null;
    }
}
