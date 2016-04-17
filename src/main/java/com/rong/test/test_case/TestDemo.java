package com.rong.test.test_case;

import com.rong.test.data_providers.DemoProvider;
import com.rong.test.model.RackInfo;
import com.rong.test.logic.HelloWorld;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by rongwf1 on 2016/4/17.
 */

@Test
public class TestDemo {

    private HelloWorld helloWorld;

    @BeforeClass
    public void init(){
        helloWorld = new HelloWorld("init");
    }

    @Test(priority = 1)
    public void testGetHelloWorld() {
        Assert.assertEquals(helloWorld.getMessage(), "init", "OK");
    }

    @Test(priority = 2)
    @Parameters({"message"})
    public void testSetHelloWorld(String msg){
        System.out.println(msg);
        helloWorld.setMessage(msg);
        Assert.assertEquals(helloWorld.getMessage(), msg, "ok");
    }
    @Parameters({"a","b"})
    public void testOper(Integer a, Integer b){
        Assert.assertEquals((int)helloWorld.oper(a, b), a + b, "0k");
    }

    @Test(dataProvider = "createRackInfo", dataProviderClass = DemoProvider.class)
    public void testRackInfo(RackInfo info) {
    }
}


