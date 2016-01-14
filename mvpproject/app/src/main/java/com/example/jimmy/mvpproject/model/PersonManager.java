package com.example.jimmy.mvpproject.model;

import com.example.jimmy.mvpproject.utils.core.Autowired;
import com.example.jimmy.mvpproject.utils.core.BaseComponent;
import com.example.jimmy.mvpproject.utils.http.ApiEngine;
import com.example.jimmy.mvpproject.utils.http.FHttpException;
import com.example.jimmy.mvpproject.utils.http.HttpResponse;


import java.util.HashMap;
import java.util.Map;


/**
 * Created by jimmy on 16/1/14.
 */
public class PersonManager extends BaseComponent
{
    @Autowired
    ApiEngine apiEngine;

    public Person getPerson() throws FHttpException
    {
        Map<String, Object> params = new HashMap<>();
        HttpResponse response = apiEngine.request("person.person", params);

        if (response.getStatus() == HttpResponse.STATUS_SUCCESS)
        {
            Person person = Person.generateByJson((Map<String, Object>) response.getContent());
            return person;
        } else
        {
            throw new FHttpException(FHttpException.CODE_BUSINESS_ERROR, response.getErrorMessage());
        }
    }
}
