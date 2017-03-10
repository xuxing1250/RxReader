package com.oos_team.xuxin.rxreader.fragment;


import android.support.v4.app.Fragment;
import android.view.View;


/**
 * Created by xuxin on 16-11-23.
 */

public abstract class BaseTabFragment extends Fragment {
    public void setViewVisiable(View v) {
        v.setVisibility(View.VISIBLE);
    }
    public void setViewInvisiable(View v) {
        v.setVisibility(View.GONE);
    }

    protected abstract void replaceFragment();
    /**
     * 数据库通用方法
     */
    protected abstract void insert(Object object);
    protected abstract void update();
    protected abstract void delete();
    protected abstract void findAll();
    protected abstract void findRecord();

}
