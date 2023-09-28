package com.example.lab03;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        WebView webView = findViewById(R.id.webView);


        String url = getIntent().getStringExtra("URL");


        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
    }
}
