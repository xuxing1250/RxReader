package com.oos_team.xuxin.rxreader.Retrofit;


import android.util.Log;

import com.oos_team.xuxin.rxreader.Applcation.MyApplication;

import java.io.File;
import java.net.CookieManager;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CookieJar;
import okhttp3.OkHttpClient;

/**
 * Created by xuxin on 17-2-16.
 */
public class OKHttpUtils {
    private static OkHttpClient mOkHttpClient;
    private static final String TAG = "OKHttpUtils";
    //设置缓存目录

    public static OkHttpClient getOkHttpClient() {
        Log.d(TAG, "getOkHttpClient: "+ MyApplication.getContext());
        File cacheDirectory = new File(MyApplication.getContext().getCacheDir().getAbsolutePath(), "MyCache");
        Cache cache = new Cache(cacheDirectory, 10 * 1024 * 1024);
        if (mOkHttpClient == null) {
            mOkHttpClient = new OkHttpClient.Builder()
//                    .cookieJar(new CookiesManager())
                    //.addInterceptor(new MyIntercepter())
                    //.addNetworkInterceptor(new CookiesInterceptor(MyApplication.getInstance().getApplicationContext()))
                    //设置请求读写的超时时间
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .cache(cache)
                    .build();
        }
        return mOkHttpClient;
    }
}
