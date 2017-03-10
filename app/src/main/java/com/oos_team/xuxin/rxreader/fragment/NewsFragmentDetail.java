package com.oos_team.xuxin.rxreader.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.oos_team.xuxin.rxreader.R;
import com.oos_team.xuxin.rxreader.Retrofit.NetUtil;
import com.oos_team.xuxin.rxreader.adapter.NewsAdapter;
import com.oos_team.xuxin.rxreader.bean.NewsBean;
import com.oos_team.xuxin.rxreader.ui.view.ManyCircle;
import com.oos_team.xuxin.rxreader.ui.view.NewsListView;
import com.oos_team.xuxin.rxreader.ui.view.PullRecycleView;

import java.util.List;

import rx.Observer;

/**
 * Created by xuxin on 17-2-24.
 */

public class NewsFragmentDetail extends BaseTabFragment {
    private static final String TAG = "NewsFragmentDetail";

    public static final String URL = "http://v.juhe.cn/toutiao/index?type=top&key=fb8020bbe3361c39650cdcc43a20c3dd";

    private PullRecycleView mRecycleView;
    private TextView mLoading;
    private ManyCircle mCircle;
    private MyHandle mHandle;
    private NewsAdapter mAdapter;

    private String mType;
    private List<NewsBean.ResultBean.DataBean> mBeanList;

    public class MyHandle extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    setViewVisiable(mRecycleView);
                    setViewInvisiable(mLoading);
                    setViewInvisiable(mCircle);
                    break;
            }
        }
    }

    public NewsFragmentDetail() {

    }

    public NewsFragmentDetail(String type) {

        mType = type;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_fragment_tab, container, false);
        /**
         * for recycleView
         */
        mRecycleView = (PullRecycleView) view.findViewById(R.id.news_recycleview);


        mLoading = (TextView) view.findViewById(R.id.news_loading);
        mCircle = (ManyCircle) view.findViewById(R.id.image_loading);
        mHandle = new MyHandle();
        mHandle.sendEmptyMessageDelayed(0, 2000);
        getNewsBean();
        return view;
    }

    /**
     * 网络请求接口
     */
    public void getNewsBean() {
        NetUtil.getNewsWithType(new Observer<NewsBean>() {
            @Override
            public void onCompleted() {
                mAdapter = new NewsAdapter(getActivity(), mBeanList);
                mRecycleView.setAdapter(mAdapter);
                //线性布局
                mRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));

//               mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL_LIST));

                //添加Item动画
                mRecycleView.setItemAnimator(new DefaultItemAnimator());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(NewsBean newsBean) {
                mBeanList = newsBean.getResult().getData();
            }
        }, mType);
    }

    @Override
    protected void replaceFragment() {

    }

    @Override
    protected void insert(Object object) {

    }

    @Override
    protected void update() {

    }

    @Override
    protected void delete() {

    }

    @Override
    protected void findAll() {

    }

    @Override
    protected void findRecord() {

    }
}
