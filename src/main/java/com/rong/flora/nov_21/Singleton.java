package com.rong.flora.nov_21;


import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

/**
 * Created by rong on 2016/11/23.
 */
public class Singleton {
    private String host;
    private int port;
    private static Singleton inst;
    private static final Singleton instance;

    static {
        inst = new Singleton();
        instance = new Singleton();
    }
    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    private Singleton() {
        try {
            InputStream is = ClassLoader.getSystemResourceAsStream("conf.properties");
            if (is != null) {
                Properties p = new Properties();
                p.load(is);
                this.host = p.getProperty("host");
                this.port = Integer.valueOf(p.getProperty("port"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized static Singleton getInst(){
        inst = inst==null? new Singleton():inst;
        return inst;
    }

    public static Singleton getInstance(){
        if (inst == null) {
            synchronized (Singleton.class) {
                inst = inst == null ? new Singleton() : inst;
            }
        }
        return inst;
    }

    public static Singleton getInstance1(){
        return instance;
    }

    public String changeString(String s) {
        s += "changed";
        return s;
    }

    public static void main(String... args) {
        Singleton singleton = Singleton.getInstance1();
        System.out.println(singleton.getHost());
        System.out.println(singleton.getPort());

        String src = "1234";
        System.out.println("before change src: " + src);
        String dst = singleton.changeString(src);
        System.out.println("after change src: " + src);
        System.out.println("dst: " + dst);
    }
}
