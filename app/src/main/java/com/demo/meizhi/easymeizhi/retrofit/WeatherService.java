package com.demo.meizhi.easymeizhi.retrofit;

import com.demo.meizhi.easymeizhi.bean.BaseHttpBean;
import com.demo.meizhi.easymeizhi.bean.WeatherBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by 何祥源 on 16/7/5.
 * Desc:
 */
public interface WeatherService {
    @GET("index")
    Observable<BaseHttpBean<WeatherBean>> getWeather(@Query("format")int format, @Query("cityname")String cityName, @Query("key")String key);
}
