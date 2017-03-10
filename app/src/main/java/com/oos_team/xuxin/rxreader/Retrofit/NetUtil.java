package com.oos_team.xuxin.rxreader.Retrofit;

import com.oos_team.xuxin.rxreader.bean.ImageBean;
import com.oos_team.xuxin.rxreader.bean.NewsBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by xuxin on 17-2-16.
 * 网络申请接口类
 */

public class NetUtil extends RetrofitHelper {
    public static NetService mJuheservice;
    public static NetService mGankioservice;
//    public static final NetService mDoubanservice = getDoubanRetrofit().create(NetService.class);
//    public static final NetService mDongtingservice = getDongtingRetrofit().create(NetService.class);



    public interface NetService{
        /**
         * for juhe aip
         * @param name
         * @param key
         * @return
         */
        @GET("toutiao/index")
        Observable<NewsBean> getNewsWithType(@Query("type") String name, @Query("key") String key);

        @GET("data/{type}/{per_page}/{page}")
        Observable<ImageBean> getFuliBean(@Path("type") String type, @Path("per_page") int count, @Path("page") int page);

        @GET("/v2/book/10")
        Observable<ImageBean> getDoubanBook();
    }

    /**
     * for Juhe Api
     * @return
     */

    public static NetService getJuheService() {
        if (mJuheservice == null) {
            return getJuheRetrofit().create(NetService.class);
        }
        return mJuheservice;
    }

    public static NetService getGankioService() {
        if (mGankioservice == null) {
            return getGankioRetrofit().create(NetService.class);
        }
        return mGankioservice;
    }

    public static void getNewsWithType(Observer<NewsBean> observer, String type) {
        setSubscribe(getJuheService().getNewsWithType(type, "fb8020bbe3361c39650cdcc43a20c3dd"), observer);
    }

    public static void getGankioMeinv(Observer<ImageBean> observer, int count) {
        setSubscribe(getGankioService().getFuliBean("福利", count, 1), observer);
    }


    public static <T> void setSubscribe(Observable<T> observable, Observer<T> observer) {
        observable.subscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.newThread())//子线程访问网络
                .observeOn(AndroidSchedulers.mainThread())//回调到主线程
                .subscribe(observer);
    }
}
