package com.example.lenovo.awersome_wanandroid_gys.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.awersome_wanandroid_gys.R;
import com.example.lenovo.awersome_wanandroid_gys.base.BaseActivity;
import com.example.lenovo.awersome_wanandroid_gys.bean.LoginData;
import com.example.lenovo.awersome_wanandroid_gys.data.source.HomeRemoteSource;
import com.example.lenovo.awersome_wanandroid_gys.data.source.HomeRepositorySource;
import com.example.lenovo.awersome_wanandroid_gys.ui.fragment.home.HomeFragment;
import com.example.lenovo.awersome_wanandroid_gys.ui.fragment.home.HomesPresenter;
import com.example.lenovo.awersome_wanandroid_gys.ui.fragment.sideslip_menu.AbouvActivity;
import com.example.lenovo.awersome_wanandroid_gys.ui.fragment.sideslip_menu.CollectFragment;
import com.example.lenovo.awersome_wanandroid_gys.ui.fragment.sideslip_menu.SettingFragment;

import java.io.Serializable;

public class HomeActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ImageView sideslip_head;
    private TextView sideslip_login;
    private HomesPresenter presenter;
    public static boolean isFirstRun = true;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View headerView = navigationView.getHeaderView(0);
        sideslip_login = headerView.findViewById(R.id.sideslip_login);
        sideslip_head = headerView.findViewById(R.id.spread_inside);

        sideslip_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo 跳转登录Activity
                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        presenter = new HomesPresenter(HomeRepositorySource.getInstance(HomeRemoteSource.getInstance()));
        try {
            addFragment(HomeFragment.class, presenter, R.id.form, null, null);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        if (!isFirstRun) {

            Intent intent = getIntent();
            Bundle extras = intent.getExtras();
            LoginData data = (LoginData) extras.getSerializable("data");
            if (data != null) {
                sideslip_login.setText(data.getUsername());
                sideslip_login.setClickable(false);

            }
        }

        isFirstRun = false;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) { //ToolBar右边菜单
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.menu_home) {
            //主页面
            try {
                addFragment(HomeFragment.class, presenter, R.id.form, null, null);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        } else if (id == R.id.menu_collect) {
            //选中弹出收藏页面
            try {
                addFragment(CollectFragment.class, presenter, R.id.form, null, null);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } else if (id == R.id.menu_setting) {
            //选中 弹出设置页面
            try {
                addFragment(SettingFragment.class, presenter, R.id.form, null, null);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } else if (id == R.id.menu_about) {
            //选中跳转关于页面
            Intent intent = new Intent(HomeActivity.this, AbouvActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
