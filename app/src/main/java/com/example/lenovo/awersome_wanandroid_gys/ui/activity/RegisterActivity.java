package com.example.lenovo.awersome_wanandroid_gys.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.awersome_wanandroid_gys.R;
import com.example.lenovo.awersome_wanandroid_gys.base.BaseActivity;
import com.example.lenovo.awersome_wanandroid_gys.bean.Banners;
import com.example.lenovo.awersome_wanandroid_gys.bean.HomeList;
import com.example.lenovo.awersome_wanandroid_gys.bean.LoginData;
import com.example.lenovo.awersome_wanandroid_gys.bean.RegisterData;
import com.example.lenovo.awersome_wanandroid_gys.data.source.HomeRemoteSource;
import com.example.lenovo.awersome_wanandroid_gys.data.source.HomeRepositorySource;
import com.example.lenovo.awersome_wanandroid_gys.ui.fragment.home.HomesContract;
import com.example.lenovo.awersome_wanandroid_gys.ui.fragment.home.HomesPresenter;

import java.util.ArrayList;

public class RegisterActivity extends BaseActivity implements View.OnClickListener, HomesContract.View {

    private TextView reg_close;
    private Toolbar common_toolbar;
    private EditText reg_psw;
    private EditText register_username;
    private EditText reg_repsw;
    private Button register_btn;
    private HomesPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        presenter = new HomesPresenter(HomeRepositorySource.getInstance(HomeRemoteSource.getInstance()));
        setPresenter(presenter);
        initView();
    }

    private void initView() {
        reg_close = (TextView) findViewById(R.id.reg_close);
        common_toolbar = (Toolbar) findViewById(R.id.common_toolbar);
        reg_psw = (EditText) findViewById(R.id.reg_psw);
        register_username = (EditText) findViewById(R.id.register_username);
        reg_repsw = (EditText) findViewById(R.id.reg_repsw);
        register_btn = (Button) findViewById(R.id.register_btn);

        register_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_btn:
                String username = register_username.getText().toString();
                String psw = reg_psw.getText().toString();
                String repsw = reg_repsw.getText().toString();
                presenter.register(username,psw,repsw);
                break;
        }
    }

    @Override
    public void getHomeFail(String message) {

    }

    @Override
    public void getHomeSucees(HomeList homeLists) {

    }

    @Override
    public void getBannerFail(String message) {

    }

    @Override
    public void getBannerSucees(ArrayList<Banners> banners) {

    }

    @Override
    public void getLoginFail(String message) {

    }

    @Override
    public void getLoginSucees(LoginData loginData) {

    }

    @Override
    public void getRegisterFail(String message) {

    }

    @Override
    public void getRegisterSucess(RegisterData registerData) {
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void setPresenter(HomesContract.Presenter presenter) {
        presenter = presenter;
        presenter.attachView(this);
    }

    @Override
    public Activity getActivity() {
        return null;
    }
}
