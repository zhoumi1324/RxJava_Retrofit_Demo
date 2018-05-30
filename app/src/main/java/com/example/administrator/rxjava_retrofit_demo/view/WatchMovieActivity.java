package com.example.administrator.rxjava_retrofit_demo.view;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.GridView;

import com.example.administrator.rxjava_retrofit_demo.R;
import com.example.administrator.rxjava_retrofit_demo.adapter.MainAdapter;
import com.example.administrator.rxjava_retrofit_demo.entity.Movie;
import com.example.administrator.rxjava_retrofit_demo.service.ApiMethods;
import com.example.administrator.rxjava_retrofit_demo.service.MyObserver;
import com.example.administrator.rxjava_retrofit_demo.service.ProgressObserver;

import java.util.List;


/**
 * Created by zhoumi on 2018/5/29.
 */

public class WatchMovieActivity extends Activity{
    private GridView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_movie);

        recyclerView = findViewById(R.id.recyclerView);

        MyObserver.ObserverOnNextListener<Movie> listener = new MyObserver.ObserverOnNextListener<Movie>() {
            @Override
            public void onNext(Movie movie) {
                List<Movie.Subjects> list = movie.getSubjects();
                for (Movie.Subjects sub : list) {
                    Log.d("Movie", "onNext~: " + sub.getId() + "," + sub.getYear() + "," + sub.getTitle());
                }
                MainAdapter adapter = new MainAdapter(WatchMovieActivity.this ,list);
                recyclerView.setAdapter(adapter);
            }
        };
        ApiMethods.getTopMovie(new ProgressObserver<Movie>(this ,listener), 0, 10);
    }
}
