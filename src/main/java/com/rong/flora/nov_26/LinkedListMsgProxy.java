package com.rong.flora.nov_26;

import org.apache.commons.lang3.SystemUtils;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Created by rongwf1 on 2016/12/3.
 */
public class LinkedListMsgProxy implements IMsgProxy {
    private static final Logger logger = Logger.getLogger(LinkedListMsgProxy.class);
    List<Message> list = new LinkedList<>();
    private static IMsgProxy proxy = null;
    private LinkedListMsgProxy(){}

    public static synchronized IMsgProxy getInst(){
        if (proxy == null){
            proxy = new LinkedListMsgProxy();
        }
        return proxy;
    }

    @Override
    public synchronized boolean write(Message message){
        return list.add(message);
    }

    @Override
    public synchronized Message read(int fd, int dst){
        while (true) {
            Optional<Message> optional = list.stream().
                    filter(msg -> msg.getDst().equals(dst) && msg.getFd().equals(fd))
                    .findFirst();
            if (optional.isPresent()) {
                Message message = optional.get();
                list.remove(message);
                return message;
            }
        }
    }
}
