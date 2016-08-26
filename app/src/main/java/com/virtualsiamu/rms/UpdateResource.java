package com.virtualsiamu.rms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class UpdateResource extends AppCompatActivity {

    private WebView webView;
    private static final String urlPHP = "http://androidthai.in.th";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_resource);

        webView = (WebView) findViewById(R.id.webView2);

        webView.setWebViewClient(new WebViewClient());

        webView.loadUrl(urlPHP);


    }   // Main Method

    public void clickBackUpdateResource(View view) {
        finish();
    }

}   // Main Class
