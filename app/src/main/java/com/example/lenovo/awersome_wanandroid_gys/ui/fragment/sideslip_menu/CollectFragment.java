package com.example.lenovo.awersome_wanandroid_gys.ui.fragment.sideslip_menu;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.awersome_wanandroid_gys.R;
import com.example.lenovo.awersome_wanandroid_gys.base.BaseFragment;
import com.example.lenovo.awersome_wanandroid_gys.bean.Banners;
import com.example.lenovo.awersome_wanandroid_gys.bean.HomeList;
import com.example.lenovo.awersome_wanandroid_gys.bean.LoginData;
import com.example.lenovo.awersome_wanandroid_gys.bean.RegisterData;
import com.example.lenovo.awersome_wanandroid_gys.ui.fragment.home.HomesContract;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CollectFragment extends BaseFragment implements HomesContract.View{

    private HomesContract.Presenter mPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_collect, container, false);

        return view;
    }

    @Override
    public void setPresenter(HomesContract.Presenter presenter) {

        mPresenter=presenter;

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

    }

}
