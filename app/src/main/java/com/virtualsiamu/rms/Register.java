package com.virtualsiamu.rms;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class Register extends AppCompatActivity {

    //Explicit
    private EditText nameIDEditText, nameSurEditText,
            emailEditText,
            userEditText, passwordEditText;
    private Spinner codeMSpinner;
    private String nameIDString, nameSurString,
            codeMString, emailString,
            userString, passwordString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Bind Widget
        nameIDEditText = (EditText) findViewById(R.id.editText);
        nameSurEditText = (EditText) findViewById(R.id.editText2);
        emailEditText = (EditText) findViewById(R.id.editText4);
        userEditText = (EditText) findViewById(R.id.editText5);
        passwordEditText = (EditText) findViewById(R.id.editText6);
        codeMSpinner = (Spinner) findViewById(R.id.editText3);

    }   // Main Method

    public void clickSignUpRegis(View view) {

        //Get Value from Edit Text
        nameIDString = nameIDEditText.getText().toString().trim();
        nameSurString = nameSurEditText.getText().toString().trim();
        emailString = emailEditText.getText().toString().trim();
        userString = userEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();

        //Check Space
        if (nameIDString.equals("") || nameSurString.equals("") ||
                emailString.equals("") || userString.equals("") ||
                passwordString.equals("")) {

            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this, R.drawable.doremon48,
                    "มีช่องว่าง", "กรุณากรอกทุกช่องคะ");

        }

    }   // clickSign

}   // Main Class
