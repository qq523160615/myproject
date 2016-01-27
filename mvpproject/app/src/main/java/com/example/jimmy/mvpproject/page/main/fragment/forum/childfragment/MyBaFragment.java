package com.example.jimmy.mvpproject.page.main.fragment.forum.childfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.jimmy.mvpproject.R;
import com.example.jimmy.mvpproject.model.Forum;
import com.example.jimmy.mvpproject.page.main.fragment.forum.childfragment.adapter.BaNameItemAdapter;
import com.example.jimmy.mvpproject.widget.ToastHelper;
import com.lzh.pulltorefresh.MyListener;
import com.lzh.pulltorefresh.PullToRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的吧
 *
 * @author Jimmy
 */
public class MyBaFragment extends Fragment implements AdapterView.OnItemClickListener
{
    @Bind(R.id.content_view)
    GridView gridView;

    private View convertView;

    private BaNameItemAdapter baNameItemAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_my_ba, container, false);
        ButterKnife.bind(this, view);
        init(view);
        return view;
    }


    public void init(View view)
    {
        ((PullToRefreshLayout) view.findViewById(com.lzh.pulltorefresh.R.id.refresh_view))
                .setOnRefreshListener(new MyListener());
        initGridView();
    }

    /**
     * GridView初始化
     */
    private void initGridView()
    {
        List<Forum> items = new ArrayList<Forum>();
        for (int i = 0; i < 30; i++)
        {
            Forum forum = new Forum();
            forum.setName("海贼王" + i);
            forum.setLevel(i);
            items.add(forum);
        }
        baNameItemAdapter = new BaNameItemAdapter(getActivity(), items);
        gridView.setAdapter(baNameItemAdapter);
        gridView.setOnItemClickListener(this);
    }

    @OnClick(R.id.ll_search)
    public void search(View view)
    {
        ToastHelper.getInstance(getActivity()).longShowMessage("搜索");
    }


    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        baNameItemAdapter.setLongClick(true);
        baNameItemAdapter.notifyDataSetChanged();

        ToastHelper.getInstance(getActivity()).longShowMessage("长按");
    }
}
