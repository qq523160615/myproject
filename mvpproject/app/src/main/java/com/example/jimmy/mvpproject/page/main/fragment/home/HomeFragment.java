package com.example.jimmy.mvpproject.page.main.fragment.home;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jimmy.mvpproject.R;
import com.example.jimmy.mvpproject.page.main.MainActivity;
import com.example.jimmy.mvpproject.page.main.fragment.home.adapter.TabFragmentAdapter;
import com.example.jimmy.mvpproject.page.main.fragment.home.childfragment.HomeContentFragment;
import com.example.jimmy.mvpproject.widget.ToastHelper;

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

    private String[] titles = new String[]{"推荐dfdfd", "热点df", "赣州dfd", "社会dfdfdfdf", "订阅dfdf", "娱乐", "科技", "汽车", "体育", "财经", "美女"};

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
            Bundle bundle = new Bundle();
            bundle.putString("text", titles[i]);
            fragment.setArguments(bundle);
            fragments.add(fragment);
        }
        viewPager.setAdapter(new TabFragmentAdapter(fragments, titles, MainActivity.fm, getActivity()));
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
        ToastHelper.getInstance(getActivity()).longShowMessage("切换");
    }

}
