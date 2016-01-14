package com.example.jimmy.mvpproject.utils.http;



import com.example.jimmy.mvpproject.utils.core.BaseComponent;
import com.example.jimmy.mvpproject.utils.core.ComponentEngine;
import com.example.jimmy.mvpproject.utils.httputils.*;


import java.util.Map;

/**
 * 网络连接抽象类
 *
 * @author Devin
 */
public abstract class BaseHttpEngine extends BaseComponent
{
    //加密KEY
    protected String secretKey;

    //是否打印log信息
    protected boolean isLog;

    //网络地址
    protected String baseUrl;

    protected BaseHttpEngine()
    {

    }

    /**
     * 构造函数
     *
     * @param baseUrl   基础API服务地址
     * @param secretKey 加密KEY
     * @param isLog     是否打印log信息
     * @param timeOut   是否超时
     */
    protected BaseHttpEngine(String baseUrl, String secretKey, boolean isLog, int timeOut)
    {
        this.baseUrl = baseUrl;
        this.secretKey = secretKey;
        this.isLog = isLog;
    }

    /**
     * 分装网络请求数据
     *
     * @param params      参数
     * @param baseHttpRequest 要返回的格式
     * @return 分装类
     */
    protected HttpRequest getRequest(Map<String, Object> params,HttpRequest baseHttpRequest)
    {
        Environment environment = (Environment) ComponentEngine.getInstance(Environment.class);
        baseHttpRequest.setOs(environment.getOs());
        baseHttpRequest.setOsVersion(environment.getOsVersion());
        baseHttpRequest.setAppName(environment.getAppName());
        baseHttpRequest.setAppVersion(environment.getAppVersion());
        baseHttpRequest.setUdid(environment.getUdid());
        baseHttpRequest.setParams(params);
        return baseHttpRequest;
    }

    /**
     * 网络请求结果
     *
     * @param serviceName 服务器接口名
     * @param params      参数
     * @param baseHttpResponse 要发送的分装类
     * @param baseHttpRequest 要返回的分装类
     */
    public abstract HttpResponse request(String serviceName, Map<String, Object> params,HttpResponse baseHttpResponse, HttpRequest baseHttpRequest) throws FHttpException;

    public String getSecretKey()
    {
        return secretKey;
    }

    public void setSecretKey(String secretKey)
    {
        this.secretKey = secretKey;
    }

    public boolean isLog()
    {
        return isLog;
    }

    public void setIsLog(boolean isLog)
    {
        this.isLog = isLog;
    }

    public String getBaseUrl()
    {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl)
    {
        this.baseUrl = baseUrl;
    }
}
