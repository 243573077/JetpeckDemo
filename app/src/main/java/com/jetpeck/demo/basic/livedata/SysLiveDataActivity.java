package com.jetpeck.demo.basic.livedata;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

import com.jetpeck.demo.R;
import com.jetpeck.demo.basic.viewmodel.ViewModelOne;
import com.jetpeck.demo.model.User;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class SysLiveDataActivity extends AppCompatActivity {

    private final String TAG = "SysLiveDataActivity";

    ViewModelOne model;
    TextView tvLiveData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewmodel);
        model = ViewModelProviders.of(this).get(ViewModelOne.class);
        //携带参数 使用 ViewModelProvider of(Fragment fragment, Factory factory) 方法


        tvLiveData = findViewById(R.id.tvViewModel);

        //
        model.getUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                Log.d(TAG, "onChanged:  -------and update UI-----");
                if (users != null) {
                    User item = users.get(0);
                    tvLiveData.setText(TextUtils.isEmpty(item.getName()) ? "null value" :
                            item.getName());
                }
            }
        });
//        model.getUsers().observe(this, users -> {
//             Log.d(TAG, "onChanged:  -------and update UI-----");
//            //update UI
//        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        //模拟更新，修改ViewModel中保存的数据
        ViewModelProviders.of(this).get(ViewModelOne.class).updateUser();//更新数据
        //或者 model.updateUser();
    }
}
