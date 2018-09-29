package com.example.lenovo.awersome_wanandroid_gys.data.source;

import com.example.lenovo.awersome_wanandroid_gys.bean.Banners;
import com.example.lenovo.awersome_wanandroid_gys.bean.HomeList;
import com.example.lenovo.awersome_wanandroid_gys.bean.LoginData;
import com.example.lenovo.awersome_wanandroid_gys.bean.RegisterData;
import com.trello.rxlifecycle2.LifecycleProvider;

import java.util.ArrayList;
import java.util.HashMap;

import io.reactivex.Observer;

public class HomeRepositorySource implements HomeDataSource {
    private HomeDataSource mRemote;

    private static HomeRepositorySource INSTANCE;

    private HomeRepositorySource(HomeDataSource remote){
        mRemote =remote;
    }

    public static synchronized HomeRepositorySource getInstance(HomeDataSource remote){
        if (INSTANCE == null){
            INSTANCE = new HomeRepositorySource(remote);
        }
        return INSTANCE;
    }



    @Override
    public void homeCorrelation(LifecycleProvider lifecycleProvider, int page, Observer<HomeList> observer) {
        mRemote.homeCorrelation(lifecycleProvider,page,observer);
    }

    @Override
    public void banner(LifecycleProvider lifecycleProvider, Observer<ArrayList<Banners>> observer) {
        mRemote.banner(lifecycleProvider,observer);
    }

    @Override
    public void login(LifecycleProvider lifecycleProvider, String username, String password, Observer<LoginData> observer) {
        mRemote.login(lifecycleProvider,username,password,observer);
    }

    @Override
    public void register(LifecycleProvider lifecycleProvider, HashMap<String, String> map, Observer<RegisterData> observer) {
        mRemote.register(lifecycleProvider,map,observer);
    }

}
