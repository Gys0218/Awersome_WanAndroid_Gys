package com.example.lenovo.awersome_wanandroid_gys.base;

import android.app.Activity;

public interface BaseView<T extends BasePresenter> {

    void setPresenter(T presenter);

    Activity getActivity();

}
