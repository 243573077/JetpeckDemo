package com.jetpeck.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.jetpeck.demo.basic.lifecycles.CustomLifeCyclesActivity;
import com.jetpeck.demo.basic.lifecycles.SystemLifeCyclesActivity;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tvCustomLifeCycle).setOnClickListener(this);
        findViewById(R.id.tvLifeCycle).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.tvCustomLifeCycle:
                intent.setClass(this, CustomLifeCyclesActivity.class);
                startActivity(intent);
                break;
            case R.id.tvLifeCycle:
                intent.setClass(this, SystemLifeCyclesActivity.class);
                startActivity(intent);
                break;
        }
    }
}
