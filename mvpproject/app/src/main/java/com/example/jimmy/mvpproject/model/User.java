package com.example.jimmy.mvpproject.model;

import java.io.Serializable;
import java.util.List;

/**
 * 用户
 *
 * @author Jimmy
 */
public class User implements Serializable
{
    //ID
    private int id;

    //头像
    private String headImageUrl;

    //名称
    private String name;

    //所创建的贴子
    private List<Post> postList;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getHeadImageUrl()
    {
        return headImageUrl;
    }

    public void setHeadImageUrl(String headImageUrl)
    {
        this.headImageUrl = headImageUrl;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Post> getPostList()
    {
        return postList;
    }

    public void setPostList(List<Post> postList)
    {
        this.postList = postList;
    }
}
