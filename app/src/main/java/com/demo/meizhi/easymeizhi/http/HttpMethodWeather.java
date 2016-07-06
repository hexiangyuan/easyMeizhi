package com.demo.meizhi.easymeizhi.http;

import com.demo.meizhi.easymeizhi.bean.BaseHttpBean;
import com.demo.meizhi.easymeizhi.bean.WeatherBean;
import com.demo.meizhi.easymeizhi.retrofit.WeatherService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 何祥源 on 16/7/6.
 * Desc:
 */
public class HttpMethodWeather {
    private WeatherService weatherService = null;
    private Retrofit retrofit = null;
    private final static int TIME_OUT_SECOND = 3;

    /**
     * 私有化的构造函数初始化retrofit
     */
    public HttpMethodWeather() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(3, TimeUnit.SECONDS)
                .build();
        retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(Url.WEATHER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        weatherService = retrofit.create(WeatherService.class);
    }

    /**
     * singleton 单例
     */
    private static class SingletonHolder{
        private static final HttpMethodWeather INSTANCE = new HttpMethodWeather();
    }

    public static HttpMethodWeather getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * 获取天气的
     */
    public  void getWeather(String cityName, Subscriber<BaseHttpBean<WeatherBean>> subscriber){
        weatherService.getWeather(2,cityName,Url.KEY)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
