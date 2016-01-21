package com.example.jimmy.mvpproject.model;

import java.io.Serializable;

/**
 * Created by jimmy on 16/1/21.
 */
public class Course implements Serializable
{
    private String name;

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
}
