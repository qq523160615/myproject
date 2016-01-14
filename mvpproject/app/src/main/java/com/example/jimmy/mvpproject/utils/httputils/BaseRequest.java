package com.example.jimmy.mvpproject.utils.httputils;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by jimmy on 16/1/14.
 */
public class BaseRequest implements Serializable
{
    @JSONField(
            name = "os"
    )
    private String os;
    @JSONField(
            name = "os_version"
    )
    private String osVersion;
    @JSONField(
            name = "app_name"
    )
    private String appName;
    @JSONField(
            name = "app_version"
    )
    private String appVersion;
    @JSONField(
            name = "udid"
    )
    private String udid;

    @JSONField(
            name = "params"
    )
    private Map<String, Object> params;

    public BaseRequest()
    {
        init();
    }

    private void init()
    {
        setOs("Android");
        setAppName("test");
        setOsVersion("5.0.1");
        setAppVersion("1.0");
        setUdid("1511351351351");
    }

    public String getOs()
    {
        return os;
    }

    public void setOs(String os)
    {
        this.os = os;
    }

    public String getOsVersion()
    {
        return osVersion;
    }

    public void setOsVersion(String osVersion)
    {
        this.osVersion = osVersion;
    }

    public String getAppName()
    {
        return appName;
    }

    public void setAppName(String appName)
    {
        this.appName = appName;
    }

    public String getAppVersion()
    {
        return appVersion;
    }

    public void setAppVersion(String appVersion)
    {
        this.appVersion = appVersion;
    }

    public String getUdid()
    {
        return udid;
    }

    public void setUdid(String udid)
    {
        this.udid = udid;
    }

    public Map<String, Object> getParams()
    {
        return params;
    }

    public void setParams(Map<String, Object> params)
    {
        this.params = params;
    }
}
