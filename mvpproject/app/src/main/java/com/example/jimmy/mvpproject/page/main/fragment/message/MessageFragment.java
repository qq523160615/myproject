package com.example.jimmy.mvpproject.page.main.fragment.message;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jimmy.mvpproject.R;
import com.example.jimmy.mvpproject.page.main.MainActivity;
import com.example.jimmy.mvpproject.page.main.fragment.home.adapter.TabFragmentAdapter;
import com.example.jimmy.mvpproject.page.main.fragment.home.childfragment.HomeContentFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 消息
 *
 * @author Jimmy
 */
public class MessageFragment extends Fragment
{
    @Bind(R.id.tablayout)
    TabLayout tablayout;
    @Bind(R.id.viewPager)
    ViewPager viewPager;

    private String[] titles = new String[]{"聊天", "回复", "@我"};

    private String[] className = new String[]{"ChatFragment", "ReplyFragment", "AtMeFragment"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        ButterKnife.bind(this, view);
        initFragment();
        return view;
    }

    /**
     * 初始化fragment
     */
    private void initFragment()
    {
        String packageName = getActivity().getPackageName() + ".page.main.fragment.message.childfragment.";

        List<android.support.v4.app.Fragment> fragments = new ArrayList<android.support.v4.app.Fragment>();
        for (int i = 0; i < titles.length; i++)
        {
            android.support.v4.app.Fragment fragment = Fragment.instantiate(getActivity(), packageName + className[i]);
            fragments.add(fragment);
        }

        viewPager.setAdapter(new com.example.jimmy.mvpproject.page.main.fragment.home.adapter.TabFragmentAdapter(fragments, titles, getChildFragmentManager(), getActivity()));
        tablayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
