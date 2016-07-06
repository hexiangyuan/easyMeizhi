package com.demo.meizhi.easymeizhi.bean;

import java.util.List;

/**
 * Created by 何祥源 on 16/7/5.
 * Desc:
 */
public class WeatherBean {

    public SkBean sk;
    public TodayBean today;
    public List<FutureBean> future;

    public static class SkBean {
        public String temp;
        public String wind_direction;
        public String wind_strength;
        public String humidity;
        public String time;
    }

    public static class TodayBean {
        public String temperature;
        public String weather;
        public WeatherIdBean weather_id;
        public String wind;
        public String week;
        public String city;
        public String date_y;
        public String dressing_index;
        public String dressing_advice;
        public String uv_index;
        public String comfort_index;
        public String wash_index;
        public String travel_index;
        public String exercise_index;
        public String drying_index;

        public static class WeatherIdBean {
            public String fa;
            public String fb;
        }
    }

    public static class FutureBean {
        public String temperature;
        public String weather;
        public WeatherIdBean weather_id;
        public String wind;
        public String week;
        public String date;

        public static class WeatherIdBean {
            public String fa;
            public String fb;
        }
    }

    @Override
    public String toString() {

        return today.weather + today.temperature + today.wind;
    }
}
