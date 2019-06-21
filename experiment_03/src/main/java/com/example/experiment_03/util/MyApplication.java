package com.example.experiment_03.util;

import android.app.Application;

public class MyApplication extends Application {
    private static Application instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
    public static Application getInstance() {
        return instance;
    }
}