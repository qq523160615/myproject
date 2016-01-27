package com.example.jimmy.mvpproject.widget;

import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.jimmy.mvpproject.R;

/**
 * 内容加载loading
 *
 * @author Jimmy
 */
public class ContentLoading
{
    //加载动画
    private ImageView ivLoading;

    //加载中布局
    private LinearLayout llLoading;

    //内容布局
    private LinearLayout llContent;

    private AnimationDrawable animationDrawable;

    public ContentLoading(View view)
    {
        ivLoading = (ImageView) view.findViewById(R.id.iv_loading);
        llLoading = (LinearLayout) view.findViewById(R.id.ll_loading);
        llContent = (LinearLayout) view.findViewById(R.id.ll_content);
    }

    public void showLoading()
    {
        ivLoading.setImageResource(R.drawable.animation);
        animationDrawable = (AnimationDrawable) ivLoading.getDrawable();
        animationDrawable.setOneShot(false);
        animationDrawable.start();
    }

    public void showContent()
    {
        animationDrawable.stop();
        llLoading.setVisibility(View.GONE);
        llContent.setVisibility(View.VISIBLE);
    }
}
