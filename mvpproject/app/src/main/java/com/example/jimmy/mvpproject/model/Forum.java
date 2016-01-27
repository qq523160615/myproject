package com.example.jimmy.mvpproject.model;

import java.io.Serializable;

/**
 * 贴吧
 *
 * @author Jimmy
 */
public class Forum implements Serializable
{
    //ID
    private int id;

    //贴吧名字
    private String name;

    //贴吧等级
    private int level;

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

    public int getLevel()
    {
        return level;
    }

    public void setLevel(int level)
    {
        this.level = level;
    }
}
