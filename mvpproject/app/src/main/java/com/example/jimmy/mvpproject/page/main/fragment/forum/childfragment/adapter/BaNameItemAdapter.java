package com.example.jimmy.mvpproject.page.main.fragment.forum.childfragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jimmy.mvpproject.R;
import com.example.jimmy.mvpproject.model.Forum;

import java.util.List;

/**
 * gridview 选项适配器
 *
 * @author Jimmy
 */
public class BaNameItemAdapter extends BaseAdapter
{

    private Context context;

    private List<Forum> forumList;

    private ViewHolder viewHolder;

    private Boolean longClick = false;

    public BaNameItemAdapter(Context context, List<Forum> forumList)
    {
        this.context = context;
        this.forumList = forumList;
    }

    @Override
    public int getCount()
    {
        return forumList.size();
    }

    @Override
    public Object getItem(int position)
    {
        return forumList.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if (convertView == null)
        {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.item_ba_name, null);
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.tv_name);
            viewHolder.ivLevel = (ImageView) convertView.findViewById(R.id.iv_level);
            viewHolder.ivQuit = (ImageView) convertView.findViewById(R.id.iv_quit_ba);
            convertView.setTag(viewHolder);
        } else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tvName.setText(forumList.get(position).getName());
        viewHolder.ivLevel.setImageResource(R.mipmap.icon_grade_lv1);

        if (longClick)
        {
            viewHolder.ivQuit.setVisibility(View.VISIBLE);
        } else
        {
            viewHolder.ivQuit.setVisibility(View.GONE);
        }

        return convertView;
    }

    public void setLongClick(Boolean longClick)
    {
        this.longClick = longClick;
    }

    private class ViewHolder
    {
        public TextView tvName;

        public ImageView ivLevel;

        public ImageView ivQuit;
    }
}
