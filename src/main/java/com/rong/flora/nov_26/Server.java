package com.rong.flora.nov_26;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by rongwf1 on 2016/11/27.
 */
public class Server implements IServer {
    private static final org.apache.log4j.Logger logger = Logger.getLogger(Server.class);
    private State state;
    private int connect;
    private Map<Integer, Integer> clientMap;
    private List<Message> messageList;
    private int fd;
    private static final Server inst = new Server();


    private Server(){
        state = State.S_CLOSED;
        connect = 0;
        fd = 0;
        clientMap = new HashMap<>(MAX_CONN);
        messageList = new LinkedList<>();
    }

    public  static Server getInst(){
        return inst;
    }

    public boolean start(){
        boolean flag = true;
        logger.debug("start the server");
        try {

            state = State.S_STARTING;
            Thread.sleep(5000);
        } catch (InterruptedException e){
            flag = false;
            logger.debug(e.getMessage());
        }
        state = State.S_RUNNING;
        logger.debug("server is running");
        return flag;
    }

    public boolean shutDown(){
        boolean flag = true;
        logger.debug(" start to close the server");
        try {
            state = State.S_CLOSING;
            Thread.sleep(5000);
        } catch (InterruptedException e){
            flag = false;
            logger.debug(e.getMessage());
        }
        state = State.S_CLOSED;
        logger.debug(" the server is closed");
        return flag;
    }

    public void receiveMsg(int fd, IOncomplete action){
        if (Message.getServerMessages().isEmpty())return;
        Message msg =Message.getServerMessages().poll();
        if (fd == clientMap.get(msg.getClentId())){
            messageList.add(msg);
            if (action != null)
                action.success();
            logger.debug("message:" + msg);
        } else {
            if (action != null && !msg.getType().equals("ack"))
                action.failure();
            Message.getServerMessages().add(msg);
            logger.debug(" error !");
        }
    }

    public boolean sendMsg(int fd, Message msg){
        boolean flag = true;
        if (fd == clientMap.get(msg.getClentId())){
            Message.getClientMessages().add(msg);
//            logger.debug("send message: " + msg);
        } else {
            flag = false;
            logger.debug(" error!");
        }
        return flag;
    }

    public State status(){
        return state;
    }

    public int accept(IClient client){

        if(status().equals(State.S_RUNNING) && connect<MAX_CONN ){
            connect++;
            clientMap.put(client.getClientId(), ++fd);
        }

        if (fd > MAX_CONN){
            logger.debug("fd > max count, can't accept");
        }
        return fd;
    }
}
