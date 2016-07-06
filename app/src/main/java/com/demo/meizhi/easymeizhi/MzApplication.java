package com.demo.meizhi.easymeizhi;

import android.app.Application;

/**
 * Created by 何祥源 on 16/7/6.
 * Desc:
 */
public class MzApplication extends Application {
    private static MzApplication Instance;

    @Override
    public void onCreate() {
        super.onCreate();
        Instance = this;
    }

    public static MzApplication getInstance() {
        return Instance;
    }
}
