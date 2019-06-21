package com.example.experiment_02;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.example.experiment_02.databinding.ActivityBinding;
import com.example.experiment_02.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity);
        //自动生成
        ActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.activity);
        //用providers创建viewmodel
        MainViewModel mainViewModel= ViewModelProviders.of(this).get((MainViewModel.class));
        //绑定
        binding.setMainVM(mainViewModel);
        binding.setLifecycleOwner(this);
    }
}
