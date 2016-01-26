package com.example.jimmy.mvpproject.page.main.fragment.home.childfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jimmy.mvpproject.R;

/**
 * 娱乐八卦
 *
 * @author Jimmy
 */
public class EntertainmentFragment extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_entainment, container, false);
        return view;
    }
}
