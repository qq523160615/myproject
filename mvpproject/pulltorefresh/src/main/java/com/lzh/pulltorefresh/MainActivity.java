package com.lzh.pulltorefresh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.Toast;


import com.lzh.pulltorefresh.activity.PullableExpandableListViewActivity;
import com.lzh.pulltorefresh.activity.PullableGridViewActivity;
import com.lzh.pulltorefresh.activity.PullableImageViewActivity;
import com.lzh.pulltorefresh.activity.PullableListViewActivity;
import com.lzh.pulltorefresh.activity.PullableScrollViewActivity;
import com.lzh.pulltorefresh.activity.PullableTextViewActivity;
import com.lzh.pulltorefresh.activity.PullableWebViewActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * ������������http://blog.csdn.net/zhongkejingwang/article/details/38868463
 * 
 * @author �¾�
 * 
 */
public class MainActivity extends Activity
{
	private ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
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
		items.add("������ˢ���������ص�ListView");
		items.add("������ˢ���������ص�GridView");
		items.add("������ˢ���������ص�ExpandableListView");
		items.add("������ˢ���������ص�SrcollView");
		items.add("������ˢ���������ص�WebView");
		items.add("������ˢ���������ص�ImageView");
		items.add("������ˢ���������ص�TextView");
		MyAdapter adapter = new MyAdapter(this, items);
		listView.setAdapter(adapter);
		listView.setOnItemLongClickListener(new OnItemLongClickListener()
		{

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id)
			{
				Toast.makeText(
						MainActivity.this,
						" LongClick on "
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

				Intent it = new Intent();
				switch (position)
				{
				case 0:
					it.setClass(MainActivity.this,
							PullableListViewActivity.class);
					break;
				case 1:
					it.setClass(MainActivity.this,
							PullableGridViewActivity.class);
					break;
				case 2:
					it.setClass(MainActivity.this,
							PullableExpandableListViewActivity.class);
					break;
				case 3:
					it.setClass(MainActivity.this,
							PullableScrollViewActivity.class);
					break;
				case 4:
					it.setClass(MainActivity.this,
							PullableWebViewActivity.class);
					break;
				case 5:
					it.setClass(MainActivity.this,
							PullableImageViewActivity.class);
					break;
				case 6:
					it.setClass(MainActivity.this,
							PullableTextViewActivity.class);
					break;

				default:
					break;
				}
				startActivity(it);
			}
		});
	}
}
