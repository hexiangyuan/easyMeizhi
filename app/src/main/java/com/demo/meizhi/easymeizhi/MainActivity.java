package com.demo.meizhi.easymeizhi;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.meizhi.easymeizhi.base.BaseActivity;
import com.demo.meizhi.easymeizhi.bean.BaseHttpBean;
import com.demo.meizhi.easymeizhi.bean.WeatherBean;
import com.demo.meizhi.easymeizhi.http.HttpMethodWeather;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;

public class MainActivity extends BaseActivity {
    @BindView(R.id.til_address)
    TextInputLayout tilText;
    @BindView(R.id.edit_address)
    EditText editText;
    @BindView(R.id.tv_content)
    TextView tvContent;

    Subscriber<BaseHttpBean<WeatherBean>> subscriber = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        subscriber = new Subscriber<BaseHttpBean<WeatherBean>>() {
            @Override
            public void onCompleted() {
                Toast.makeText(MainActivity.this, "completed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNext(BaseHttpBean<WeatherBean> weatherBean) {
                setTvContent(weatherBean.result.toString());
            }
        };
    }

    @OnClick(R.id.btn_search)
    public void searchClicked() {
        String cityName = editText.getText().toString();
        if (TextUtils.isEmpty(cityName)) {
            tilText.setError("请输入城市名");
            return;
        }
        HttpMethodWeather.getInstance().getWeather(editText.getText().toString(), subscriber);
    }

    private void setTvContent(String str) {
        tvContent.setText(str);
    }

}
