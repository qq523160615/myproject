package com.example.jimmy.mvpproject.utils.http;




import com.example.jimmy.mvpproject.utils.core.BaseComponent;

import java.util.Map;

/**
 * 网络连接管理抽象类
 *
 * @author Devin
 */
public abstract class BaseHttpProcesser extends BaseComponent
{
    private BaseHttpEngine baseHttpEngine;
    private String oldUrl;

    private HttpResponse baseHttpResponse;
    private com.example.jimmy.mvpproject.utils.http.HttpRequest baseHttpRequest;

    public void init(String baseUrl, String secretKey, boolean isLog, int timeOut)
    {
        setIsExtends(true);
//        /**-------通过反射获取操作类对象*********/
//        try
//        {
//            String str = ComponentEngine.getInstance(BaseHttpEngine.class).getClass().getName();
//            Class<?> clazz = Class.forName(str);
//            this.oldUrl = baseUrl;
//            Constructor constructor = clazz.getConstructor(String.class, String.class, boolean.class, int.class);
//            baseHttpEngine = (BaseHttpEngine) constructor.newInstance
//                    (baseUrl, secretKey, isLog, timeOut);
//        }
//        catch (Exception e)
//        {
//            Log.e("HttpEngine", "Http处理类初始化错误，请检查配置文件！");
//        }
        baseHttpEngine = new HttpClientResponse(baseUrl,secretKey,isLog,timeOut);

    }

    /**
     * 网络请求
     *
     * @param serviceName 服务器接口
     * @param params      参数
     * @return 网络回馈
     * @throws FHttpException
     */
    public BaseHttpResponse request(final String serviceName, final Map<String, Object> params) throws FHttpException
    {
        if (baseHttpResponse == null)
        {
            baseHttpResponse = new HttpResponse();
        }
        if (baseHttpRequest == null)
        {
            baseHttpRequest = new HttpRequest();
        }
        return baseHttpEngine.request(serviceName, params, baseHttpResponse, baseHttpRequest);
    }

    public void setUrl(String url)
    {
        baseHttpEngine.setBaseUrl(oldUrl + "?" + url);
    }

    public String getUrl()
    {
        return baseHttpEngine.getBaseUrl();
    }

    public BaseHttpResponse getBaseHttpResponse()
    {
        return baseHttpResponse;
    }

    public void setBaseHttpResponse(HttpResponse baseHttpResponse)
    {
        this.baseHttpResponse = baseHttpResponse;
    }

    public HttpRequest getBaseHttpRequest()
    {
        return baseHttpRequest;
    }

    public void setBaseHttpRequest(HttpRequest baseHttpRequest)
    {
        this.baseHttpRequest = baseHttpRequest;
    }
}
