package com.oos_team.xuxin.rxreader.Applcation;

import android.app.Application;
import android.content.Context;
import android.util.Log;



/**
 * Created by xuxin on 17-2-16.
 */

public class MyApplication  extends Application {
    private static Context mContext;
    private static final String TAG = "MyApplication";
    private static MyApplication mMyApplication;


    @Override
    public void onCreate() {
        Log.d("OKHttpUtils", "onCreate: ");
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static MyApplication getInstance() {
        if (mMyApplication == null) {
            mMyApplication =  new MyApplication();
        }
        Log.d(TAG, "getInstance: "+mMyApplication);
        return mMyApplication;
    }

    public static Context getContext() {
        return mContext;
    }
}
