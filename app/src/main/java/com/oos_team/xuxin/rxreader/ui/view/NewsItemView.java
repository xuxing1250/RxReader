package com.oos_team.xuxin.rxreader.ui.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.oos_team.xuxin.rxreader.R;

/**
 * Created by xuxin on 16-12-30.
 */

/**
 * 自定义列表样式
 */
public class NewsItemView extends LinearLayout{
    public static final String TAG = "NewsItemView";

    private LinearLayout mLayout;
    public TextView mDelete, mMark;

    private ValueAnimator mValueAnimator;


    public NewsItemView(Context context) {
        super(context);
    }

    public NewsItemView(Context context, AttributeSet attrs) {
        /**
         * xml 调用
         */
        super(context, attrs);
    }

    public NewsItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


    }

    public NewsItemView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

    }

    @Override
    protected void onFinishInflate() {
        mLayout = (LinearLayout) findViewById(R.id.hide_more_layout);
        mDelete = (TextView) findViewById(R.id.delete_item);
        mMark = (TextView) findViewById(R.id.mark_item);

        super.onFinishInflate();
    }



    public boolean showHideView() {
        Log.d(TAG, "onLongClick");
//        mValueAnimator = ObjectAnimator.ofFloat(mLayout, "translationY", -10.0f, 0.0f);
//        mValueAnimator.setDuration(1000);
//        mValueAnimator.start();
        TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                -1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
        translateAnimation.setDuration(500);
        mLayout.setVisibility(View.VISIBLE);
        mLayout.startAnimation(translateAnimation);
        return true;
    }
    public void hideView() {
        mLayout.setVisibility(View.GONE);
    }

    public void showHideViewNoAnimator() {
        mLayout.setVisibility(View.VISIBLE);
    }
}
