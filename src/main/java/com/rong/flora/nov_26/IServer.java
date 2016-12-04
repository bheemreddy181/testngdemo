package com.rong.flora.nov_26;

import java.util.List;
import java.util.Map;

/**
 * Created by rongwf1 on 2016/11/27.
 */
public interface IServer {
    int MAX_CONN = 1024;
    int accept(IClient client) throws RuntimeException;
    boolean write(int fd, Message msg) throws RuntimeException;
    void read(int fd, IOncomplete action) throws RuntimeException;
    boolean start() throws RuntimeException;
    boolean shutDown();
    State status();
    int getId();
    boolean close(int fd, IClient client);
    default Map<Integer, List<Integer>> getClientMap(){return null;}
}
