package com.example.lenovo.awersome_wanandroid_gys.ui.fragment.home;

import android.util.Log;

import com.example.lenovo.awersome_wanandroid_gys.bean.Banners;
import com.example.lenovo.awersome_wanandroid_gys.bean.Datas;
import com.example.lenovo.awersome_wanandroid_gys.bean.HomeList;
import com.example.lenovo.awersome_wanandroid_gys.bean.LoginData;
import com.example.lenovo.awersome_wanandroid_gys.bean.RegisterData;
import com.example.lenovo.awersome_wanandroid_gys.data.source.HomeDataSource;
import com.example.lenovo.awersome_wanandroid_gys.data.source.HomeRepositorySource;
import com.trello.rxlifecycle2.LifecycleProvider;

import java.util.ArrayList;
import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class HomesPresenter implements HomesContract.Presenter {
    private HomesContract.View mView;
    private HomeDataSource mHomeDataSource;

    public HomesPresenter(HomeRepositorySource homeRepositorySource){
        mHomeDataSource = homeRepositorySource;
    }

    @Override
    public void attachView(HomesContract.View baseView) {
        mView = baseView;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    @Override
    public void HomeCorrelation(int pager) {

        //网络请求
        mHomeDataSource.homeCorrelation((LifecycleProvider) mView, pager, new Observer<HomeList>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(HomeList homeLists) {
                mView.getHomeSucees(homeLists);
            }



            @Override
            public void onError(Throwable e) {
                mView.getHomeFail(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void Banner() {
        mHomeDataSource.banner((LifecycleProvider) mView, new Observer<ArrayList<Banners>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ArrayList<Banners> banners) {
                mView.getBannerSucees(banners);
            }

            @Override
            public void onError(Throwable e) {
                mView.getBannerFail(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void login(String username, String password) {


        mHomeDataSource.login((LifecycleProvider) mView, username,password, new Observer<LoginData>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(LoginData loginData) {
                Log.d("HomesPresenter", loginData.toString());
                mView.getLoginSucees(loginData);
            }

            @Override
            public void onError(Throwable e) {
                Log.d("HomesPresenter", e.getMessage());
                mView.getLoginFail(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void register(String usernmae, String password, String repassword) {
        HashMap<String, String> map = new HashMap<>();
        map.put("username",usernmae);
        map.put("password",password);
        map.put("repassword",repassword);

        mHomeDataSource.register((LifecycleProvider) mView, map, new Observer<RegisterData>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(RegisterData registerData) {
                mView.getRegisterSucess(registerData);
            }

            @Override
            public void onError(Throwable e) {
                mView.getRegisterFail(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
