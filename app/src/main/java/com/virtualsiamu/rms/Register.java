package com.virtualsiamu.rms;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONObject;

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

        SynMajorTABLE synMajorTABLE = new SynMajorTABLE(this, codeMSpinner);
        synMajorTABLE.execute();

    }   // Main Method

    //Create Inner Class
    private class SynMajorTABLE extends AsyncTask<Void, Void, String> {

        // Explicit
        private Context context;
        private Spinner mySpinner;
        private static final String urlJSON = "http://virtualsiamu.com/RMS/Major/Get_Major.php";
        private String[] codeMStrings, nameMStrings, majorStrings;



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

            try {

                JSONArray jsonArray = new JSONArray(s);

                codeMStrings = new String[jsonArray.length()];
                nameMStrings = new String[jsonArray.length()];
                majorStrings = new String[jsonArray.length()];

                for (int i=0;i<jsonArray.length();i+=1) {

                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    codeMStrings[i] = jsonObject.getString("Code_M");
                    nameMStrings[i] = jsonObject.getString("Name_M");
                    majorStrings[i] = codeMStrings[i] + " " + nameMStrings[i];

                }   // for

                //Create Spinner
                ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(context,
                        android.R.layout.simple_list_item_1, majorStrings);
                mySpinner.setAdapter(stringArrayAdapter);

            } catch (Exception e) {
                Log.d("25AugV1", "e onPost ==> " + e.toString());
            }


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
