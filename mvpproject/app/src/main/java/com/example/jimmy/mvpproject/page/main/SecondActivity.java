package com.example.jimmy.mvpproject.page.main;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import com.example.jimmy.mvpproject.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by jimmy on 16/1/20.
 */
public class SecondActivity extends Activity
{

    @Bind(R.id.animationIV)
    ImageView animationIV;
    @Bind(R.id.buttonA)
    Button buttonA;
    @Bind(R.id.buttonB)
    Button buttonB;
    @Bind(R.id.buttonC)
    Button buttonC;

    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_animation);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.buttonA)
    public void btnA(View view)
    {
        animationIV.setImageResource(R.drawable.animation2);
        animationDrawable = (AnimationDrawable)animationIV.getDrawable();
        animationDrawable.setOneShot(false);
        animationDrawable.start();
    }

    @OnClick(R.id.buttonB)
    public void btnB(View view)
    {
        animationDrawable = (AnimationDrawable) animationIV.getDrawable();
        animationDrawable.stop();
    }

    @OnClick(R.id.buttonC)
    public void btnC(View view)
    {
        animationIV.setImageResource(R.drawable.animation);
        animationDrawable = (AnimationDrawable) animationIV.getDrawable();
        animationDrawable.start();
    }
}
