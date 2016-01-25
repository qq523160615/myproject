package com.example.jimmy.mvpproject.app;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * application初始化
 *
 * @author Jimmy
 */
public class App extends BaseApplication
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        Fresco.initialize(this);
    }
}
