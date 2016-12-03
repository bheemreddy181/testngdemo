package com.rong.flora.nov_26;

import java.util.*;

/**
 * Created by rongwf1 on 2016/11/27.
 */
public class Message {
    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Message.class);
    private String id;
    private Protocol protocol;
    private String content;
    private Integer fd;

    private Message(){
        this.protocol = new Protocol();
        this.id = UUID.randomUUID().toString();
    }
    public Message( Integer fd, String content, Integer src, Integer dst, String... msgFmt) {
        this();
        this.fd = fd;
        this.content = content;
        protocol.setSrc(src);
        protocol.setDst(dst);
        for (String fmt : msgFmt) protocol.setType(fmt);
    }

    public Integer getFd() {
        return fd;
    }

    public void setFd(Integer fd) {
        this.fd = fd;
    }

    public Integer getSrc(){
        return protocol.getSrc();
    }

    public Integer getDst(){
        return protocol.getDst();
    }

    public Integer getLife(){
        return protocol.getLife();
    }
    public Integer decLife() {
        int oldLife = protocol.getLife();
        if (oldLife > 0) protocol.setLife(--oldLife);
        return oldLife;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", protocol=" + protocol +
                ", content='" + content + '\'' +
                '}';
    }
}
