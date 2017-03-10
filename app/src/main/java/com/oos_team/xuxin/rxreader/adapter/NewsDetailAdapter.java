package com.oos_team.xuxin.rxreader.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.HashMap;
import java.util.List;

/**
 * Created by xuxin on 17-2-24.
 */

public class NewsDetailAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private List<HashMap<String, Object>> mList;

    public NewsDetailAdapter(FragmentManager fm) {
        super(fm);
    }

    public NewsDetailAdapter(FragmentManager fm , Context context, List<HashMap<String, Object>> list) {
        super(fm);
        mContext = context;
        mList = list;

    };

    @Override
    public Fragment getItem(int position) {
        HashMap<String, Object> hashMap = mList.get(position);
        Fragment f  = (Fragment) hashMap.get("fragment");
        return f;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return (CharSequence) mList.get(position).get("title");
    }
}
