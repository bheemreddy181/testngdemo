package com.rong.flora.test_case;

import com.rong.flora.friday.LenovoServer;
import com.rong.flora.friday.NetworkInterface;
import com.rong.flora.friday.Power;
import com.rong.flora.friday.Server;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by rongwf1 on 2016/5/21.
 */
public class TestLenovoServer {

    private LenovoServer lenovoServer;
    private Server server;
    private NetworkInterface networkInterface;
    private Power power;

    @BeforeClass
    public void init(){
        lenovoServer = new LenovoServer(7873);
        server = new Server();
        networkInterface = new LenovoServer(7879);
        power = new Server();
    }


    @Test
    public void testTotalPrice(){Assert.assertEquals(lenovoServer.totalPrice(),Integer.valueOf(100),"ok");}

    @Test
    @Parameters({"price"})
    public void testTotalPrice(Integer price){
        server.setPrice(price);
    Assert.assertEquals(server.totalPrice(),Integer.valueOf(server.getPrice()*Server.getSales()), "ok");
    }

    @Test
    public void testPing() {
        Assert.assertEquals(lenovoServer.ping(),"ping ok", "ok");
        Assert.assertEquals(networkInterface.ping(),"ping ok", "ok");

    }

    @Test
    public void testServerList(){
        Assert.assertEquals(serverList(9).size(),9,"ok");
        Assert.assertEquals(Server.getSales(),Integer.valueOf(13),"ok");
    }

    public List<Server> serverList(int size){
        List<Server> serverList = new LinkedList<>();
        for (int i = 0; i< size;i++) {
            Server server = new Server();
            serverList.add(server);
        }
        return serverList;
    }

}

