package com.example.lenovo.awersome_wanandroid_gys.data.retrofit;

import android.support.annotation.NonNull;

import com.example.lenovo.awersome_wanandroid_gys.bean.Banners;
import com.example.lenovo.awersome_wanandroid_gys.bean.Commom;
import com.example.lenovo.awersome_wanandroid_gys.bean.HomeList;
import com.example.lenovo.awersome_wanandroid_gys.bean.HttpResult;
import com.example.lenovo.awersome_wanandroid_gys.bean.LoginData;
import com.example.lenovo.awersome_wanandroid_gys.bean.Mhs;
import com.example.lenovo.awersome_wanandroid_gys.bean.RegisterData;
import com.example.lenovo.awersome_wanandroid_gys.bean.Search;

import java.util.ArrayList;
import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ApiService {

    //http://www.wanandroid.com/article/list/0/json
    //首页
    @GET("article/list/{page}/json")
    Observable<HttpResult<HomeList>> home(@Path("page") int page);


    //http://www.wanandroid.com/banner/json
    //首页轮播图
    @GET("banner/json")
    Observable<HttpResult<ArrayList<Banners>>> banner();

    //http://www.wanandroid.com/friend/json
    //首页常用网站
    @GET("friend/json")
    Observable<HttpResult<ArrayList<Commom>>> common();


    //http://www.wanandroid.com//hotkey/json
    //搜索热词
    @GET("hotkey/json")
    Observable<HttpResult<ArrayList<Search>>> search();



    //http://www.wanandroid.com/tree/json
    //体系数据
    @GET()
    Observable<HttpResult<ArrayList<Mhs>>> mhs();



    //登录http://www.wanandroid.com/user/login?username=1138876627&password=gao1138876627
    @POST("user/login")
    Observable<HttpResult<LoginData>> login(@Query("username") String username, @Query("password") String password);

    //http://www.wanandroid.com/user/register  注册
    @POST("user/register")
    Observable<HttpResult<RegisterData>> register(@QueryMap HashMap<String,String> map);
}
