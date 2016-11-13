package com.rong.flora.nov_12;

import redis.clients.jedis.Jedis;

/**
 * Created by lafengnan on 2016/11/12.
 */
public class App {
    static final Jedis jedis = new Jedis("127.0.0.1");
    public static void main(String... args) {
        Client client = new Client();
        jedis.set("hello", "world");
        Data data = client.request(jedis.get("hello"));

    }
}

class Client {
    public Data request(final String str) {
        final FutureData futureData = new FutureData();

        new Thread(()->{
            RealDataImpl realData = new RealDataImpl(str);
            futureData.setRealData(realData);
        }).start();

        return futureData;
    }
}
