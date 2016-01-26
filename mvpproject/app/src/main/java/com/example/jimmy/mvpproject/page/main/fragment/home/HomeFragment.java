package com.example.jimmy.mvpproject.page.main.fragment.home;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.jimmy.mvpproject.R;
import com.example.jimmy.mvpproject.page.main.fragment.home.adapter.TabFragmentAdapter;
import com.example.jimmy.mvpproject.page.main.fragment.home.childfragment.HomeContentFragment;
import com.example.jimmy.mvpproject.page.main.fragment.home.popwindow.TransformPop;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Jimmy
 */
public class HomeFragment extends Fragment
{

    private String[] titles = new String[]{"推荐", "内涵笑话", "娱乐八卦", "秀男秀女", "福利专区", "直播", "文字控", "神奇圈子"};

    private TransformPop transformPop;

    @Bind(R.id.tablayout)
    TabLayout tablayout;
    @Bind(R.id.viewPager)
    ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);

        List<android.support.v4.app.Fragment> fragments = new ArrayList<android.support.v4.app.Fragment>();
        for (int i = 0; i < titles.length; i++)
        {
            android.support.v4.app.Fragment fragment = new HomeContentFragment();
            fragments.add(fragment);
        }

        viewPager.setAdapter(new TabFragmentAdapter(fragments, titles, getChildFragmentManager(), getActivity()));
        tablayout.setupWithViewPager(viewPager);

        return view;
    }


    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    @OnClick(R.id.ll_transform)
    public void transform(View view)
    {
        if (transformPop != null)
        {
            transformPop.showTransformPop();
        } else
        {
            transformPop = new TransformPop(getActivity(), view, stringsToList(titles), viewPager);
            transformPop.showTransformPop();
        }
    }

    private List<String> stringsToList(String[] strings)
    {
        List<String> stringList = new ArrayList<>();
        for (String string : strings)
        {
            stringList.add(string);
        }
        return stringList;
    }

}
