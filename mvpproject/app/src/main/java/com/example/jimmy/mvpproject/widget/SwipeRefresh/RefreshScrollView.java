package com.example.jimmy.mvpproject.widget.SwipeRefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * 继承自SwipeRefreshLayout,从而实现滑动到底部时上拉加载更多的功能.
 *
 * @author mrsimple
 */
public class RefreshScrollView extends ScrollView {

    private OnScrollToBottomListener onScrollToBottom;

    public RefreshScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RefreshScrollView(Context context) {
        super(context);
    }

    @Override
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX,
                                  boolean clampedY) {
        super.onOverScrolled(scrollX, scrollY, clampedX, clampedY);
        if(scrollY >0 && null != onScrollToBottom){
            onScrollToBottom.onScrollBottomListener(clampedY);
        }
    }

    public void setOnScrollToBottomLintener(OnScrollToBottomListener listener){
        onScrollToBottom = listener;
    }

    public interface OnScrollToBottomListener{
        public void onScrollBottomListener(boolean isBottom);
    }

}
