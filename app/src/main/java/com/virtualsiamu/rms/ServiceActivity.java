package com.virtualsiamu.rms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ServiceActivity extends AppCompatActivity {

    //Explicit
    private String userIDString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        userIDString = getIntent().getStringExtra("UserID");

    }   // Main Method

    public void clickUpdateResource(View view) {

        Intent intent = new Intent(ServiceActivity.this, UpdateResource.class);
        intent.putExtra("UserID", userIDString);
        startActivity(intent);

    }

    public void clickCheckResource(View view) {

        Intent intent = new Intent(ServiceActivity.this, CheckResource.class);
        intent.putExtra("UserID", userIDString);
        startActivity(intent);


    }

}   // Main Class
