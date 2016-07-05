package com.demo.meizhi.easymeizhi.bean;

/**
 * Created by 何祥源 on 16/7/5.
 * Desc:
 */
public class WeatherBean {

    public String resultcode;
    public String reason;
    public ResultBean result;
    public int error_code;

    public static class ResultBean {
        public SkBean sk;
        public TodayBean today;
        public FutureBean future;

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
            public Day20160705Bean day_20160705;
            public Day20160706Bean day_20160706;
            public Day20160707Bean day_20160707;
            public Day20160708Bean day_20160708;
            public Day20160709Bean day_20160709;
            public Day20160710Bean day_20160710;
            public Day20160711Bean day_20160711;

            public static class Day20160705Bean {
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

            public static class Day20160706Bean {
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

            public static class Day20160707Bean {
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

            public static class Day20160708Bean {
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

            public static class Day20160709Bean {
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

            public static class Day20160710Bean {
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

            public static class Day20160711Bean {
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
        }
    }
}
