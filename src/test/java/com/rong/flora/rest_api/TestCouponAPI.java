package com.rong.flora.rest_api;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.rong.flora.practice.MyOkHttpClient;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

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

    @Test
    public void testGetCoupon(){
        String URI = host + ":" + port + uri + "/mgt/coupon";

        OkHttpClient client = MyOkHttpClient.getClient();
        Request request = new Request.Builder()
                .url(URI)
                .build();
        try {
            Response response = client.newCall(request).execute();
            Assert.assertEquals(response.code(), 200);
            JSONObject body = new JSONObject(response.body().string());
            Integer error = body.getInt("error");
            JSONArray data = body.getJSONArray("data");
            JSONObject coupon = data.getJSONObject(0).getJSONObject("coupon");
            JSONArray products = data.getJSONObject(0).getJSONArray("products");
            Integer prodCodeId = products.getJSONObject(0).getInt("prodCodeId");
            Integer term = coupon.getInt("term");
            System.out.println(error);
            System.out.println(term);
            System.out.println(products);
            System.out.println(prodCodeId);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}

