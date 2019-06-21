package com.example.experiment_03.service;

import com.example.experiment_03.util.MyApplication;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceFactory {
    // 默认retrofit将请求的图片置于缓存，当向相同地址请求图片时，自动加载缓存的图片
    // 自动在data/data/应用包/cache下，创建缓存文件,10MB
    private static OkHttpClient client = new OkHttpClient.Builder()
            .cache(new Cache(MyApplication.getInstance().getCacheDir(), 10 * 1024 * 1024))
            .build();
    private static Retrofit retrofit = new Retrofit.Builder()
            // 授权错误？
            .baseUrl("http://www.whyman.site/api/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    // retrofit自动创建接口的代理类
    public static NewsService getNewsService() {
        return retrofit.create(NewsService.class);
    }
}