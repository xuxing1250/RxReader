package com.oos_team.xuxin.rxreader.Retrofit;



import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by xuxin on 17-2-16.
 * 创建Retrofit对象
 */

public abstract class RetrofitHelper {
    private static RetrofitHelper mRetrofitHelper;
    private static Retrofit mJuheRetrofit;
    private static Retrofit mDoubanRetrofit;
    private static Retrofit mGankioRetrofit;
    private static Retrofit mDongtingRetrofit;

    private static OkHttpClient mJuheOkHttpClient;
    private static OkHttpClient mGankioOkHttpClient;

    public static final String API_JUHE = "http://v.juhe.cn";
    public final static String API_GANKIO = "http://gank.io/api/";
    public final static String API_DOUBAN = "https://api.douban.com";
    public final static String API_DONGTING = "http://api.dongting.com";

    /**
     * for juhe api
     * @return
     */

    public static Retrofit getJuheRetrofit() {
        if (mJuheRetrofit == null) {
            if (mJuheOkHttpClient == null) {
                mJuheOkHttpClient = OKHttpUtils.getOkHttpClient();
            }
            mJuheRetrofit = new Retrofit.Builder()
                    .baseUrl(API_JUHE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(mJuheOkHttpClient)
                    .build();
            return mJuheRetrofit;
        }
        return mJuheRetrofit;
    }

    /**
     * for gankio api
     * @return
     */
    public static Retrofit getGankioRetrofit() {
        if (mGankioRetrofit ==  null) {
            if (mGankioOkHttpClient == null) {
                mGankioOkHttpClient = OKHttpUtils.getOkHttpClient();
            }
            mGankioRetrofit = new Retrofit.Builder()
                    .baseUrl(API_GANKIO)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(mGankioOkHttpClient)
                    .build();
            return mGankioRetrofit;

        }
        return mGankioRetrofit;
    }

    /**
     * for douban api
     * @return
     */

    public static Retrofit getDoubanRetrofit() {
        if (mDoubanRetrofit ==  null) {
            if (mGankioOkHttpClient == null) {
                mGankioOkHttpClient = OKHttpUtils.getOkHttpClient();
            }
            mDoubanRetrofit = new Retrofit.Builder()
                    .baseUrl(API_DOUBAN)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(mGankioOkHttpClient)
                    .build();
            return mDoubanRetrofit;

        }
        return mDoubanRetrofit;
    }

    /**
     * for DongtingApi
     * @return
     */
    public static Retrofit getDongtingRetrofit() {
        if (mDongtingRetrofit ==  null) {
            if (mGankioOkHttpClient == null) {
                mGankioOkHttpClient = OKHttpUtils.getOkHttpClient();
            }
            mDongtingRetrofit = new Retrofit.Builder()
                    .baseUrl(API_DONGTING)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(mGankioOkHttpClient)
                    .build();
            return mDongtingRetrofit;
        }
        return mDongtingRetrofit;
    }









}
