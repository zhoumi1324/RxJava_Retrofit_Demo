package com.example.administrator.rxjava_retrofit_demo;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.administrator.rxjava_retrofit_demo.service.ApiMethods;
import com.example.administrator.rxjava_retrofit_demo.service.MyObserver;
import com.example.administrator.rxjava_retrofit_demo.service.ProgressObserver;
import com.example.administrator.rxjava_retrofit_demo.view.WatchMovieActivity;

import org.json.JSONObject;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.watchMovie).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this  ,WatchMovieActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.upload).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyStoragePermissions(MainActivity.this);
                File file = new File(Environment.getExternalStorageDirectory(),"ss.jpg");
                RequestBody body = RequestBody.create(MediaType.parse("image/jpg") ,file);
                MultipartBody.Part filePart = MultipartBody.Part.createFormData("pic",file.getName(),body);
                ApiMethods.doUpload(new ProgressObserver<JSONObject>(MainActivity.this ,listener),"10134" , filePart);

            }
        });

    }

    MyObserver.ObserverOnNextListener<JSONObject> listener = new MyObserver.ObserverOnNextListener<JSONObject>() {
        @Override
        public void onNext(JSONObject str) {
            Log.d("Movie", "onNext~: " + str.toString());
        }
    };

    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE);
        }
    }
}
