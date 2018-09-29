package com.example.lenovo.awersome_wanandroid_gys.data.source;

import com.example.lenovo.awersome_wanandroid_gys.bean.Banners;
import com.example.lenovo.awersome_wanandroid_gys.bean.HomeList;
import com.example.lenovo.awersome_wanandroid_gys.bean.HttpResult;
import com.example.lenovo.awersome_wanandroid_gys.bean.LoginData;
import com.example.lenovo.awersome_wanandroid_gys.bean.RegisterData;
import com.example.lenovo.awersome_wanandroid_gys.data.retrofit.ApiService;
import com.example.lenovo.awersome_wanandroid_gys.data.retrofit.DataRetrofit;
import com.example.lenovo.awersome_wanandroid_gys.utlis.ServerException;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.android.FragmentEvent;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class HomeRemoteSource implements HomeDataSource{
    private static HomeRemoteSource INSTANCE = null;
    private final ApiService apiService;

    public HomeRemoteSource(){
        apiService = DataRetrofit.getRetrofitService();
    }

    public static synchronized HomeRemoteSource getInstance(){
        if (INSTANCE ==null){
            INSTANCE = new HomeRemoteSource();
        }
        return INSTANCE;
    }

    @Override
    public void homeCorrelation(LifecycleProvider lifecycleProvider, int page, Observer<HomeList> observer) {
        Observable<HttpResult<HomeList>> observable = apiService.home(page);
        observable.flatMap(new Function<HttpResult<HomeList>, ObservableSource<HomeList>>() {
            @Override
            public ObservableSource<HomeList> apply(HttpResult<HomeList> arrayListHttpResult) throws Exception {
                if (arrayListHttpResult.getErrorCode() == 0){
                    return Observable.just(arrayListHttpResult.getData());
                }
                return Observable.error(new ServerException(arrayListHttpResult.getErrorCode(),arrayListHttpResult.getErrorMsg()));
            }
        }).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose((lifecycleProvider instanceof RxAppCompatActivity) ? ((RxAppCompatActivity) lifecycleProvider).<ArrayList<HomeList>>bindUntilEvent(ActivityEvent.DESTROY):lifecycleProvider.<ArrayList<HomeList>>bindUntilEvent(FragmentEvent.DESTROY))
                .subscribe(observer);
    }

    @Override
    public void banner(LifecycleProvider lifecycleProvider, Observer<ArrayList<Banners>> observer) {
        Observable<HttpResult<ArrayList<Banners>>> observable = apiService.banner();
        observable.flatMap(new Function<HttpResult<ArrayList<Banners>>, ObservableSource<ArrayList<Banners>>>() {
            @Override
            public ObservableSource<ArrayList<Banners>> apply(HttpResult<ArrayList<Banners>> arrayListHttpResult) throws Exception {
                if (arrayListHttpResult.getErrorCode() == 0){
                    return Observable.just(arrayListHttpResult.getData());
                }
                return Observable.error(new ServerException(arrayListHttpResult.getErrorCode(),arrayListHttpResult.getErrorMsg()));
            }
        }).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose((lifecycleProvider instanceof RxAppCompatActivity) ? (((RxAppCompatActivity) lifecycleProvider).<ArrayList<Banners>>bindUntilEvent(ActivityEvent.DESTROY)):lifecycleProvider.<ArrayList<Banners>>bindUntilEvent(FragmentEvent.DESTROY))
                .subscribe(observer);
    }

    @Override
    public void login(LifecycleProvider lifecycleProvider, String username,String password, Observer<LoginData> observer) {
        Observable<HttpResult<LoginData>> observable = apiService.login(username,password);
        observable.flatMap(new Function<HttpResult<LoginData>, ObservableSource<LoginData>>() {
            @Override
            public ObservableSource<LoginData> apply(HttpResult<LoginData> loginDataHttpResult) throws Exception {
                if (loginDataHttpResult.getErrorCode() == 0){
                    return Observable.just(loginDataHttpResult.getData());
                }
                return Observable.error(new ServerException(loginDataHttpResult.getErrorCode(),loginDataHttpResult.getErrorMsg()));
            }
        }).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose((lifecycleProvider instanceof RxAppCompatActivity) ? ((RxAppCompatActivity) lifecycleProvider).<LoginData>bindUntilEvent(ActivityEvent.DESTROY):lifecycleProvider.<LoginData>bindUntilEvent(FragmentEvent.DESTROY))
                .subscribe(observer);

    }

    @Override
    public void register(LifecycleProvider lifecycleProvider, HashMap<String, String> map, Observer<RegisterData> observer) {
        Observable<HttpResult<RegisterData>> observable = apiService.register(map);
        observable.flatMap(new Function<HttpResult<RegisterData>, ObservableSource<RegisterData>>() {
            @Override
            public ObservableSource<RegisterData> apply(HttpResult<RegisterData> registerDataHttpResult) throws Exception {
                if (registerDataHttpResult.getErrorCode() == 0){
                    return Observable.just(registerDataHttpResult.getData());
                }
                return Observable.error(new ServerException(registerDataHttpResult.getErrorCode(),registerDataHttpResult.getErrorMsg()));
            }
        }).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose((lifecycleProvider instanceof RxAppCompatActivity) ? ((RxAppCompatActivity) lifecycleProvider).<RegisterData>bindUntilEvent(ActivityEvent.DESTROY):lifecycleProvider.<RegisterData>bindUntilEvent(FragmentEvent.DESTROY))
                .subscribe(observer);
    }
}
