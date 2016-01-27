package com.example.jimmy.mvpproject.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ScrollView;

import com.example.jimmy.mvpproject.R;

/**
 * 图片下拉自定义scrollview
 *
 * @author Jimmy
 */
public class PullScrollView extends ScrollView implements ViewTreeObserver.OnGlobalLayoutListener
{

    private MoveUpListener moveUpListener;

    View view;
    int srcTopMargion;
    float lastY;
    float offsetY;

    public PullScrollView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        ViewTreeObserver observer = getViewTreeObserver();
        if (null != observer)
            observer.addOnGlobalLayoutListener(this);
    }

    public PullScrollView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
    }

    public void setMoveUpListener(MoveUpListener moveUpListener)
    {
        this.moveUpListener = moveUpListener;
    }

    @Override
    protected void onFinishInflate()
    {
        super.onFinishInflate();
        view = findViewById(R.id.iv_pull_img);
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev)
    {
        int action = ev.getAction();
        float y = ev.getY();
        Log.d("onTouchEvent", "action=" + action + ",y=" + y);
        MarginLayoutParams params = (MarginLayoutParams) view.getLayoutParams();
        switch (action)
        {
            case MotionEvent.ACTION_DOWN:
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                //计算滑动y方向偏移值
                offsetY = y - lastY;
                //向下移动
                if (offsetY > 0)
                {
                    //滑动到看到所有图片展示，交给原来的逻辑处理
                    if (params.topMargin == 0)
                    {
                        return super.onTouchEvent(ev);
                    }
                    //在不是下拉图片的时候，向下移动，交给原来的逻辑处理
                    if (getScrollY() != 0)
                    {
                        return super.onTouchEvent(ev);
                    }
                    //可以下拉图片的情况
                    params.topMargin += offsetY / 10;
                    Log.d("onTouchEvent", "topMargin" + params.topMargin + ",lastY=" + lastY + ",y=" + y + ",offsetY" + offsetY);
                    if (params.topMargin >= 0)
                    {
                        params.topMargin = 0;
                    }
                    view.setLayoutParams(params);
                    invalidate();
                }
                lastY = y;
                break;
            case MotionEvent.ACTION_UP:
                //不和原始margion偏移一样的时候
                if (params.topMargin != -srcTopMargion)
                {
                    Log.d("ACTION_UP", "moveY=" + (srcTopMargion + params.topMargin));
                    //滚动原始偏移值和现在偏移值之间的差值 eg:3~10
                    ObjectAnimator animator = ObjectAnimator.ofInt(this, "moveY", params.topMargin, -srcTopMargion);
                    animator.setDuration(200);
                    animator.setInterpolator(new AccelerateDecelerateInterpolator());
                    animator.start();
                    moveUpListener.moveUp();
                }
                break;
        }
        return super.onTouchEvent(ev);
    }

    /**
     * 设置移动中的Y值
     *
     * @param value
     */
    public void setMoveY(int value)
    {
        MarginLayoutParams params = (MarginLayoutParams) view.getLayoutParams();
        params.topMargin = value;
        Log.d("computeScroll", "topMargin=" + params.topMargin);
        view.setLayoutParams(params);
        invalidate();
    }

    @Override
    public void onGlobalLayout()
    {
        MarginLayoutParams params = (MarginLayoutParams) view.getLayoutParams();
        srcTopMargion = -params.topMargin;
        Log.d("srcTopMargion", "" + srcTopMargion);
        getViewTreeObserver()
                .removeGlobalOnLayoutListener(this);
    }

    public interface MoveUpListener
    {
        public void moveUp();
    }
}
