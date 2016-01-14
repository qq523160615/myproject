package com.example.jimmy.mvpproject.utils.http;

import android.util.Log;

import com.example.jimmy.mvpproject.utils.core.Config;

import java.util.Map;

/**
 * Created by jimmy on 16/1/14.
 */
public class ApiEngine extends BaseHttpProcesser
{
    //服务器地址
    @Config("http.base_url")
    private String baseUrl;

    //是否打印Log
    @Config("http.is_log")
    private boolean isLog;

    //超时
    @Config("http.time_out")
    private int timeOut;

    public ApiEngine()
    {
        Log.e("baseurl",baseUrl);
        init(baseUrl, null, isLog, timeOut);
    }

    @Override
    public HttpResponse request(String serviceName, Map<String, Object> params) throws FHttpException
    {
        //接收数据的实体类
        HttpResponse httpResponse=new HttpResponse();
        setBaseHttpResponse(httpResponse);

        //发送数据的实体类
        HttpRequest httpRequest=new HttpRequest();
        httpRequest.setServiceName(serviceName);
        setBaseHttpRequest(httpRequest);
        httpResponse = (HttpResponse) super.request(serviceName, params);
        return httpResponse;
    }
}
