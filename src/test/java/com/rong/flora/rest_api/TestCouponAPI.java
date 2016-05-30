package com.rong.flora.rest_api;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by bluerwf on 16/5/30.
 */
public class TestCouponAPI {
    private static final String host ="http://127.0.0.1";
    private static final String port = "8090";
    private static final String uri = "/mkt/coupon";

    @Test(parameters = {"couponId", "account", "operator"} )
    public void testSendCouponToTargetAccount(Integer couponId, Integer account, Integer operator) {

        String URI = host + ":" + port+ uri + "/" + couponId + "/code/single" +"?account=" +account;
        try {
            HttpResponse<JsonNode> jsonResponse = Unirest.get(URI).asJson();
            Assert.assertEquals(jsonResponse.getStatus(),200,"ok");
        } catch (UnirestException e) {
            System.out.println(e.getMessage());
        }


    }
}
