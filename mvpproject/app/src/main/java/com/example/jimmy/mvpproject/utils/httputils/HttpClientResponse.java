package com.example.jimmy.mvpproject.utils.httputils;

import android.util.Log;

import com.alibaba.fastjson.JSON;


import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.jimmy.mvpproject.utils.core.ComponentEngine;


import com.example.jimmy.mvpproject.utils.http.BaseHttpEngine;
import com.example.jimmy.mvpproject.utils.http.BaseHttpRequest;
import com.example.jimmy.mvpproject.utils.http.BaseHttpResponse;
import com.example.jimmy.mvpproject.utils.http.Encryptor;
import com.example.jimmy.mvpproject.utils.http.FHttpException;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;


import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * HttpClient网络请求操作类
 *
 * @author Jimmy
 */
public class HttpClientResponse extends BaseHttpEngine
{
    // Http Client
    private OkHttpClient okHttpClient;

    public HttpClientResponse()
    {

    }

    /**
     * 构造函数
     *
     * @param baseUrl   基础API服务地址
     * @param secretKey 加密KEY
     * @param isLog     是否打印log信息
     * @param timeout   设置超时时间
     */
    public HttpClientResponse(String baseUrl, String secretKey, boolean isLog, int timeout)
    {
        super(baseUrl, secretKey, isLog, timeout);
        this.okHttpClient = new OkHttpClient();

        okHttpClient.setConnectTimeout(timeout, TimeUnit.SECONDS);
        okHttpClient.setReadTimeout(timeout, TimeUnit.SECONDS);
    }

    /**
     * 网络请求
     *
     * @param serviceName      服务器接口名
     * @param params           参数
     * @param baseHttpResponse 要发送的分装类
     * @param baseHttpRequest  要返回的分装类
     */
    @Override
    public BaseHttpResponse request(String serviceName, Map<String, Object> params, BaseHttpResponse baseHttpResponse, BaseHttpRequest baseHttpRequest) throws FHttpException
    {
        Encryptor encryptor = (Encryptor) ComponentEngine.getInstance(Encryptor.class);
        baseHttpRequest = this.getRequest(params, baseHttpRequest);

        String debugMessage = JSON.toJSONString(baseHttpRequest, true);
        if (isLog)
        {
            Log.d("ApiEngine", String.format("request -> %s\n%s", serviceName, debugMessage));
        }


        byte[] jsonBytes = JSON.toJSONBytes(baseHttpRequest, new SerializerFeature[0]);
        byte[] encodedBytes =
                secretKey == null ? jsonBytes : encryptor.encode(jsonBytes, secretKey);

        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString(baseHttpRequest));

        final Request request = new Request.Builder()
                .url(baseUrl)
                .post(body)
                .build();

        try
        {
            Response response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful())
            {
                String responseString = null;
                try
                {
                    responseString = response.body().string();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
                if (isLog)
                {
                    Log.d("ApiEngine", String.format(
                            "response string -> %s\n%s", serviceName, responseString
                    ));
                }

                //       baseHttpResponse = JSON.parseObject(responseBytes, baseHttpResponse.getClass());
                baseHttpResponse = JSON.parseObject(responseString.getBytes(), baseHttpResponse.getClass(), new Feature[0]);

                String debugMessageResponse = JSON.toJSONString(baseHttpResponse, true);
                if (isLog)
                {
                    Log.d("ApiEngine", String.format("response -> %s\n%s", serviceName, debugMessageResponse));
                }
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return baseHttpResponse;
    }


}
