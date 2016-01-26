package com.example.jimmy.mvpproject.page.main.fragment.home.childfragment;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.jimmy.mvpproject.R;
import com.example.jimmy.mvpproject.widget.CommonAdapter;
import com.example.jimmy.mvpproject.widget.SwipeRefresh.SwipeRefreshListView;
import com.example.jimmy.mvpproject.widget.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 推荐
 *
 * @author jimmy
 */
public class HomeContentFragment extends Fragment implements SwipeRefreshListView.IXListViewListener
{

    @Bind(R.id.slv_content)
    SwipeRefreshListView slvContent;

    private Handler handler = new Handler()
    {
        @Override
        public void handleMessage(Message msg)
        {
            super.handleMessage(msg);
            slvContent.stopLoadMore();
            slvContent.stopRefresh();
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        ButterKnife.bind(this, view);
        init();
        Log.e("标志", "onCreateView");
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Log.e("标志", "onCreate");
    }

    @Override
    public void onResume()
    {
        super.onResume();
        Log.e("标志", "onResume");
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        Log.e("标志", "onDestroy");
    }

    private void init()
    {
        slvContent.setPullLoadEnable(false);
        slvContent.setPullRefreshEnable(true);

        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 20; i++)
        {
            stringList.add("测试");
        }

        slvContent.setAdapter(new CommonAdapter<String>(getActivity(), stringList, R.layout.item_content)
        {
            @Override
            public void convert(ViewHolder holder, String item, int position)
            {

            }
        });

        slvContent.setXListViewListener(this);
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onRefresh()
    {
        Log.e("Home", "onRefresh");
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(1000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                handler.sendEmptyMessage(0);
            }
        }).start();
    }

    @Override
    public void onLoadMore()
    {
        Log.e("Home", "onLoadMore");
    }

    @Override
    public void onNetworkErrorRefresh()
    {
        Log.e("Home", "onNetworkErrorRefresh");
    }
}
