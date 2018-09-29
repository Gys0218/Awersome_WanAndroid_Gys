package com.example.lenovo.awersome_wanandroid_gys.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.awersome_wanandroid_gys.R;
import com.example.lenovo.awersome_wanandroid_gys.base.BaseActivity;
import com.example.lenovo.awersome_wanandroid_gys.bean.Banners;
import com.example.lenovo.awersome_wanandroid_gys.bean.HomeList;
import com.example.lenovo.awersome_wanandroid_gys.bean.LoginData;
import com.example.lenovo.awersome_wanandroid_gys.bean.RegisterData;
import com.example.lenovo.awersome_wanandroid_gys.data.source.HomeDataSource;
import com.example.lenovo.awersome_wanandroid_gys.data.source.HomeRemoteSource;
import com.example.lenovo.awersome_wanandroid_gys.data.source.HomeRepositorySource;
import com.example.lenovo.awersome_wanandroid_gys.ui.fragment.home.HomesContract;
import com.example.lenovo.awersome_wanandroid_gys.ui.fragment.home.HomesPresenter;

import java.util.ArrayList;

public class LoginActivity extends BaseActivity implements HomesContract.View, View.OnClickListener {

    private HomesPresenter mPresenter;
    private Toolbar login_toolbar;
    private TextView login_tv;
    private EditText login_name_edit;
    private LinearLayout login_account_group;
    private View login_divider;
    private EditText login_psw_edit;
    private LinearLayout login_password_group;
    private View register_divider;
    private Button login_btn;
    private TextView login_or_tv;
    private Button login_register_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mPresenter = new HomesPresenter(HomeRepositorySource.getInstance(HomeRemoteSource.getInstance()));
        setPresenter(mPresenter);
        initView();
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
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getLoginSucees(LoginData loginData) {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("data",loginData);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }

    @Override
    public void getRegisterFail(String message) {

    }

    @Override
    public void getRegisterSucess(RegisterData registerData) {

    }

    @Override
    public void setPresenter(HomesContract.Presenter presenter) {
        mPresenter= (HomesPresenter) presenter;
        mPresenter.attachView(this);
    }

    @Override
    public Activity getActivity() {
        return null;
    }

    private void initView() {
        login_toolbar = (Toolbar) findViewById(R.id.login_toolbar);
        login_tv = (TextView) findViewById(R.id.login_tv);
        login_name_edit = (EditText) findViewById(R.id.login_name_edit);
        login_account_group = (LinearLayout) findViewById(R.id.login_account_group);
        login_divider = (View) findViewById(R.id.login_divider);
        login_psw_edit = (EditText) findViewById(R.id.login_psw_edit);
        login_password_group = (LinearLayout) findViewById(R.id.login_password_group);
        register_divider = (View) findViewById(R.id.register_divider);
        login_btn = (Button) findViewById(R.id.login_btn);
        login_or_tv = (TextView) findViewById(R.id.login_or_tv);
        login_register_btn = (Button) findViewById(R.id.login_register_btn);

        login_btn.setOnClickListener(this);
        login_register_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_btn:
                String userName = login_name_edit.getText().toString();
                String password = login_psw_edit.getText().toString();
                mPresenter.login(userName,password);

                break;
            case R.id.login_register_btn:
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }

}
