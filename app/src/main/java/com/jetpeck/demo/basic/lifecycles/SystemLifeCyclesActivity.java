package com.jetpeck.demo.basic.lifecycles;

import android.os.Bundle;

import com.jetpeck.demo.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SystemLifeCyclesActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycles);
        //AppCompatActivity  26.1.0+  ,can use getLifecycle();
        getLifecycle().addObserver(new LifeCycleObserverLearnOne());
        getLifecycle().addObserver(new LifeCycleObserverLearnTwo());
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
