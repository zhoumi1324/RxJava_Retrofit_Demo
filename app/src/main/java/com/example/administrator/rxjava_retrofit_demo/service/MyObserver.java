package com.example.administrator.rxjava_retrofit_demo.service;

import android.content.Context;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2018/5/18.
 */

public class MyObserver<T> implements Observer<T> {
    private ObserverOnNextListener listener;
    private Context context;

    public MyObserver(Context context ,ObserverOnNextListener listener){
        this.context = context;
        this.listener = listener;
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T o) {
        listener.onNext(o);
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }

    public interface ObserverOnNextListener<T>{
        void onNext(T t);
    }
}
