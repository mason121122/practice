package com.practice.web.test;

import com.practice.model.result.ReturnResult;
import io.swagger.models.HttpMethod;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @author Mark Wang
 * @date 2021/11/27
 */
public class HttpClientDemo {
    public static final int connectionRequestTimeout = 2 * 1000;
    public static final int connectTimeout = 3 * 1000;
    public static final int socketTimeOut = 10 * 1000;

    public static HttpClient httpClient = createHttpClient();

    private static HttpClient createHttpClient() {
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(connectionRequestTimeout)
                .setConnectTimeout(connectTimeout)
                .setSocketTimeout(socketTimeOut)
                .build();

        return HttpClients.custom()
                .setDefaultRequestConfig(requestConfig)
                .setMaxConnTotal(5)
                .setMaxConnPerRoute(2)
                .build();
    }

    public static void main(String[] args) {
        String url = "https://www.baidu.com/";
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-Type", "application/json");
        httpPost.setHeader("Accept", "application/json");
//        httpPost.setEntity(new StringEntity(requestBody, ENCODING_CHARSET_UTF8));
        try {
            while (true){
                Thread.sleep(100);
                HttpResponse httpResponse = httpClient.execute(httpPost);
                HttpEntity httpEntity = httpResponse.getEntity();
                String content = EntityUtils.toString(httpEntity, "UTF-8");
                System.out.println(content);
            }
//            return new ReturnResult<>(httpResponse.getStatusLine().getStatusCode(), "", content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
