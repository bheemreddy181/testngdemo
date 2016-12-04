package com.rong.flora.nov_26;

import java.util.List;
import java.util.Map;

/**
 * Created by rongwf1 on 2016/11/27.
 */
public interface IClient {
    int connect(IServer s) throws RuntimeException;
    boolean write(int fd, Message msg) throws RuntimeException;
    void read(int fd, IOncomplete action) throws RuntimeException;
    boolean checkServerState(IServer s);
    State status();
    int getClientId();
    boolean close(int fd, IServer server);
    default Map<Integer, List<Integer>> getServerMap(){return null;}
}
