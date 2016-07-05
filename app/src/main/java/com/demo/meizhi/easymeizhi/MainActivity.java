package com.demo.meizhi.easymeizhi;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.demo.meizhi.easymeizhi.base.BaseActivity;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    @BindView(R.id.btn_search)Button btnSearch;
    @BindView(R.id.btn_search)TextInputLayout tilText;
    @BindView(R.id.btn_search)EditText editText;
    @BindView(R.id.tv_content)TextView tvContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
