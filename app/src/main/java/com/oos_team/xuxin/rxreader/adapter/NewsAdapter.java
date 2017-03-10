package com.oos_team.xuxin.rxreader.adapter;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.oos_team.xuxin.rxreader.R;
import com.oos_team.xuxin.rxreader.bean.NewsBean;
import com.oos_team.xuxin.rxreader.utils.Options;

import java.util.List;

/**
 * Created by xuxin on 17-2-24.
 */

public class NewsAdapter extends RecyclerView.Adapter <MyViewHolder> {
    private static final String TAG = "NewsAdapter";
    private List<NewsBean.ResultBean.DataBean> mBeanList;
    private Context mContext;

    public NewsAdapter(Context context, List<NewsBean.ResultBean.DataBean> mBeanList) {
        mContext = context;
        this.mBeanList = mBeanList;
        Log.d(TAG, "NewsAdapter: --------");
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_list_itme_card, parent, false));
        Log.d(TAG, "onCreateViewHolder: ------------");
        Log.d(TAG, "onCreateViewHolder: ");
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: "+position);
        NewsBean.ResultBean.DataBean bean = mBeanList.get(position);
        //强制取消复用
//        holder.setIsRecyclable(false);


        holder.mContent.setText(bean.getTitle());
        holder.mNewsFrom.setText(bean.getAuthor_name());
        holder.mTime.setText(bean.getDate());

        //缓存图片
        setBitmapFromUrl(bean.getThumbnail_pic_s02(), holder.mNewsIcon);

        //波浪动画
        holder.mItemView.setScaleX(0.8f);
        holder.mItemView.setScaleY(0.8f);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(holder.mItemView, "scaleX", holder.mItemView.getScaleX(), 1f);
        objectAnimator.setDuration(300).start();
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(holder.mItemView, "scaleY", holder.mItemView.getScaleY(), 1f);
        objectAnimator2.setDuration(300).start();
    }

    protected void setBitmapFromUrl(String url, ImageView imageView) {
        ImageLoader.getInstance().displayImage(url, imageView);
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: "+ mBeanList.size());
        return mBeanList.size();
    }

}
