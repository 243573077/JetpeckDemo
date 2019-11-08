package com.jetpeck.demo.basic.viewmodel;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

public class ViewModelActivity extends AppCompatActivity {
    private final String TAG = "ViewModel Activity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ViewModelOne model = ViewModelProviders.of(this).get(ViewModelOne.class);
//        model.getUsers().observe(this, new Observer<List<User>>() {
//            @Override
//            public void onChanged(List<User> users) {
//                //update UI
//            }
//        });
        model.getUsers().observe(this, users -> {
            //update UI
            Log.d(TAG, "model onChanged:  update UI");
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        ViewModelProviders.of(this).get(ViewModelOne.class).updateUser();//更新数据
    }

}
