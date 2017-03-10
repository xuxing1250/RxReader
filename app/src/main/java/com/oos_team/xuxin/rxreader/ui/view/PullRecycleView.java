package com.oos_team.xuxin.rxreader.ui.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by xuxin on 16-12-24.
 */

public class PullRecycleView extends RecyclerView implements PullableView{
    public static final String TAG = "PullRecycleView";

    public PullRecycleView(Context context) {
        super(context);
    }

    public PullRecycleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PullRecycleView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /**
     * 判断view是否滑动到底部和顶部的通用方法
     * @return
     */
    //是否可以下拉
    @Override
    public boolean canPullDonw() {
        if (!canScrollVertically(-1)) {
            return true;
        } else {
            return false;
        }
    }
    //是否可以上拉
    @Override
    public boolean canPullUp()
    {
        if (!canScrollVertically(1)) {
            return true;
        } else {
            return false;
        }
    }


}
