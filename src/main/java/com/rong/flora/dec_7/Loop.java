package com.rong.flora.dec_7;

import com.rong.flora.nov_26.Client;
import com.rong.flora.nov_26.Server;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.time.Instant;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by rong on 2016/12/7.
 */
public class Loop {
    private  static  final Logger logger =  Logger.getLogger(Loop.class);

    @Output(isOutput = true)
    private Integer[] data = new Integer[1<<13];
    // 1<<13 = 2^13
    private String[] dataStr = new String[1<<5];
    private Client[] dataClient = new Client[1<<15];

    public Loop() {
        for (int i = 0; i < data.length; i++) data[i] = i;
        for (int i = 0; i < dataStr.length; i++) dataStr[i] = RandomStringUtils.randomAlphabetic(i);
        int i = 0;
        while (i < dataClient.length){
            dataClient[i++] = new Client();
        }
    }

    public <T> void printGeneric (T[] tArray){
        for (T t : tArray){
            logger.debug(t);
        }
    }
    public void print(int index, int type){
        long begin = Instant.now().toEpochMilli();
        Field[] fields = getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Output.class)) {
                Output annotation = field.getAnnotation(Output.class);
                if (annotation.isOutput()) {
                    if (index > data.length) {
                        logger.debug("invalid length");
                        return;
                    }
                    switch (type) {
                        case 1:
                            for (int i = 0; i < index; i++) {
                                logger.debug("data is: " + data[i]);
                            }
                            break;
                        case 2:
                            for (Integer i : data) {
                                logger.debug("data is: " + i);
                            }
                            break;
                    }

                }
            }
        }

        long end = Instant.now().toEpochMilli();
        logger.debug(" run time is " + (end - begin));
    }

    public void printStr(){
        for (int i = 0; i < dataStr.length; i++){
            if ( find(dataStr[i], 'a') > 1){
                    logger.debug(" data[" + i +"] is " + dataStr[i]);
                }
        }
    }

    public void printClient(int maxId) throws MyException{
//        int i = 0;
//        while (i < dataClient.length){
//            if (dataClient[i].getClientId() < maxId){
//                logger.debug(dataClient[i]);
//            }
//            i++;
//        }
//        for (Client c : dataClient){
//            if (c.getClientId() < maxId){
//                logger.debug(c);
//            }
//        }
        int count =0;
        Iterator<Client> clientIterator = Arrays.asList(dataClient).iterator();
        while (clientIterator.hasNext()){
            Client client = clientIterator.next();
            if (client.getClientId() < maxId){
                count++;
                logger.debug(client);
            }
        }
        if (count < 1000){
            throw new MyException("countWithMap < 1000");
        }
    }

    @Deprecated
    private int find (String s, char c) {
        int count = 0;
        for (int i = 0 ; i < s.length(); i++){
            logger.debug(UploadStatus.valueOf(i));
            if (s.charAt(i) == c){
                count++;
            }
        }
        return count;
    }

   public class InnerClient extends Client{
        private String name;
        public InnerClient(String name){
            super();
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public class InnerServer extends Server{
        private String name;
        public InnerServer(String name){
            super(3);
            this.name = name;
        }
    }

    public static class InnerClass{
        private String name;
        public InnerClass(String name){
            this.name = name;
        }
    }
    public static void main(String... args) {
        Loop loop = new Loop();
//        Loop loop1 = new Loop();
//        Class loopClass = loop.getClass();
//        Field[] fields = loopClass.getDeclaredFields();
//
//        Method[] methods = loopClass.getDeclaredMethods();
//        for (Method m :  methods) {
//            if (m.isAnnotationPresent(Deprecated.class)) {
//                logger.debug(m.getName());
//            }
//        }
//
//        loop.printGeneric(fields);
//        InnerClient client = loop.new InnerClient("star");
//        InnerClient client1 = loop1.new InnerClient("star");
//        InnerServer server = loop.new InnerServer("server");
//        InnerServer server1 = loop1.new InnerServer("server");
//        InnerClass innerClass = new Loop.InnerClass("inner");
//            loop.printClient(100);
        loop.print(1<<10, 2);
//        loop.printStr();
    }
}
