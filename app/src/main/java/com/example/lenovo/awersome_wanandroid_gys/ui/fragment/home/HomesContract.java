package com.example.lenovo.awersome_wanandroid_gys.ui.fragment.home;

import com.example.lenovo.awersome_wanandroid_gys.base.BasePresenter;
import com.example.lenovo.awersome_wanandroid_gys.base.BaseView;
import com.example.lenovo.awersome_wanandroid_gys.bean.Banners;
import com.example.lenovo.awersome_wanandroid_gys.bean.HomeList;
import com.example.lenovo.awersome_wanandroid_gys.bean.LoginData;
import com.example.lenovo.awersome_wanandroid_gys.bean.RegisterData;

import java.util.ArrayList;

public interface HomesContract {

    public interface View extends BaseView<HomesContract.Presenter>{

        //首页相关
        void getHomeFail(String message);
        void getHomeSucees(HomeList homeLists);

        //轮播图
        void getBannerFail(String message);
        void getBannerSucees(ArrayList<Banners> banners);

        //登录
        void getLoginFail(String message);
        void getLoginSucees(LoginData loginData);

        //注册
        void  getRegisterFail(String message);
        void getRegisterSucess(RegisterData registerData);
    }




    public interface Presenter extends BasePresenter<HomesContract.View>{

        //首页相关
        void HomeCorrelation(int pager);

        //轮播图
        void Banner();

        //登录
        void login(String username,String password);

        //注册
        void register(String usernmae,String password,String repassword);
    }

}
