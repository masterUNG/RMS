package com.virtualsiamu.rms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private WebView webView;
    private static final String urlPHP = "http://www.virtualsiamu.com/RMS/Search/Search_Result.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.webView);

        webView.setWebViewClient(new WebViewClient());

        webView.loadUrl(urlPHP);



    }   // Main Method

    public void clickMemberLogin(View view) {
        startActivity(new Intent(MainActivity.this, MemberLogin.class));
    }

}   // Main Class
