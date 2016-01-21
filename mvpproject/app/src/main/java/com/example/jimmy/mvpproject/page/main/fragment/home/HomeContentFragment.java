package com.example.jimmy.mvpproject.page.main.fragment.home;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
 * 首页子项内容
 *
 * @author jimmy
 */
public class HomeContentFragment extends Fragment
{

    @Bind(R.id.slv_content)
    SwipeRefreshListView slvContent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        ButterKnife.bind(this, view);
        init();
        return view;
    }

    private void init()
    {
        slvContent.setPullLoadEnable(true);
        slvContent.setPullRefreshEnable(true);

        List<String> stringList = new ArrayList<>();
        for(int i = 0; i < 20; i++)
        {
            stringList.add("测试");
        }

        slvContent.setAdapter(new CommonAdapter<String>(getActivity(),stringList,R.layout.item_content)
        {
            @Override
            public void convert(ViewHolder holder, String item, int position)
            {

            }
        });
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
