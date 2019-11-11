package com.jetpeck.demo.basic.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class ViewModelTwo extends AndroidViewModel {


    private String name = "";

    public ViewModelTwo(@NonNull Application application) {
        super(application);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
