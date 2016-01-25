package com.example.jimmy.mvpproject.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;


/**
 * Created by jimmy on 16/1/19.
 */
public class ViewHolder
{
    private final SparseArray<View> viewSparseArray;
    private int position;
    private View convertView;

    private ViewHolder(Context context, ViewGroup parent, int layoutId,
                       int position)
    {
        this.position = position;
        this.viewSparseArray = new SparseArray<View>();
        convertView = LayoutInflater.from(context).inflate(layoutId, parent,
                false);
        //setTag
        convertView.setTag(this);
    }

    public static ViewHolder get(Context context, View convertView, ViewGroup parent, int layoutId, int position)
    {
        if (convertView == null)
        {
            return new ViewHolder(context, parent, layoutId, position);
        }
        return (ViewHolder) convertView.getTag();
    }

    public <T extends View> T getView(int viewId)
    {
        View view = viewSparseArray.get(viewId);
        if (view == null)
        {
            view = convertView.findViewById(viewId);
            viewSparseArray.put(viewId, view);
        }
        return (T) view;
    }

    public View getConvertView()
    {
        return convertView;
    }

    public ViewHolder setText(int viewId, String text)
    {
        TextView view = getView(viewId);
        view.setText(text);
        return this;
    }

    public ViewHolder setImageResource(int viewId, int drawableId)
    {
        ImageView view = getView(viewId);
        view.setImageResource(drawableId);

        return this;
    }


    public ViewHolder setBackgroundColor(int viewId, int drawableId)
    {
        ImageView view = getView(viewId);
        view.setBackgroundColor(drawableId);

        return this;
    }

    public ViewHolder setImageBitmap(int viewId, Bitmap bitmap)
    {
        ImageView view = getView(viewId);
        view.setImageBitmap(bitmap);

        return this;
    }

    public ViewHolder setImageByUrl(int viewId, String url)
    {
        SimpleDraweeView view = getView(viewId);
        view.setImageURI(Uri.parse(url));

        return this;
    }

    public ViewHolder setClickListener(int viewId, View.OnClickListener clickListener)
    {
        View view = getView(viewId);
        view.setOnClickListener(clickListener);
        return this;
    }

    public ViewHolder setTextColor(int viewId, int color)
    {
        TextView view = getView(viewId);
        view.setTextColor(color);
        return this;
    }

    public int getPosition()
    {
        return position;
    }
}
