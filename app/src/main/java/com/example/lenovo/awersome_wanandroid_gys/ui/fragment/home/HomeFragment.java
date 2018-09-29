package com.example.lenovo.awersome_wanandroid_gys.ui.fragment.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.lenovo.awersome_wanandroid_gys.R;
import com.example.lenovo.awersome_wanandroid_gys.base.BaseFragment;
import com.example.lenovo.awersome_wanandroid_gys.bean.Banners;
import com.example.lenovo.awersome_wanandroid_gys.bean.HomeList;
import com.example.lenovo.awersome_wanandroid_gys.bean.LoginData;
import com.example.lenovo.awersome_wanandroid_gys.bean.RegisterData;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment implements HomesContract.View, RadioGroup.OnCheckedChangeListener {
    private HomesContract.Presenter mPresenter;

    private RadioGroup radioGroup;
    private RadioButton radio_home;
    private RadioButton radio_knowledge;
    private RadioButton radio_navigation;
    private RadioButton radio_progject;
    private FragmentTransaction transaction;
    private HomeChildFragment homeChildFragment;
    private KnowledgeChildFragment knowledgeChildFragment;
    private NavigationChildFragment navigationFragment;
    private ProgjectChildFragment progjectChildFragment;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        radioGroup = view.findViewById(R.id.radioGroup);
        radio_home = view.findViewById(R.id.radio_home);
        radio_knowledge = view .findViewById(R.id.radio_knowledge);
        radio_navigation = view.findViewById(R.id.radio_navigation);
        radio_progject = view.findViewById(R.id.radio_progject);

        transaction = getChildFragmentManager().beginTransaction();
        homeChildFragment = new HomeChildFragment();

        radio_home.setChecked(true);
        transaction.add(R.id.child_form,homeChildFragment).commit();

        radioGroup.setOnCheckedChangeListener(this);


        return view;
    }


    @Override
    public void setPresenter(HomesContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        FragmentManager childFragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = childFragmentManager.beginTransaction();
        switch (radioGroup.getId()){
            case R.id.radio_home:
                radio_home.setChecked(true);
                fragmentTransaction.add(R.id.child_form,homeChildFragment).commit();
                break;
            case R.id.radio_knowledge:
                knowledgeChildFragment = new KnowledgeChildFragment();
                radio_knowledge.setChecked(true);
                fragmentTransaction.add(R.id.child_form,knowledgeChildFragment);
                break;
            case R.id.radio_navigation:
                radio_navigation.setChecked(true);
                navigationFragment = new NavigationChildFragment();
                fragmentTransaction.add(R.id.child_form,navigationFragment);
                break;

            case R.id.radio_progject:
                radio_progject.setChecked(true);
                progjectChildFragment = new ProgjectChildFragment();
                fragmentTransaction.add(R.id.child_form, progjectChildFragment);
                break;

        }
        fragmentTransaction.commit();
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
