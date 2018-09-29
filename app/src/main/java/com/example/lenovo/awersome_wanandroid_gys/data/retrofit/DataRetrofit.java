package com.example.lenovo.awersome_wanandroid_gys.data.retrofit;

import java.io.IOException;
import java.nio.Buffer;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataRetrofit {

    private static final long DEFAULT_TIMEOUT = 20000;

    public static ApiService getRetrofitService(){

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        Request.Builder requestBuilder = request.newBuilder();
                        request = requestBuilder
                                .addHeader("Content-Type", "application/json;charset=UTF-8")
                                .post(RequestBody.create(MediaType.parse("application/json;charset=UTF-8"),
                                        bodyToString(request.body())))//关键部分，设置requestBody的编码格式为json
                                .build();
                        return chain.proceed(request);
                    }
                })
                .addInterceptor(logging)
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
//                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("http://www.wanandroid.com/").build();

        return retrofit.create(ApiService.class);

    }
    private static String bodyToString(final RequestBody request) {
        try {
            final RequestBody copy = request;
            final okio.Buffer buffer = new okio.Buffer();
            if (copy != null)
                copy.writeTo(buffer);
            else
                return "";
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "did not work";
        }
    }

}
