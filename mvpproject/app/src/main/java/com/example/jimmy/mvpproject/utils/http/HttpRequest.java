package com.example.jimmy.mvpproject.utils.http;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * Response
 *
 * @author kutzhang@gmail.com
 */
public class HttpRequest extends BaseHttpRequest implements Serializable
{
    // 服务名
    @JSONField(name = "service")
    private String serviceName;

    //accessToken
    @JSONField(name="access_token")
    private String accessToken;

    public String getServiceName()
    {
        return serviceName;
    }

    public void setServiceName(String serviceName)
    {
        this.serviceName = serviceName;
    }

    public String getAccessToken()
    {
        return accessToken;
    }

    public void setAccessToken(String accessToken)
    {
        this.accessToken = accessToken;
    }
}
