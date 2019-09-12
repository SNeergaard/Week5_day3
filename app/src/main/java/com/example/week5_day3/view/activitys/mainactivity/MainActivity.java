package com.example.week5_day3.view.activitys.mainactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.week5_day3.R;
import com.example.week5_day3.model.fliker.Flickr;
import com.example.week5_day3.model.fliker.ItemsItem;
import com.example.week5_day3.view.adapters.FlickrRVAdapter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainActivityContract {
    private MainActivityPresenter presenter;
    RecyclerView rvFlickr;
    FlickrRVAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainActivityPresenter(this);
        BindViews();
        presenter.getFlickr();
//        rvFlickr.setLayoutManager(new LinearLayoutManager(this));


    }

    private void BindViews() {

        rvFlickr = findViewById(R.id.rvFlickr);


    }


    @Override
    public void onFlickr(Flickr flickr) {
        if (flickr != null){
            List<ItemsItem> items = flickr.getItems();
            adapter = new FlickrRVAdapter(items);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
            rvFlickr.setLayoutManager(layoutManager);
            rvFlickr.setAdapter(new FlickrRVAdapter(items));
        }
    }
}
