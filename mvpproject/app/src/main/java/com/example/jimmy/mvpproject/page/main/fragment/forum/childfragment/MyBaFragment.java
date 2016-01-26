package com.example.jimmy.mvpproject.page.main.fragment.forum.childfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.jimmy.mvpproject.R;
import com.example.jimmy.mvpproject.widget.CommonAdapter;
import com.example.jimmy.mvpproject.widget.ToastHelper;
import com.example.jimmy.mvpproject.widget.ViewHolder;
import com.lzh.pulltorefresh.MyAdapter;
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
public class MyBaFragment extends Fragment
{
    @Bind(R.id.content_view)
    GridView gridView;

    private View convertView;

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
     * GridView��ʼ������
     */
    private void initGridView()
    {
        List<String> items = new ArrayList<String>();
        for (int i = 0; i < 30; i++)
        {
            items.add("gridview item " + i);
        }
        gridView.setAdapter(new CommonAdapter<String>(getActivity(), items, R.layout.item_ba_name)
        {
            @Override
            public void convert(ViewHolder holder, String item, int position)
            {
                convertView = holder.getConvertView();
            }
        });
        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           int position, long id)
            {
                Log.e("onItemLong", "onItemLong");
                ImageView ivQuit = (ImageView) convertView.findViewById(R.id.iv_quit_ba);
                ivQuit.setVisibility(View.VISIBLE);
                return true;
            }
        });
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id)
            {
                Toast.makeText(getActivity(),
                        " Click on " + parent.getAdapter().getItemId(position),
                        Toast.LENGTH_SHORT).show();
            }
        });
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
}
