package com.virtualsiamu.rms;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class Register extends AppCompatActivity {

    //Explicit
    private EditText nameIDEditText, nameSurEditText,
            emailEditText,
            userEditText, passwordEditText;
    private Spinner codeMSpinner;
    private String nameIDString, nameSurString,
            codeMString, emailString,
            userString, passwordString;
    private String[] majorStrings;


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

        SynMajorTABLE synMajorTABLE = new SynMajorTABLE(this, codeMSpinner);
        synMajorTABLE.execute();

    }   // Main Method

    //Create Inner Class
    private class SynMajorTABLE extends AsyncTask<Void, Void, String> {

        // Explicit
        private Context context;
        private Spinner mySpinner;
        private static final String urlJSON = "http://virtualsiamu.com/RMS/Major/Get_Major.php";

        public SynMajorTABLE(Context context, Spinner mySpinner) {
            this.context = context;
            this.mySpinner = mySpinner;
        }

        @Override
        protected String doInBackground(Void... voids) {

            try {

                OkHttpClient okHttpClient = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                Request request = builder.url(urlJSON).build();
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();

            } catch (Exception e) {
                Log.d("25AugV1", "e doinback ==> " + e.toString());
                return null;
            }


        }   // doIn

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Log.d("25AugV1", "JSON ==> " + s);

        }   // onPost

    }   // SynClass


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
