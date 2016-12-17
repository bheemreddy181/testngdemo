package com.rong.flora.nov_26;

import org.apache.commons.lang3.RandomUtils;
import org.apache.log4j.Logger;

import java.util.*;

/**
 * Created by rongwf1 on 2016/11/27.
 */
public class Client implements IClient {

    private static final Logger logger = Logger.getLogger(Client.class);
    private int clientId;
    private Map<Integer,List<Integer>> serverMap = new HashMap<>();
    private State state;
    private List<Message> messageList;
    private IServer server;
    private int fd;
    private IMsgProxy msgProxy;

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    public Map<Integer, List<Integer>> getServerMap() {
        return serverMap;
    }

    public void setServerMap(Map<Integer, List<Integer>> serverMap) {
        this.serverMap = serverMap;
    }

    public Client(){
        clientId = RandomUtils.nextInt(1, 10000);
        state = State.C_RUNNING;
        messageList = new LinkedList<>();
        fd = 0;
//        msgProxy = new MsgProxy();
        msgProxy = LinkedListMsgProxy.getInst();
    }

    public boolean write(int fd, Message msg){
        boolean flag = true;
        if (serverMap.get(msg.getDst()) != null &&
                serverMap.get(msg.getDst()).contains(fd) &&
                checkServerState(server)) {
            try {
                msgProxy.write(msg);
            } catch (RuntimeException e){
                flag = false;
                logger.debug(e.getMessage());
            }
        }else {
            flag = false;
            if (serverMap.get(msg.getDst()) == null ||
                    !serverMap.get(msg.getDst()).contains(fd)) {
                logger.debug(" connection is closed");
            }else {
                logger.debug("error, the server is down");
            }
        }
        return flag;
    }


    public void read(int fd, IOncomplete action) {
        if (server == null || !serverMap.get(server.getId()).contains(fd)) {
            logger.debug("error");
            return;
        }

//        Message message = msgProxy.read();
        Message message = msgProxy.read(fd, clientId);
        if (message == null) return;

        if (clientId == message.getDst()&& message.getLife() > 0) {
            message.decLife();
            messageList.add(message);
            if(action != null && !message.getContent().equals("ack")) {
                action.success();
                logger.debug("client read message: " + message);
            }
        } else {
            // put back to queue
            if (!msgProxy.write(message) && action != null) {
                action.failure();
                logger.debug("client puts back msg to queue");
            }
        }
    }

 public boolean checkServerState(IServer server){
     return server.status().equals(State.S_RUNNING);
 }


    public State status(){
        return state;
    }

    public synchronized int connect( IServer server){
        if (checkServerState(server)){
            fd = server.accept(this);
            List<Integer> fds = serverMap.getOrDefault(server.getId(), new LinkedList<>());
            fds.add(fd);
            serverMap.put(server.getId(), fds);
            this.server = server;
        }
        return fd;
    }

    public synchronized boolean close(int fd, IServer server){

        boolean flag = true;
        if (serverMap.get(server.getId()) == null){
            logger.debug(" this server is not exist");
            return flag;
        }
        serverMap.get(server.getId()).remove(fd);
        server.clearFd(fd);
        if (serverMap.get(server.getId()).size() == 0){
            serverMap.remove(server.getId());
        }


        if (server.getClientMap().get(clientId) == null){
            logger.debug(" this client is not exist");
            return flag;
        }
        server.getClientMap().get(clientId).remove(fd);
        if (server.getClientMap().get(clientId).size() == 0){
            server.getClientMap().remove(clientId);
        }
        return flag;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", serverMap=" + serverMap +
                ", state=" + state +
                ", messageList=" + messageList +
                ", server=" + server +
                ", fd=" + fd +
                ", msgProxy=" + msgProxy +
                '}';
    }
}
