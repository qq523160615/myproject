package com.example.jimmy.mvpproject.widget.SwipeRefresh;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.example.jimmy.mvpproject.R;


/**
 * 继承自SwipeRefreshLayout,从而实现滑动到底部时上拉加载更多的功能.
 *
 * @author mrsimple
 */
public class RefreshLayout extends SwipeRefreshLayout
{

    /**
     * 滑动到最下面时的上拉操作
     */

    private int mTouchSlop;
    /**
     * listview实例
     */
    private RefreshScrollView scrollView;
    private LinearLayout llSc;

    /**
     * 上拉监听器, 到了最底部的上拉加载操作
     */
    private OnLoadListener mOnLoadListener;

    /**
     * ListView的加载中footer
     */
    private View mListViewFooter;

    /**
     * 按下时的y坐标
     */
    private int mYDown;
    /**
     * 抬起时的y坐标, 与mYDown一起用于滑动到底部时判断是上拉还是下拉
     */
    private int mLastY;
    /**
     * 是否在加载中 ( 上拉加载更多 )
     */
    private boolean isLoading = false;

    /**
     * 是否要允许上推加载
     */
    private boolean isOpenLoad=true;

    /**
     * @param context
     */
    public RefreshLayout(Context context)
    {
        this(context, null);
    }

    public RefreshLayout(Context context, AttributeSet attrs)
    {
        super(context, attrs);

        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();

        mListViewFooter = LayoutInflater.from(context).inflate(R.layout.lin_load_footer, null,
                false);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom)
    {
        super.onLayout(changed, left, top, right, bottom);

        // 初始化ListView对象
        if (scrollView == null)
        {
            getListView();
        }
    }

    /**
     * 获取ListView对象
     */
    private void getListView()
    {
        int childs = getChildCount();
        if (childs > 0)
        {
            View childView = getChildAt(0);
            if (childView instanceof ScrollView)
            {
                scrollView = (RefreshScrollView) childView;
                View childLL=scrollView.getChildAt(0);
                if(childLL instanceof LinearLayout)
                {
                    llSc=(LinearLayout)childLL;
                }
                // 设置滚动监听器给ListView, 使得滚动的情况下也可以自动加载
                scrollView.setOnScrollToBottomLintener(new RefreshScrollView.OnScrollToBottomListener() {

                    @Override
                    public void onScrollBottomListener(boolean isBottom) {
                        // TODO Auto-generated method stub
                        Log.e("SCROLLVIEW", isBottom + "");
                        if(isBottom)
                        {
                            if (mOnLoadListener != null)
                            {
                                // 设置状态
                                setLoading(true);
                                //

                            }
                        }

                    }
                });
                Log.d(VIEW_LOG_TAG, "### 找到listview");
            }
        }
    }


    /**
     * 如果到了最底部,而且是上拉操作.那么执行onLoad方法
     */
    private void loadData()
    {
        if (mOnLoadListener != null)
        {
            // 设置状态
            setLoading(true);
            //
            mOnLoadListener.onLoad();
        }
    }

    /**
     * @param loading
     */
    public void setLoading(boolean loading)
    {
        if(isLoading==loading || !isOpenLoad)
        {
            return;
        }
        isLoading = loading;
        if (isLoading)
        {
            llSc.addView(mListViewFooter);
            mOnLoadListener.onLoad();
        }
        else
        {
            llSc.removeView(mListViewFooter);
        }

    }

    /**
     * @param loadListener
     */
    public void setOnLoadListener(OnLoadListener loadListener)
    {
        mOnLoadListener = loadListener;
    }


    /**
     * 加载更多的监听器
     *
     * @author mrsimple
     */
    public static interface OnLoadListener
    {
        public void onLoad();
    }

    public boolean isOpenLoad()
    {
        return isOpenLoad;
    }

    public void setIsOpenLoad(boolean isOpenLoad)
    {
        this.isOpenLoad = isOpenLoad;
    }
}
