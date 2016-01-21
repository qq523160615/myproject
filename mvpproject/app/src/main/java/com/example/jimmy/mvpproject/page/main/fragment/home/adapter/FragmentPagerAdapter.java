package com.example.jimmy.mvpproject.page.main.fragment.home.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * viewPager适配器
 *
 * @author Jimmy
 */
public class FragmentPagerAdapter extends FragmentStatePagerAdapter
{


    ArrayList<Fragment> fragmentArrayList;


    public FragmentPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragmentArrayList)
    {
        super(fm);
        this.fragmentArrayList = fragmentArrayList;

    }


    @Override
    public int getCount()
    {
        return fragmentArrayList.size();
    }

    @Override
    public Fragment getItem(int arg0)
    {
        return fragmentArrayList.get(arg0);
    }
}
