package com.example.jimmy.mvpproject.page.main;


import android.os.Build;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.jimmy.mvpproject.R;
import com.example.jimmy.mvpproject.page.main.fragment.forum.ForumFragment;
import com.example.jimmy.mvpproject.page.main.fragment.home.HomeFragment;
import com.example.jimmy.mvpproject.page.main.fragment.message.MessageFragment;
import com.example.jimmy.mvpproject.page.main.fragment.MineFragment;


import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 主界面
 *
 * @author Jimmy
 */
public class MainActivity extends FragmentActivity implements View.OnClickListener
{
    @Bind(R.id.fl_home)
    FrameLayout flHome;

    @Bind(R.id.ll_home)
    LinearLayout llHome;

    @Bind(R.id.ll_forum)
    LinearLayout llForum;

    @Bind(R.id.ll_message)
    LinearLayout llMessage;

    @Bind(R.id.ll_mine)
    LinearLayout llMine;

    public static android.support.v4.app.FragmentManager fm;

    //加载fragment用
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;

    private HomeFragment homeFragment;

    private ForumFragment forumFragment;

    private MessageFragment messageFragment;

    private MineFragment mineFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
        {
            setTranslucentStatus(true);
        }
        init();
    }

    private void setTranslucentStatus(boolean on)
    {
        Window window = getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on)
        {
            params.flags |= bits;
        } else
        {
            params.flags &= ~bits;
        }
        window.setAttributes(params);
    }

    /**
     * 初始化
     */
    private void init()
    {
        fm = getSupportFragmentManager();

        selectedOne(true, false, false, false);

        //加载邮箱默认布局
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        homeFragment = new HomeFragment();
        transaction.add(R.id.fl_home, homeFragment);
        transaction.commit();

        llHome.setOnClickListener(this);
        llForum.setOnClickListener(this);
        llMessage.setOnClickListener(this);
        llMine.setOnClickListener(this);
    }

    /**
     * 点击按钮选中效果
     *
     * @param homeSelector    Boolean
     * @param forumSelector   Boolean
     * @param messageSelector Boolean
     * @param mineSelector    Boolean
     */
    private void selectedOne(Boolean homeSelector, Boolean forumSelector, Boolean messageSelector, Boolean mineSelector)
    {
        llHome.setSelected(homeSelector);
        llForum.setSelected(forumSelector);
        llMessage.setSelected(messageSelector);
        llMine.setSelected(mineSelector);
    }

    @Override
    public void onClick(View view)
    {
        transaction = fragmentManager.beginTransaction();
        hideFragment(transaction);
        switch (view.getId())
        {
            case R.id.ll_home:
                selectedOne(true, false, false, false);
                if (homeFragment == null)
                {
                    homeFragment = new HomeFragment();
                    showFragment(homeFragment, true);
                } else
                {
                    showFragment(homeFragment, false);
                }
                break;
            case R.id.ll_forum:
                selectedOne(false, true, false, false);
                if (forumFragment == null)
                {
                    forumFragment = new ForumFragment();
                    showFragment(forumFragment, true);
                } else
                {
                    showFragment(forumFragment, false);
                }
                break;
            case R.id.ll_message:
                selectedOne(false, false, true, false);
                if (messageFragment == null)
                {
                    messageFragment = new MessageFragment();
                    showFragment(messageFragment, true);
                } else
                {
                    showFragment(messageFragment, false);
                }
                break;
            case R.id.ll_mine:
                selectedOne(false, false, false, true);
                if (mineFragment == null)
                {
                    mineFragment = new MineFragment();
                    showFragment(mineFragment, true);
                } else
                {
                    showFragment(mineFragment, false);
                }
                break;
        }
    }

    /**
     * 隐藏其他fragment,如果不隐藏将一直累加
     *
     * @param transaction
     */
    private void hideFragment(FragmentTransaction transaction)
    {
        if (homeFragment != null)
        {
            transaction.hide(homeFragment);
        }

        if (forumFragment != null)
        {
            transaction.hide(forumFragment);
        }

        if (messageFragment != null)
        {
            transaction.hide(messageFragment);
        }

        if (mineFragment != null)
        {
            transaction.hide(mineFragment);
        }
    }

    /**
     * 显示Fragment
     *
     * @param fragment BaseFragment 要显示的fragment
     */
    private void showFragment(Fragment fragment, boolean type)
    {
        if (type)
        {
            transaction.add(R.id.fl_home, fragment);
        } else
        {
            transaction.show(fragment);
        }
        transaction.commit();
    }
}
