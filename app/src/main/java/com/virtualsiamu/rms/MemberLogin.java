package com.virtualsiamu.rms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MemberLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_login);
    }   // Main Method

    public void clickSignUp(View view) {
        startActivity(new Intent(MemberLogin.this, Register.class));
    }

}   // Main Class
