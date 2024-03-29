package com.example.experiment_03.service;

import com.example.experiment_03.dto.NewsDTO;
import com.example.experiment_03.entity.News;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface NewsService {
    @GET("news/{id}")
    Call<NewsDTO> getNews(@Path("id") int id);

    @GET("news")
    Call<NewsDTO> listNews();

    @GET
    Call<ResponseBody> getBitmap(@Url String url);

    @POST("news")
    Call<ResponseBody> post(@Body News n);
}