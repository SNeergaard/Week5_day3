package com.example.week5_day3.model.datasource.network.retrofit.services;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {
        private HttpLoggingInterceptor getLoggingInterceptor(){
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
            return httpLoggingInterceptor;
        }

    private OkHttpClient getClient(){
        return new OkHttpClient.Builder().addInterceptor(getLoggingInterceptor()).build();
    }

    private Retrofit getRetrofitinstance(){
        return new Retrofit.Builder()
                .client(getClient())
                .baseUrl(UrlConstants.BASE_API)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
    public FlickrService getService() {
        return getRetrofitinstance().create(FlickrService.class);
    }
}
