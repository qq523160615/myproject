package com.example.jimmy.mvpproject.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by jimmy on 16/1/19.
 */
public abstract class CommonAdapter<T> extends BaseAdapter
{
    protected LayoutInflater layoutInflater;
    protected Context context;
    protected List<T> datas;
    protected final int itemLayoutId;

    public CommonAdapter(Context context, List<T> datas,int itemLayoutId)
    {
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.datas = datas;
        this.itemLayoutId = itemLayoutId;
    }

    @Override
    public int getCount()
    {
        return datas.size();
    }

    @Override
    public T getItem(int position)
    {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        final ViewHolder viewHolder = getViewHolder(position,convertView,parent);
        convert(viewHolder,getItem(position));
        return viewHolder.getConvertView();
    }

    public abstract void convert(ViewHolder holder,T item);

    private ViewHolder getViewHolder(int position,View convertView,ViewGroup parent)
    {
        return ViewHolder.get(context, convertView, parent, itemLayoutId, position);
    }
}
