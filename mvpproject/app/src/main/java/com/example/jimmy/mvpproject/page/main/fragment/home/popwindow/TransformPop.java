package com.example.jimmy.mvpproject.page.main.fragment.home.popwindow;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.PopupWindow;

import com.example.jimmy.mvpproject.R;
import com.example.jimmy.mvpproject.widget.CommonAdapter;
import com.example.jimmy.mvpproject.widget.ToastHelper;
import com.example.jimmy.mvpproject.widget.ViewHolder;

import java.util.List;

/**
 * 栏目切换popwindow
 *
 * @author Jimmy
 */
public class TransformPop
{
    //上下文
    private Context context;

    //菜单 popupWindow
    protected PopupWindow popupWindow;

    //菜单界面
    protected View popView;
    //在哪个view的下面
    private View view;
    //透明层
    private View transparentView;

    private GridView gvItem;

    private List<String> stringList;

    private ViewPager viewPager;

    public TransformPop(Context context, View view, List<String> stringList, ViewPager viewPager)
    {
        this.view = view;
        this.context = context;
        this.stringList = stringList;
        this.viewPager = viewPager;
    }

    public TransformPop(Context context, View view, View transparentView)
    {
        this.view = view;
        this.context = context;
        this.transparentView = transparentView;

    }


    public void showTransformPop()
    {
        if (popupWindow == null)
        {
            LayoutInflater inflater = LayoutInflater.from(context);
            popView = inflater.inflate(R.layout.pop_transform, null);
            popupWindow = new PopupWindow(popView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);

            popupWindow.setFocusable(true);
            popupWindow.setOutsideTouchable(true);
            popupWindow.setTouchInterceptor(new View.OnTouchListener()
            {

                @Override
                public boolean onTouch(View v, MotionEvent event)
                {

                    Log.i("mengdd", "onTouch : ");

                    return false;
                    // 这里如果返回true的话，touch事件将被拦截
                    // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
                }
            });
            popupWindow.update();
            popupWindow.setBackgroundDrawable(new BitmapDrawable());
            init();
            popupWindow.showAsDropDown(view);
        } else
        {
            popupWindow.showAsDropDown(view);
        }
    }


    private void init()
    {
        gvItem = (GridView) popView.findViewById(R.id.gv_item);
        gvItem.setAdapter(new CommonAdapter<String>(context, stringList, R.layout.item_child_item)
        {
            @Override
            public void convert(ViewHolder holder, final String item, final int position)
            {
                holder.setButtonText(R.id.btn_item, item);
                holder.setClickListener(R.id.btn_item, new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        ToastHelper.getInstance(context).longShowMessage(item);
                        viewPager.setCurrentItem(position);
                        popupWindow.dismiss();
                    }
                });

                if (viewPager.getCurrentItem() == position)
                {
                    holder.setButtonOnclikable(R.id.btn_item, false);
                } else
                {
                    holder.setButtonOnclikable(R.id.btn_item, true);
                }
            }
        });
    }

}
