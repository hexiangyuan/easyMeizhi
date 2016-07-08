package com.demo.meizhi.easymeizhi;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;

import com.demo.meizhi.easymeizhi.base.BaseActivity;
import com.demo.meizhi.easymeizhi.bean.BaseHttpBean;
import com.demo.meizhi.easymeizhi.bean.WeatherBean;
import com.demo.meizhi.easymeizhi.http.HttpMethodWeather;
import com.demo.meizhi.easymeizhi.util.ToastUtil;

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

    }

    @OnClick(R.id.btn_search)
    public void searchClicked() {
        String cityName = editText.getText().toString();
        if (TextUtils.isEmpty(cityName)) {
            tilText.setError("请输入城市名");
            return;
        }
        subscriber = new Subscriber<BaseHttpBean<WeatherBean>>() {
            @Override
            public void onStart() {
                super.onStart();
            }

            @Override
            public void onCompleted() {
                ToastUtil.showToast("Completed");
            }

            @Override
            public void onError(Throwable e) {
                ToastUtil.showToast(e.getMessage());
            }

            @Override
            public void onNext(BaseHttpBean<WeatherBean> weatherBean) {
                setTvContent(weatherBean.result.toString());
            }
        };
        HttpMethodWeather.getInstance().getWeather(editText.getText().toString(), subscriber);
    }

    private void setTvContent(String str) {
        tvContent.setText(str);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (subscriber != null)
            subscriber.unsubscribe();
        subscriber = null;
    }
}
