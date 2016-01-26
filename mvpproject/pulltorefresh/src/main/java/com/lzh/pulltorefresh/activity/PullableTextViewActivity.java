package com.lzh.pulltorefresh.activity;

import android.app.Activity;
import android.os.Bundle;

import com.lzh.pulltorefresh.MyListener;
import com.lzh.pulltorefresh.PullToRefreshLayout;
import com.lzh.pulltorefresh.R;


public class PullableTextViewActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textview);
        ((PullToRefreshLayout) findViewById(R.id.refresh_view))
                .setOnRefreshListener(new MyListener());
    }
}
