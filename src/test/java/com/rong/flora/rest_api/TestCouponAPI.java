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

        String URI = host + ":" + port+ uri + "/" + couponId + "/code/single";
        try {
            HttpResponse<JsonNode> jsonResponse = Unirest.get(URI)
                    .queryString("account", account)
                    .queryString("operator", operator)
                    .asJson();
            Assert.assertEquals(jsonResponse.getStatus(),200,"ok");
            Integer couponId1 = jsonResponse.getBody().getObject().getJSONObject("coupon").getInt("couponId");
            Integer account1 = jsonResponse.getBody().getObject().getInt("account");
            Assert.assertEquals(couponId1,couponId, "ok");
            Assert.assertEquals(account1, account, "ok");
            System.out.println(jsonResponse.getBody().toString());
        } catch (UnirestException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test(parameters = {"invalidCouponId", "account", "operator"})
    public void testNoCouponAvailable(Integer couponId, Integer account, Integer operator){
        String URI = host + ":" + port + uri + "/" + couponId + "/code/single";
        try {
            HttpResponse<JsonNode> httpResponse = Unirest.get(URI)
                    .queryString("account", account)
                    .queryString("operator", operator)
                    .asJson();
            Integer statusCode = httpResponse.getStatus();
            Integer error = httpResponse.getBody().getObject().getInt("error");
            String message = httpResponse.getBody().getObject().getString("message");
            Assert.assertEquals(statusCode, Integer.valueOf(200), "ok");
            Assert.assertEquals(error, Integer.valueOf(6010), "ok");
            Assert.assertEquals(message, "NO_COUPON_AVAILABLE", "ok");
            System.out.println(httpResponse.getBody().toString());

        }catch (UnirestException e) {
            System.out.println(e.getMessage());
        }
    }
}

