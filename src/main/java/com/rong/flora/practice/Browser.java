package com.rong.flora.practice;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.squareup.okhttp.*;

import java.io.IOException;
import java.util.Map;

/**
 * Created by rongwf1 on 2016/6/25.
 */
public class Browser {

    public <T> HttpResponse<T> getWebsite(String url, Class<T> clz,
                                          Map<String,String> headers,
                                          Map<String, Object> parameters){
        try {
            HttpResponse<T> httpResponse = Unirest.get(url)
                    .headers(headers)
                    .queryString(parameters)
                    .asObject(clz);
            Integer code = httpResponse.getStatus();
            T body = httpResponse.getBody();
            System.out.println(code);
            System.out.println(body);
            return httpResponse;

        } catch (UnirestException e){
            System.out.println(e);
        } finally {

        }
        return null;
    }

    public static void main(String[] args){
//        String url = "http://www.baidu.com";
        String url = "http://www.163.com";

        Browser browser = new Browser();
        browser.getWebsite(url, String.class, null, null);

    }
}
