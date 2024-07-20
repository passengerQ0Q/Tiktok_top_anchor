package com.langlang.utils;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class HttpUtil {

    private static final CloseableHttpClient httpClient = HttpClients.createDefault();



    // 发送 GET 请求
    public static String sendGet(String url, Map<String, String> headers) throws Exception {
        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
        con.setRequestMethod("GET");

        // 设置请求头
        if (headers != null) {
            for (Map.Entry<String, String> header : headers.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }
        }

        return readResponse(con);
    }
    // 读取响应
    private static String readResponse(HttpURLConnection con) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

    public static String sendPost(String url, String jsonInputString) throws IOException {
        HttpPost post = new HttpPost(url);
        post.setHeader("Content-Type", "application/json");
        post.setHeader("Accept", "application/json");
        post.setEntity(new StringEntity(jsonInputString));

        try (CloseableHttpResponse response = httpClient.execute(post)) {
            HttpEntity entity = response.getEntity();
            return entity != null ? EntityUtils.toString(entity) : null;
        }
    }
    // 发送 POST 请求
    public static String sendPost(String url, String jsonInputString, Map<String, String> headers) throws IOException {
        HttpPost post = new HttpPost(url);
        post.setHeader("Content-Type", "application/json");
        if (headers != null) {
            for (Map.Entry<String, String> header : headers.entrySet()) {
                post.setHeader(header.getKey(), header.getValue());
            }
        }
        post.setEntity(new StringEntity(jsonInputString));
        return executeRequest(post);
    }
    // 执行请求并返回响应
    private static String executeRequest(org.apache.http.client.methods.HttpUriRequest request) throws IOException {
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();
            return entity != null ? EntityUtils.toString(entity) : null;
        }
    }

    // 发送 POST 请求
    public static String sendPost(String url, Map<String, String> headers, Object object) {
        HttpPost post = new HttpPost(url);
        post.setHeader("Content-Type", "application/json");
        if (headers != null) {
            for (Map.Entry<String, String> header : headers.entrySet()) {
                post.setHeader(header.getKey(), header.getValue());
            }
        }
        String jsonInputString = JSON.toJSONString(object);
        try {
            post.setEntity(new StringEntity(jsonInputString));
            return executeRequest(post);
        }catch (Exception e) {

        }
        return null;
    }
}
