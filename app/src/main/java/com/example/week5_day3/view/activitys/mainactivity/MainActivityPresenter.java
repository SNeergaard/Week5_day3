package com.example.week5_day3.view.activitys.mainactivity;

import android.util.Log;

import com.example.week5_day3.model.datasource.network.retrofit.services.RetrofitHelper;
import com.example.week5_day3.model.fliker.Flickr;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivityPresenter {
    private MainActivityContract contract;

    public MainActivityPresenter(MainActivityContract contract) {
        this.contract = contract;
    }

    public void getFlickr(){
        RetrofitHelper retrofitHelper = new RetrofitHelper();
        retrofitHelper.getService().getFlickr(String.valueOf(20))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Flickr>() {
                    Flickr flickr;
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Flickr flickr) {
                        this.flickr = flickr;
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Main_ACT_Present", "onError");
                    }

                    @Override
                    public void onComplete() {
                        contract.onFlickr(flickr);
                    }
                });
    }
}
