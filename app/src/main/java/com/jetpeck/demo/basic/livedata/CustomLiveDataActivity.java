package com.jetpeck.demo.basic.livedata;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import com.jetpeck.demo.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

public class CustomLiveDataActivity extends AppCompatActivity {

    TextView tvModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewmodel);
        tvModel = findViewById(R.id.tvViewModel);

        init();
    }

    private void init() {
        CustomLiveData customLiveData = CustomLiveData.getInstance();
        customLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if (TextUtils.isEmpty(s)) {
                    return;
                }
                tvModel.setText(s);
            }
        });
    }
}
