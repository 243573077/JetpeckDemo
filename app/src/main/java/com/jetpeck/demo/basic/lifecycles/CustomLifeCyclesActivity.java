package com.jetpeck.demo.basic.lifecycles;

import android.app.Activity;
import android.os.Bundle;

import com.jetpeck.demo.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;

public class CustomLifeCyclesActivity extends Activity implements LifecycleOwner {
    private LifecycleRegistry mLifecycleRegistry;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycles);

        mLifecycleRegistry = new LifecycleRegistry(this);
        mLifecycleRegistry.addObserver(new LifeCycleObserverLearnOne());
        mLifecycleRegistry.addObserver(new LifeCycleObserverLearnTwo());

        mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return mLifecycleRegistry;
    }
}
