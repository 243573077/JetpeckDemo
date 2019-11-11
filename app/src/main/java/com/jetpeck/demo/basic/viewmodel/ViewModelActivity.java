package com.jetpeck.demo.basic.viewmodel;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.jetpeck.demo.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

public class ViewModelActivity extends AppCompatActivity {
    private final String TAG = "ViewModel Activity";
    ViewModelTwo model;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_viewmodel);

        //简单使用ViewModel
        model = ViewModelProviders.of(this).get(ViewModelTwo.class);
        findViewById(R.id.tvViewModel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = model.getName();
                Log.d(TAG, "click before name is ->" + name);
                model.setName("click on ViewModel");
                ((TextView) findViewById(R.id.tvViewModel)).setText(model.getName());
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

}
