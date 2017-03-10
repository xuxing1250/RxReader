package com.oos_team.xuxin.rxreader.utils;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.oos_team.xuxin.rxreader.Applcation.MyApplication;

/**
 * Created by xuxin on 16-11-23.
 */


public class Options {
    /**
     * 新闻列表中用到的图片加载配置
     */
    public static DisplayImageOptions getListOptions() {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
//				// 设置图片在下载期间显示的图片
//				.showImageOnLoading(R.drawable.small_image_holder_listpage)
//				// 设置图片Uri为空或是错误的时候显示的图片
//				.showImageForEmptyUri(R.drawable.small_image_holder_listpage)
//				// 设置图片加载/解码过程中错误时候显示的图片
//				.showImageOnFail(R.drawable.small_image_holder_listpage)
                .cacheInMemory(true)
                // 设置下载的图片是否缓存在内存中
                .cacheOnDisc(true)
                // 设置下载的图片是否缓存在SD卡中
                .considerExifParams(true)
                .imageScaleType(ImageScaleType.EXACTLY_STRETCHED)// 设置图片以如何的编码方式显示
                .bitmapConfig(Bitmap.Config.RGB_565)// 设置图片的解码类型
                // .decodingOptions(android.graphics.BitmapFactory.Options
                // decodingOptions)//设置图片的解码配置
                .considerExifParams(true)
                // 设置图片下载前的延迟
                // .delayBeforeLoading(int delayInMillis)//int
                // delayInMillis为你设置的延迟时间
                // 设置图片加入缓存前，对bitmap进行设置
                // 。preProcessor(BitmapProcessor preProcessor)
                .resetViewBeforeLoading(true)// 设置图片在下载前是否重置，复位
                // .displayer(new RoundedBitmapDisplayer(20))//是否设置为圆角，弧度为多少
                .displayer(new FadeInBitmapDisplayer(100))// 淡入
                .build();
        return options;
    }


    //设置margin
    public static ViewGroup.MarginLayoutParams setMargin(View view, boolean isDp, int left, int right, int top , int bottom) {
        if (view == null) {
            return null;
        }
        int leftPx = left;
        int rightPx = right;
        int topPx = top;
        int bottomPx = bottom;

        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
        }
        if (isDp) {
            leftPx = dip2px(left);
            rightPx = dip2px(right);
            topPx = dip2px(top);
            bottomPx = dip2px(bottom);
        }
        //设置margin
        marginLayoutParams.setMargins(leftPx, topPx, rightPx, bottomPx);
        view.setLayoutParams(marginLayoutParams);
        view.requestLayout();
        return marginLayoutParams;
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(float dpValue) {
        final float scale = MyApplication.getInstance().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
