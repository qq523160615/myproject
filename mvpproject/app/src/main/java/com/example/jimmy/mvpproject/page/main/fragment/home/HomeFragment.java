package com.example.jimmy.mvpproject.page.main.fragment.home;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;

import com.example.jimmy.mvpproject.R;
import com.example.jimmy.mvpproject.page.main.MainActivity;
import com.example.jimmy.mvpproject.page.main.fragment.home.adapter.FragmentPagerAdapter;
import com.example.jimmy.mvpproject.widget.CommonAdapter;
import com.example.jimmy.mvpproject.widget.HorizontialListView;
import com.example.jimmy.mvpproject.widget.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author Jimmy
 */
public class HomeFragment extends Fragment implements ViewPager.OnPageChangeListener
{
    //viewpager中子界面列表
    private ArrayList<android.support.v4.app.Fragment> fragmentList;

    @Bind(R.id.vp_content)
    ViewPager vgContent;

    private BaseAdapter hlAdapter;

    private int selected = 0;

    @Bind(R.id.hl_items)
    HorizontialListView hlItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        init();
        initViewPager();
        return view;
    }


    private void initViewPager()
    {
        //添加fragment
        fragmentList = new ArrayList<android.support.v4.app.Fragment>();
        for (int i = 0; i < 10; i++)
        {
            fragmentList.add(new HomeContentFragment());
        }
        vgContent.setAdapter(new FragmentPagerAdapter(MainActivity.fm, fragmentList));
        vgContent.setOnPageChangeListener(this);
    }

    private void init()
    {
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 10; i++)
        {
            stringList.add("测试" + i);
        }


        hlItems.setAdapter(hlAdapter = new CommonAdapter<String>(getActivity(), stringList, R.layout.item_home_items)
        {
            @Override
            public void convert(ViewHolder holder, String item, int position)
            {
                holder.setText(R.id.tv_item, item);
                if (selected == position)
                {
                    holder.setBackgroundColor(R.id.view_down, getResources().getColor(R.color.accent_material_dark));
                } else
                {
                    holder.setBackgroundColor(R.id.view_down, getResources().getColor(R.color.material_blue_grey_800));
                }
            }
        });

        hlItems.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                selected = position;
                Log.e("position", position + "");
                vgContent.setCurrentItem(position,false);
                hlAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
    {

    }

    @Override
    public void onPageSelected(int position)
    {
        selected = position;
        hlItems.setSelection(position);
        hlAdapter.notifyDataSetChanged();
        Log.e("pageSelected", position + "");
    }

    @Override
    public void onPageScrollStateChanged(int state)
    {

    }
}
