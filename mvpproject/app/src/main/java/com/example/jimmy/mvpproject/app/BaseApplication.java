package com.example.jimmy.mvpproject.app;

import android.app.Application;

import com.example.jimmy.mvpproject.utils.core.ComponentEngine;


/**
 * Base Application
 *
 * @author kutzhang@gmail.com
 */
public abstract class BaseApplication extends Application
{
    private static Application application;

    /**
     * 获取当前应用实例
     *
     * @param clazz 类
     * @param <T>   类型
     * @return 当前应用实例
     */
    @SuppressWarnings("unchecked")
    public static <T extends BaseApplication> T getApplication(Class<T> clazz)
    {
        if (application == null)
        {
            throw new RuntimeException("Application has not initialized.");
        }

        return (T) application;
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
        application = this;
        ComponentEngine.init(this);
        ComponentEngine.initialLoad(this);
    }
}
