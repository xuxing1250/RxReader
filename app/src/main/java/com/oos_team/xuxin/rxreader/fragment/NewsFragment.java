package com.oos_team.xuxin.rxreader.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.oos_team.xuxin.rxreader.R;
import com.oos_team.xuxin.rxreader.Retrofit.NetUtil;
import com.oos_team.xuxin.rxreader.adapter.NewsDetailAdapter;
import com.oos_team.xuxin.rxreader.bean.NewsBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import rx.Observer;

/**
 * Created by xuxin on 17-2-23.
 */

public class NewsFragment extends Fragment{
    private static final String TAG = "NewsFragment";
    public static final String [] TAB_TITLE = {"推荐", "社会", "国内", "国际", "娱乐", "体育", "军事", "科技", "财经"};
    public static final String [] TAB_API = {"top", "shehui" , "guonei", "guoji", "yule", "tiyu", "junshi", "keji", "caijing"};

    private TabLayout mTabLay;
    private ViewPager mPager;
    private NewsDetailAdapter mAdapter;

    private List<HashMap<String, Object>> mList;
    private NewsBean mBean;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_fragment, container, false);
        mTabLay = (TabLayout) view.findViewById(R.id.news_tab);
        mPager = (ViewPager) view.findViewById(R.id.news_viewpager);
        initAdapter();
        return view;
    }

    private void initAdapter() {
        mList = new ArrayList<>();
        for (int i = 0; i < TAB_TITLE.length; i++) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("title", TAB_TITLE[i]);
            hashMap.put("fragment", new NewsFragmentDetail(TAB_API[i]));
            mList.add(hashMap);
        }
        mAdapter = new NewsDetailAdapter(getActivity().getSupportFragmentManager(), getActivity(), mList);
        mPager.setAdapter(mAdapter);
        mTabLay.setupWithViewPager(mPager);
    }

}
