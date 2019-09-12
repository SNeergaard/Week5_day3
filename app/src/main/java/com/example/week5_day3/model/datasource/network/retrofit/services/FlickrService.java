package com.example.week5_day3.model.datasource.network.retrofit.services;

import com.example.week5_day3.model.fliker.Flickr;
import com.example.week5_day3.model.fliker.ItemsItem;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.example.week5_day3.model.datasource.network.retrofit.services.UrlConstants.PATH_FLICKR;

public interface FlickrService {
    @GET(PATH_FLICKR)
    Observable<Flickr> getFlickr(@Query("results")String numOfResults);
}
