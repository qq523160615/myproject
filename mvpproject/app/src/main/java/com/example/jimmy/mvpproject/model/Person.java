package com.example.jimmy.mvpproject.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by jimmy on 16/1/13.
 */
public class Person implements Serializable
{
    private String name;

    private int age;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public static Person generateByJson(Map<String,Object> json)
    {
        Person person = new Person();

        String name = (String) json.get("name");
        int age = (int) json.get("age");

        person.setName(name);
        person.setAge(age);

        return person;
    }
}
