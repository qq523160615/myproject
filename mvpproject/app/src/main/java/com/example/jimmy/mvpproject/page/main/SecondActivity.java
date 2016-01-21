package com.example.jimmy.mvpproject.page.main;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.jimmy.mvpproject.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;

/**
 * Created by jimmy on 16/1/20.
 */
public class SecondActivity extends Activity
{


    Observer<String> observer;

    Observable observable;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_forum);
        ButterKnife.bind(this);
        observer = (Observer<String>) getIntent().getExtras().get("observer");

        observable = Observable.create(new Observable.OnSubscribe<String>()
        {

            @Override
            public void call(Subscriber<? super String> subscriber)
            {
                subscriber.onNext("Hello");
                subscriber.onNext("Hi");
                subscriber.onNext("Aloha");
                subscriber.onCompleted();
            }
        });
    }

}
