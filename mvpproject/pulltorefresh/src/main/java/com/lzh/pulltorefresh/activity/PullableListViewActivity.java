package com.lzh.pulltorefresh.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.Toast;


import com.lzh.pulltorefresh.MyAdapter;
import com.lzh.pulltorefresh.MyListener;
import com.lzh.pulltorefresh.PullToRefreshLayout;
import com.lzh.pulltorefresh.R;

import java.util.ArrayList;
import java.util.List;


public class PullableListViewActivity extends Activity
{
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        ((PullToRefreshLayout) findViewById(R.id.refresh_view))
                .setOnRefreshListener(new MyListener());
        listView = (ListView) findViewById(R.id.content_view);
        initListView();
    }

    /**
     * ListView��ʼ������
     */
    private void initListView()
    {
        List<String> items = new ArrayList<String>();
        for (int i = 0; i < 30; i++)
        {
            items.add("������item " + i);
        }
        MyAdapter adapter = new MyAdapter(this, items);
        listView.setAdapter(adapter);
        listView.setOnItemLongClickListener(new OnItemLongClickListener()
        {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           int position, long id)
            {
                Toast.makeText(
                        PullableListViewActivity.this,
                        "LongClick on "
                                + parent.getAdapter().getItemId(position),
                        Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        listView.setOnItemClickListener(new OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id)
            {
                Toast.makeText(PullableListViewActivity.this,
                        " Click on " + parent.getAdapter().getItemId(position),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

}