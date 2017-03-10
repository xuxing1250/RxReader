package com.oos_team.xuxin.rxreader.fragment;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.oos_team.xuxin.rxreader.R;
import com.oos_team.xuxin.rxreader.Retrofit.NetUtil;
import com.oos_team.xuxin.rxreader.bean.ImageBean;
import com.oos_team.xuxin.rxreader.utils.Options;
import com.oos_team.xuxin.xrecycleview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;

/**
 * Created by xuxin on 17-2-23.
 */

public class CommondFragment extends Fragment {
    private static final String TAG = "CommondFragment";
    private int mShowitemCount = 20;

    private XRecyclerView mRecycleView;
    private ListApdater mAdapter;
    private List<ImageBean.ResultsBean> mList = new ArrayList<>();




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.commond_fragment, container, false);
        mRecycleView = (XRecyclerView) view.findViewById(R.id.recycle_list);
        getFuliBean();
        return view;
    }

    private void getFuliBean() {
        NetUtil.getGankioMeinv(new Observer<ImageBean>() {
            @Override
            public void onCompleted() {
                mAdapter = new ListApdater();
//                mRecycleView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
                mRecycleView.setLayoutManager(new GridLayoutManager(getContext(), 2));
                mRecycleView.setAdapter(mAdapter);
                mRecycleView.setItemAnimator(null);
                mRecycleView.setLoadingMoreEnabled(true);
                mRecycleView.setLoadingListener(new XRecyclerView.LoadingListener() {
                    @Override
                    public void onRefresh() {

                    }

                    @Override
                    public void onLoadMore() {
                        Log.d(TAG, "onLoadMore: ----------");
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                loadingMorePic();
                            }
                        }, 1000);

                    }
                });

            }
            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: " + e);
            }

            @Override
            public void onNext(ImageBean imageBean) {

                mList = imageBean.getResults();
            }
        }, mShowitemCount);
    }

    private void loadingMorePic() {
        mShowitemCount += 20;
        NetUtil.getGankioMeinv(new Observer<ImageBean>() {
            @Override
            public void onCompleted() {
                mRecycleView.refreshComplete();
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ImageBean imageBean) {
                mList = imageBean.getResults();
                Log.d(TAG, "onNext: " + mList.size());
            }
        }, mShowitemCount);
        mAdapter.notifyDataSetChanged();
    }

    protected void setBitmapFromUrl(String url, ImageView imageView) {
        ImageLoader.getInstance().displayImage(url, imageView);

    }


    public class ListApdater extends XRecyclerView.Adapter <ListApdater.MyViewHolder> {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(getContext())
                    .inflate(R.layout.meizi_item_view, parent,false));
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            ImageBean.ResultsBean bean = mList.get(position);
            String url = bean.getUrl();
            if (!url.equals(holder.mImage.getTag())) {
                holder.mImage.setTag(url);
                setBitmapFromUrl(url, holder.mImage);
            }
//            if (position % 2 == 0) {
//                Options.setMargin(holder.mImage, false, 12, 6, 12, 0);
//            } else {
//                Options.setMargin(holder.mImage, false, 6, 12, 12, 0);
//            }
        }

        @Override
        public int getItemCount() {

            return mList.size();
        }

        class MyViewHolder extends XRecyclerView.ViewHolder {
            private ImageView mImage;
            private View mItemView;
            public MyViewHolder(View itemView) {
                super(itemView);
                mImage = (ImageView) itemView.findViewById(R.id.meizi_image);
                mItemView = itemView;
            }
        }
    }


}