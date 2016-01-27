package com.example.jimmy.mvpproject.page.main.fragment.home.childfragment;


import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.jimmy.mvpproject.R;
import com.example.jimmy.mvpproject.widget.ContentLoading;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 内涵笑话
 *
 * @author Jimmy
 */
public class JokeFragment extends Fragment
{
    //加载动画类
    private ContentLoading contentLoading;

    private Handler handler = new Handler()
    {
        @Override
        public void handleMessage(Message msg)
        {
            super.handleMessage(msg);
            contentLoading.showContent();
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_joke, container, false);
        ButterKnife.bind(this, view);
        contentLoading = new ContentLoading(view);

        contentLoading.showLoading();

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(5000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                handler.sendEmptyMessage(0);
            }
        }).start();

        return view;
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
