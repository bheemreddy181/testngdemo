package com.rong.flora.rest_api;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by rongwf1 on 2016/6/1.
 */
@Test
public class TestVirtualAppMgt {
    private static String host;
    @BeforeClass
    public void init(){
        host = "xxx.xxx.xxx.xxx";
    }
    public void testGetAiccNetworkIpDisable(){
        String url = host +"/acc/appliance/ipdisable";
        try{

            HttpResponse<JsonNode> httpResponse = Unirest.get(url).asJson();
            Integer statusCode = httpResponse.getStatus();
            JSONArray jsonArray = httpResponse.getBody().getObject().getJSONArray("ip_status");

            Assert.assertEquals(statusCode, Integer.valueOf(200), "ok");

            for( int i = 0; i < jsonArray.length(); i++){
                Integer ip_disable = jsonArray.getJSONObject(i).getInt("ip_disable");
                Integer ip_version = jsonArray.getJSONObject(i).getInt("ip_version");
                switch (ip_version) {
                    case 4:
                        Assert.assertEquals(ip_disable, Integer.valueOf(0));
                        break;
                    case 6:
                        Assert.assertEquals(ip_disable, Integer.valueOf(1));
                        break;
                    default:
                        break;
                }
            }

        }catch (UnirestException e){
            System.out.println(e.getMessage());
        }
    }
}
