package com.example.lenovo.awersome_wanandroid_gys.ui.fragment.home;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.lenovo.awersome_wanandroid_gys.R;
import com.example.lenovo.awersome_wanandroid_gys.base.BaseFragment;
import com.example.lenovo.awersome_wanandroid_gys.bean.Banners;
import com.example.lenovo.awersome_wanandroid_gys.bean.Datas;
import com.example.lenovo.awersome_wanandroid_gys.bean.HomeList;
import com.example.lenovo.awersome_wanandroid_gys.bean.LoginData;
import com.example.lenovo.awersome_wanandroid_gys.bean.RegisterData;
import com.example.lenovo.awersome_wanandroid_gys.data.source.HomeRemoteSource;
import com.example.lenovo.awersome_wanandroid_gys.data.source.HomeRepositorySource;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeChildFragment extends BaseFragment implements HomesContract.View {

    private RecyclerView home_rv;
    private SmartRefreshLayout refreshLayout;
    private HomesPresenter presenter;
    private int page = 0;
    private HomeAdapter adapter;
    private ArrayList<Datas> list = new ArrayList<>();
    private View inflate;
    private Banner banner;
    private ArrayList<String> bannerTitle;
    private ArrayList<String> bannerUrl;
    private ArrayList<String> bannerImg;
    ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_child, container, false);
        inflate = inflater.inflate(R.layout.home_banner, null);


        presenter = new HomesPresenter(HomeRepositorySource.getInstance(HomeRemoteSource.getInstance()));

        setPresenter(presenter);

        presenter.Banner();
        presenter.HomeCorrelation(page);


        initView(view);
        return view;
    }

    private void initView(View view) {
        home_rv = (RecyclerView) view.findViewById(R.id.home_rv);
        refreshLayout = (SmartRefreshLayout) view.findViewById(R.id.refreshLayout);
        banner = inflate.findViewById(R.id.banner);

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        home_rv.setLayoutManager(manager);

        home_rv.addItemDecoration(new SpaceItemDecoration(20));

        adapter = new HomeAdapter(list);
        adapter.addHeaderView(inflate);
        home_rv.setAdapter(adapter);


        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                presenter.HomeCorrelation(0);
                refreshLayout.finishRefresh(2000);
            }
        });

        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                page++;
                //下拉加载数据
                presenter.HomeCorrelation(page);

                refreshLayout.finishLoadmore(2000);

            }
        });

    }

    @Override
    public void getHomeFail(String message) {

    }

    @Override
    public void getHomeSucees(HomeList homeLists) {

        list.addAll(homeLists.getDatas());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void getBannerFail(String message) {

    }

    @Override
    public void getBannerSucees(ArrayList<Banners> banners) {

        bannerTitle = new ArrayList<>();
        bannerUrl = new ArrayList<>();
        bannerImg = new ArrayList<>();

        for (int i = 0; i < banners.size(); i++) {
            bannerTitle.add(banners.get(i).getTitle());
            bannerUrl.add(banners.get(i).getUrl());
            bannerImg.add(banners.get(i).getImagePath());
        }

        //设置banner样式
        banner.setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(bannerImg);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
        banner.setBannerTitles(bannerTitle);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(banners.size() * 400);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
//        banner.setOnBannerListener(i -> JudgeUtils.startArticleDetailActivity(_mActivity, null,
//                0, mBannerTitleList.get(i), mBannerUrlList.get(i),
//                false, false, true));
        //banner设置方法全部调vz用完毕时最后调用
        banner.start();
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


    @Override
    public void setPresenter(HomesContract.Presenter presenter) {
        presenter = presenter;
        presenter.attachView(this);
    }
}
