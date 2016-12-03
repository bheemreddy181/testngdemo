package com.rong.flora.nov_26;

import org.apache.log4j.Logger;

/**
 * Created by rongwf1 on 2016/11/27.
 */
public class Main {

    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String... args){
        IClient client = new Client();
        IServer server = Server.getInst();

        server.start();
        int fd =  client.connect(server);
        int fd2 =  client.connect(server);

        Thread serverThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(1000);
                        server.read(fd2, new IOncomplete() {
                            @Override
                            public boolean success() {
                               server.write(fd2, new Message(fd,"ack", server.getId(), client.getClientId(), "txt"));
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
                        client.read(fd2, new IOncomplete() {
                            @Override
                            public boolean success() {
                               client.write(fd2, new Message(fd,"ack", client.getClientId(), server.getId(), "txt"));
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
        serverThread.setName("server: " + server.getId());
        clientThread.setName("client: " + client.getClientId());
        serverThread.start();
        clientThread.start();

        for (int i =0; i< 10; i++){
            Message msg = new Message(fd,"hello", client.getClientId(), server.getId(), "txt");
            client.write(fd, msg);
            Message msg1 = new Message(fd,"world", server.getId(), client.getClientId(), "txt");
            server.write(fd, msg1 );
        }
        for (int i =0; i< 10; i++){
            Message msg = new Message(fd2,"hi", client.getClientId(), server.getId(), "txt");
            client.write(fd2, msg);
            Message msg1 = new Message(fd2,"java", server.getId(), client.getClientId(), "txt");
            server.write(fd2, msg1 );
        }
        logger.debug("over");
//        boolean f = client.write(fd,message);
//        server.read(fd);
//        server.write(fd, new Message("world", "string", client.getClientId()));
//        client.read(fd);
//
//
//        logger.debug(f);
//
//        server.shutDown();
//        f = client.write(fd, message);
//        server.read(fd);
//        logger.debug(f);


    }
}
