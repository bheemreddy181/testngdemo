package com.rong.flora.dec_7;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import javax.net.ssl.*;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

/**
 * Created by rongwf1 on 2016/12/11.
 */
public class HtmlParse {
    static {
        TrustManager[] trustAllCertificates = new TrustManager[] {
                new X509TrustManager() {
                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        return null; // Not relevant.
                    }
                    @Override
                    public void checkClientTrusted(X509Certificate[] certs, String authType) {
                        // Do nothing. Just allow them all.
                    }
                    @Override
                    public void checkServerTrusted(X509Certificate[] certs, String authType) {
                        // Do nothing. Just allow them all.
                    }
                }
        };

        HostnameVerifier trustAllHostnames = new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true; // Just allow them all.
            }
        };

        try {
            System.setProperty("jsse.enableSNIExtension", "false");
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCertificates, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            HttpsURLConnection.setDefaultHostnameVerifier(trustAllHostnames);
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
    String html = "<html><head><title>First parse</title></head>"
            + "<body><p>Parsed HTML into a doc.</p></body></html>";

    public void parse()throws MalformedURLException, IOException{
        org.jsoup.nodes.Document doc = Jsoup.parse(html);

        URL url = new URL("https","10.240.196.223",443,"/ui/login.html");
        org.jsoup.nodes.Document html = Jsoup.parse(url,100000);

        Element appNode = html.getElementById("augustaApplication");

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");
        System.out.println(appNode.html());
        System.out.println(appNode.cssSelector());
//        System.out.println(doc);
//        System.out.println(html);
    }

    public static final void main(String... args) throws Exception{
        HtmlParse htmlParse = new HtmlParse();
        htmlParse.parse();
    }
}
