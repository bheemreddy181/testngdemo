package com.rong.flora.rest_api;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by flora on 16/5/8.
 */

public class TestRestAPI {
    String host = "http://127.0.0.1:8080";

    @Test(parameters = {"id"})
    public void testGetOpJournal( int id){
        String uri = "/settlement/dlc/journal/op/in/"+id;

        try {
            HttpResponse<JsonNode> response =Unirest.get(host+uri).asJson();
            JSONObject body = response.getBody().getObject();
            JSONArray data = body.getJSONArray("data");

            for (int i = 0; i < data.length(); i++) {
                JSONObject object = (JSONObject)data.get(i);
                Assert.assertEquals(object.get("opAt"), "2016-05-08T18:02:46", "ok");
                Assert.assertEquals(object.get("operator"), "chris", "ok");
                Assert.assertEquals(object.getInt("opAction"), 0, "ok");
                Assert.assertEquals(object.getString("remark"), "有钱了", "ok");
                Assert.assertEquals(object.getInt("reportId"), 1, "ok");
                Assert.assertEquals(object.getBoolean("inFlag"), true, "ok");
                Assert.assertEquals(object.getInt("statusOld"), 1, "ok");
                Assert.assertEquals(object.getInt("statusNew"), 2, "ok");
            }
            Assert.assertEquals(body.get("error"), 0, "ok");
            Assert.assertSame(body.getJSONArray("data").length(), 1, "ok");
            Assert.assertEquals(((JSONObject)body.get("paging")).getInt("page"), 1, "ok");
            Assert.assertEquals(((JSONObject)body.get("paging")).getInt("pageSize"), 50, "ok");
            Assert.assertEquals(((JSONObject)body.get("paging")).getInt("total"), 1, "ok");
        } catch (UnirestException e){
            e.printStackTrace();
        }

    }

}
