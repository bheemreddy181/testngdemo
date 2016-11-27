package com.rong.flora.nov_26;

import org.apache.log4j.Logger;

import java.util.concurrent.FutureTask;

/**
 * Created by rongwf1 on 2016/11/27.
 */
public class Main {

    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String... args){
        IClient client = new Client();
        IServer server = Server.getInst();
        Message message = new Message.Builder().content("hi").type("String").clientId(client.getClientId()).build();


        server.start();
        int fd =  client.connect(server);
        Thread serverThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(1000);
                        server.receiveMsg(fd, new IOncomplete() {
                            @Override
                            public boolean success() {
                               server.sendMsg(fd, new Message.Builder().type("ack").content("server received").clientId(client.getClientId()).build());
                                return true;
                            }

                            @Override
                            public boolean failure() {
                                logger.debug("serverThread error");
                                return false;
                            }
                        });
                    } catch (InterruptedException e){
                        logger.debug(e.getMessage());
                    }
                }
            }
        });
        Thread clientThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                        client.receiveMsg(fd, new IOncomplete() {
                            @Override
                            public boolean success() {
                               client.sendMsg(fd, new Message.Builder().type("ack").content("client received").clientId(client.getClientId()).build());
                                return true;
                            }

                            @Override
                            public boolean failure() {
                                logger.debug(" clientThread error");
                                return false;
                            }
                        });
                    } catch (InterruptedException e){
                        logger.debug(e.getMessage());
                    }
                }
            }
        });
        serverThread.start();
        clientThread.start();

        for (int i =0; i< 10; i++){
            Message msg = new Message.Builder().type("string").content("hello "+ i).clientId(client.getClientId()).build();
            client.sendMsg(fd, msg);
            Message msg1 = new Message.Builder().type("string").content("world "+ i).clientId(client.getClientId()).build();
            server.sendMsg(fd, msg1 );
        }
//        boolean f = client.sendMsg(fd,message);
//        server.receiveMsg(fd);
//        server.sendMsg(fd, new Message("world", "string", client.getClientId()));
//        client.receiveMsg(fd);
//
//
//        logger.debug(f);
//
//        server.shutDown();
//        f = client.sendMsg(fd, message);
//        server.receiveMsg(fd);
//        logger.debug(f);


    }
}
