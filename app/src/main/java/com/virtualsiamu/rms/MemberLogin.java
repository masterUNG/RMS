package com.virtualsiamu.rms;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONObject;

public class MemberLogin extends AppCompatActivity {

    //Explicit
    private MyManage myManage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_login);

        myManage = new MyManage(this);

        //Test Add Value
        //testAddValue();

        //Delete All SQLite
        deleteAllSQLite();

        synAllData();

    }   // Main Method

    private void synAllData() {

        String urlIden = "http://www.virtualsiamu.com/RMS/Get/Get_UserID.php";
        String urlCorrect = "http://www.virtualsiamu.com/RMS/Get/Get_CorrectID.php";

        //for Identity
        SynData identitySynData = new SynData(this, urlIden, 0);
        identitySynData.execute();

        //for Correct
        SynData correctSynData = new SynData(this, urlCorrect, 1);
        correctSynData.execute();

    }

    private class SynData extends AsyncTask<Void, Void, String> {

        //Explicit
        private Context context;
        private String urlPHP;
        private int addValueAnInt;

        public SynData(Context context, String urlPHP, int addValueAnInt) {
            this.context = context;
            this.urlPHP = urlPHP;
            this.addValueAnInt = addValueAnInt;
        }

        @Override
        protected String doInBackground(Void... voids) {

            try {

                OkHttpClient okHttpClient = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                Request request = builder.url(urlPHP).build();
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();


            } catch (Exception e) {
                Log.d("26AugV2", "e doInBack ==> " + e.toString());
                return null;
            }


        }   // doInBack

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Log.d("26AugV2", "JSON ==> " + s);

            try {

                JSONArray jsonArray = new JSONArray(s);
                for (int i=0;i<jsonArray.length();i++) {

                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    switch (addValueAnInt) {


                        case 0:
                            myManage.addIdentity(jsonObject.getString("UserID"));
                            break;
                        case 1:
                            myManage.addCorrectID(jsonObject.getString("CorrectID"));
                            break;

                    }   // switch

                }   // for


            } catch (Exception e) {
                Log.d("26AugV2", "e onPost ==> " + e.toString());
            }

        }   // onPost

    }   // SynData Class


    private void deleteAllSQLite() {
        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        sqLiteDatabase.delete(MyManage.identityTABLE_name, null, null);
        sqLiteDatabase.delete(MyManage.correctIDTABLE_name, null, null);
    }

    private void testAddValue() {
        myManage.addIdentity("testUserID");
        myManage.addCorrectID("testCorrectID");
    }

    public void clickSignUp(View view) {
        startActivity(new Intent(MemberLogin.this, Register.class));
    }

}   // Main Class
