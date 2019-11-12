package com.jetpeck.demo.basic.livedata;

import android.util.Log;

import androidx.lifecycle.LiveData;

public class CustomLiveData extends LiveData<String> {

    private static CustomLiveData sInstance;
    private String TAG = this.getClass().getSimpleName();

    private CustomLiveData() {

    }

    public static CustomLiveData getInstance() {
        if (sInstance == null) {
            sInstance = new CustomLiveData();
        }
        return sInstance;
    }

    @Override
    protected void onActive() {
        super.onActive();
        Log.d(TAG, "onActive  , start listener");
    }

    @Override
    protected void onInactive() {
        super.onInactive();
        Log.d(TAG, "onInactive:   stop listener");
    }
}
