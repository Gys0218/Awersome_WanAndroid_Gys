package com.example.lenovo.awersome_wanandroid_gys.base;

public interface BasePresenter<T extends BaseView> {

    void attachView(T baseView);

    void detachView();

}
