package com.example.lenovo.awersome_wanandroid_gys.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.Window;

import com.example.lenovo.awersome_wanandroid_gys.R;
import com.example.lenovo.awersome_wanandroid_gys.utlis.StatusBarCompat;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.util.List;

public class BaseActivity extends RxAppCompatActivity{

    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);




        mFragmentManager = getSupportFragmentManager();

        mFragmentManager= getSupportFragmentManager();
        StatusBarCompat.compat(this, R.color.colorAccent);

    }

    public  <T extends BaseFragment,E extends BasePresenter> void addFragment(@NonNull Class<T> tClass, E presenter, int containerId, String tag, Bundle args) throws InstantiationException, IllegalAccessException {

        if (TextUtils.isEmpty(tag)){
            tag = tClass.getName();
        }

        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        Fragment addedFragment = mFragmentManager.findFragmentByTag(tag);

        BaseFragment targetFragment = null;

        if (addedFragment == null){
            targetFragment = tClass.newInstance();
            targetFragment.setArguments(args);

            if (targetFragment instanceof BaseView){
                ((BaseView) targetFragment).setPresenter(presenter);
            }
            addFragmentAnimation(fragmentTransaction,targetFragment);
            fragmentTransaction.add(containerId,targetFragment,tag);

        }else {
            targetFragment = (BaseFragment) addedFragment;
            addFragmentAnimation(fragmentTransaction,targetFragment);
            targetFragment.setArguments(args);
            if (targetFragment.isHidden()){
                fragmentTransaction.show(targetFragment);
            }
        }

        if (targetFragment != null){
            hidePreFragment(fragmentTransaction,targetFragment);

            if (targetFragment.isNeedAddToBackStack()){
                fragmentTransaction.addToBackStack(tag);
            }
            fragmentTransaction.commit();
        }

    }

    private void hidePreFragment(FragmentTransaction fragmentTransaction, BaseFragment targetFragment) {

        if (targetFragment.isNeedHidePreFragment()){
            List<Fragment> fragments = mFragmentManager.getFragments();

            for (Fragment fragment: fragments) {
                if (fragment != targetFragment){
                    fragmentTransaction.hide(fragment);
                }
            }
        }
    }

    private void addFragmentAnimation(FragmentTransaction fragmentTransaction, BaseFragment targetFragment) {
        fragmentTransaction.setCustomAnimations(targetFragment.getSelfEnterAnimId(),targetFragment.getPreExistAnimId(),targetFragment.getSelfPopExistAnimId(),targetFragment.getPrePopEnterAnimId());
    }


}
