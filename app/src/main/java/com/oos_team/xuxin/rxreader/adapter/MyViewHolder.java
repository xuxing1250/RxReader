package com.oos_team.xuxin.rxreader.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.oos_team.xuxin.rxreader.R;

/**
 * Created by xuxin on 17-2-24.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {
    private Context mContext;
    TextView mContent;
    TextView mTime;
    TextView mNewsFrom;
    ImageView mNewsIcon;
    View mItemView;

    /**
     *  初始化
     * @param itemView
     */
    public MyViewHolder(View itemView) {
        super(itemView);
        mItemView = itemView;
        mContent = (TextView) itemView.findViewById(R.id.title_content);
        mTime = (TextView) itemView.findViewById(R.id.news_item_time);
        mNewsFrom = (TextView) itemView.findViewById(R.id.news_item_from);
        mNewsIcon = (ImageView) itemView.findViewById(R.id.news_item_icon);
    }

    public MyViewHolder(Context context, View itemView) {
        super(itemView);
        mContext = context;
        mItemView = itemView;
    }

    public static MyViewHolder createViewHolder(Context context, View itemView) {
        MyViewHolder myViewHolder = new MyViewHolder(context, itemView);
        return myViewHolder;
    }
}

