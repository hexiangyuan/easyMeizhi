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
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends BaseActivity {
//    @BindView(R.id.btn_search)Button btnSearch;
    @BindView(R.id.til_address)TextInputLayout tilText;
    @BindView(R.id.edit_address)EditText editText;
    @BindView(R.id.tv_content)TextView tvContent;
    Retrofit retrofit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
         retrofit = new Retrofit.Builder()
                .baseUrl(Url.WEATHER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @OnClick(R.id.btn_search)
   public void searchClicked(){
        String cityName = editText.getText().toString();
        if(TextUtils.isEmpty(cityName)){
            tilText.setError("请输入城市名");
            return;
        }
        WeatherService weatherService = retrofit.create(WeatherService.class);
        weatherService.getWeather(2,editText.getText().toString(), Url.KEY)
                .enqueue(new Callback<WeatherBean>() {
                    @Override
                    public void onResponse(Call<WeatherBean> call, Response<WeatherBean> response) {
                        tvContent.setText(response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<WeatherBean> call, Throwable t) {
                        Toast.makeText(MainActivity.this,"错误",Toast.LENGTH_SHORT).show();
                    }
                });
    }

}
