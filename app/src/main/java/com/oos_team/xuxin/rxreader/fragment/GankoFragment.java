package com.oos_team.xuxin.rxreader.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.oos_team.xuxin.rxreader.R;
import com.oos_team.xuxin.rxreader.utils.Options;
import com.oos_team.xuxin.xrecycleview.XRecyclerView;

import org.w3c.dom.Text;

/**
 * Created by xuxin on 17-2-23.
 */

public class GankoFragment extends Fragment {
    private static final String TAG = "GankoFragment";

    private RecyclerView mGankioList;
    private GankoAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.gankio_fragment, container, false);
        mGankioList = (RecyclerView) view.findViewById(R.id.gankio_list);
        mAdapter = new GankoAdapter();
        mGankioList.setLayoutManager(new LinearLayoutManager(getContext()));
        mGankioList.setAdapter(mAdapter);
        return mGankioList;
    }

    public class GankoAdapter extends XRecyclerView.Adapter<XRecyclerView.ViewHolder> {
        public static final int GANKIO_ITEM_TYPE_HEADER = 0;
        public static final int GANKIO_ITEM_TYPE_ANDROID = 1;
        public static final int GANKIO_ITEM_TYPE_FULI = 2;
        public static final int GANKIO_ITEM_TYPE_IOS = 3;
        public static final int GANKIO_ITEM_TYPE_XIXIU = 4;
        public static final int GANKIO_ITEM_TYPE_TUOZHAN = 5;
        public static final int GANKIO_ITEM_TYPE_FOOTER = 6;


        @Override
        public XRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            if (viewType == GANKIO_ITEM_TYPE_HEADER) {
                View view = LayoutInflater.from(getContext()).inflate(R.layout.gankio_header_view, parent, false);
                GankioViewHeaderHolder viewHeaderHolder = new GankioViewHeaderHolder(view);
                ViewGroup.LayoutParams lp = viewHeaderHolder.mItemView.getLayoutParams();
                lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
                lp.width = ViewGroup.LayoutParams.MATCH_PARENT;
                return viewHeaderHolder;
            } else {
                View view = LayoutInflater.from(getContext()).inflate(R.layout.gankio_android_view, parent, false);
                GankioViewItemHolder viewItemHolder = new GankioViewItemHolder(view);
                //手动设置高度自适应 否则会出现高度过高的情况
                ViewGroup.LayoutParams lp = viewItemHolder.mItemView.getLayoutParams();
                lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
                lp.width = ViewGroup.LayoutParams.MATCH_PARENT;
                return viewItemHolder;
            }
        }

        @Override
        public void onBindViewHolder(XRecyclerView.ViewHolder holder, int position) {
            if (getItemViewType(position) == GANKIO_ITEM_TYPE_HEADER) {
                GankioViewHeaderHolder viewItemHolder = (GankioViewHeaderHolder) holder;
                ((GankioViewHeaderHolder) holder).mCurrentDay.
                        setText(Options.getSystemCurrentDate());
            } else {
                GankioViewItemHolder viewItemHolder = (GankioViewItemHolder) holder;
                viewItemHolder.mItemView.getWidth();
            }
        }

        @Override
        public int getItemCount() {
            return 4;
        }

        @Override
        public int getItemViewType(int position) {
            if (position == 0) {
                return GANKIO_ITEM_TYPE_HEADER;
            } else {
                return GANKIO_ITEM_TYPE_ANDROID;
            }
        }
    }

    public class GankioViewHeaderHolder extends XRecyclerView.ViewHolder {
        private ImageButton mXiandu, mEveryDay, mHotMovie;
        private View mItemView;
        private TextView mCurrentDay;
        public GankioViewHeaderHolder(View itemView) {
            super(itemView);
            mItemView = itemView;
            mXiandu = (ImageButton) mItemView.findViewById(R.id.ib_xiandu);
//            mEveryDay = (ImageButton) mItemView.findViewById(R.id.fl_everyday);
            mHotMovie = (ImageButton) mItemView.findViewById(R.id.ib_movie_hot);
            mCurrentDay = (TextView) mItemView.findViewById(R.id.tv_daily_text);
        }
    }

    public class GankioViewItemHolder extends XRecyclerView.ViewHolder {
        private View mItemView;
        public GankioViewItemHolder(View itemView) {
            super(itemView);
            mItemView = itemView;
        }
    }
}
