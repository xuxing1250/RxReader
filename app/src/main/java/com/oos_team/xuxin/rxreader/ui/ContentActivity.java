package com.oos_team.xuxin.rxreader.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.TableLayout;

import com.oos_team.xuxin.rxreader.MainActivity;
import com.oos_team.xuxin.rxreader.R;
import com.oos_team.xuxin.rxreader.adapter.ContentFragmentAdapter;
import com.oos_team.xuxin.rxreader.fragment.CommondFragment;
import com.oos_team.xuxin.rxreader.fragment.GankoFragment;
import com.oos_team.xuxin.rxreader.fragment.MoviesFragment;
import com.oos_team.xuxin.rxreader.fragment.NewsFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuxin on 17-2-23.
 */

public class ContentActivity extends MainActivity {
    private static final String TAG = "ContentActivity";

    private ViewPager mViewPager;
    private NewsFragment mNewsFragment;
    private GankoFragment mGankoFragment;
    private CommondFragment mCommondFragment;
    private MoviesFragment mMoviesFragment;
    private TabLayout mTabLayout;

    private ContentFragmentAdapter mAdapter;

    private List<Fragment> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.content_viewpager);
        mTabLayout = (TabLayout) findViewById(R.id.content_tablayout);

        mNewsFragment = new NewsFragment();
        mGankoFragment = new GankoFragment();
        mCommondFragment = new CommondFragment();
        mMoviesFragment = new MoviesFragment();

        mList = new ArrayList<>();
        mList.add(mNewsFragment);
        mList.add(mGankoFragment);
        mList.add(mCommondFragment);
        mList.add(mMoviesFragment);

        mAdapter = new ContentFragmentAdapter(getSupportFragmentManager(), mList, this);
        mViewPager.setAdapter(mAdapter);
        /**
         * 解决viewpager 切换fragment时 出现的异常
         * The specified child already has a parent. You must call removeView()
         */
        mViewPager.setOffscreenPageLimit(3);

        mTabLayout.setupWithViewPager(mViewPager);
        for (int i = 0; i < mTabLayout.getTabCount(); i++) {

            TabLayout.Tab tab = mTabLayout.getTabAt(i);
            tab.setCustomView(mAdapter.getTabView(i));
        }
    }
}
