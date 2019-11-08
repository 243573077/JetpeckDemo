package com.jetpeck.demo.basic.viewmodel;

import android.util.Log;

import com.jetpeck.demo.model.User;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ViewModelOne extends ViewModel {

    private final String TAG = "ViewModel";

    private MutableLiveData<List<User>> users;


    public LiveData<List<User>> getUsers() {
        if (users == null) {
            users = new MutableLiveData<List<User>>();
            loadUsers();
        }
        return users;
    }

    private void loadUsers() {
        //do what you want to
        Log.d(TAG, "loadUsers: from local or network");
//        loadData();
    }

//    private void loadData() {
//        List<User> data = new ArrayList<>();
//        data.add(new User("test", 22, "info"));
//        users.postValue(data);//异步：接收端在主线程回调数据
//        users.setValue(data);//同步：接收端数据回调与发送端同一个线程
//    }

    public void updateUser() {
        loadUsers();
    }
}
