package com.example.locationsharing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        WebView webView1 = findViewById(R.id.websearch);
        webView1.getSettings().setJavaScriptEnabled(true);
        webView1.loadUrl("https://yt1s.com/enkt9o6");
        webView1.setWebViewClient(new webViewControl());
    }
}