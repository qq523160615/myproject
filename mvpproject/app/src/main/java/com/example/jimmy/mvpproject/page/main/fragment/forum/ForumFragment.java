package com.example.jimmy.mvpproject.page.main.fragment.forum;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jimmy.mvpproject.R;
import com.example.jimmy.mvpproject.page.main.fragment.forum.adapter.TabFragmentAdapter;
import com.example.jimmy.mvpproject.page.main.fragment.forum.childfragment.MyBaFragment;
import com.example.jimmy.mvpproject.page.main.fragment.home.childfragment.HomeContentFragment;


import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * 进吧
 *
 * @author Jimmy
 */
public class ForumFragment extends Fragment
{

    @Bind(R.id.tablayout)
    TabLayout tablayout;
    @Bind(R.id.viewPager)
    ViewPager viewPager;

    private String[] titles = new String[]{"我的吧", "吧推荐"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_forum, container, false);
        ButterKnife.bind(this, view);


        List<android.support.v4.app.Fragment> fragments = new ArrayList<android.support.v4.app.Fragment>();
        for (int i = 0; i < titles.length; i++)
        {
            android.support.v4.app.Fragment fragment = new MyBaFragment();
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
}
