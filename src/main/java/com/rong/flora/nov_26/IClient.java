package com.rong.flora.nov_26;

/**
 * Created by rongwf1 on 2016/11/27.
 */
public interface IClient {
    int connect(IServer s) throws RuntimeException;
    boolean sendMsg(int fd, Message msg) throws RuntimeException;
    void receiveMsg(int fd, IOncomplete action) throws RuntimeException;
    boolean checkServerState(IServer s);
    State status();
    int getClientId();
}
