package com.demo.meizhi.easymeizhi;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.meizhi.easymeizhi.base.BaseActivity;
import com.demo.meizhi.easymeizhi.bean.WeatherBean;
import com.demo.meizhi.easymeizhi.http.Url;
import com.demo.meizhi.easymeizhi.retrofit.WeatherService;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends BaseActivity {
    @BindView(R.id.til_address)
    TextInputLayout tilText;
    @BindView(R.id.edit_address)
    EditText editText;
    @BindView(R.id.tv_content)
    TextView tvContent;
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        retrofit = new Retrofit.Builder()
                .baseUrl(Url.WEATHER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @OnClick(R.id.btn_search)
    public void searchClicked() {
        String cityName = editText.getText().toString();
        if (TextUtils.isEmpty(cityName)) {
            tilText.setError("请输入城市名");
            return;
        }
        WeatherService weatherService = retrofit.create(WeatherService.class);


        weatherService.getWeather(2, editText.getText().toString(), Url.KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<WeatherBean>() {
                    @Override
                    public void onCompleted() {
                        Toast.makeText(MainActivity.this, "Complete", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(WeatherBean weatherBean) {
                        setTvContent(weatherBean.toString());
                    }
                });
    }

    private void setTvContent(String str) {
        tvContent.setText(str);
    }

}
