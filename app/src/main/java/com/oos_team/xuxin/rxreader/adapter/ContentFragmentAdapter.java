package com.oos_team.xuxin.rxreader.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.oos_team.xuxin.rxreader.R;

import java.util.List;

/**
 * Created by xuxin on 17-2-23.
 */

public class ContentFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> mList;
    private Context mContext;
    public static final String[] mTitles = {"新闻","干货", "推荐", "电影"};
    public static final int[] mImageResId = {R.drawable.ic_nav_homepage, R.drawable.ic_nav_about,
                                R.drawable.ic_nav_deedback, R.drawable.ic_nav_scan};
    private int mCount = 4;

    public ContentFragmentAdapter(FragmentManager fm, List<Fragment> list, Context context) {
        super(fm);
        mList = list;
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mCount;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

    public View getTabView(int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.tab_item_view, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.tab_image);
        TextView  textView = (TextView) view.findViewById(R.id.tab_title);

        imageView.setImageResource(mImageResId[position]);
        textView.setText(mTitles[position]);
        return view;
    }
}
