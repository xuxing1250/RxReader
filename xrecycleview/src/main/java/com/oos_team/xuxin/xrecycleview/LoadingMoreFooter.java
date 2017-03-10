package com.oos_team.xuxin.xrecycleview;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by xuxin on 17-2-27.
 */

public class LoadingMoreFooter extends LinearLayout {
    public final static int STATE_LOADING = 0;
    public final static int STATE_COMPLETE = 1;
    public final static int STATE_NOMORE = 2;
    private int mState;

    private ImageView mImage;
    private TextView mText;
    private AnimationDrawable mAnimationDrawable;

    public LoadingMoreFooter(Context context) {
        super(context);
        initView();
    }

    public LoadingMoreFooter(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public LoadingMoreFooter(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    public LoadingMoreFooter(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.yun_refresh_footer, this);
        mImage = (ImageView) findViewById(R.id.iv_progress);
        mText = (TextView) findViewById(R.id.msg);
        mAnimationDrawable = (AnimationDrawable) mImage.getDrawable();
        if (!mAnimationDrawable.isRunning()) {
            mAnimationDrawable.start();
        }
        setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    public void setState(int state) {
        mState = state;
        switch (state) {
            case STATE_LOADING:
                if (!mAnimationDrawable.isRunning()) {
                    mAnimationDrawable.start();
                }
                mImage.setVisibility(View.VISIBLE);
                mText.setText(getContext().getText(R.string.listview_loading));
                this.setVisibility(View.VISIBLE);
                break;
            case STATE_COMPLETE:
                if (mAnimationDrawable.isRunning()) {
                    mAnimationDrawable.stop();
                }
                mText.setText(getContext().getText(R.string.listview_loading));
                this.setVisibility(View.GONE);
                break;
            case STATE_NOMORE:
                if (mAnimationDrawable.isRunning()) {
                    mAnimationDrawable.stop();
                }
                mText.setText(getContext().getText(R.string.nomore_loading));
                mImage.setVisibility(View.GONE);
                this.setVisibility(View.VISIBLE);
                break;
        }
    }

    public void startAnimation() {
        if (mAnimationDrawable != null) {
            mAnimationDrawable.start();
        }
    }
    public void reSet() {
        this.setVisibility(GONE);
    }
}
