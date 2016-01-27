package com.example.jimmy.mvpproject.page.main.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;

import com.example.jimmy.mvpproject.R;
import com.example.jimmy.mvpproject.widget.PullScrollView;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * 我的
 *
 * @author Jimmy
 */
public class MineFragment extends Fragment implements PullScrollView.MoveUpListener
{
    @Bind(R.id.iv_pull_img)
    ImageView ivPullImg;

    @Bind(R.id.ll_bar)
    LinearLayout llBar;

    @Bind(R.id.pb_item_head)
    ProgressBar pbItemHead;

    @Bind(R.id.ll_loading)
    LinearLayout llLoading;

    @Bind(R.id.ps_scroll_view)
    PullScrollView scrollView;

    private Handler handler = new Handler()
    {
        @Override
        public void handleMessage(Message msg)
        {
            super.handleMessage(msg);
            llLoading.setVisibility(View.GONE);
            llBar.setVisibility(View.VISIBLE);
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        ButterKnife.bind(this, view);

        scrollView.setMoveUpListener(this);

        return view;
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void moveUp()
    {
        llLoading.setVisibility(View.VISIBLE);
        llBar.setVisibility(View.GONE);

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(3000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                handler.sendEmptyMessage(0);
            }
        }).start();
    }
}
