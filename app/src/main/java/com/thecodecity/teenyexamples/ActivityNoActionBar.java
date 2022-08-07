package com.thecodecity.teenyexamples;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityNoActionBar extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Request window feature
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        //getActionBar().hide();

        setContentView(R.layout.acitivty_no_toolbar);
    }
}
