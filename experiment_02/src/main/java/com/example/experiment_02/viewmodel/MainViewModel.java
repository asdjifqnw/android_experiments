package com.example.experiment_02.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.experiment_02.entity.User;

public class MainViewModel extends AndroidViewModel {
    private static final String TAG = "MainViewModel";

    public MutableLiveData<User> userLiveData = new MutableLiveData<>();
    //构造函数
    public MainViewModel(@NonNull Application application) {
        super(application);
        User user = new User("BO");
        userLiveData.setValue(user);
    }
    //异步修改值
    public void change() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    User u = userLiveData.getValue();
                    assert u != null;
                    u.name = "SUN";
                    // 也可重新重新创建一个user对象，置入
                    userLiveData.postValue(u);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }).start();
    }
}