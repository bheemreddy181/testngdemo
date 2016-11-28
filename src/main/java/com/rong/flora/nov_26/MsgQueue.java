package com.rong.flora.nov_26;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by rong on 2016/11/28.
 */
public class  MsgQueue{

    private static final int CAPACITY = 1024;

    private static Queue<Message> mq = new ArrayBlockingQueue<Message>(CAPACITY);

    public static Message read(){
        return mq.poll();
    }

    public static boolean write(Message msg){
        return mq.size() <= CAPACITY && mq.add(msg);
    }

}
