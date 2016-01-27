package com.example.jimmy.mvpproject.model;

import android.graphics.Bitmap;

import java.io.Serializable;
import java.util.List;

/**
 * 贴子
 *
 * @author Jimmy
 */
public class Post implements Serializable
{
    //ID
    private int id;

    //贴吧名称
    private String name;

    //内容
    private String context;

    //创建时间
    private String createTime;

    //所属贴吧
    private Forum forum;

    //图片
    private List<String> imageList;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getContext()
    {
        return context;
    }

    public void setContext(String context)
    {
        this.context = context;
    }

    public String getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(String createTime)
    {
        this.createTime = createTime;
    }

    public Forum getForum()
    {
        return forum;
    }

    public void setForum(Forum forum)
    {
        this.forum = forum;
    }

    public List<String> getImageList()
    {
        return imageList;
    }

    public void setImageList(List<String> imageList)
    {
        this.imageList = imageList;
    }
}
