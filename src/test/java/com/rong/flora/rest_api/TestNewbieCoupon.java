package com.rong.flora.rest_api;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * Created by lafengnan on 16/6/2.
 */
public class TestNewbieCoupon {
    private static String host;
    private static String port;

    @BeforeClass
    public void init(){
        host = "http://127.0.0.1";
        port = "8090";
    }

    @Test(parameters = {"accountId"})
    public void testGetNewbieCoupon(Integer  accountId){
        String uri = "/mkt/coupon/biz/newbie/code";
        String url = host + ":"+ port + uri;
        accountId = new Random().nextInt();

        try {
            HttpResponse<JsonNode> httpResponse = Unirest.get(url)
                    .queryString("accountId", accountId)
                    .asJson();
            Integer statusCode = httpResponse.getStatus();
            JSONObject body = httpResponse.getBody().getObject();
            Integer accountId1 = body.getInt("accountId");
            Integer error = body.getInt("error");
            String message = null;
            if (error == 0){
                JSONArray data = body.getJSONArray("data");
            } else {
                 message = body.getString("message");
            }

            Assert.assertEquals(statusCode, Integer.valueOf(200), "ok");
            Assert.assertEquals(accountId1, accountId, "ok");
            if (message != null){

                Assert.assertEquals(message, "NO_COUPON_AVAILABLE", "ok");
            }
            System.out.println(body);
        } catch (UnirestException e){
            System.out.println(e.getMessage());
        }
    }

}
