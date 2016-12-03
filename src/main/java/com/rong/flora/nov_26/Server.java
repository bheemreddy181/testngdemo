package com.rong.flora.nov_26;

import org.apache.commons.lang3.RandomUtils;
import org.apache.log4j.Logger;

import java.util.*;

/**
 * Created by rongwf1 on 2016/11/27.
 */
public class Server implements IServer {
    private static final org.apache.log4j.Logger logger = Logger.getLogger(Server.class);
    private State state;
    private int connect;
    private Map<Integer, List<Integer>> clientMap;
    private List<Message> messageList;
    private int fd;
    private int id;
    private static final Server inst = new Server();
    private IMsgProxy msgProxy;

    private Server(){
        state = State.S_CLOSED;
        connect = 0;
        fd = 0;
        id = RandomUtils.nextInt(10001, 20000);
        clientMap = new HashMap<>(MAX_CONN);
        messageList = new LinkedList<>();
//        msgProxy = new MsgProxy();
        msgProxy = LinkedListMsgProxy.getInst();
    }

    public  static Server getInst(){
        return inst;
    }

    public Map<Integer, List<Integer>> getClientMap() {
        return clientMap;
    }

    public void setClientMap(Map<Integer, List<Integer>> clientMap) {
        this.clientMap = clientMap;
    }

    @Override
    public int getId() {
        return id;
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

    public void read(int fd, IOncomplete action){
//        Message msg = msgProxy.read();
        Message msg = msgProxy.read(fd, id);
        if (msg == null) return;

        if (clientMap.get(msg.getSrc()) != null &&
                clientMap.get(msg.getSrc()).contains(fd) &&
                msg.getDst()==id &&
                msg.getLife() > 0){
            messageList.add(msg);
            if (action != null && !msg.getContent().equals("ack")){
                action.success();
            }
            logger.debug("message:" + msg);
        } else {
            // write back to the queue
            if (!msgProxy.write(msg) && action != null) {
                action.failure();
                logger.debug("server puts back message to queue");
            }
        }
    }

    public boolean write(int fd, Message msg){
        boolean flag = true;
        if (clientMap.get(msg.getDst()) != null && clientMap.get(msg.getDst()).contains(fd)){
            msgProxy.write(msg);
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

    public synchronized int accept(IClient client){

        if(status().equals(State.S_RUNNING) && connect<MAX_CONN ){
            connect++;
            List<Integer> fds = clientMap.getOrDefault(client.getClientId(), new LinkedList<>());
            fds.add(++fd);
            clientMap.put(client.getClientId(), fds);
        }

        if (fd > MAX_CONN){
            logger.debug("fd > max count, can't accept");
        }
        return fd;
    }
}
