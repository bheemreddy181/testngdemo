package com.rong.flora.nov_26;

import org.apache.commons.lang3.RandomUtils;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by rongwf1 on 2016/11/27.
 */
public class Client implements IClient {

    private static final Logger logger = Logger.getLogger(Client.class);
    private int clientId;
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
        if (checkServerState(server)){
            try {
                msgProxy.write(msg);
            } catch (RuntimeException e){
                flag = false;
                logger.debug(e.getMessage());
            }
        }else {
            flag = false;
            logger.debug("error, the server is down");
        }
        return flag;
    }


    public void read(int fd, IOncomplete action) {
        if (fd != this.fd) {
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

    public int connect( IServer server){
        if (checkServerState(server)){
            fd = server.accept(this);
            this.server = server;
        }
        return fd;
    }
}
