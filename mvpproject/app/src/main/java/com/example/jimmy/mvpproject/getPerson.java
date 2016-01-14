package com.example.jimmy.mvpproject;

import android.content.Context;

import com.example.jimmy.mvpproject.model.Person;
import com.example.jimmy.mvpproject.model.PersonManager;
import com.example.jimmy.mvpproject.utils.core.ComponentEngine;
import com.example.jimmy.mvpproject.utils.http.FHttpException;
import com.example.jimmy.mvpproject.utils.task.BaseTask;

import java.util.List;

/**
 * Created by jimmy on 16/1/14.
 */
public class getPerson extends BaseTask
{
    PersonManager personManager;

    public getPerson(Context context)
    {
        super(context);

        personManager = (PersonManager) ComponentEngine.getInstance(PersonManager.class);
    }

    @Override
    protected TaskResult doInBackground(Void... params)
    {
        try
        {
            Person person = personManager.getPerson();
            return new TaskResult(person, null);
        }
        catch (FHttpException ex)
        {
            return new TaskResult(null, ex);
        }
    }
}
