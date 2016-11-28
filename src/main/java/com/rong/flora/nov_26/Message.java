package com.rong.flora.nov_26;

import java.util.*;

/**
 * Created by rongwf1 on 2016/11/27.
 */
public class Message {
    private String ts;
    private String id;
    private String type;
    private Integer life;
    private Integer cId;
    private Integer sId;
    // true means c to s. false means s to c.
    private boolean direction;
    private String content;

    private Message(){
        this.ts = new Date().toString();
        this.id = UUID.randomUUID().toString();
        this.life = 10;
    }
    private Message( String content, String type, Integer clientId) {
        this();
        this.content = content;
        this.type = type;
        this.cId =clientId;
    }

   public static class Builder{
        private String content;
        private String type;
        private Integer clientId;
       private Integer serverId;
       private boolean direction;


        public Builder content(String content){
            this.content = content;
            return this;
        }

        public Builder type(String type){
            this.type = type;
            return this;
        }

        public Builder clientId(Integer clientId){
            this.clientId = clientId;
            return this;
        }

        public Builder serverId(Integer serverId){
            this.serverId = serverId;
            return this;
        }

        public Builder direction(boolean direction){
            this.direction = direction;
            return this;
        }

        public Message build(){
            Message message = new Message();
            message.content = this.content;
            message.type = this.type;
            message.cId = this.clientId;
            message.sId = this.serverId;
            message.direction = this.direction;
            return message;
        }

    }


    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getLife() {
        return life;
    }

    public void setLife(Integer life) {
        this.life = life;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    @Override
    public String toString() {
        return "Message{" +
                "ts='" + ts + '\'' +
                ", id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", type='" + type + '\'' +
                ", life=" + life +
                ", cId=" + cId +
                ", sId=" + sId +
                ", direction=" + direction +
                '}';
    }
}
