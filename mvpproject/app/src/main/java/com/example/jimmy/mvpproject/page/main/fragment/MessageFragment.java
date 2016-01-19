package com.example.jimmy.mvpproject.page.main.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.jimmy.mvpproject.R;
import com.example.jimmy.mvpproject.model.Person;
import com.example.jimmy.mvpproject.widget.CommonAdapter;
import com.example.jimmy.mvpproject.widget.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jimmy on 16/1/15.
 */
public class MessageFragment extends Fragment
{
    private ListView lvPerson;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        lvPerson = (ListView) view.findViewById(R.id.lv_person);

        final List<Person> personList = new ArrayList<>();

        for (int i = 0; i < 100; i++)
        {
            Person person = new Person();
            person.setName("jimmy");
            person.setAge(18);
            personList.add(person);
        }

        lvPerson.setAdapter(new CommonAdapter<Person>(getActivity().getApplicationContext(), personList, R.layout.item_person)
        {

            @Override
            public void convert(ViewHolder holder, Person item)
            {
                holder.setText(R.id.tv_name, item.getName());
                holder.setText(R.id.tv_age, item.getAge() + "");
            }
        });

        return view;
    }
}
