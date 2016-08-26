package com.virtualsiamu.rms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MemberLogin extends AppCompatActivity {

    //Explicit
    private MyManage myManage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_login);

        myManage = new MyManage(this);

        //Test Add Value
        testAddValue();

    }   // Main Method

    private void testAddValue() {
        myManage.addIdentity("testUserID");
        myManage.addCorrectID("testCorrectID");
    }

    public void clickSignUp(View view) {
        startActivity(new Intent(MemberLogin.this, Register.class));
    }

}   // Main Class
