package com.example.administrator.rxjava_retrofit_demo.service;

import com.example.administrator.rxjava_retrofit_demo.entity.CamperCar;
import com.example.administrator.rxjava_retrofit_demo.entity.Movie;

import org.json.JSONObject;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2018/5/18.
 */

public interface ApiService {
    @GET("top250")
    Observable<Movie> getTopMovie(@Query("start") int start, @Query("count") int count);

    @GET("/motorHomes/getMotorHomes.ashx")
    Observable<CamperCar> getCamperCar();

    @POST("file/upload")
    @Multipart
    Observable<JSONObject> doUpload(@Query("uid") String uid , @Part MultipartBody.Part file);
}