package com.example.jimmy.mvpproject.page.main.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jimmy.mvpproject.R;

/**
 * Created by jimmy on 16/1/15.
 */
public class MessageFragment extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        return view;
    }
}