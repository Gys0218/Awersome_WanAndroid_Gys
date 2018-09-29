package com.example.lenovo.awersome_wanandroid_gys.data.source;

import com.example.lenovo.awersome_wanandroid_gys.bean.Banners;
import com.example.lenovo.awersome_wanandroid_gys.bean.HomeList;
import com.example.lenovo.awersome_wanandroid_gys.bean.LoginData;
import com.example.lenovo.awersome_wanandroid_gys.bean.RegisterData;
import com.trello.rxlifecycle2.LifecycleProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

import io.reactivex.Observer;

public interface HomeDataSource{

    //https://yunxue-bucket.oss-cn-shanghai.aliyuncs.com/imgurl/teacher/headimg_1516173827162.jpg
    void homeCorrelation(LifecycleProvider lifecycleProvider,int page, Observer<HomeList> observer);

    //Banner
    void banner(LifecycleProvider lifecycleProvider,Observer<ArrayList<Banners>> observer);

    //登录
    void login(LifecycleProvider lifecycleProvider, String username,String password, Observer<LoginData> observer);

    //注册
    void register(LifecycleProvider lifecycleProvider, HashMap<String,String> map, Observer<RegisterData> observer);

}
